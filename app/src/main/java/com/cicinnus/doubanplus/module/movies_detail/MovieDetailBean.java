package com.cicinnus.doubanplus.module.movies_detail;

import com.cicinnus.doubanplus.module.movies_detail.model.MovieDetailModel;

import java.util.List;

/**
 * @author Cicinnus
 *         on 2017/11/24.
 */

public class MovieDetailBean {

    /**
     * rating : {"max":10,"average":7.5,"stars":"40","min":0}
     * reviews_count : 705
     * wish_count : 21265
     * douban_site : https://site.douban.com/171632/
     * year : 2013
     * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1955027201.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1955027201.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1955027201.jpg"}
     * alt : https://movie.douban.com/subject/3231742/
     * id : 3231742
     * mobile_url : https://movie.douban.com/subject/3231742/mobile
     * title : 钢铁侠3
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/3231742
     * seasons_count : null
     * schedule_url :
     * episodes_count : null
     * countries : ["美国","中国大陆"]
     * genres : ["动作","科幻"]
     * collect_count : 246289
     * casts : [{"alt":"https://movie.douban.com/celebrity/1016681/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.jpg"},"name":"小罗伯特·唐尼","id":"1016681"},{"alt":"https://movie.douban.com/celebrity/1035672/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p381.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p381.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p381.jpg"},"name":"盖·皮尔斯","id":"1035672"},{"alt":"https://movie.douban.com/celebrity/1018985/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1138.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1138.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1138.jpg"},"name":"格温妮斯·帕特洛","id":"1018985"},{"alt":"https://movie.douban.com/celebrity/1054393/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1374649659.58.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1374649659.58.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1374649659.58.jpg"},"name":"本·金斯利","id":"1054393"}]
     * current_season : null
     * original_title : Iron Man 3
     * summary : 自纽约事件以来，托尼·斯塔克（小罗伯特·唐尼 Robert Downey Jr. 饰）为前所未有的焦虑症所困扰。他疯狂投入钢铁侠升级版的研发，为此废寝忘食，甚至忽略了女友佩珀·波茨（格温妮斯·帕特洛 Gwyneth Paltrow 饰）的感受。与此同时，臭名昭著的恐怖头目曼达林（本·金斯利 Ben Kingsley 饰）制造了一连串的爆炸袭击事件，托尼当年最忠诚的保镖即在最近的一次袭击中身负重伤。未过多久，托尼、佩珀以及曾与他有过一面之缘的女植物学家玛雅（丽贝卡·豪尔 Rebecca Hall 饰）在家中遭到猛烈的炮火袭击，几乎丧命，而这一切似乎都与22年前那名偶然邂逅的科学家阿尔德里奇·基连（盖·皮尔斯 Guy Pearce 饰）及其终极生物的研究有关。
     即使有精密先进的铠甲护身，也无法排遣发自心底的焦虑。被击碎一切的托尼，如何穿越来自地狱的熊熊烈火……©豆瓣
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1036569/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg"},"name":"沙恩·布莱克","id":"1036569"}]
     * comments_count : 71729
     * ratings_count : 207307
     * aka : ["铁甲奇侠3(港)","钢铁人3(台)","铁人3"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private int collect_count;
    private Object current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
    private List<String> aka;
    private MovieDetailModel movieDetailModel;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
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

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
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

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public MovieDetailModel getMovieDetailModel() {
        return movieDetailModel;
    }

    public void setMovieDetailModel(MovieDetailModel movieDetailModel) {
        this.movieDetailModel = movieDetailModel;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 7.5
         * stars : 40
         * min : 0
         */

        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
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
         * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1955027201.jpg
         * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1955027201.jpg
         * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p1955027201.jpg
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
         * alt : https://movie.douban.com/celebrity/1016681/
         * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.jpg"}
         * name : 小罗伯特·唐尼
         * id : 1016681
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
             * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.jpg
             * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.jpg
             * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.jpg
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
         * alt : https://movie.douban.com/celebrity/1036569/
         * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg"}
         * name : 沙恩·布莱克
         * id : 1036569
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
             * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg
             * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg
             * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21117.jpg
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
