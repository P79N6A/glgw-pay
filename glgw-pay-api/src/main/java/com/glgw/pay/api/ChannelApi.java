package com.glgw.pay.api;

import com.glgw.pay.request.BankCnapsQueryByCityAndBankRequest;
import com.glgw.pay.request.BankCnapsQueryByCnapsRequest;
import com.glgw.pay.request.BankCnapsQueryCityRequest;
import com.glgw.pay.request.IssuerQueryByPIReqeset;
import com.glgw.pay.response.*;

public interface ChannelApi {

    //根据支付工具查询渠道发卡机构列表
    public GlgwResponse<IssuerListResponse> queryAllByPI(IssuerQueryByPIReqeset request) throws Exception;

    //全量查询省份信息
    public GlgwResponse<ProvinceListResponse> queryProvince() throws Exception;


    //根据省份id查询城市信息
    public GlgwResponse<CityListResponse> queryCityByProvince(BankCnapsQueryCityRequest request) throws Exception;


    //根据城市id和银行编码查询联行信息
    public GlgwResponse<BankCnapsListResponse> queryByCityAndBank(BankCnapsQueryByCityAndBankRequest request) throws Exception;


    //根据联行号查询银行信息
    public GlgwResponse<BankCnapsResponse> queryByCnaps(BankCnapsQueryByCnapsRequest request) throws Exception;

}
