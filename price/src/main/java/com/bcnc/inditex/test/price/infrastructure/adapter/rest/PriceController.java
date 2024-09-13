package com.bcnc.inditex.test.price.infrastructure.adapter.rest;

import com.bcnc.inditex.test.price.application.usecase.service.GetPriceUseCase;
import com.bcnc.inditex.test.price.domain.model.Price;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/price")
public class PriceController {

    private final GetPriceUseCase getPriceUseCase;

    @GetMapping
    public ResponseEntity<Price> getPrice(@RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
                                          @RequestParam("productId") Long productId, @RequestParam("brandId") Long brandId) {
        log.info("Get available price by product: {} and brand: {} and date: {}", productId, brandId, applicationDate.toString());

        return new ResponseEntity<>(getPriceUseCase.execute(productId, brandId, applicationDate), HttpStatus.OK);

    }

}

