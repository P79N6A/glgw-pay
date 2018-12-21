package com.glgw.pay.api;

import com.glgw.pay.request.*;
import com.glgw.pay.response.*;

/**
 * 企业账户信息
 */
public interface EnterpriseAccountApi {

    //企业资金账户信息查询接口
    public GlgwResponse<EnterAccountInfoResponse> queryAccountInfo(EnterAccountInfoRequest request) throws Exception;

    //余额充值收单接口
    public GlgwResponse<BalanceRechargeOrderResponse> balanceRechargeOrder(BalanceRechargeOrderRequest request) throws Exception;

    //余额充值订单查询接口
    public GlgwResponse<BalanceRechargeQueryResponse> queryBalanceRechargeInfo(BalanceRechargeQueryRequest request) throws Exception;

    //余额提现收单接口
    public GlgwResponse<BalanceExtractOrderResponse> balanaceExtractOrder(BalanceExtractOrderRequest request) throws Exception;

    //余额提现订单查询接口
    public GlgwResponse<BalanceExtractQueryResponse> queryBalanaceExtractInfo(BalanceExtractQueryRequest request) throws Exception;


}
