package com.glgw.pay;


import com.glgw.pay.request.BankCnapsQueryByCityAndBankRequest;
import com.glgw.pay.request.BankCnapsQueryByCnapsRequest;
import com.glgw.pay.request.BankCnapsQueryCityRequest;
import com.glgw.pay.request.IssuerQueryByPIReqeset;
import com.glgw.pay.response.*;
import com.glgw.pay.service.ChannelServiceImpl;
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
public class ChannelTest {

    private static final Logger logger = LogManager.getLogger(ChannelTest.class);


    @Autowired
    private ChannelServiceImpl channelService;


    /**
     * 根据支付工具查询渠道发卡机构列表 （已调通）
     */
    @Test
    public void testQueryAllByPI() {
        IssuerQueryByPIReqeset request = new IssuerQueryByPIReqeset();
        //支付工具  00:快捷 01:网银  02:代收  03:代付/付款
        request.setPiType("03");

        try {
            GlgwResponse<IssuerListResponse> response = channelService.queryAllByPI(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }


    /**
     * 全量查询省份信息 （已调通）
     */
    @Test
    public void testQueryProvince() {
        try {
            GlgwResponse<ProvinceListResponse> response = channelService.queryProvince();
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }


    /**
     * 根据省份id查询城市信息 （已调通）
     */
    @Test
    public void testQueryCityByProvince() {
        BankCnapsQueryCityRequest request = new BankCnapsQueryCityRequest();
        request.setProvinceId("110");

        try {
            GlgwResponse<CityListResponse> response = channelService.queryCityByProvince(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }

    /**
     * 根据城市id和银行编码查询联行信息 （已调通）
     */
    @Test
    public void testQueryByCityAndBank() {
        BankCnapsQueryByCityAndBankRequest request = new BankCnapsQueryByCityAndBankRequest();
        request.setCityId("1000");
        request.setBankCode("308");
        request.setChannelBankCode("CMB");

        try {
            GlgwResponse<BankCnapsListResponse> response = channelService.queryByCityAndBank(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }

    /**
     * 根据联行号查询银行信息 （已调通）
     */
    @Test
    public void testQueryByCnaps() {
        BankCnapsQueryByCnapsRequest request = new BankCnapsQueryByCnapsRequest();
        request.setCnaps("308100005762");

        try {
            GlgwResponse<BankCnapsResponse> response = channelService.queryByCnaps(request);
            logger.info("response:{}", response);
        } catch (Exception e) {
            logger.error("{}", e);
        }

    }


}
