package com.glgw.pay;

/**
 * CCreated by liuyingnan1 on 16-12-12.
 * update by liuyingnan1 on 18-06-12.
 * 企业会员账户服务
 * 账户基本信息相关服务
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jd.jr.jropen.sdk.api.EnterpriseInfoService;
import com.jd.jr.jropen.sdk.model.CommonRequest;
import com.jd.jr.jropen.sdk.model.CommonRequestHeader;
import com.jd.jr.jropen.sdk.model.enter.*;
import com.jd.jr.jropen.sdk.util.Base64;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class lcfshimingdakuan {
    private static EnterpriseInfoService eis = new EnterpriseInfoService();

    public static void main(String[] args)  throws  Exception{




      //------------------------------打款实名认证--------------------------------

        Test_Register(); //企业账户注册接口
        //realNameApplyRejectQuery();//企业/个体工商户实名认证查詢接口new
       //realNameApplynew();//企业/个体工商户打款实名认证申请/变更接口--李红松
       // realNamePayCheckMoney();//企业/个体工商户打款实名金额校验接口--李红松
    }


    //  企业注册接口
    private static void Test_Register() {
        CommonRequest<EnterRegisterRequestBody> req = new CommonRequest<EnterRegisterRequestBody>();
        CommonRequestHeader reqHeader = new CommonRequestHeader();
        reqHeader.setPartnerId("lcf1188");//weizhi001,lyn4,sxf_zhiren
        reqHeader.setVersion("1.0.0");
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        reqHeader.setMerRequestNo("REQ" + reqTime);
        reqHeader.setMerRequestTime(reqTime);
        reqHeader.setCharset("UTF-8");
        reqHeader.setSignType("MD5");//MD5,CERT
        reqHeader.setEncryptType("3DES");
        req.setRequestHeader(reqHeader);

        EnterRegisterRequestBody reqBody = new EnterRegisterRequestBody();
        reqBody.setAuthorize("1");//0:用户未授权，1：用户已授权；
        reqBody.setJrMerMobile("18910228619");
        reqBody.setMerCustomerId("121223333");//
        req.setRequestBody(reqBody);
        System.out.println(JSONObject.toJSONString(eis.register(req)));
    }

    //    查询账户基本信息接口：密码设置状态、实名状态
    private static void merQueryInfo() {
        CommonRequest<EnterQueryInfoRequestBody> request = new CommonRequest<EnterQueryInfoRequestBody>();
        CommonRequestHeader requestHeader = new CommonRequestHeader();
        requestHeader.setEncryptType("3DES");
        requestHeader.setSignType("CERT");//MD5,CERT
        requestHeader.setPartnerId("lcf1188");
        requestHeader.setAppId("lcf1188");
        requestHeader.setVersion("1.0.0");
        requestHeader.setCharset("UTF-8");
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        requestHeader.setMerRequestNo("REQ" + reqTime);
        requestHeader.setMerRequestTime(reqTime);
        request.setRequestHeader(requestHeader);
        request.setRequestBody(new EnterQueryInfoRequestBody());
        request.getRequestBody().setMerCustomerId("newshiminglcf001");
        System.out.println(JSONObject.toJSONString(eis.query(request)));
    }

    //    账户信息修改接口：手机号变更zanbuzhichi
    private static void Test_modify() {
        CommonRequest<EnterModifyInfoRequestBody> req = new CommonRequest<EnterModifyInfoRequestBody>();
        CommonRequestHeader reqHeader = new CommonRequestHeader();
        reqHeader.setPartnerId("lcf1188");//lyn1
        reqHeader.setVersion("1.0.0");
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        reqHeader.setMerRequestNo("REQ" + reqTime);
        reqHeader.setMerRequestTime(reqTime);
        reqHeader.setCharset("UTF-8");
        reqHeader.setSignType("CERT");//MD5,CERT
        reqHeader.setEncryptType("3DES");
        req.setRequestHeader(reqHeader);

        EnterModifyInfoRequestBody reqBody = new EnterModifyInfoRequestBody();
        reqBody.setMerCustomerId("newshiminglcf001");
        reqBody.setJrMerMobile("18910228699");
        req.setRequestBody(reqBody);
        System.out.println(JSONObject.toJSONString(eis.modify(req)));
    }

    //    查询实名驳回原因接口已经废弃
    private static void Test_queryRealRejectInfo() {
        CommonRequest<EnterRealRejectInfoRequestBody> req = new CommonRequest<EnterRealRejectInfoRequestBody>();
        CommonRequestHeader reqHeader = new CommonRequestHeader();
        reqHeader.setPartnerId("hgl");//lyn6 hgl
        reqHeader.setVersion("1.0.0");
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        reqHeader.setMerRequestNo("REQ" + reqTime);
        reqHeader.setMerRequestTime(reqTime);
        reqHeader.setCharset("UTF-8");
        reqHeader.setSignType("CERT");//MD5,CERT
        reqHeader.setEncryptType("3DES");
        req.setRequestHeader(reqHeader);

        EnterRealRejectInfoRequestBody reqBody = new EnterRealRejectInfoRequestBody();
        reqBody.setMerCustomerId("lcfMerCustomerId88");//lyn6partnerMember003:三证，lyn6partnerMember004：三证合一，lyn6partnerMember005：五证合一
        req.setRequestBody(reqBody);
        System.out.println(JSONObject.toJSONString(eis.queryRealRejectInfo(req)));
    }
    //企业/个体工商户实名认证申请图片上传接口
    private static void realNameApplyUploadImg() throws Exception {
        CommonRequest<EnterRealNameApplyUploadImgRequestBody> req = new CommonRequest<EnterRealNameApplyUploadImgRequestBody>();
        CommonRequestHeader reqHeader = new CommonRequestHeader();
        reqHeader.setPartnerId("lcf1188");//lyn1 sxf_zhiren
        reqHeader.setVersion("1.0.0");
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        reqHeader.setMerRequestNo("REQ" + reqTime);
        reqHeader.setMerRequestTime(reqTime);
        reqHeader.setCharset("UTF-8");
        reqHeader.setSignType("MD5");//MD5,CERT
        reqHeader.setEncryptType("3DES");
        req.setRequestHeader(reqHeader);
        EnterRealNameApplyUploadImgRequestBody reqModel = new EnterRealNameApplyUploadImgRequestBody();
        req.setRequestBody(reqModel);
        FileImageInputStream input = new FileImageInputStream(new File("c:/test.png"));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int numBytesRead = 0;
        while ((numBytesRead = input.read(buf)) != -1) {
            output.write(buf, 0, numBytesRead);
        }
        byte[] data = output.toByteArray();
        output.close();
        input.close();
        String xx = Base64.encodeOriginal(data);
        reqModel.setBase64Text(xx);
        reqModel.setMerCustomerId("INDIVIDUALlcf001");
        reqModel.setPartnerApplyId("lcf1188");
        reqModel.setAttachType("blicUrlA");
        System.out.println(JSON.toJSON(eis.realNameApplyUploadImg(req)));
        reqModel.setAttachType("lepUrlA");
        System.out.println(JSON.toJSON(eis.realNameApplyUploadImg(req)));
        reqModel.setAttachType("lepUrlB");
        System.out.println(JSON.toJSON(eis.realNameApplyUploadImg(req)));
        reqModel.setAttachType("aupPaUrlA");
        System.out.println(JSON.toJSON(eis.realNameApplyUploadImg(req)));
        reqModel.setAttachType("occUrl");
        System.out.println(JSON.toJSON(eis.realNameApplyUploadImg(req)));
        reqModel.setAttachType("aupUrlA");
        System.out.println(JSON.toJSON(eis.realNameApplyUploadImg(req)));
        reqModel.setAttachType("aupUrlB");
        System.out.println(JSON.toJSON(eis.realNameApplyUploadImg(req)));
    }
    //企业/个体工商户实名认证查詢接口
    private static void realNameApplyRejectQuery() {
        CommonRequest<EnterRealNameApplyRejectQueryRequestBody> req = new CommonRequest<EnterRealNameApplyRejectQueryRequestBody>();
        CommonRequestHeader reqHeader = new CommonRequestHeader();
        reqHeader.setPartnerId("lcf1188");//lyn1
        reqHeader.setVersion("1.0.0");
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        reqHeader.setMerRequestNo("REQ" + reqTime);
        reqHeader.setMerRequestTime(reqTime);
        reqHeader.setCharset("UTF-8");
        reqHeader.setSignType("MD5");//MD5,CERT
        reqHeader.setEncryptType("3DES");
        req.setRequestHeader(reqHeader);
        EnterRealNameApplyRejectQueryRequestBody requestBody = new EnterRealNameApplyRejectQueryRequestBody();
        requestBody.setMerCustomerId("上海大众汽车003");//MerCustomerIdlcf002
        requestBody.setPartnerApplyId("198602081530687441008");//8602081530610581226
        req.setRequestBody(requestBody);
        System.out.println(JSON.toJSON(eis.realNameApplyRejectQuery(req)));
    }

    //企业/个体工商户实名认证申请/变更接口--老实名接口
    private static void realNameApply() throws Exception {
        CommonRequest<EnterRealNameApplyRequestBody> req = new CommonRequest<EnterRealNameApplyRequestBody>();
        CommonRequestHeader reqHeader = new CommonRequestHeader();
        reqHeader.setPartnerId("lcf1188");//lyn1  lyn4
        reqHeader.setVersion("1.0.0");
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        reqHeader.setMerRequestNo("REQ" + reqTime);
        reqHeader.setMerRequestTime(reqTime);
        reqHeader.setCharset("UTF-8");
        reqHeader.setSignType("MD5");//MD5,CERT
        reqHeader.setEncryptType("3DES");
        req.setRequestHeader(reqHeader);


        EnterRealNameApplyRequestBody reqMode = getReq1(new EnterRealNameApplyRequestBody());

        reqMode.setBlicUrlA(uploadImg(reqHeader.getPartnerId(), reqMode.getMerCustomerId(),
                reqMode.getPartnerApplyId(), "blicUrlA" + System.currentTimeMillis(), "blicUrlA"));
        reqMode.setLepUrlA(uploadImg(reqHeader.getPartnerId(), reqMode.getMerCustomerId(),
                reqMode.getPartnerApplyId(), "lepUrlA" + System.currentTimeMillis(), "lepUrlA"));
        reqMode.setLepUrlB(uploadImg(reqHeader.getPartnerId(), reqMode.getMerCustomerId(),
                reqMode.getPartnerApplyId(), "lepUrlB" + System.currentTimeMillis(), "lepUrlB"));
        reqMode.setAupPaUrlA(uploadImg(reqHeader.getPartnerId(), reqMode.getMerCustomerId(),
                reqMode.getPartnerApplyId(), "aupPaUrlA" + System.currentTimeMillis(), "aupPaUrlA"));
        reqMode.setOccUrl(uploadImg(reqHeader.getPartnerId(), reqMode.getMerCustomerId(),
                reqMode.getPartnerApplyId(), "occUrl" + System.currentTimeMillis(), "occUrl"));
        reqMode.setAupUrlA(uploadImg(reqHeader.getPartnerId(), reqMode.getMerCustomerId(),
                reqMode.getPartnerApplyId(), "aupUrlA" + System.currentTimeMillis(), "aupUrlA"));
        reqMode.setAupUrlB(uploadImg(reqHeader.getPartnerId(), reqMode.getMerCustomerId(),
                reqMode.getPartnerApplyId(), "aupUrlB" + System.currentTimeMillis(), "aupUrlB"));
        reqMode.setBlicTrcUrlA(uploadImg(reqHeader.getPartnerId(), reqMode.getMerCustomerId(),
                reqMode.getPartnerApplyId(), "blicTrcUrlA" + System.currentTimeMillis(), "blicTrcUrlA"));
        reqMode.setBlicObaUrlA(uploadImg(reqHeader.getPartnerId(), reqMode.getMerCustomerId(),
                reqMode.getPartnerApplyId(), "blicObaUrlA" + System.currentTimeMillis(), "blicObaUrlA"));
        req.setRequestBody(reqMode);
        System.out.println("请求数据:"+ JSONObject.toJSONString(req));
        System.out.println("返回数据"+JSON.toJSON(eis.realNameApply(req)));
    }



    //企业/个体工商户打款实名认证申请/变更接口--李红松
    private static void realNameApplynew() throws Exception {
        CommonRequest<EnterRealNameApplyRequestBody> req = new CommonRequest<EnterRealNameApplyRequestBody>();
        CommonRequestHeader reqHeader = new CommonRequestHeader();
        reqHeader.setPartnerId("lcf1188");// lyn1  lcf  lcf1188
        reqHeader.setVersion("1.0.0");
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        reqHeader.setMerRequestNo("REQ" + reqTime);
        reqHeader.setMerRequestTime(reqTime);
        reqHeader.setCharset("UTF-8");
        reqHeader.setSignType("MD5");// MD5,CERT
        reqHeader.setEncryptType("3DES");
        req.setRequestHeader(reqHeader);


        EnterRealNameApplyRequestBody reqModel = getReq1(new EnterRealNameApplyRequestBody());
        reqModel.setOccBankAccount("6228481234567891003");//("622848"+String.valueOf(System.currentTimeMillis()));
        reqModel.setOccBankName("中国农业银行");
        reqModel.setOccBankCode("ABC");
        reqModel.setOccBankCnap("103");
        reqModel.setOccBankChildCode("103100000013");
        reqModel.setOccBankChildName("农业银行北京1京东12388分行3");

        reqModel.setBlicUrlA(uploadImg(reqHeader.getPartnerId(), reqModel.getMerCustomerId(),
                reqModel.getPartnerApplyId(), "blicUrlA" + System.currentTimeMillis(), "blicUrlA"));
        reqModel.setLepUrlA(uploadImg(reqHeader.getPartnerId(), reqModel.getMerCustomerId(),
                reqModel.getPartnerApplyId(), "lepUrlA" + System.currentTimeMillis(), "lepUrlA"));
        reqModel.setLepUrlB(uploadImg(reqHeader.getPartnerId(), reqModel.getMerCustomerId(),
                reqModel.getPartnerApplyId(), "lepUrlB" + System.currentTimeMillis(), "lepUrlB"));
        reqModel.setAupPaUrlA(uploadImg(reqHeader.getPartnerId(), reqModel.getMerCustomerId(),
                reqModel.getPartnerApplyId(), "aupPaUrlA" + System.currentTimeMillis(), "aupPaUrlA"));
        reqModel.setOccUrl(uploadImg(reqHeader.getPartnerId(), reqModel.getMerCustomerId(),
                reqModel.getPartnerApplyId(), "occUrl" + System.currentTimeMillis(), "occUrl"));
        reqModel.setAupUrlA(uploadImg(reqHeader.getPartnerId(), reqModel.getMerCustomerId(),
                reqModel.getPartnerApplyId(), "aupUrlA" + System.currentTimeMillis(), "aupUrlA"));
        reqModel.setAupUrlB(uploadImg(reqHeader.getPartnerId(), reqModel.getMerCustomerId(),
                reqModel.getPartnerApplyId(), "aupUrlB" + System.currentTimeMillis(), "aupUrlB"));
        reqModel.setBlicTrcUrlA(uploadImg(reqHeader.getPartnerId(), reqModel.getMerCustomerId(),
                reqModel.getPartnerApplyId(), "blicTrcUrlA" + System.currentTimeMillis(), "blicTrcUrlA"));
        reqModel.setBlicObaUrlA(uploadImg(reqHeader.getPartnerId(), reqModel.getMerCustomerId(),
                reqModel.getPartnerApplyId(), "blicObaUrlA" + System.currentTimeMillis(), "blicObaUrlA"));
        req.setRequestBody(reqModel);
        System.out.println("请求数据:"+ JSONObject.toJSONString(req));
        System.out.println("返回数据"+JSON.toJSON(eis.realNamePayApply(req)));
    }



  //以下为实名主体参数

    private static EnterRealNameApplyRequestBody getReq1(EnterRealNameApplyRequestBody reqModel) {
        reqModel.setMerCustomerId("oldshiminglcf001");
        reqModel.setPartnerApplyId("860208"+String.valueOf(System.currentTimeMillis()));//不能重复 ("860208"+String.valueOf(System.currentTimeMillis()))
        reqModel.setCompanyType("ENTER");    //INDIVIDUAL   ENTER
        reqModel.setBlicCardType("USC");//USC:统一社会信用代码证  OCI:多证合一  BLI:普通五证
        reqModel.setBlicCompanyName("企业实名老街口001");
        reqModel.setBlicUscc("88888"+String.valueOf(System.currentTimeMillis()));//"88888"+String.valueOf(System.currentTimeMillis())
        reqModel.setBlicCardNo("BL12345677863");//证件号码：当blicCardType= BLI时必填且必须为15位字母数字组合，当blicCardType= OCI时必填且必须为1-50位字母数字组合。
        reqModel.setBlicProvince("北京");
        reqModel.setBlicCity("北京");
        reqModel.setBlicAddress("京东大厦1001室");
        reqModel.setBlicScope("飞机大炮火箭2直升机核潜艇1001");
        reqModel.setBlicLongTerm("true");
        reqModel.setBlicValidityEnd("长期");

        //BlicCardType("BLI")如下必填
        //reqModel.setBlicUrlA("A2_1807_7_333_8302E13_RAS@6d8b43055c322137d");
        reqModel.setBlicTrcCardNo("12345628-1");    //blicCardType=BLI且companyType= ENTER时必填
        reqModel.setBlicTrcLongTerm("true");      //blicCardType=BLI且companyType= ENTER时必填
        reqModel.setBlicTrcValidityEnd("长期");
       // reqModel.setBlicTrcUrlA("A2_1807_7_333_8302E13_RAS@6d8b43055c322137d");
        reqModel.setBlicObaCardNo("131128254222287653");

        reqModel.setLepCardType("ID");//ID：身份证  PAS：护照 PASHK：港澳通行证
        reqModel.setLepName("刘春锋");
        reqModel.setLepCardNo("131128198801010068");
        reqModel.setLepLongTerm("false");
        reqModel.setLepValidityEnd("2019-01-01 22:22:26");
        //reqModel.setLepUrlA("A2_1807_7_333_8302E13_RAS@6d8b43055c322137d");
        // reqModel.setLepUrlB("A2_1807_7_333_8302E13_RAS@6d8b43055c322137d");

         reqModel.setAupIsLEP("true"); //后面可以不填写

//        reqModel.setAupCardType("PAS");
//        reqModel.setAupName("刘春锋");
//        reqModel.setAupCardNo("131128198602080088");
//        reqModel.setAupLongTerm("true");
//        reqModel.setAupValidityEnd("长期");
//       reqModel.setAupUrlA("A2_1807_7_333_8302E13_RAS@6d8b43055c322137d");
//       reqModel.setAupUrlB("A2_1807_7_333_8302E13_RAS@6d8b43055c322137d");
//       reqModel.setAupPaUrlA("A2_1807_7_333_8302E13_RAS@6d8b43055c322137d");

      // reqModel.setOccUrl("A2_1807_7_333_8302E13_RAS@6d8b43055c322137d");

        return reqModel;
    }

//无需打开  代码无参数
    public static String uploadImg(String partnerId, String merCustomerId, String partnerApplyId, String merRequestNo,
                                   String attachType) throws Exception {
        FileImageInputStream input = new FileImageInputStream(new File("c:/test.png"));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int numBytesRead = 0;
        while ((numBytesRead = input.read(buf)) != -1) {
            output.write(buf, 0, numBytesRead);
        }
        byte[] data = output.toByteArray();
        output.close();
        input.close();
        String xx = Base64.encodeOriginal(data);
        CommonRequest<EnterRealNameApplyUploadImgRequestBody> req = new CommonRequest<EnterRealNameApplyUploadImgRequestBody>();
        CommonRequestHeader reqHeader = new CommonRequestHeader();
        reqHeader.setPartnerId(partnerId);// lyn1
        reqHeader.setVersion("1.0.0");
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        reqHeader.setMerRequestNo("REQ" + reqTime);
        reqHeader.setMerRequestTime(reqTime);
        reqHeader.setCharset("UTF-8");
        reqHeader.setSignType("MD5");// MD5,CERT
        reqHeader.setEncryptType("3DES");
        req.setRequestHeader(reqHeader);
        EnterRealNameApplyUploadImgRequestBody reqModel = new EnterRealNameApplyUploadImgRequestBody();

        reqModel.setBase64Text(xx);
        reqModel.setMerCustomerId(merCustomerId);
        reqModel.setPartnerApplyId(partnerApplyId);
        reqModel.setAttachType(attachType);
        req.setRequestBody(reqModel);
        return eis.realNameApplyUploadImg(req).getResponseBody().getAttachPath();

    }



    // 打款实名校验打款金额--lihongsong
    private static void realNamePayCheckMoney() {
        CommonRequest<EnterRealNamePayCheckRequestBody> req = new CommonRequest<EnterRealNamePayCheckRequestBody>();
        CommonRequestHeader reqHeader = new CommonRequestHeader();
        reqHeader.setPartnerId("partner_huipiaozhushou");// lyn1  lcf1188
        reqHeader.setVersion("1.0.0");
        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        reqHeader.setMerRequestNo("REQ" + reqTime);
        reqHeader.setMerRequestTime(reqTime);
        reqHeader.setCharset("UTF-8");
        reqHeader.setSignType("MD5");// MD5,CERT
        reqHeader.setEncryptType("3DES");
        req.setRequestHeader(reqHeader);
        EnterRealNamePayCheckRequestBody requestBody = new EnterRealNamePayCheckRequestBody();
        requestBody.setMerCustomerId("43");
        requestBody.setPartnerApplyId("2018112214050314441608");
        requestBody.setAmount("0.02");
        req.setRequestBody(requestBody);
        System.out.println(JSON.toJSON(eis.realNamePayCheckMoney(req)));
    }

}