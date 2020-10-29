package com.aires.weichat.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @program: weichat-public
 * @description:
 * @author: fan zhengxiang
 * @create: 2020-08-28 20:53
 */
@XStreamAlias("xml")
public class NewsMessage extends BaseMessage implements Serializable {


    @XStreamAlias("ArticleCount")
    private String articleCount;
    @XStreamAlias("Articles")
    private List<Article> articles;

    public NewsMessage(Map<String, String> requestMap, List<Article> articles) {
        super(requestMap);
        this.setMsgType("news");
        this.articleCount = articles.size() + "";
        this.articles = articles;
    }

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @XStreamAlias("item")
    public static class Article {
        @XStreamAlias("Title")
        private String title;
        @XStreamAlias("Description")
        private String description;
        @XStreamAlias("PicUrl")
        private String picUrl;
        @XStreamAlias("Url")
        private String url;

        public Article(String title, String description, String picUrl, String url) {
            this.title = title;
            this.description = description;
            this.picUrl = picUrl;
            this.url = url;
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
}
