package com.bcnc.inditex.test.price.integration.application.usecase;

import com.bcnc.inditex.test.price.application.usecase.service.GetPriceUseCase;
import com.bcnc.inditex.test.price.domain.model.Price;
import com.bcnc.inditex.test.price.domain.repository.PriceRepository;
import com.bcnc.inditex.test.price.infrastructure.exception.BackendException;
import com.bcnc.inditex.test.price.infrastructure.mapper.PriceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
public class GetPriceUseCaseIntegrationTest {

    @Autowired
    private GetPriceUseCase getPriceUseCase;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceMapper priceMapper;

    @Test
    void shouldReturnPriceWhenFound() {
        // Arrange
        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime date =  LocalDateTime.of(2020,06,14, 10,00);
        // Act
        Price result = getPriceUseCase.execute(productId, brandId, date);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getPrice()).isEqualTo(35.5);
    }

    @Test
    void shouldThrowExceptionWhenPriceNotFound() {
        // Arrange
        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime date =  LocalDateTime.of(2020,01,14, 10,00);

        // Act & Assert
        assertThatThrownBy(() -> getPriceUseCase.execute(productId, brandId, date))
                .isInstanceOf(BackendException.class)
                .hasFieldOrPropertyWithValue("status", HttpStatus.BAD_REQUEST);
    }
}
