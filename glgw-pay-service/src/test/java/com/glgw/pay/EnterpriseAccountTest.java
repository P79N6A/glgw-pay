package com.glgw.pay;

import com.glgw.pay.request.*;
import com.glgw.pay.response.GlgwResponse;
import com.glgw.pay.service.EnterpriseAccountServiceImpl;
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
public class EnterpriseAccountTest {

    private static final Logger logger = LogManager.getLogger(EnterpriseAccountTest.class);

    @Autowired
    private EnterpriseAccountServiceImpl enterpriseAccountService;

    //企业资金账户信息查询接口 (已调通)
    @Test
    public void testQueryAccountInfo() {
        EnterAccountInfoRequest request = new EnterAccountInfoRequest();
        request.setMerCustomerId("fk000000");

        try {
            GlgwResponse response = enterpriseAccountService.queryAccountInfo(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }

    //余额充值收单接口 (已调通)
    @Test
    public void testBalanceRechargeOrder() {
        BalanceRechargeOrderRequest request = new BalanceRechargeOrderRequest();
        request.setMerCustomerId("fk000000");
        request.setMerOrderNo("CZ0010");
        request.setOrderAmount(500L);
        request.setCallBackUrl("http://localhost:8080/index.jsp");
        request.setMemo("余额充值");

        try {
            GlgwResponse response = enterpriseAccountService.balanceRechargeOrder(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }


    //余额充值订单查询接口 (已调通)
    @Test
    public void testQueryBalanceRechargeInfo() {
        BalanceRechargeQueryRequest request = new BalanceRechargeQueryRequest();
        request.setMerOrderNo("CZ0010");

        try {
            GlgwResponse response = enterpriseAccountService.queryBalanceRechargeInfo(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }


    //余额提现收单接口 (已调通)
    @Test
    public void testBalanaceExtractOrder() {
        BalanceExtractOrderRequest request = new BalanceExtractOrderRequest();
        request.setMerCustomerId("fk000000");
        request.setMerOrderNo("TX010");
        request.setOrderAmount(35L);
        request.setMemo("余额提现");

        try {
            GlgwResponse response = enterpriseAccountService.balanaceExtractOrder(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }

    //余额提现订单查询接口 (已调通)
    @Test
    public void testQueryBalanaceExtractInfo() {
        BalanceExtractQueryRequest request = new BalanceExtractQueryRequest();
        request.setMerOrderNo("TX010");

        try {
            GlgwResponse response = enterpriseAccountService.queryBalanaceExtractInfo(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }

}

