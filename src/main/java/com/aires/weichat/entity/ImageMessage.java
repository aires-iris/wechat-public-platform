package com.aires.weichat.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: weichat-public
 * @description:
 * @author: fan zhengxiang
 * @create: 2020-08-28 20:44
 */
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage implements Serializable {

    @XStreamAlias("Image")
    private Image image;

    public ImageMessage(Map<String, String> requestMap, Image image) {
        super(requestMap);
        this.setMsgType("image");
        this.image = image;
    }

    public ImageMessage() {
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public  class Image {
        @XStreamAlias("MediaId")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public Image(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}

