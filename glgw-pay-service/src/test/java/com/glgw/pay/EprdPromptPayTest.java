package com.glgw.pay;


import com.glgw.pay.request.PromptPayAcquirerQueryRequest;
import com.glgw.pay.request.PromptPayAcquirerRequest;
import com.glgw.pay.response.GlgwResponse;
import com.glgw.pay.service.EprdPromptPayServiceImpl;
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
public class EprdPromptPayTest {

    private static final Logger logger = LogManager.getLogger(EprdPromptPayTest.class);

    @Autowired
    private EprdPromptPayServiceImpl eprdPromptPayService;


    /**
     * 收银台支付接口 (已调通)
     */
    @Test
    public void testEnterpriseAccountRegister() {
        PromptPayAcquirerRequest request = new PromptPayAcquirerRequest();
        request.setInMerCustomerId("sk000000");   //商户平台收款用户的唯一标识
        request.setOutMerCustomerId("fk000000");  //商户平台出款用户的唯一标识，payRoleType对公时该字段必填，对私时为空
        request.setMerOrderNo("dd999999999");    //商户订单号，唯一定位一笔订单
        request.setOrderAmount(6890);    //订单金额，单位：分
        request.setMemo("测试订单");   //订单概述，限制30中文
        request.setCallBackUrl("http://localhost:8080/payResult.jsp"); //收银台支付后展示结果的页面，例如http://www.jdpay.com
        request.setPayRoleType("FOR_CORPORATE");   //对公对私选项，FOR_CORPORATE：对公
        /**
         * 支付银行类型，
         * NORMAL_PAY：普通银行，由商户平台的用户自主选择银行支付，
         * 商户平台不需要传递payBankCode字段给开放平台，
         * 商户平台的用户在收银台自主选择银行支付。
         */
        request.setPayBankType("NORMAL_PAY");
        request.setPayBankCode(null);//银行编码

        try {
            GlgwResponse response = eprdPromptPayService.getAccountPayAcquirer(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }
    }


    /**
     * 实时付款订单查询  (已调通)
     */
    @Test
    public void testQueryPromptPayOrder() {
        PromptPayAcquirerQueryRequest request = new PromptPayAcquirerQueryRequest();
        request.setMerOrderNo("dd999999999");   //商户平台收款用户的唯一标识

        try {
            GlgwResponse response = eprdPromptPayService.queryPromptPayOrder(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }
    }
}
