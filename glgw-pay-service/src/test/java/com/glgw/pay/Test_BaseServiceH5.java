package com.glgw.pay;

import com.alibaba.fastjson.JSONObject;
import com.jd.jr.jropen.sdk.api.BaseService;
import com.jd.jr.jropen.sdk.model.CommonRequest;
import com.jd.jr.jropen.sdk.model.CommonRequestHeader;
import com.jd.jr.jropen.sdk.model.enter.HapiLoginRequestBody;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Test_BaseServiceH5 {

    private static final String jrOpenH5Url = "http://back.jd.com:8090/hapi/sign/loginIn";

    public static void main(String[] args) throws Exception {
        CommonRequest<JSONObject> req = new CommonRequest<JSONObject>();
        CommonRequest<HapiLoginRequestBody> commonRequest=new CommonRequest<HapiLoginRequestBody>();
        HapiLoginRequestBody body=new HapiLoginRequestBody();
        CommonRequestHeader header=new CommonRequestHeader();
        header.setCharset("UTF-8");
        header.setEncryptType("3DES");
        header.setSignType("MD5");
        header.setVersion("1.0.0");
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        header.setMerRequestTime(reqTime);

        header.setMerRequestNo("REQ" + reqTime);
        header.setPartnerId("partner_ganglaigangwang");//lplp,lyn4,aaaa,weizhi001，sxf_zhiren,sxf_shuiyou,E7B8435B0F98DACB634A14D1684640BF
        body.setMerCustomerId("fk000000");//partnerMemberID4,lplp123,guoyaxue1,lyn1partnerMemberID9,23762，lyn1partnerMemberID1,sxf_zyc1,eprd_test_1
        header.setAppId("23454558436");//appidlyn4,lpappid，123456,0001,23454558436,00035001
        body.setLoginRole("ENTER");//企业ENTER或者个人账户:PERSONAL
        body.setExtJson("{\"merCustomerId\":\"eprd_test_1\"}");
        body.setComponentCode("SET_AUTHCODE");//TRADE_INFO,BILL_E2E_AGREE,SET_AUTHCODE,POP_AGREE

        commonRequest.setRequestBody(body);
        commonRequest.setRequestHeader(header);
        System.out.println(new BaseService().getRedirectUrl(commonRequest));

    }

}


