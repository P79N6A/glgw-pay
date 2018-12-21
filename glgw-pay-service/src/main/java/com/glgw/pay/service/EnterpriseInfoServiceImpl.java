package com.glgw.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.glgw.pay.api.EnterpriseInfoApi;
import com.glgw.pay.enums.ErrorCodeConstant;
import com.glgw.pay.request.*;
import com.glgw.pay.response.*;
import com.jd.jr.jropen.sdk.api.EnterpriseInfoService;
import com.jd.jr.jropen.sdk.model.CommonRequest;
import com.jd.jr.jropen.sdk.model.CommonRequestHeader;
import com.jd.jr.jropen.sdk.model.CommonResponse;
import com.jd.jr.jropen.sdk.model.enter.*;
import com.jd.jr.jropen.sdk.util.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

@Service
public class EnterpriseInfoServiceImpl extends BaseService implements EnterpriseInfoApi {

    private static final Logger logger = LogManager.getLogger(EnterpriseInfoServiceImpl.class);


    //企业账户注册
    @Override
    public GlgwResponse<EnterRegisterResponse> register(EnterRegisterRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},企业账户注册上送数据：{}", reqNum, request);


        GlgwResponse<EnterRegisterResponse> response = new GlgwResponse();

        //请求体
        EnterRegisterRequestBody body = new EnterRegisterRequestBody();
        body.setMerCustomerId(request.getMerCustomerId());
        body.setJrMerMobile(request.getJrMerMobile());
        body.setAuthorize(request.getAuthorize());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<EnterRegisterRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoService();
        CommonResponse<EnterRegisterResponseBody> commonResponse = enterpriseInfoService.register(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);


        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                EnterRegisterResponseBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    EnterRegisterResponse enterRegisterResponse = new EnterRegisterResponse();

                    enterRegisterResponse.setJrMerchantId(responseBody.getJrMerchantId());
                    enterRegisterResponse.setAlais(responseBody.getAlais());

                    response.setBody(enterRegisterResponse);
                    response.setSuccess();
                } else {
                    response.setFail(commonResponse.getResponseBody().getResponseCode(), commonResponse.getResponseBody().getResponseDesc());
                }
            } else {
                response.setFail(commonResponse.getResponseHeader().getCode(), commonResponse.getResponseHeader().getMsg());
            }
        } else {
            response.setFail(ErrorCodeConstant.SYSTEM_EXCEPTION.getValue(), ErrorCodeConstant.SYSTEM_EXCEPTION.getName());
        }

        logger.info("请求编号:{},企业账户注册返回数据：{}", reqNum, response);
        return response;
    }

    //账户信息查询接口
    @Override
    public GlgwResponse<EnterQueryInfoResponse> queryInfo(EnterQueryInfoRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},账户信息查询接口上送数据：{}", reqNum, request);

        GlgwResponse<EnterQueryInfoResponse> response = new GlgwResponse();

        //请求体
        EnterQueryInfoRequestBody body = new EnterQueryInfoRequestBody();
        body.setMerCustomerId(request.getMerCustomerId());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<EnterQueryInfoRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoService();
        CommonResponse<EnterQueryInfoResponseBody> commonResponse = enterpriseInfoService.query(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);


        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                EnterQueryInfoResponseBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    EnterQueryInfoResponse enterQueryInfoResponse = new EnterQueryInfoResponse();

                    enterQueryInfoResponse.setMerCustomerId(responseBody.getMerCustomerId());
                    enterQueryInfoResponse.setHasPayPwd(responseBody.getHasPayPwd());
                    enterQueryInfoResponse.setMerRealStatus(responseBody.getMerRealStatus());

                    response.setBody(enterQueryInfoResponse);
                    response.setSuccess();
                } else {
                    response.setFail(commonResponse.getResponseBody().getResponseCode(), commonResponse.getResponseBody().getResponseDesc());
                }
            } else {
                response.setFail(commonResponse.getResponseHeader().getCode(), commonResponse.getResponseHeader().getMsg());
            }
        } else {
            response.setFail(ErrorCodeConstant.SYSTEM_EXCEPTION.getValue(), ErrorCodeConstant.SYSTEM_EXCEPTION.getName());
        }

        logger.info("请求编号:{},账户信息查询接口返回数据：{}", reqNum, response);
        return response;
    }

    //企业/个体工商户实名认证申请/变更接口（打款认证）
    @Override
    public GlgwResponse<EnterRealNameApplyResponse> realNamePayApply(EnterRealNameApplyRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},企业/个体工商户实名认证申请/变更接口(打款认证)上送数据：{}", reqNum, request);


        GlgwResponse<EnterRealNameApplyResponse> response = new GlgwResponse();

        //请求体
        EnterRealNameApplyRequestBody body = new EnterRealNameApplyRequestBody();
        body.setMerCustomerId(request.getMerCustomerId());
        body.setPartnerApplyId(request.getPartnerApplyId());
        body.setCompanyType(request.getCompanyType());
        body.setBlicCardType(request.getBlicCardType());
        body.setBlicCompanyName(request.getBlicCompanyName());
        body.setBlicUscc(request.getBlicUscc());
        body.setBlicCardNo(request.getBlicCardNo());
        body.setBlicProvince(request.getBlicProvince());
        body.setBlicCity(request.getBlicCity());
        body.setBlicAddress(request.getBlicAddress());
        body.setBlicScope(request.getBlicScope());
        body.setBlicLongTerm(request.getBlicLongTerm());
        body.setBlicValidityEnd(request.getBlicValidityEnd());
        body.setBlicUrlA(request.getBlicUrlA());
        body.setBlicTrcCardNo(request.getBlicTrcCardNo());
        body.setBlicTrcLongTerm(request.getBlicTrcLongTerm());
        body.setBlicTrcValidityEnd(request.getBlicTrcValidityEnd());
        body.setBlicTrcUrlA(request.getBlicTrcUrlA());
        body.setBlicObaCardNo(request.getBlicObaCardNo());
        body.setBlicObaUrlA(request.getBlicObaUrlA());
        body.setLepCardType(request.getLepCardType());
        body.setLepName(request.getLepName());
        body.setLepCardNo(request.getLepCardNo());
        body.setLepLongTerm(request.getLepLongTerm());
        body.setLepValidityEnd(request.getLepValidityEnd());
        body.setLepUrlA(request.getLepUrlA());
        body.setLepUrlB(request.getLepUrlB());
        body.setAupIsLEP(request.getAupIsLEP());
        body.setAupCardType(request.getAupCardType());
        body.setAupName(request.getAupName());
        body.setAupCardNo(request.getAupCardNo());
        body.setAupLongTerm(request.getAupLongTerm());
        body.setAupValidityEnd(request.getAupValidityEnd());
        body.setAupUrlA(request.getAupUrlA());
        body.setAupUrlB(request.getAupUrlB());
        body.setAupPaUrlA(request.getAupPaUrlA());
        body.setOccUrl(request.getOccUrl());
        body.setOccBankAccount(request.getOccBankAccount());
        body.setOccBankName(request.getOccBankName());
        body.setOccBankCode(request.getOccBankCode());
        body.setOccBankCnap(request.getOccBankCnap());
        body.setOccBankChildName(request.getOccBankChildName());
        body.setOccBankChildCode(request.getOccBankChildCode());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<EnterRealNameApplyRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoService();
        CommonResponse<EnterRealNameApplyResponseBody> commonResponse = enterpriseInfoService.realNamePayApply(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                EnterRealNameApplyResponseBody responseBody = commonResponse.getResponseBody();
                if ("00000".equals(responseBody.getResultCode())) {
                    EnterRealNameApplyResponse enterRealNameApplyResponse = new EnterRealNameApplyResponse();

                    enterRealNameApplyResponse.setPartnerApplyId(responseBody.getPartnerApplyId());
                    enterRealNameApplyResponse.setJrApplyId(responseBody.getJrApplyId());
                    enterRealNameApplyResponse.setErrorMap(responseBody.getErrorMap());

                    response.setBody(enterRealNameApplyResponse);
                    response.setSuccess();
                } else {
                    response.setFail(commonResponse.getResponseBody().getResultCode(), commonResponse.getResponseBody().getResultDesc());
                }
            } else {
                response.setFail(commonResponse.getResponseHeader().getCode(), commonResponse.getResponseHeader().getMsg());
            }
        } else {
            response.setFail(ErrorCodeConstant.SYSTEM_EXCEPTION.getValue(), ErrorCodeConstant.SYSTEM_EXCEPTION.getName());
        }

        logger.info("请求编号:{},企业/个体工商户实名认证申请/变更接口(打款认证)返回数据：{}", reqNum, response);
        return response;
    }

    //企业/个体工商户实名认证申请图片上传接口
    @Override
    public GlgwResponse<EnterRealNameApplyUploadImgResponse> realNameApplyUploadImg(EnterRealNameApplyUploadImgRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},企业/个体工商户实名认证申请图片上传接口上送数据：{}", reqNum, request);


        GlgwResponse<EnterRealNameApplyUploadImgResponse> response = new GlgwResponse();

        //请求体
        EnterRealNameApplyUploadImgRequestBody body = new EnterRealNameApplyUploadImgRequestBody();
        body.setMerCustomerId(request.getMerCustomerId());
        body.setPartnerApplyId(request.getPartnerApplyId());
        body.setAttachType(request.getAttachType());

        FileImageInputStream input = new FileImageInputStream(new File(request.getImgFile()));
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
        body.setBase64Text(xx);


        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<EnterRealNameApplyUploadImgRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoService();
        CommonResponse<EnterRealNameApplyUploadImgResponseBody> commonResponse = enterpriseInfoService.realNameApplyUploadImg(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                EnterRealNameApplyUploadImgResponseBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    EnterRealNameApplyUploadImgResponse enterRealNameApplyUploadImgResponse = new EnterRealNameApplyUploadImgResponse();

                    enterRealNameApplyUploadImgResponse.setAttachPath(responseBody.getAttachPath());

                    response.setBody(enterRealNameApplyUploadImgResponse);
                    response.setSuccess();
                } else {
                    response.setFail(commonResponse.getResponseBody().getResponseCode(), commonResponse.getResponseBody().getResponseDesc());
                }
            } else {
                response.setFail(commonResponse.getResponseHeader().getCode(), commonResponse.getResponseHeader().getMsg());
            }
        } else {
            response.setFail(ErrorCodeConstant.SYSTEM_EXCEPTION.getValue(), ErrorCodeConstant.SYSTEM_EXCEPTION.getName());
        }

        logger.info("请求编号:{},企业/个体工商户实名认证申请图片上传接口返回数据：{}", reqNum, response);
        return response;
    }

    //企业/个体工商户查询实名认证申请驳回原因接口
    @Override
    public GlgwResponse<EnterRealNameApplyRejectQueryResponse> realNameApplyRejectQuery(EnterRealNameApplyRejectQueryRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},企业/个体工商户查询实名认证申请驳回原因接口上送数据：{}", reqNum, request);


        GlgwResponse<EnterRealNameApplyRejectQueryResponse> response = new GlgwResponse();

        //请求体
        EnterRealNameApplyRejectQueryRequestBody body = new EnterRealNameApplyRejectQueryRequestBody();
        body.setMerCustomerId(request.getMerCustomerId());
        body.setPartnerApplyId(request.getPartnerApplyId());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<EnterRealNameApplyRejectQueryRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoService();
        CommonResponse<EnterRealNameApplyRejectQueryResponseBody> commonResponse = enterpriseInfoService.realNameApplyRejectQuery(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                EnterRealNameApplyRejectQueryResponseBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    EnterRealNameApplyRejectQueryResponse enterRealNameApplyRejectQueryResponse = new EnterRealNameApplyRejectQueryResponse();

                    enterRealNameApplyRejectQueryResponse.setAuditStatus(responseBody.getAuditStatus());
                    enterRealNameApplyRejectQueryResponse.setSubAuditStatus(responseBody.getSubAuditStatus());
                    enterRealNameApplyRejectQueryResponse.setRejectMap(responseBody.getRejectMap());

                    response.setBody(enterRealNameApplyRejectQueryResponse);
                    response.setSuccess();
                } else {
                    response.setFail(commonResponse.getResponseBody().getResponseCode(), commonResponse.getResponseBody().getResponseDesc());
                }
            } else {
                response.setFail(commonResponse.getResponseHeader().getCode(), commonResponse.getResponseHeader().getMsg());
            }
        } else {
            response.setFail(ErrorCodeConstant.SYSTEM_EXCEPTION.getValue(), ErrorCodeConstant.SYSTEM_EXCEPTION.getName());
        }

        logger.info("请求编号:{},企业/个体工商户查询实名认证申请驳回原因接口返回数据：{}", reqNum, response);
        return response;
    }

    //企业/个体工商户实名认证打款金额验证接口
    @Override
    public GlgwResponse<EnterRealNamePayCheckResponse> realNamePayCheckMoney(EnterRealNamePayCheckRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},企业/个体工商户实名认证打款金额验证接口上送数据：{}", reqNum, request);


        GlgwResponse<EnterRealNamePayCheckResponse> response = new GlgwResponse();

        //请求体
        EnterRealNamePayCheckRequestBody body = new EnterRealNamePayCheckRequestBody();
        body.setMerCustomerId(request.getMerCustomerId());
        body.setPartnerApplyId(request.getPartnerApplyId());
        body.setAmount(request.getAmount());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<EnterRealNamePayCheckRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoService();
        CommonResponse<EnterRealNamePayCheckResponseBody> commonResponse = enterpriseInfoService.realNamePayCheckMoney(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                EnterRealNamePayCheckResponseBody responseBody = commonResponse.getResponseBody();
                if ("00000".equals(responseBody.getResultCode())) {
                    EnterRealNamePayCheckResponse enterRealNamePayCheckResponse = new EnterRealNamePayCheckResponse();

                    enterRealNamePayCheckResponse.setResultCode(responseBody.getResultCode());
                    enterRealNamePayCheckResponse.setResultDesc(responseBody.getResultDesc());
                    enterRealNamePayCheckResponse.setPartnerApplyId(responseBody.getPartnerApplyId());
                    enterRealNamePayCheckResponse.setRemainCount(responseBody.getRemainCount());
                    enterRealNamePayCheckResponse.setTradeNo(responseBody.getTradeNo());

                    response.setBody(enterRealNamePayCheckResponse);
                    response.setSuccess();
                } else {
                    response.setFail(commonResponse.getResponseBody().getResultCode(), commonResponse.getResponseBody().getResultCode());
                }
            } else {
                response.setFail(commonResponse.getResponseHeader().getCode(), commonResponse.getResponseHeader().getMsg());
            }
        } else {
            response.setFail(ErrorCodeConstant.SYSTEM_EXCEPTION.getValue(), ErrorCodeConstant.SYSTEM_EXCEPTION.getName());
        }

        logger.info("请求编号:{},企业/个体工商户实名认证打款金额验证接口返回数据：{}", reqNum, response);
        return response;
    }

    //查询是否同意协议
    @Override
    public GlgwResponse<EnterpriseApplyResponse> queryIsApply(EnterpriseApplyRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},查询是否同意协议上送数据：{}", reqNum, request);


        GlgwResponse<EnterpriseApplyResponse> response = new GlgwResponse();

        //请求体
        EnterpriseApplyRequestBody body = new EnterpriseApplyRequestBody();
        body.setMerCustomerId(request.getMerCustomerId());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<EnterpriseApplyRequestBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        EnterpriseInfoService enterpriseInfoService = new EnterpriseInfoService();
        CommonResponse<EnterpriseApplyResponseBody> commonResponse = enterpriseInfoService.queryIsApply(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);


        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                EnterpriseApplyResponse enterpriseApplyResponse = new EnterpriseApplyResponse();

                EnterpriseApplyResponseBody responseBody = commonResponse.getResponseBody();
                if (responseBody != null) {
                    enterpriseApplyResponse.setId(responseBody.getId());
                    enterpriseApplyResponse.setCreatedDate(responseBody.getCreatedDate());
                    enterpriseApplyResponse.setModifiedDate(responseBody.getModifiedDate());
                    enterpriseApplyResponse.setPartnerId(responseBody.getPartnerId());
                    enterpriseApplyResponse.setPartnerMemberId(responseBody.getPartnerMemberId());
                    enterpriseApplyResponse.setIsAgree(responseBody.getIsAgree());
                    enterpriseApplyResponse.setMerchantId(responseBody.getMerchantId());
                }
                response.setBody(enterpriseApplyResponse);
                response.setSuccess();
            } else {
                response.setFail(commonResponse.getResponseHeader().getCode(), commonResponse.getResponseHeader().getMsg());
            }
        } else {
            response.setFail(ErrorCodeConstant.SYSTEM_EXCEPTION.getValue(), ErrorCodeConstant.SYSTEM_EXCEPTION.getName());
        }

        logger.info("请求编号:{},查询是否同意协议返回数据：{}", reqNum, response);
        return response;
    }
}
