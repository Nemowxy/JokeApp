package com.nemo.joke.bean;

import java.util.List;

/**
 * Created by nemo on 2016/8/2 0002.
 */

public class Bean {
    /**
     * error : false
     * results : [{"_id":"579ec037421aa90d2fc94ba1","createdAt":"2016-08-01T11:21:27.209Z","desc":"nock-nock 一个可以帮助你监控网站是否异常的 App (抄送代码家)","publishedAt":"2016-08-01T12:00:57.45Z","source":"chrome","type":"App","url":"https://github.com/afollestad/nock-nock","used":true,"who":"咕咚"},{"_id":"579eb6fa421aa91e26064748","createdAt":"2016-08-01T10:42:02.491Z","desc":"有朋友通过尝试逆向微信图片压缩算法而实现的一个压缩比还不错的压缩算法。","publishedAt":"2016-08-01T12:00:57.45Z","source":"chrome","type":"Android","url":"https://github.com/Curzibn/Luban","used":true,"who":"代码家"},{"_id":"579eb5e4421aa90d39e709a8","createdAt":"2016-08-01T10:37:24.458Z","desc":"Java 和 Javascript Bridge 封装。","publishedAt":"2016-08-01T12:00:57.45Z","source":"chrome","type":"Android","url":"https://github.com/ImangazalievM/Scripto","used":true,"who":"代码家"},{"_id":"579eb4b4421aa90d2fc94ba0","createdAt":"2016-08-01T10:32:20.10Z","desc":"8.1","publishedAt":"2016-08-01T12:00:57.45Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f6e1f1qmg3j20u00u0djp.jpg","used":true,"who":"代码家"},{"_id":"579eadfc421aa90d36e960cc","createdAt":"2016-08-01T10:03:40.631Z","desc":"iOS 漂亮的 Tag 组件，支持自动换行，做的不错","publishedAt":"2016-08-01T12:00:57.45Z","source":"chrome","type":"iOS","url":"https://github.com/weijentu/automatic-height-tagcells","used":true,"who":"代码家"},{"_id":"579eabfc421aa91e26064747","createdAt":"2016-08-01T09:55:08.841Z","desc":"iOS 版本的人脸图片自动智能居中（昨天发布了 Android 版本的）","publishedAt":"2016-08-01T12:00:57.45Z","source":"chrome","type":"iOS","url":"https://github.com/BeauNouvelle/AspectFillFaceAware","used":true,"who":"代码家"},{"_id":"579eaa97421aa90d39e709a6","createdAt":"2016-08-01T09:49:11.97Z","desc":"根据页面内容，自动调节屏幕亮度，夜间使用尤其舒服。","publishedAt":"2016-08-01T12:00:57.45Z","source":"chrome","type":"iOS","url":"https://github.com/anishathalye/lumen","used":true,"who":"代码家"},{"_id":"579ea6d0421aa91e26064746","createdAt":"2016-08-01T09:33:04.931Z","desc":"哈哈哈好污[哈哈]这个老师可能是性 冷淡","publishedAt":"2016-08-01T12:00:57.45Z","source":"chrome","type":"休息视频","url":"http://www.miaopai.com/show/HrBuGCzGZ53UgCaZoNWahA__.htm","used":true,"who":"lxxself"},{"_id":"579e9ba8421aa90d39e709a4","createdAt":"2016-08-01T08:45:28.443Z","desc":"聊天列表样式，使用很简单","publishedAt":"2016-08-01T12:00:57.45Z","source":"chrome","type":"Android","url":"https://github.com/snipsnap/SlyceMessaging","used":true,"who":"花开堪折枝"},{"_id":"579e1b06421aa90d2fc94b9c","createdAt":"2016-07-31T23:36:38.674Z","desc":"HTML5 File API \u2014 让前端操作文件变的可能","publishedAt":"2016-08-01T12:00:57.45Z","source":"web","type":"前端","url":"http://www.cnblogs.com/zichi/p/html5-file-api.html","used":true,"who":"子迟"}]
     */

    private boolean error;
    /**
     * _id : 579ec037421aa90d2fc94ba1
     * createdAt : 2016-08-01T11:21:27.209Z
     * desc : nock-nock 一个可以帮助你监控网站是否异常的 App (抄送代码家)
     * publishedAt : 2016-08-01T12:00:57.45Z
     * source : chrome
     * type : App
     * url : https://github.com/afollestad/nock-nock
     * used : true
     * who : 咕咚
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
