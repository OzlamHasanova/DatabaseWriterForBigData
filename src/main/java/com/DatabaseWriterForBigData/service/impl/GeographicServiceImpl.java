package com.DatabaseWriterForBigData.service.impl;

import com.DatabaseWriterForBigData.entity.Geographic;
import com.DatabaseWriterForBigData.repository.GeographicRepository;
import com.DatabaseWriterForBigData.service.GeographicApiFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class GeographicServiceImpl {
    private final GeographicRepository geographicRepository;
    private final GeographicApiFeignClient geographicApiFeignClient;

    @Async
    @Transactional
    public CompletableFuture<Void> fetchDataAndSaveToDatabaseAsync() {
        try {
            // Fetch all data from the API asynchronously
            List<Geographic> allGeographicData = geographicApiFeignClient.getGeographicDataFromApi();

            // Save data to the database in batches asynchronously
            int batchSize = 500;
            for (int i = 0; i < allGeographicData.size(); i += batchSize) {
                List<Geographic> batch = allGeographicData.subList(i, Math.min(i + batchSize, allGeographicData.size()));
                try{
                    geographicRepository.saveAll(batch);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
            return CompletableFuture.completedFuture(null);
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }
}
