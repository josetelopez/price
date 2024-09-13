package com.bcnc.inditex.test.price.domain.repository;

import com.bcnc.inditex.test.price.infrastructure.entity.PriceEntity;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepository {
    Optional<PriceEntity> findTopByProductAndBrandAndDate(Long productId, Long brandId, LocalDateTime date);
}
