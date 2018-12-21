package com.glgw.pay;

import com.glgw.pay.request.*;
import com.glgw.pay.response.EnterRealNameApplyUploadImgResponse;
import com.glgw.pay.response.GlgwResponse;
import com.glgw.pay.service.EnterpriseInfoServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class EnterpriseInfoTest {

    private static final Logger logger = LogManager.getLogger(EnterpriseInfoTest.class);

    @Autowired
    private EnterpriseInfoServiceImpl enterpriseInfoService;


    //账户信息查询接口 (已调通)
    @Test
    public void testQueryInfo() {
        EnterQueryInfoRequest request = new EnterQueryInfoRequest();
        request.setMerCustomerId("fk000000");

        try {
            GlgwResponse response = enterpriseInfoService.queryInfo(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }


    //企业账户注册 (已调通)
    @Test
    public void testRegister() {
        EnterRegisterRequest request = new EnterRegisterRequest();
        request.setMerCustomerId("xx000000");
        request.setJrMerMobile("13051349886");
        request.setAuthorize("1");

        try {
            GlgwResponse response = enterpriseInfoService.register(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }


    //企业/个体工商户实名认证申请/变更接口（打款认证） (已调通)
    @Test
    public void testRealNamePayApply() {
        String partnerApplyId = "PA123456555";

        EnterRealNameApplyRequest request = new EnterRealNameApplyRequest();
        request.setMerCustomerId("hj000000");
        request.setPartnerApplyId(partnerApplyId);
        request.setCompanyType("ENTER");    //公司类型 ENTER:企业  INDIVIDUAL :个体工商户 如果该商户已经实名成功但需要实名信息更新，则该字段需要与原实名信息一致
        request.setBlicCardType("OCI");
        request.setBlicCompanyName("掌众金融");
//        request.setBlicUscc(null);
        request.setBlicCardNo("9985HFDED34988K");
        request.setBlicProvince("110");
        request.setBlicCity("1000");
        request.setBlicAddress("知春路");
        request.setBlicScope("软件研发");
        request.setBlicLongTerm("true");
        request.setBlicValidityEnd("长期");
        request.setBlicUrlA(uploadImg(partnerApplyId, "blicUrlA"));

        request.setBlicTrcCardNo("66666666-8");
        request.setBlicTrcLongTerm("true");
        request.setBlicTrcValidityEnd("长期");
        request.setBlicTrcUrlA(uploadImg(partnerApplyId, "blicTrcUrlA"));
        request.setBlicObaCardNo("24587615154");
        request.setBlicObaUrlA(uploadImg(partnerApplyId, "blicObaUrlA"));

        request.setLepCardType("ID");
        request.setLepName("张成林");
        request.setLepCardNo("411522198607130610");
        request.setLepLongTerm("false");
        request.setLepValidityEnd("2037-10-21 22:22:22");
        request.setLepUrlA(uploadImg(partnerApplyId, "lepUrlA"));
        request.setLepUrlB(uploadImg(partnerApplyId, "lepUrlB"));

        request.setAupIsLEP("true");
        request.setAupCardType(null);
        request.setAupName(null);
        request.setAupCardNo(null);
        request.setAupLongTerm(null);
        request.setAupValidityEnd(null);
        request.setAupUrlA(null);
        request.setAupUrlB(null);
        request.setAupPaUrlA(null);

        request.setOccUrl(uploadImg(partnerApplyId, "occUrl"));
        request.setOccBankAccount("6225880150357581");
        request.setOccBankName("招商银行");
        request.setOccBankCode("CMB");
        request.setOccBankCnap("308");  //记得修改此处值
        request.setOccBankChildCode("308100005416");//记得修改此处值
        request.setOccBankChildName("招商银行股份有限公司北京上地支行");//记得修改此处值

        try {
            GlgwResponse response = enterpriseInfoService.realNamePayApply(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }

    private String uploadImg(String partnerApplyId, String type) {
        EnterRealNameApplyUploadImgRequest request = new EnterRealNameApplyUploadImgRequest();
        request.setMerCustomerId("fk000000");
        request.setPartnerApplyId(partnerApplyId);
        request.setImgFile("D:\\phone.jpg");
        request.setAttachType(type);

        try {
            GlgwResponse<EnterRealNameApplyUploadImgResponse> response = enterpriseInfoService.realNameApplyUploadImg(request);
            logger.info("response:{}", response);

            return response.getBody().getAttachPath();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    //企业/个体工商户实名认证打款金额验证接口
    @Test
    public void testRealNamePayCheckMoney() {
        EnterRealNamePayCheckRequest request = new EnterRealNamePayCheckRequest();
        request.setMerCustomerId("fk000000");
        request.setPartnerApplyId("pa1545044708070");
        request.setAmount("0.11");

        try {
            GlgwResponse response = enterpriseInfoService.realNamePayCheckMoney(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }


    //企业/个体工商户实名认证申请图片上传接口  (已调通)
    @Test
    public void testRealNameApplyUploadImg() {
        EnterRealNameApplyUploadImgRequest request = new EnterRealNameApplyUploadImgRequest();
        request.setMerCustomerId("fk000000");
        request.setPartnerApplyId("pa789456123");
        request.setImgFile("D:\\phone.jpg");
        request.setAttachType("lepUrlA");

        try {
            GlgwResponse response = enterpriseInfoService.realNameApplyUploadImg(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }

    //企业/个体工商户查询实名认证申请驳回原因接口 (已调通)
    @Test
    public void testRealNameApplyRejectQuery() {
        EnterRealNameApplyRejectQueryRequest request = new EnterRealNameApplyRejectQueryRequest();
        request.setMerCustomerId("fk000000");
        request.setPartnerApplyId("pa1545044708070");

        try {
            GlgwResponse response = enterpriseInfoService.realNameApplyRejectQuery(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }

    //查询是否同意协议 (已调通)
    @Test
    public void testQueryIsApply() {
        EnterpriseApplyRequest request = new EnterpriseApplyRequest();
        request.setMerCustomerId("sk000000");

        try {
            GlgwResponse response = enterpriseInfoService.queryIsApply(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }


}
