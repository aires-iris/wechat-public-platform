package com.aires.weichat.service;

import com.aires.weichat.entity.*;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: weichat-public
 * @description:
 * @author: fan zhengxiang
 * @create: 2020-08-28 19:17
 */
public class WxService {

    private static final String TOKEN = "fanzhengxiang";

    /**
     * 微信签名验证
     *
     * @param signature
     * @param nonce
     * @param timestamp
     * @return
     */
    public static boolean check(String signature, String nonce, String timestamp) {
        // 1字典排序
        String[] strs = new String[]{TOKEN, timestamp, nonce};
        Arrays.sort(strs);
        // 2拼接字符串然后sha1加密
        String str = strs[0] + strs[1] + strs[2];
        String mySig = sha1(str);
        // 3校验signature
        return signature.equalsIgnoreCase(mySig);
    }

    /**
     * 进行sha1加密
     *
     * @param src
     * @return
     */
    private static String sha1(String src) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("sha1");
            byte[] digest = md.digest(src.getBytes());
            char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            StringBuilder builder = new StringBuilder();
            for (byte b : digest) {
                // 处理高4位
                builder.append(chars[(b >> 4) & 15]);
                // 处理低4位
                builder.append(chars[b & 15]);
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 处理xml消息体内容
     *
     * @param is
     * @return
     */
    public static HashMap<String, String> parseRequest(InputStream is) {
        HashMap<String, String> map = new HashMap<>(8);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(is);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            elements.forEach(e -> map.put(e.getName(), e.getStringValue()));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 构建返回的xml字符串
     *
     * @param requestMap
     * @return
     */
    public static String buildResponseXml(HashMap<String, String> requestMap) {
        BaseMessage baseMessage = new BaseMessage();
        switch (requestMap.get("MsgType")) {
            case "text":

                if ("aires".equals(requestMap.get("Content"))) {
                    ArrayList<NewsMessage.Article> list = new ArrayList<>();
                    list.add(new NewsMessage.Article("title","describution","https://www.aires-iris.tech/content/images/size/w2000/2020/08/49grv8.png","https://www.bing.com"));
                    baseMessage = new NewsMessage(requestMap, list);
                } else {

                    baseMessage = dealText(requestMap);
                }
                break;
            case "image":
                break;
            case "voice":
                break;
            case "video":
                break;
            case "music":
                break;
            case "news":
                break;
            default:
        }
        // 将对象转为xml
        if (baseMessage != null) {
            return beanToXml(baseMessage);
        }
        return null;
    }


    /**
     * 处理文本消息
     *
     * @param requestMap
     * @return
     */
    private static BaseMessage dealText(HashMap<String, String> requestMap) {
        return new TextMessage(requestMap, "你要咋子Ma!");
    }


    /**
     * 对象转xml
     *
     * @param baseMessage
     * @return
     */
    private static String beanToXml(BaseMessage baseMessage) {
        XStream xs = new XStream();
        xs.processAnnotations(TextMessage.class);
        xs.processAnnotations(ImageMessage.class);
        xs.processAnnotations(MusicMessage.class);
        xs.processAnnotations(NewsMessage.class);
        xs.processAnnotations(VideoMessage.class);
        xs.processAnnotations(VoiceMessage.class);
        return xs.toXML(baseMessage);
    }
}
