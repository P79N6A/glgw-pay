package com.glgw.pay.controller;

import com.glgw.pay.api.ChannelApi;
import com.glgw.pay.api.EnterpriseInfoApi;
import com.glgw.pay.request.*;
import com.glgw.pay.response.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enterpriseInfo")
public class EnterpriseInfoController {

    private static final Logger logger = LogManager.getLogger(EnterpriseInfoController.class);

    @Autowired
    private ChannelApi channelApi;

    @Autowired
    private EnterpriseInfoApi enterpriseInfoApi;

    //根据支付工具查询渠道发卡机构列表
    @RequestMapping("queryAllByPI")
    public GlgwResponse<IssuerListResponse> queryAllByPI(@RequestBody IssuerQueryByPIReqeset request) throws Exception {
        GlgwResponse<IssuerListResponse> response = null;

        try {
            response = channelApi.queryAllByPI(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //全量查询省份信息
    @RequestMapping("queryProvince")
    public GlgwResponse<ProvinceListResponse> queryProvince() throws Exception {
        GlgwResponse<ProvinceListResponse> response = null;

        try {
            response = channelApi.queryProvince();
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //根据省份id查询城市信息
    @RequestMapping("queryCityByProvince")
    public GlgwResponse<CityListResponse> queryCityByProvince(@RequestBody BankCnapsQueryCityRequest request) throws Exception {
        GlgwResponse<CityListResponse> response = null;

        try {
            response = channelApi.queryCityByProvince(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //根据城市id和银行编码查询联行信息
    @RequestMapping("queryByCityAndBank")
    public GlgwResponse<BankCnapsListResponse> queryByCityAndBank(@RequestBody BankCnapsQueryByCityAndBankRequest request) throws Exception {
        GlgwResponse<BankCnapsListResponse> response = null;

        try {
            response = channelApi.queryByCityAndBank(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //根据联行号查询银行信息
    @RequestMapping("queryByCnaps")
    public GlgwResponse<BankCnapsResponse> queryByCnaps(@RequestBody BankCnapsQueryByCnapsRequest request) throws Exception {
        GlgwResponse<BankCnapsResponse> response = null;

        try {
            response = channelApi.queryByCnaps(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //企业账户注册
    @RequestMapping("register")
    public GlgwResponse<EnterRegisterResponse> register(@RequestBody EnterRegisterRequest request) throws Exception {
        GlgwResponse<EnterRegisterResponse> response = null;

        try {
            response = enterpriseInfoApi.register(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //账户信息查询接口
    @RequestMapping("queryInfo")
    public GlgwResponse<EnterQueryInfoResponse> queryInfo(@RequestBody EnterQueryInfoRequest request) throws Exception {
        GlgwResponse<EnterQueryInfoResponse> response = null;

        try {
            response = enterpriseInfoApi.queryInfo(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }


    //企业/个体工商户实名认证申请/变更接口（打款认证）
    @RequestMapping("realNamePayApply")
    public GlgwResponse<EnterRealNameApplyResponse> realNamePayApply(@RequestBody EnterRealNameApplyRequest request) throws Exception {
        GlgwResponse<EnterRealNameApplyResponse> response = null;

        try {
            response = enterpriseInfoApi.realNamePayApply(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //业/个体工商户实名认证申请图片上传接口
    @RequestMapping("realNameApplyUploadImg")
    public GlgwResponse<EnterRealNameApplyUploadImgResponse> realNameApplyUploadImg(@RequestBody EnterRealNameApplyUploadImgRequest request) throws Exception {
        GlgwResponse<EnterRealNameApplyUploadImgResponse> response = null;

        try {
            response = enterpriseInfoApi.realNameApplyUploadImg(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //企业/个体工商户查询实名认证申请驳回原因接口
    @RequestMapping("realNameApplyRejectQuery")
    public GlgwResponse<EnterRealNameApplyRejectQueryResponse> realNameApplyRejectQuery(@RequestBody EnterRealNameApplyRejectQueryRequest request) throws Exception {
        GlgwResponse<EnterRealNameApplyRejectQueryResponse> response = null;

        try {
            response = enterpriseInfoApi.realNameApplyRejectQuery(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //企业/个体工商户实名认证打款金额验证接口
    @RequestMapping("realNamePayCheckMoney")
    public GlgwResponse<EnterRealNamePayCheckResponse> realNamePayCheckMoney(@RequestBody EnterRealNamePayCheckRequest request) throws Exception {
        GlgwResponse<EnterRealNamePayCheckResponse> response = null;

        try {
            response = enterpriseInfoApi.realNamePayCheckMoney(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

    //查询是否同意协议
    @RequestMapping("queryIsApply")
    public GlgwResponse<EnterpriseApplyResponse> queryIsApply(@RequestBody EnterpriseApplyRequest request) throws Exception {
        GlgwResponse<EnterpriseApplyResponse> response = null;

        try {
            response = enterpriseInfoApi.queryIsApply(request);
        } catch (Exception e) {
            logger.error("{}", e);
        }
        return response;
    }

}
