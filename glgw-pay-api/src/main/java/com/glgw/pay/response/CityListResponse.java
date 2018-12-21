package com.glgw.pay.response;

import java.util.List;

public class CityListResponse {

    private List<CityItem> cityRespList;    //城市列表列表

    public List<CityItem> getCityRespList() {
        return cityRespList;
    }

    public void setCityRespList(List<CityItem> cityRespList) {
        this.cityRespList = cityRespList;
    }

    @Override
    public String toString() {
        return "CityListResponse{" +
                "cityRespList=" + cityRespList +
                '}';
    }
}
