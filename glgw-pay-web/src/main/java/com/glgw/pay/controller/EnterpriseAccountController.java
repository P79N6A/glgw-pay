package com.glgw.pay.controller;


import com.glgw.pay.api.EnterDefrayApi;
import com.glgw.pay.api.EnterpriseAccountApi;
import com.glgw.pay.api.EprdPromptPayApi;
import com.glgw.pay.request.*;
import com.glgw.pay.response.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enterpriseAccount")
public class EnterpriseAccountController {

    private static final Logger logger = LogManager.getLogger(EnterpriseAccountController.class);

    @Autowired
    private EnterDefrayApi enterDefrayApi;

    @Autowired
    private EnterpriseAccountApi enterpriseAccountApi;

    @Autowired
    private EprdPromptPayApi eprdPromptPayApi;


    //批量代付
    @RequestMapping("defray")
    public GlgwResponse<EtDefrayResponse> defray(@RequestBody BatchDefrayRequest request) throws Exception {
        GlgwResponse<EtDefrayResponse> response = null;

        try {
            response = enterDefrayApi.defray(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }


    //企业资金账户信息查询接口
    @RequestMapping("queryAccountInfo")
    public GlgwResponse<EnterAccountInfoResponse> queryAccountInfo(@RequestBody EnterAccountInfoRequest request) throws Exception {
        GlgwResponse<EnterAccountInfoResponse> response = null;

        try {
            response = enterpriseAccountApi.queryAccountInfo(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //余额充值收单接口
    @RequestMapping("balanceRechargeOrder")
    public GlgwResponse<BalanceRechargeOrderResponse> balanceRechargeOrder(@RequestBody BalanceRechargeOrderRequest request) throws Exception {
        GlgwResponse<BalanceRechargeOrderResponse> response = null;

        try {
            response = enterpriseAccountApi.balanceRechargeOrder(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //余额充值订单查询接口
    @RequestMapping("queryBalanceRechargeInfo")
    public GlgwResponse<BalanceRechargeQueryResponse> queryBalanceRechargeInfo(@RequestBody BalanceRechargeQueryRequest request) throws Exception {
        GlgwResponse<BalanceRechargeQueryResponse> response = null;

        try {
            response = enterpriseAccountApi.queryBalanceRechargeInfo(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }


    //余额提现收单接口
    @RequestMapping("balanaceExtractOrder")
    public GlgwResponse<BalanceExtractOrderResponse> balanaceExtractOrder(@RequestBody BalanceExtractOrderRequest request) throws Exception {
        GlgwResponse<BalanceExtractOrderResponse> response = null;

        try {
            response = enterpriseAccountApi.balanaceExtractOrder(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //余额提现订单查询接口
    @RequestMapping("queryBalanaceExtractInfo")
    public GlgwResponse<BalanceExtractQueryResponse> queryBalanaceExtractInfo(@RequestBody BalanceExtractQueryRequest request) throws Exception {
        GlgwResponse<BalanceExtractQueryResponse> response = null;

        try {
            response = enterpriseAccountApi.queryBalanaceExtractInfo(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //收银台支付接口
    @RequestMapping("getAccountPayAcquirer")
    public GlgwResponse<PromptPayAcquirerResponse> getAccountPayAcquirer(@RequestBody PromptPayAcquirerRequest request) throws Exception {
        GlgwResponse<PromptPayAcquirerResponse> response = null;

        try {
            response = eprdPromptPayApi.getAccountPayAcquirer(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //实时付款订单查询
    @RequestMapping("queryPromptPayOrder")
    public GlgwResponse<PromptPayAcquirerQueryResponse> queryPromptPayOrder(@RequestBody PromptPayAcquirerQueryRequest request) throws Exception {
        GlgwResponse<PromptPayAcquirerQueryResponse> response = null;

        try {
            response = eprdPromptPayApi.queryPromptPayOrder(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }


}
