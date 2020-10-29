package com.aires.weichat.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.Map;

/**
 * @program: weichat-public
 * @description:
 * @author: fan zhengxiang
 * @create: 2020-08-28 20:21
 */
@XStreamAlias("xml")
public class TextMessage extends BaseMessage implements Serializable {
    @XStreamAlias("Content")
    private String content;

    public TextMessage(Map<String, String> requestMap, String content) {
        super(requestMap);
        this.setMsgType("text");
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
