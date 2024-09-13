package com.bcnc.inditex.test.price.infrastructure.mapper;

import com.bcnc.inditex.test.price.domain.model.Price;
import com.bcnc.inditex.test.price.infrastructure.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapper {

    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "product.id", target = "productId")
    Price mapToDto(PriceEntity entity);
}
