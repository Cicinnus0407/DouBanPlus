package com.cicinnus.doubanplus.module.search;

import java.util.List;

/**
 * Created by Cicinnus
 * on 2017/11/23.
 */

public class SearchResultBean {


    /**
     * count : 5
     * start : 0
     * total : 96
     * subjects : [{"rating":{"max":10,"average":9.1,"stars":"45","min":0},"genres":["剧情","动作","犯罪"],"title":"制裁者","casts":[{"alt":"https://movie.douban.com/celebrity/1049679/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg"},"name":"乔·博恩瑟","id":"1049679"},{"alt":"https://movie.douban.com/celebrity/1323445/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56531.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56531.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56531.jpg"},"name":"艾波·罗丝·雷瓦","id":"1323445"},{"alt":"https://movie.douban.com/celebrity/1137089/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p27617.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p27617.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p27617.jpg"},"name":"艾邦·摩斯-巴克拉赫","id":"1137089"}],"collect_count":1570,"original_title":"The Punisher","subtype":"tv","directors":[{"alt":"https://movie.douban.com/celebrity/1339951/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg"},"name":"安迪·戈达德","id":"1339951"},{"alt":"https://movie.douban.com/celebrity/1297313/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p22445.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p22445.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p22445.jpg"},"name":"汤姆·森兰","id":"1297313"},{"alt":"https://movie.douban.com/celebrity/1305517/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496304684.02.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496304684.02.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496304684.02.jpg"},"name":"安东尼奥·坎波斯","id":"1305517"},{"alt":"https://movie.douban.com/celebrity/1050169/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5862.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5862.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5862.jpg"},"name":"凯文·霍克斯","id":"1050169"},{"alt":"https://movie.douban.com/celebrity/1356857/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"马克·乔博斯特","id":"1356857"},{"alt":"https://movie.douban.com/celebrity/1042024/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"吉姆·奥汉龙","id":"1042024"},{"alt":"https://movie.douban.com/celebrity/1297749/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1423388251.37.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1423388251.37.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1423388251.37.jpg"},"name":"卡莉·斯考格兰德","id":"1297749"},{"alt":"https://movie.douban.com/celebrity/1298671/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"史蒂芬·瑟吉克","id":"1298671"},{"alt":"https://movie.douban.com/celebrity/1373405/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"迪尔巴拉·沃尔什","id":"1373405"},{"alt":"https://movie.douban.com/celebrity/1357865/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/phJiw7gbQTNkcel_avatar_uploaded1463475968.24.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/phJiw7gbQTNkcel_avatar_uploaded1463475968.24.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/phJiw7gbQTNkcel_avatar_uploaded1463475968.24.jpg"},"name":"杰里米·韦布","id":"1357865"},{"alt":"https://movie.douban.com/celebrity/1382257/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"Jet Wilkinson","id":"1382257"}],"year":"2017","images":{"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2500482503.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2500482503.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2500482503.jpg"},"alt":"https://movie.douban.com/subject/26710394/","id":"26710394"},{"rating":{"max":10,"average":5.4,"stars":"30","min":0},"genres":["动作","科幻"],"title":"铁拳 第一季","casts":[{"alt":"https://movie.douban.com/celebrity/1319072/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1402386161.52.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1402386161.52.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1402386161.52.jpg"},"name":"菲恩·琼斯","id":"1319072"},{"alt":"https://movie.douban.com/celebrity/1264859/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489834989.5.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489834989.5.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489834989.5.jpg"},"name":"杰西卡·亨维克","id":"1264859"},{"alt":"https://movie.douban.com/celebrity/1031790/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20067.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20067.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20067.jpg"},"name":"杰西卡·斯特普","id":"1031790"}],"collect_count":3301,"original_title":"Iron Fist","subtype":"tv","directors":[{"alt":"https://movie.douban.com/celebrity/1360492/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1507708620.86.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1507708620.86.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1507708620.86.jpg"},"name":"乌塔·布里兹维茨","id":"1360492"},{"alt":"https://movie.douban.com/celebrity/1350650/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1437403892.24.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1437403892.24.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1437403892.24.jpg"},"name":"米格尔·萨普什尼克","id":"1350650"}],"year":"2017","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2432973367.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2432973367.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2432973367.jpg"},"alt":"https://movie.douban.com/subject/25769159/","id":"25769159"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["动作","奇幻","冒险"],"title":"惊奇队长","casts":[{"alt":"https://movie.douban.com/celebrity/1027194/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392029372.12.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392029372.12.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392029372.12.jpg"},"name":"布丽·拉尔森","id":"1027194"},{"alt":"https://movie.douban.com/celebrity/1054408/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1365913316.45.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1365913316.45.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1365913316.45.jpg"},"name":"塞缪尔·杰克逊","id":"1054408"}],"collect_count":20,"original_title":"Captain Marvel","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1306067/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20912.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20912.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20912.jpg"},"name":"安娜·波顿","id":"1306067"},{"alt":"https://movie.douban.com/celebrity/1050201/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34806.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34806.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34806.jpg"},"name":"瑞安·弗雷克","id":"1050201"}],"year":"2019","images":{"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2446833158.jpg","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2446833158.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2446833158.jpg"},"alt":"https://movie.douban.com/subject/26213252/","id":"26213252"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["纪录片"],"title":"漫威：超级英雄王国","casts":[],"collect_count":5,"original_title":"Marvel Renaissance","subtype":"movie","directors":[{"alt":null,"avatars":null,"name":"Philippe Guedj","id":null},{"alt":null,"avatars":null,"name":"Philippe Roure","id":null}],"year":"2014","images":{"small":"http://img3.doubanio.com/f/movie/b6dc761f5e4cf04032faa969826986efbecd54bb/pics/movie/movie_default_small.png","large":"http://img7.doubanio.com/f/movie/30c6263b6db26d055cbbe73fe653e29014142ea3/pics/movie/movie_default_large.png","medium":"http://img3.doubanio.com/f/movie/5081e011b4b06f1a8c3735122b38e781bd852ab6/pics/movie/movie_default_medium.png"},"alt":"https://movie.douban.com/subject/26767344/","id":"26767344"},{"rating":{"max":10,"average":8.5,"stars":"45","min":0},"genres":["纪录片"],"title":"漫威影业：宇宙集结","casts":[{"alt":"https://movie.douban.com/celebrity/1000051/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p37606.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p37606.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p37606.jpg"},"name":"海莉·阿特维尔","id":"1000051"},{"alt":"https://movie.douban.com/celebrity/1036569/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg"},"name":"沙恩·布莱克","id":"1036569"},{"alt":"https://movie.douban.com/celebrity/1036342/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p43581.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p43581.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p43581.jpg"},"name":"肯尼思·布拉纳","id":"1036342"}],"collect_count":3290,"original_title":"Marvel Studios: Assembling a Universe","subtype":"movie","directors":[],"year":"2014","images":{"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2176820934.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2176820934.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2176820934.jpg"},"alt":"https://movie.douban.com/subject/25849036/","id":"25849036"}]
     * title : 搜索 "漫威" 的结果
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * rating : {"max":10,"average":9.1,"stars":"45","min":0}
         * genres : ["剧情","动作","犯罪"]
         * title : 制裁者
         * casts : [{"alt":"https://movie.douban.com/celebrity/1049679/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg"},"name":"乔·博恩瑟","id":"1049679"},{"alt":"https://movie.douban.com/celebrity/1323445/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56531.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56531.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56531.jpg"},"name":"艾波·罗丝·雷瓦","id":"1323445"},{"alt":"https://movie.douban.com/celebrity/1137089/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p27617.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p27617.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p27617.jpg"},"name":"艾邦·摩斯-巴克拉赫","id":"1137089"}]
         * collect_count : 1570
         * original_title : The Punisher
         * subtype : tv
         * directors : [{"alt":"https://movie.douban.com/celebrity/1339951/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg"},"name":"安迪·戈达德","id":"1339951"},{"alt":"https://movie.douban.com/celebrity/1297313/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p22445.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p22445.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p22445.jpg"},"name":"汤姆·森兰","id":"1297313"},{"alt":"https://movie.douban.com/celebrity/1305517/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496304684.02.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496304684.02.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496304684.02.jpg"},"name":"安东尼奥·坎波斯","id":"1305517"},{"alt":"https://movie.douban.com/celebrity/1050169/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5862.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5862.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5862.jpg"},"name":"凯文·霍克斯","id":"1050169"},{"alt":"https://movie.douban.com/celebrity/1356857/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"马克·乔博斯特","id":"1356857"},{"alt":"https://movie.douban.com/celebrity/1042024/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"吉姆·奥汉龙","id":"1042024"},{"alt":"https://movie.douban.com/celebrity/1297749/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1423388251.37.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1423388251.37.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1423388251.37.jpg"},"name":"卡莉·斯考格兰德","id":"1297749"},{"alt":"https://movie.douban.com/celebrity/1298671/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"史蒂芬·瑟吉克","id":"1298671"},{"alt":"https://movie.douban.com/celebrity/1373405/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"迪尔巴拉·沃尔什","id":"1373405"},{"alt":"https://movie.douban.com/celebrity/1357865/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/phJiw7gbQTNkcel_avatar_uploaded1463475968.24.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/phJiw7gbQTNkcel_avatar_uploaded1463475968.24.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/phJiw7gbQTNkcel_avatar_uploaded1463475968.24.jpg"},"name":"杰里米·韦布","id":"1357865"},{"alt":"https://movie.douban.com/celebrity/1382257/","avatars":{"small":"http://img3.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img7.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img3.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"Jet Wilkinson","id":"1382257"}]
         * year : 2017
         * images : {"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2500482503.jpg","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2500482503.jpg","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2500482503.jpg"}
         * alt : https://movie.douban.com/subject/26710394/
         * id : 26710394
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 9.1
             * stars : 45
             * min : 0
             */

            private double max;
            private double average;
            private String stars;
            private int min;

            public double getMax() {
                return max;
            }

            public void setMax(double max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2500482503.jpg
             * large : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2500482503.jpg
             * medium : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2500482503.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1049679/
             * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg"}
             * name : 乔·博恩瑟
             * id : 1049679
             */

            private String alt;
            private AvatarsBean avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg
                 * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg
                 * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10894.jpg
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1339951/
             * avatars : {"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg"}
             * name : 安迪·戈达德
             * id : 1339951
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBeanX {
                /**
                 * small : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg
                 * large : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg
                 * medium : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1496733556.8.jpg
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }
    }
}
