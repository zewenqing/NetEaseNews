package com.lwl.video.modle.bean;

import java.io.Serializable;

/**
 * Created by zewen Administrator on 2017/4/8 0008.
 * email 1350495049@qq.com
 * use :
 */

public class VideoBean implements Serializable{

    /**
     * title : 最惨车祸，看完后司机们要注意了
     * url : http://v.163.com/paike/VCEQEEGG7/VCG212U73.html
     * img : http://imgsize.ph.126.net/?imgurl=http://vimg2.ws.126.net/image/snapshot/2017/4/U/U/VCGIJ5UUU.jpg_330x184x1x85.jpg
     * vote : {"info":{"hits":0,"id":"","opposecount":0,"supportcount":0,"vid":"VCG212U73"}}
     * vid : VCG212U73
     * sname : 老顽童
     * comment : {"against":0,"boardId":"video_bbs","channelId":"0001","cmtAgainst":0,"cmtVote":0,"createTime":"2017-04-02 00:43:03","docId":"CG212U73008535RB","isAudit":false,"modifyTime":"2017-04-02 00:43:03","rcount":0,"status":{"app":"on","web":"on","audio":"off","against":"on","joincount":"on","label":"on"},"tcount":0,"title":"实拍最惨车祸，看完后司机们要注意了","url":"http://v.163.com/paike/VCEQEEGG7/VCG212U73.html","vote":0}
     */

    private String title;
    private String url;
    private String img;
    private VoteBean vote;
    private String vid;
    private String sname;
    private CommentBean comment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public VoteBean getVote() {
        return vote;
    }

    public void setVote(VoteBean vote) {
        this.vote = vote;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public CommentBean getComment() {
        return comment;
    }

    public void setComment(CommentBean comment) {
        this.comment = comment;
    }

    public static class VoteBean implements Serializable{
        /**
         * info : {"hits":0,"id":"","opposecount":0,"supportcount":0,"vid":"VCG212U73"}
         */

        private InfoBean info;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean implements Serializable{
            /**
             * hits : 0
             * id :
             * opposecount : 0
             * supportcount : 0
             * vid : VCG212U73
             */

            private int hits;
            private String id;
            private int opposecount;
            private int supportcount;
            private String vid;

            public int getHits() {
                return hits;
            }

            public void setHits(int hits) {
                this.hits = hits;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getOpposecount() {
                return opposecount;
            }

            public void setOpposecount(int opposecount) {
                this.opposecount = opposecount;
            }

            public int getSupportcount() {
                return supportcount;
            }

            public void setSupportcount(int supportcount) {
                this.supportcount = supportcount;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }
        }
    }

    public static class CommentBean implements Serializable{
        /**
         * against : 0
         * boardId : video_bbs
         * channelId : 0001
         * cmtAgainst : 0
         * cmtVote : 0
         * createTime : 2017-04-02 00:43:03
         * docId : CG212U73008535RB
         * isAudit : false
         * modifyTime : 2017-04-02 00:43:03
         * rcount : 0
         * status : {"app":"on","web":"on","audio":"off","against":"on","joincount":"on","label":"on"}
         * tcount : 0
         * title : 实拍最惨车祸，看完后司机们要注意了
         * url : http://v.163.com/paike/VCEQEEGG7/VCG212U73.html
         * vote : 0
         */

        private int against;
        private String boardId;
        private String channelId;
        private int cmtAgainst;
        private int cmtVote;
        private String createTime;
        private String docId;
        private boolean isAudit;
        private String modifyTime;
        private int rcount;
        private StatusBean status;
        private int tcount;
        private String title;
        private String url;
        private int vote;

        public int getAgainst() {
            return against;
        }

        public void setAgainst(int against) {
            this.against = against;
        }

        public String getBoardId() {
            return boardId;
        }

        public void setBoardId(String boardId) {
            this.boardId = boardId;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public int getCmtAgainst() {
            return cmtAgainst;
        }

        public void setCmtAgainst(int cmtAgainst) {
            this.cmtAgainst = cmtAgainst;
        }

        public int getCmtVote() {
            return cmtVote;
        }

        public void setCmtVote(int cmtVote) {
            this.cmtVote = cmtVote;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDocId() {
            return docId;
        }

        public void setDocId(String docId) {
            this.docId = docId;
        }

        public boolean isIsAudit() {
            return isAudit;
        }

        public void setIsAudit(boolean isAudit) {
            this.isAudit = isAudit;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public StatusBean getStatus() {
            return status;
        }

        public void setStatus(StatusBean status) {
            this.status = status;
        }

        public int getTcount() {
            return tcount;
        }

        public void setTcount(int tcount) {
            this.tcount = tcount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getVote() {
            return vote;
        }

        public void setVote(int vote) {
            this.vote = vote;
        }

        public static class StatusBean implements Serializable{
            /**
             * app : on
             * web : on
             * audio : off
             * against : on
             * joincount : on
             * label : on
             */

            private String app;
            private String web;
            private String audio;
            private String against;
            private String joincount;
            private String label;

            public String getApp() {
                return app;
            }

            public void setApp(String app) {
                this.app = app;
            }

            public String getWeb() {
                return web;
            }

            public void setWeb(String web) {
                this.web = web;
            }

            public String getAudio() {
                return audio;
            }

            public void setAudio(String audio) {
                this.audio = audio;
            }

            public String getAgainst() {
                return against;
            }

            public void setAgainst(String against) {
                this.against = against;
            }

            public String getJoincount() {
                return joincount;
            }

            public void setJoincount(String joincount) {
                this.joincount = joincount;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }
        }
    }
}
