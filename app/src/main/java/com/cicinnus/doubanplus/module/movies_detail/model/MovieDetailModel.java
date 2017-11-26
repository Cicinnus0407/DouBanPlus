package com.cicinnus.doubanplus.module.movies_detail.model;

import com.cicinnus.doubanplus.base.IteratorObj;

import java.util.List;

/**
 * Created by Cicinnus
 * on 2017/11/25.
 */

public class MovieDetailModel {

    //影片名字
    private String title;
    //评分
    private String rating;
    //上映信息
    private List<ReleaseInfo> releaseInfoList;
    //评价人数
    private String ratingsCount;
    //影片类型
    private List<MovieType> movieTypeList;
    //影片简介
    private String summary;
    //影片海报
    private String image;
    //获奖列表
    private List<Award> awardList;
    //短评
    private List<ShortComment> shortComments;




    private List<CastsModel> castsModel;
    private List<PicModel> picModel;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Award> getAwardList() {
        return awardList;
    }

    public void setAwardList(List<Award> awardList) {
        this.awardList = awardList;
    }

    public List<ShortComment> getShortComments() {
        return shortComments;
    }

    public void setShortComments(List<ShortComment> shortComments) {
        this.shortComments = shortComments;
    }


    public static class MovieLength{
        private String movieLength;

        public String getMovieLength() {
            return movieLength;
        }

        public void setMovieLength(String movieLength) {
            this.movieLength = movieLength;
        }
    }


    public static class MovieType extends IteratorObj<String> {
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String getIteratorString() {
            return getType();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<ReleaseInfo> getReleaseInfoList() {
        return releaseInfoList;
    }

    public void setReleaseInfoList(List<ReleaseInfo> releaseInfoList) {
        this.releaseInfoList = releaseInfoList;
    }

    public String getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(String ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public List<MovieType> getMovieTypeList() {
        return movieTypeList;
    }

    public void setMovieTypeList(List<MovieType> movieTypeList) {
        this.movieTypeList = movieTypeList;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<CastsModel> getCastsModel() {
        return castsModel;
    }

    public void setCastsModel(List<CastsModel> castsModel) {
        this.castsModel = castsModel;
    }

    public List<PicModel> getPicModel() {
        return picModel;
    }

    public void setPicModel(List<PicModel> picModel) {
        this.picModel = picModel;
    }

    public static class ReleaseInfo extends IteratorObj<String> {
        private String releaseInfo;

        public String getReleaseInfo() {
            return releaseInfo;
        }

        public void setReleaseInfo(String releaseInfo) {
            this.releaseInfo = releaseInfo;
        }

        @Override
        public String getIteratorString() {
            return getReleaseInfo();
        }
    }


    public static class Award {
        private String awardName;
        private String awardCondition;
        private List<AwardPeople> awardPeopleList;

        public String getAwardName() {
            return awardName;
        }

        public void setAwardName(String awardName) {
            this.awardName = awardName;
        }

        public String getAwardCondition() {
            return awardCondition;
        }

        public void setAwardCondition(String awardCondition) {
            this.awardCondition = awardCondition;
        }

        public List<AwardPeople> getAwardPeopleList() {
            return awardPeopleList;
        }

        public void setAwardPeopleList(List<AwardPeople> awardPeopleList) {
            this.awardPeopleList = awardPeopleList;
        }



        public static class AwardPeople extends IteratorObj<String> {
            private String name;

            public AwardPeople(String name) {
                this.name = name;
            }

            public String getName() {
               return name;
           }

           public void setName(String name) {
               this.name = name;
           }

            @Override
            public String getIteratorString() {
                return getName();

            }
        }

    }
    public static class ShortComment {
        private String author;
        private String date;
        private String content;
        private String likeCnt;
        private String ratingStar;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getLikeCnt() {
            return likeCnt;
        }

        public void setLikeCnt(String likeCnt) {
            this.likeCnt = likeCnt;
        }

        public String getRatingStar() {
            return ratingStar;
        }

        public void setRatingStar(String ratingStar) {
            this.ratingStar = ratingStar;
        }
    }

}
