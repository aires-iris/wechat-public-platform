package com.aires.weichat.controller;

import com.aires.weichat.service.WxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

/**
 * @program: weichat-public
 * @description:
 * @author: fan zhengxiang
 * @create: 2020-08-28 19:17
 */
@RestController
@Slf4j
public class WeixinController {


    /**
     * 微信服务器校验
     *
     * @param request
     * @return
     */
    @GetMapping("/wx")
    public String doGet(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String nonce = request.getParameter("nonce");
        String timestamp = request.getParameter("timestamp");
        String echostr = request.getParameter("echostr");
        // 校验请求
        if (WxService.check(signature, nonce, timestamp)) {
            log.info("接入成功!!!");
            return echostr;
        } else {
            log.info("接入失败!!!");
            return null;
        }
    }

    /**
     * 接收用户消息
     *
     * @param request
     * @return
     */
    @PostMapping("/wx")
    public String doPost(HttpServletRequest request) {
        try {
            HashMap<String, String> requestMap = WxService.parseRequest(request.getInputStream());
            System.out.println(requestMap);
            String xml = WxService.buildResponseXml(requestMap);
            System.out.println(xml);
            return xml;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
