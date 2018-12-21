package com.glgw.pay.api;

import com.glgw.pay.request.*;
import com.glgw.pay.response.*;

/**
 * 企业信息
 */
public interface EnterpriseInfoApi {

    /**
     * 企业账户注册
     */
    public GlgwResponse<EnterRegisterResponse> register(EnterRegisterRequest request) throws Exception;


    /**
     * 账户信息查询接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    public GlgwResponse<EnterQueryInfoResponse> queryInfo(EnterQueryInfoRequest request) throws Exception;


    /**
     * 企业/个体工商户实名认证申请/变更接口（打款认证）
     *
     * @param request
     * @return
     * @throws Exception
     */
    public GlgwResponse<EnterRealNameApplyResponse> realNamePayApply(EnterRealNameApplyRequest request) throws Exception;


    /**
     * 企业/个体工商户实名认证申请图片上传接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    public GlgwResponse<EnterRealNameApplyUploadImgResponse> realNameApplyUploadImg(EnterRealNameApplyUploadImgRequest request) throws Exception;


    /**
     * 企业/个体工商户查询实名认证申请驳回原因接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    public GlgwResponse<EnterRealNameApplyRejectQueryResponse> realNameApplyRejectQuery(EnterRealNameApplyRejectQueryRequest request) throws Exception;


    /**
     * 企业/个体工商户实名认证打款金额验证接口
     *
     * @param request
     * @return
     * @throws Exception
     */
    public GlgwResponse<EnterRealNamePayCheckResponse> realNamePayCheckMoney(EnterRealNamePayCheckRequest request) throws Exception;


    /**
     * 查询是否同意协议
     * @param request
     * @return
     * @throws Exception
     */
    public GlgwResponse<EnterpriseApplyResponse> queryIsApply(EnterpriseApplyRequest request) throws Exception;

}
