package com.bcnc.inditex.test.price.application.usecase.adapter;

import com.bcnc.inditex.test.price.application.usecase.service.GetPriceUseCase;
import com.bcnc.inditex.test.price.domain.model.Price;
import com.bcnc.inditex.test.price.domain.repository.PriceRepository;
import com.bcnc.inditex.test.price.infrastructure.exception.BackendException;
import com.bcnc.inditex.test.price.infrastructure.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetPriceUseCaseImpl implements GetPriceUseCase {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;
    @Override
    public Price execute(Long productId, Long brandId, LocalDateTime date) {
        log.info("Get Price from productId: {}, brandId: {}, date: {}", productId, brandId, date.toString());
        return priceRepository.findTopByProductAndBrandAndDate(productId, brandId, date)
                .map(priceMapper::mapToDto)
                .orElseThrow(() -> new BackendException("ProductId, brandId or date specified do not return any valid prices", HttpStatus.BAD_REQUEST));
    }

}
