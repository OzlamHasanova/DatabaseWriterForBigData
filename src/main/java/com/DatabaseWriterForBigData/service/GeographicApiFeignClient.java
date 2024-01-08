package com.DatabaseWriterForBigData.service;

import com.DatabaseWriterForBigData.entity.Geographic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "geographic-api", url = "https://api.opendata.az/v2/az/json/map/geographic")
public interface GeographicApiFeignClient {

    @GetMapping("/geographicName")
    List<Geographic> getGeographicDataFromApi();
}