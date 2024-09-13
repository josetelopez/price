package com.bcnc.inditex.test.price.infrastructure.adapter.repository;

import com.bcnc.inditex.test.price.domain.repository.PriceRepository;
import com.bcnc.inditex.test.price.infrastructure.entity.PriceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.Optional;
@Component
@RequiredArgsConstructor
public class H2PriceRepository implements PriceRepository {

    private final JpaDataH2PriceRepository repository;

    @Override
    public Optional<PriceEntity> findTopByProductAndBrandAndDate(Long productId, Long brandId, LocalDateTime date) {
        return repository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId, brandId, date, date);
    }
}
