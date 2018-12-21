package com.glgw.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.glgw.pay.api.ChannelApi;
import com.glgw.pay.enums.ErrorCodeConstant;
import com.glgw.pay.request.BankCnapsQueryByCityAndBankRequest;
import com.glgw.pay.request.BankCnapsQueryByCnapsRequest;
import com.glgw.pay.request.BankCnapsQueryCityRequest;
import com.glgw.pay.request.IssuerQueryByPIReqeset;
import com.glgw.pay.response.*;
import com.jd.jr.jropen.sdk.api.ChannelService;
import com.jd.jr.jropen.sdk.model.CommonRequest;
import com.jd.jr.jropen.sdk.model.CommonRequestHeader;
import com.jd.jr.jropen.sdk.model.CommonResponse;
import com.jd.jr.jropen.sdk.model.channel.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChannelServiceImpl extends BaseService implements ChannelApi {

    private static final Logger logger = LogManager.getLogger(ChannelServiceImpl.class);

    /**
     * 根据支付工具查询渠道发卡机构列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<IssuerListResponse> queryAllByPI(IssuerQueryByPIReqeset request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},根据支付工具查询渠道发卡机构列表上送数据：{}", reqNum, request);

        GlgwResponse<IssuerListResponse> response = new GlgwResponse();

        //请求体
        IssuerQueryByPIReqBody body = new IssuerQueryByPIReqBody();
        body.setPiType(request.getPiType());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<IssuerQueryByPIReqBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        ChannelService channelService = new ChannelService();
        CommonResponse<IssuerListRespBody> commonResponse = channelService.queryAllByPI(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                IssuerListRespBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    IssuerListResponse issuerListResponse = new IssuerListResponse();
                    List<IssuerResonseItem> lists = new ArrayList<>();
                    IssuerResonseItem item = null;

                    List<IssuerRespBody> issuerRespBodyList = responseBody.getLists();
                    for (IssuerRespBody issuerRespBody : issuerRespBodyList) {
                        item = new IssuerResonseItem();
                        item.setIssuerCode(issuerRespBody.getIssuerCode());
                        item.setIssuerName(issuerRespBody.getIssuerName());
                        item.setIssuerShort(issuerRespBody.getIssuerShort());
                        item.setCnapBankCode(issuerRespBody.getCnapBankCode());
                        lists.add(item);
                    }
                    issuerListResponse.setLists(lists);

                    response.setBody(issuerListResponse);
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

        logger.info("请求编号:{},根据支付工具查询渠道发卡机构列表返回数据：{}", reqNum, response);
        return response;
    }


    /**
     * 全量查询省份信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<ProvinceListResponse> queryProvince() throws Exception {
        final long reqNum = System.currentTimeMillis();

        GlgwResponse<ProvinceListResponse> response = new GlgwResponse();

        //请求头
        CommonRequestHeader header = setCommonRequestHeader("{}");

        //请求数据
        CommonRequest<ProvinceQueryReqBody> commonRequest = new CommonRequest<ProvinceQueryReqBody>();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(null);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        ChannelService channelService = new ChannelService();
        CommonResponse<ProvinceListRespBody> commonResponse = channelService.queryProvince(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                ProvinceListRespBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {

                    ProvinceListResponse provinceListResponse = new ProvinceListResponse();
                    List<ProvinceResponseItem> lists = new ArrayList<ProvinceResponseItem>();
                    ProvinceResponseItem item = null;

                    List<ProvinceResp> provinceRespList = responseBody.getLists();
                    for (ProvinceResp provinceResp : provinceRespList) {
                        item = new ProvinceResponseItem();
                        item.setProvinceId(provinceResp.getProvinceId());
                        item.setProvinceName(provinceResp.getProvinceName());
                        lists.add(item);
                    }
                    provinceListResponse.setLists(lists);

                    response.setBody(provinceListResponse);
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

        logger.info("请求编号:{},全量查询省份信息返回数据：{}", reqNum, response);
        return response;
    }


    /**
     * 根据省份id查询城市信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<CityListResponse> queryCityByProvince(BankCnapsQueryCityRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},根据省份id查询城市信息上送数据：{}", reqNum, request);


        GlgwResponse<CityListResponse> response = new GlgwResponse();

        //请求体
        BankCnapsQueryCityReqBody body = new BankCnapsQueryCityReqBody();
        body.setProvinceId(request.getProvinceId());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<BankCnapsQueryCityReqBody> commonRequest = new CommonRequest<BankCnapsQueryCityReqBody>();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        ChannelService channelService = new ChannelService();
        CommonResponse<CityListRespBody> commonResponse = channelService.queryCityByProvince(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                CityListRespBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {

                    CityListResponse cityListResponse = new CityListResponse();
                    List<CityItem> lists = new ArrayList<CityItem>();
                    CityItem item = null;

                    List<CityResp> cityRespList = responseBody.getCityRespList();
                    for (CityResp cityResp : cityRespList) {
                        item = new CityItem();
                        item.setCityId(cityResp.getCityId());
                        item.setCityName(cityResp.getCityName());
                        item.setProvinceId(cityResp.getProvinceId());
                        item.setProvinceName(cityResp.getProvinceName());
                        lists.add(item);
                    }
                    cityListResponse.setCityRespList(lists);

                    response.setBody(cityListResponse);
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

        logger.info("请求编号:{},根据省份id查询城市信息返回数据：{}", reqNum, response);
        return response;
    }


    /**
     * 根据城市id和银行编码查询联行信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<BankCnapsListResponse> queryByCityAndBank(BankCnapsQueryByCityAndBankRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},根据城市id和银行编码查询联行信息上送数据：{}", reqNum, request);


        GlgwResponse<BankCnapsListResponse> response = new GlgwResponse();

        //请求体
        BankCnapsQueryByCityAndBrifeCodeReqBody body = new BankCnapsQueryByCityAndBrifeCodeReqBody();
        body.setCityId(request.getCityId());
        body.setBankCode(request.getBankCode());
        body.setChannelBankCode(request.getChannelBankCode());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<BankCnapsQueryByCityAndBrifeCodeReqBody> commonRequest = new CommonRequest();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        ChannelService channelService = new ChannelService();
        CommonResponse<BankCnapsListRespBody> commonResponse = channelService.queryByCnapsAndBrevityCode(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);

        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                BankCnapsListRespBody responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {

                    BankCnapsListResponse bankCnapsListResponse = new BankCnapsListResponse();
                    List<BankCnapsItem> lists = new ArrayList<BankCnapsItem>();
                    BankCnapsItem item = null;

                    List<BankCnapsResp> bankCnapsRespList = responseBody.getList();
                    for (BankCnapsResp bankCnapsResp : bankCnapsRespList) {
                        item = new BankCnapsItem();
                        item.setBankCnaps(bankCnapsResp.getBankCnaps());
                        item.setBankName(bankCnapsResp.getBankName());
                        item.setBankCode(bankCnapsResp.getBankCode());
                        item.setProvinceId(bankCnapsResp.getProvinceId());
                        item.setProvinceName(bankCnapsResp.getProvinceName());
                        item.setCityId(bankCnapsResp.getCityId());
                        item.setCityName(bankCnapsResp.getCityName());
                        item.setChannelBankCode(bankCnapsResp.getChannelBankCode());
                        lists.add(item);
                    }
                    bankCnapsListResponse.setList(lists);

                    response.setBody(bankCnapsListResponse);
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

        logger.info("请求编号:{},根据城市id和银行编码查询联行信息返回数据：{}", reqNum, response);
        return response;
    }


    /**
     * 根据联行号查询银行信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public GlgwResponse<BankCnapsResponse> queryByCnaps(BankCnapsQueryByCnapsRequest request) throws Exception {
        final long reqNum = System.currentTimeMillis();
        logger.info("请求编号:{},根据联行号查询银行信息上送数据：{}", reqNum, request);


        GlgwResponse<BankCnapsResponse> response = new GlgwResponse();

        //请求体
        BankCnapsQueryByCnapsReqBody body = new BankCnapsQueryByCnapsReqBody();
        body.setCnaps(request.getCnaps());

        //请求头
        CommonRequestHeader header = setCommonRequestHeader(JSONObject.toJSONString(body));

        //请求数据
        CommonRequest<BankCnapsQueryByCnapsReqBody> commonRequest = new CommonRequest<BankCnapsQueryByCnapsReqBody>();
        commonRequest.setRequestHeader(header);
        commonRequest.setRequestBody(body);


        logger.info("请求编号:{},京东上送数据项={}", reqNum, commonRequest);
        ChannelService channelService = new ChannelService();
        CommonResponse<BankCnapsResp> commonResponse = channelService.queryByCnaps(commonRequest);
        logger.info("请求编号:{},京东返回数据项={}", reqNum, commonResponse);
        
        if (commonResponse != null && commonResponse.getResponseHeader() != null) {
            if ("00000".equals(commonResponse.getResponseHeader().getCode())) {
                BankCnapsResp responseBody = commonResponse.getResponseBody();
                if ("success".equals(responseBody.getResponseCode())) {
                    BankCnapsResponse bankCnapsResponse = new BankCnapsResponse();
                    bankCnapsResponse.setBankCnaps(responseBody.getBankCnaps());
                    bankCnapsResponse.setBankName(responseBody.getBankName());
                    bankCnapsResponse.setBankCode(responseBody.getBankCode());
                    bankCnapsResponse.setProvinceId(responseBody.getProvinceId());
                    bankCnapsResponse.setProvinceName(responseBody.getProvinceName());
                    bankCnapsResponse.setCityId(responseBody.getCityId());
                    bankCnapsResponse.setCityName(responseBody.getCityName());
                    bankCnapsResponse.setChannelBankCode(responseBody.getChannelBankCode());

                    response.setBody(bankCnapsResponse);
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

        logger.info("请求编号:{},根据联行号查询银行信息返回数据：{}", reqNum, response);
        return response;
    }

}
