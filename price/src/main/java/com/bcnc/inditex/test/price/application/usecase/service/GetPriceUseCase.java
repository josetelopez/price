package com.bcnc.inditex.test.price.application.usecase.service;

import com.bcnc.inditex.test.price.domain.model.Price;

import java.time.LocalDateTime;

public interface GetPriceUseCase {
    Price execute(Long productId, Long brandId, LocalDateTime date);
}
