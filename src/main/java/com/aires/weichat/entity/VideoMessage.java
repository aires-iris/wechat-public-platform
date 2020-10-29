package com.aires.weichat.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: weichat-public
 * @description:
 * @author: fan zhengxiang
 * @create: 2020-08-28 20:48
 */
@XStreamAlias("xml")
public class VideoMessage extends BaseMessage implements Serializable {
    @XStreamAlias("Vodeo")
    private Video video;

    public VideoMessage(Map<String, String> requestMap, Video video) {
        super(requestMap);
        this.setMsgType("video");
        this.video = video;
    }

    public VideoMessage(){}
    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
    public static   class Video {

        @XStreamAlias("MediaId")
        private String mediaId;
        @XStreamAlias("Title")
        private String title;
        @XStreamAlias("Description")
        private String description;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
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
    }
}
