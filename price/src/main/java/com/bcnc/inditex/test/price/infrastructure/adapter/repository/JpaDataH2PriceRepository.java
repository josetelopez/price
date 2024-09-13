package com.bcnc.inditex.test.price.infrastructure.adapter.repository;

import com.bcnc.inditex.test.price.infrastructure.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface JpaDataH2PriceRepository extends JpaRepository<PriceEntity,Long>  {
    Optional<PriceEntity> findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long productId, Long brandId, LocalDateTime date1, LocalDateTime date2);

}
