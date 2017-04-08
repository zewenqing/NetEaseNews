package com.lwl.video.modle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lwl.video.modle.bean.VideoBean;

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

public class IVideoDataImp implements IVideoData {


    @Override
    public void backVideoData(ILoadeVideoDataListener iLoadeVideoDataListener) {
        //使用OkHttp加载数据
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5*1000, TimeUnit.SECONDS)
                .build();
        Request requse = new Request.Builder()
                .url("http://v.163.com/special/video_tuijian/?callback=callback_video")
                .build();
        Call call = client.newCall(requse);
        call.enqueue(new MyCallBack(iLoadeVideoDataListener));
    }

    class MyCallBack implements Callback{
        public ILoadeVideoDataListener iLoadeVideoDataListener;
        MyCallBack(ILoadeVideoDataListener iLoadeVideoDataListener){
            this.iLoadeVideoDataListener = iLoadeVideoDataListener;
        }
        //失败的时候回调 子线程
        @Override
        public void onFailure(Call call, IOException e) {

        }

        //成功的时候回调 子线程
        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()){
                String json = response.body().string();
                //解析数据得到集合
                List<VideoBean> beanList = paserJsonGetData(json);
                iLoadeVideoDataListener.LoadeBack(beanList);
            }
        }
    }

    private List<VideoBean> paserJsonGetData(String json) {
        String substring = json.substring(json.indexOf("(")+1, json.lastIndexOf(")"));
        List<VideoBean> beanList = null;
        try {
            JSONObject obj = new JSONObject(substring);
            JSONArray list = obj.getJSONArray("list");
            Gson gson = new Gson();
            TypeToken<List<VideoBean>> token = new TypeToken<List<VideoBean>>(){};
            beanList = gson.fromJson(list.toString(),token.getType());


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beanList;
    }
}
