package com.DatabaseWriterForBigData.repository;

import com.DatabaseWriterForBigData.entity.Geographic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeographicRepository extends JpaRepository<Geographic,Long> {
}
