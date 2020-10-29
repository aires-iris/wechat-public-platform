package com.aires.weichat.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: weichat-public
 * @description:
 * @author: fan zhengxiang
 * @create: 2020-08-28 20:47
 */
@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage implements Serializable {

    @XStreamAlias("Voice")
    private Voice voice;

    public VoiceMessage(Map<String, String> requestMap, Voice voice) {
        super(requestMap);
        this.setMsgType("voice");
        this.voice = voice;
    }

    public VoiceMessage() {
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public static class Voice {
        @XStreamAlias("MediaId")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
