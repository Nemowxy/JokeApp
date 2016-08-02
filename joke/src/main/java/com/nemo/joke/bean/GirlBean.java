package com.nemo.joke.bean;

import java.util.List;

/**
 * Created by nemo on 2016/8/2 0002.
 */

public class GirlBean {

    /**
     * error : false
     * results : [{"_id":"579eb4b4421aa90d2fc94ba0","createdAt":"2016-08-01T10:32:20.10Z","desc":"8.1","publishedAt":"2016-08-01T12:00:57.45Z","source":"chrome","type":"??","url":"http://ww1.sinaimg.cn/large/610dc034jw1f6e1f1qmg3j20u00u0djp.jpg","used":true,"who":"???"},{"_id":"579ab0a8421aa90d36e960b4","createdAt":"2016-07-29T09:26:00.838Z","desc":"7.29","publishedAt":"2016-07-29T09:37:39.219Z","source":"chrome","type":"??","url":"http://ww3.sinaimg.cn/large/610dc034jw1f6aipo68yvj20qo0qoaee.jpg","used":true,"who":"???"},{"_id":"57995869421aa90d43bbf042","createdAt":"2016-07-28T08:57:13.293Z","desc":"???","publishedAt":"2016-07-28T18:17:20.567Z","source":"chrome","type":"??","url":"http://ww3.sinaimg.cn/large/610dc034jw1f69c9e22xjj20u011hjuu.jpg","used":true,"who":"???"},{"_id":"57981ee6421aa90d36e96090","createdAt":"2016-07-27T10:39:34.818Z","desc":"???","publishedAt":"2016-07-27T11:27:16.610Z","source":"chrome","type":"??","url":"http://ww3.sinaimg.cn/large/610dc034jw1f689lmaf7qj20u00u00v7.jpg","used":true,"who":"???"},{"_id":"5796b970421aa90d2fc94b4e","createdAt":"2016-07-26T09:14:24.76Z","desc":"??????","publishedAt":"2016-07-26T10:30:11.357Z","source":"chrome","type":"??","url":"http://ww3.sinaimg.cn/large/c85e4a5cjw1f671i8gt1rj20vy0vydsz.jpg","used":true,"who":"???"},{"_id":"5794df0e421aa90d39e70939","createdAt":"2016-07-24T23:30:22.399Z","desc":"7.25","publishedAt":"2016-07-25T11:43:57.769Z","source":"chrome","type":"??","url":"http://ww2.sinaimg.cn/large/610dc034jw1f65f0oqodoj20qo0hntc9.jpg","used":true,"who":"???"},{"_id":"57918b5c421aa90d2fc94b35","createdAt":"2016-07-22T10:56:28.274Z","desc":"???????","publishedAt":"2016-07-22T11:04:44.305Z","source":"web","type":"??","url":"http://ww2.sinaimg.cn/large/c85e4a5cgw1f62hzfvzwwj20hs0qogpo.jpg","used":true,"who":"???"},{"_id":"578f93c4421aa90de83c1bf4","createdAt":"2016-07-20T23:07:48.480Z","desc":"7.21","publishedAt":"2016-07-20T16:09:07.721Z","source":"chrome","type":"??","url":"http://ww4.sinaimg.cn/large/610dc034jw1f60rw11f5mj20iy0sg0u2.jpg","used":true,"who":"daimajia"},{"_id":"578e3d3b421aa90df33fe7e8","createdAt":"2016-07-19T22:46:19.966Z","desc":"7.20","publishedAt":"2016-07-20T17:25:17.522Z","source":"chrome","type":"??","url":"http://ww4.sinaimg.cn/large/610dc034jw1f5zlndsr0oj20go0ciq4h.jpg","used":true,"who":"???"},{"_id":"578da129421aa90dea11ea28","createdAt":"2016-07-19T11:40:25.857Z","desc":"7.19","publishedAt":"2016-07-19T12:13:10.925Z","source":"chrome","type":"??","url":"http://ww2.sinaimg.cn/large/610dc034jw1f5z2eko5xnj20f00miq5s.jpg","used":true,"who":"???"}]
     */

    private boolean error;
    /**
     * _id : 579eb4b4421aa90d2fc94ba0
     * createdAt : 2016-08-01T10:32:20.10Z
     * desc : 8.1
     * publishedAt : 2016-08-01T12:00:57.45Z
     * source : chrome
     * type : ??
     * url : http://ww1.sinaimg.cn/large/610dc034jw1f6e1f1qmg3j20u00u0djp.jpg
     * used : true
     * who : ???
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
