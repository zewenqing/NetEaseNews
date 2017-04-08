package com.lwl.video.modle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lwl.video.modle.bean.TitleBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zewen Administrator on 2017/4/8 0008.
 * email 1350495049@qq.com
 * use :
 */

public class IVideoTitleImp implements IVideoTitle {
    @Override
    public void backTitle(OnTitleLoadeListener onTitleLoadeListener) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5*1000, TimeUnit.SECONDS)
                .build();

        Request requet = new Request.Builder()
                .url("http://route.showapi.com/578-6?showapi_appid=35239&showapi_sign=985226cd80d44137a2492bc4e987da03")
                .build();
        Call call = client.newCall(requet);
        call.enqueue(new MyTitleCallBack(onTitleLoadeListener));
    }

    class MyTitleCallBack implements Callback{
        OnTitleLoadeListener onTitleLoadeListener;
        public MyTitleCallBack(OnTitleLoadeListener onTitleLoadeListener) {
            this.onTitleLoadeListener = onTitleLoadeListener;
        }

        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()){
                String json = response.body().string();
                //解析数据

                List<TitleBean> titleList = PaserJson(json);
                onTitleLoadeListener.backTitle(titleList);
            }
        }
    }

    private List<TitleBean> PaserJson(String json) {
        List<TitleBean> titleList = null;
        try {
            JSONArray arr = new JSONObject(json)
                    .getJSONObject("showapi_res_body")
                    .getJSONArray("datalist");

            TypeToken<List<TitleBean>> token = new TypeToken<List<TitleBean>>(){};

            titleList = new Gson().fromJson(arr.toString(),token.getType());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  titleList;
    }
}
