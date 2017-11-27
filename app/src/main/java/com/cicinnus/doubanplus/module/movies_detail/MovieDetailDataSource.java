package com.cicinnus.doubanplus.module.movies_detail;


import com.cicinnus.doubanplus.module.movies_detail.model.CastsModel;
import com.cicinnus.doubanplus.module.movies_detail.model.MovieDetailModel;
import com.cicinnus.doubanplus.module.movies_detail.model.PicModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * @author Cicinnus
 *         on 2017/11/24.
 */

public class MovieDetailDataSource {


    /**
     * 获取影片数据,由于豆瓣爸爸的api只提供了很小一部分数据,所以通过Jsoup抓取网页版的数据
     *
     * @param movieId
     * @return
     */
    Observable<MovieDetailModel> getMovieDetailModel(String movieId) {
        return Observable.just("https://movie.douban.com/subject/" + movieId)
                .map(new Function<String, Document>() {
                    @Override
                    public Document apply(String url) throws Exception {
                        return Jsoup.connect(url).get();
                    }
                })
                .map(new Function<Document, MovieDetailModel>() {
                    @Override
                    public MovieDetailModel apply(Document document) throws Exception {
                        MovieDetailModel detailModel = new MovieDetailModel();
                        List<CastsModel> castsModelList = new ArrayList<>();
                        List<PicModel> picModelList = new ArrayList<>();
                        List<MovieDetailModel.ReleaseInfo> releaseInfos = new ArrayList<>();
                        List<MovieDetailModel.MovieType> movieTypeList = new ArrayList<>();


                        //标题
                        detailModel.setTitle(document.select("h1").text());
                        //简介
                        detailModel.setSummary(document.select("span[property=v:summary]").text());
                        //评分
                        detailModel.setRating(document.select("strong[property=v:average]").text());
                        //评分人数
                        detailModel.setRatingsCount(document.select("span[property=v:votes]").text());
                        //影片海报
                        detailModel.setImage(document.select("img[rel=v:image]").attr("src"));
                        //上映信息
                        for (Element element : document.select("span[property=v:initialReleaseDate]")) {
                            MovieDetailModel.ReleaseInfo releaseInfo = new MovieDetailModel.ReleaseInfo();
                            releaseInfo.setReleaseInfo(element.text());
                            releaseInfos.add(releaseInfo);
                        }
                        detailModel.setReleaseInfoList(releaseInfos);
                        //电影类型
                        for (Element element : document.select("span[property=v:genre]")) {
                            MovieDetailModel.MovieType movieType = new MovieDetailModel.MovieType();
                            movieType.setType(element.text());
                            movieTypeList.add(movieType);
                        }
                        detailModel.setMovieTypeList(movieTypeList);


                        //获取影人列表
                        Elements celebrities = document.getElementsByClass("celebrity");
                        for (Element celebrity : celebrities) {
                            CastsModel castsModel = new CastsModel();
                            //名字
                            String name = celebrity.getElementsByTag("a").attr("title");
                            castsModel.setName(name);
                            //头像
                            String bgUrl = celebrity.getElementsByClass("avatar").attr("style");
                            String avatar = bgUrl.substring(bgUrl.indexOf("(") + 1, bgUrl.indexOf(")"));
                            castsModel.setAvatar(avatar);
                            //影人页面Url
                            String castUrl = celebrity.getElementsByTag("a").attr("href");
                            castsModel.setCastUrl(castUrl);
                            //角色
                            String role = celebrity.getElementsByClass("role").attr("title");
                            castsModel.setRole(role);
                            castsModelList.add(castsModel);
                        }
                        detailModel.setCastsModel(castsModelList);

                        //预告片图片和剧照
                        Elements relatedPicElements = document.select("li a img[src]");
                        for (Element relatedPicElement : relatedPicElements) {
                            PicModel picModel = new PicModel();
                            if (relatedPicElement.attr("alt").equals("图片")) {
                                String imgUrl = relatedPicElement.attr("src");
                                picModel.setUrl(imgUrl);
                                picModelList.add(picModel);
                            }
                        }
                        detailModel.setPicModel(picModelList);


                        //获奖情况
                        List<MovieDetailModel.Award> awardList = new ArrayList<>();
                        Elements awardElements = document.select("ul.award");
                        for (Element awardElement : awardElements) {
                            MovieDetailModel.Award award = new MovieDetailModel.Award();
                            List<MovieDetailModel.Award.AwardPeople> awardPeopleList = new ArrayList<>();
                            Element element = awardElement.getElementsByTag("li").first();
                            //奖项名称
                            award.setAwardName(element.getElementsByTag("a").text());
                            //奖项状态,获奖/提名
                            award.setAwardCondition(element.nextElementSibling().text());
                            //候选人名单
                            String[] peopleList = element.nextElementSibling().nextElementSibling().text().split("/");
                            for (String s : peopleList) {
                                awardPeopleList.add(new MovieDetailModel.Award.AwardPeople(s.trim()));
                            }
                            award.setAwardPeopleList(awardPeopleList);
                            awardList.add(award);
                        }
                        detailModel.setAwardList(awardList);


                        //短评
                        List<MovieDetailModel.ShortComment> shortComments = new ArrayList<>();
                        Elements commentElements = document.select("div.comment");
                        for (Element commentElement : commentElements) {
                            MovieDetailModel.ShortComment shortComment = new MovieDetailModel.ShortComment();
                            //点赞数
                            String likeCnt = commentElement.getElementsByClass("votes").text();
                            shortComment.setLikeCnt(likeCnt);
                            //用户名
                            String userName = commentElement.getElementsByClass("comment-info").first().getElementsByTag("a").text();
                            shortComment.setAuthor(userName);
                            //内容
                            String content = commentElement.getElementsByTag("p").text();
                            shortComment.setContent(content);
                            //发布时间
                            String date = commentElement.getElementsByClass("comment-time ").text();
                            shortComment.setDate(date);
                            //评分字符串
                            String ratingStr = commentElement.getElementsByClass("comment-info").first().getElementsByTag("a").next().next().attr("class");
                            shortComment.setRatingStar(ratingStr);


                            shortComments.add(shortComment);
                        }
                        detailModel.setShortComments(shortComments);
                        //短评数量
                        String shortCommentCnt = document.select("div.mod-hd").first().getElementsByTag("span").get(1).text();
                        detailModel.setShortCommentCnt(shortCommentCnt .substring(1,shortCommentCnt.length()-1).trim());


                        return detailModel;
                    }
                });

    }
}
