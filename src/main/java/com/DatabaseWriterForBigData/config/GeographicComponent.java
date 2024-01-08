package com.DatabaseWriterForBigData.config;

import com.DatabaseWriterForBigData.entity.Geographic;
import com.DatabaseWriterForBigData.service.impl.GeographicServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GeographicComponent {
    private final GeographicServiceImpl geographicServiceImpl;
//    public void saveGeographicDataFromApi(Geographic geographic) {
//        geographicServiceImpl.saveDataToDatabase((List<Geographic>) geographic);
//    }
}
