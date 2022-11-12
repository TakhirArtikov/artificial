package com.tahir.artificialintelligence.repository;

import com.tahir.artificialintelligence.entity.MarketingDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketingDataRepository extends JpaRepository<MarketingDataEntity, Long> {
}
