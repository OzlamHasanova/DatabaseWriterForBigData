package com.DatabaseWriterForBigData.controller;

import com.DatabaseWriterForBigData.entity.Geographic;
import com.DatabaseWriterForBigData.service.GeographicApiFeignClient;
import com.DatabaseWriterForBigData.service.impl.GeographicServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GeographicController {

    private final GeographicApiFeignClient geographicApiFeignClient;
    private final GeographicServiceImpl geographicServiceImpl;


    @GetMapping("/names")
    public List<Geographic> getGeographicNames() {
        return geographicApiFeignClient.getGeographicDataFromApi();
    }

    @PostMapping("/fetch-and-save")
    public ResponseEntity<String> fetchAndSaveGeographicData() {
        try {
            geographicServiceImpl.fetchDataAndSaveToDatabaseAsync();
            return ResponseEntity.ok("Geographic data fetched from API and saved to the database successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch and save geographic data: " + e.getMessage());
        }
    }

}
