package com.aires.weichat.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: weichat-public
 * @description:
 * @author: fan zhengxiang
 * @create: 2020-08-28 20:51
 */
@XStreamAlias("xml")
public class MusicMessage extends BaseMessage implements Serializable {

    @XStreamAlias("Music")
    private Music music;

    public MusicMessage(Map<String, String> requestMap, Music music) {
        super(requestMap);
        this.setMsgType("music");
        this.music = music;
    }

    public MusicMessage() {
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }


    public static   class Music {
        @XStreamAlias("Title")
        private String title;
        @XStreamAlias("Description")
        private String description;
        @XStreamAlias("MusicUrl")
        private String musicUrl;
        @XStreamAlias("HQMusicUrl")
        private String hQMusicUrl;
        @XStreamAlias("ThumbMediaId")
        private String thumbMediaId;

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

        public String getMusicUrl() {
            return musicUrl;
        }

        public void setMusicUrl(String musicUrl) {
            this.musicUrl = musicUrl;
        }

        public String gethQMusicUrl() {
            return hQMusicUrl;
        }

        public void sethQMusicUrl(String hQMusicUrl) {
            this.hQMusicUrl = hQMusicUrl;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }
    }
}
