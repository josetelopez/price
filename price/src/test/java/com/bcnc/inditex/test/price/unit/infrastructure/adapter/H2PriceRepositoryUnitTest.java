package com.bcnc.inditex.test.price.unit.infrastructure.adapter;

import com.bcnc.inditex.test.price.infrastructure.adapter.repository.H2PriceRepository;
import com.bcnc.inditex.test.price.infrastructure.adapter.repository.JpaDataH2PriceRepository;
import com.bcnc.inditex.test.price.infrastructure.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class H2PriceRepositoryUnitTest {

    @Mock
    private JpaDataH2PriceRepository repository;

    @InjectMocks
    private H2PriceRepository h2PriceRepository;

    @Test
    void testFindTopByProductAndBrandAndDate() {
        Long productId = 1L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.now();
        PriceEntity pricesEntity = new PriceEntity();

        when(repository.findTopByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId, brandId, date, date))
                .thenReturn(Optional.of(pricesEntity));

        Optional<PriceEntity> result = h2PriceRepository.findTopByProductAndBrandAndDate(productId, brandId, date);

        assertTrue(result.isPresent());
        assertEquals(pricesEntity, result.get());
    }
}
