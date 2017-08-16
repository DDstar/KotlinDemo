package com.ddstar.kotlindemo.datas.datamodel;

import java.util.List;

/**
 * Created by DDstar on 2017/8/8.
 */

public class MainDatasModel {

    /**
     * date : 20170808
     * stories : [{"images":["https://pic2.zhimg.com/v2-f406330445555f249c2d154c241f1dc1.jpg"],"type":0,"id":9558269,"ga_prefix":"080809","title":"如果把一家互联网公司比作餐馆，那在座的各位就是\u2026\u2026"}]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-f406330445555f249c2d154c241f1dc1.jpg"]
         * type : 0
         * id : 9558269
         * ga_prefix : 080809
         * title : 如果把一家互联网公司比作餐馆，那在座的各位就是……
         */

        private int type;
        private int itemType;
        private String id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
