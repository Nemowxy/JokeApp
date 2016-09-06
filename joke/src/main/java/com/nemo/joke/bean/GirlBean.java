package com.nemo.joke.bean;

/**
 * Created by nemo on 2016/8/2 0002.
 */

public class GirlBean extends BaseBean{

        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return time;
        }
        public void setCtime(String ctime) {
            this.time = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
}
