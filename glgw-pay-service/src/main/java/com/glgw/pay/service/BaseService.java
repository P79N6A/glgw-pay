package com.glgw.pay.service;

import com.jd.jr.jropen.sdk.api.SecurityService;
import com.jd.jr.jropen.sdk.model.CommonRequestHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BaseService {

    @Value("${partnerId}")
    private String partnerId;
    @Value("${appId}")
    private String appId;
    @Value("${encrypt.type}")
    private String encryptType;


    //设置请求头
    public CommonRequestHeader setCommonRequestHeader(String bodyStr) throws Exception {
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        //请求头
        CommonRequestHeader header = new CommonRequestHeader();
        header.setVersion("1.0.0");
        header.setPartnerId(partnerId);
        header.setAppId(appId);
        header.setMerRequestNo("REQ" + reqTime);
        header.setMerRequestTime(reqTime);
        header.setCharset("UTF-8");
        header.setSignType("MD5");
        header.setEncryptType(encryptType);

        SecurityService securityService = new SecurityService();
        //加密
        String encrypt = securityService.encrypt(bodyStr);
        header.setEncrypt(encrypt);


        StringBuffer sb = new StringBuffer();
        sb.append("sdkVersion=" + header.getSdkVersion() + "&");
        sb.append("version=" + header.getVersion() + "&");
        sb.append("partnerId=" + header.getPartnerId() + "&");
        sb.append("appId=" + header.getAppId() + "&");
        sb.append("merRequestNo=" + header.getMerRequestNo() + "&");
        sb.append("merRequestTime=" + header.getMerRequestTime() + "&");
        sb.append("charset=" + header.getCharset() + "&");
        sb.append("signType=" + header.getSignType() + "&");
        sb.append("encryptType=" + header.getEncryptType() + "&");
        sb.append("encrypt=" + header.getEncrypt());
        //签名
        String sign = securityService.generateSign(sb.toString(), header.getSignType());
        header.setSign(sign);

        return header;
    }


}
