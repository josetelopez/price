package com.bcnc.inditex.test.price.infrastructure.mapper;

import com.bcnc.inditex.test.price.domain.model.Price;
import com.bcnc.inditex.test.price.infrastructure.entity.BrandEntity;
import com.bcnc.inditex.test.price.infrastructure.entity.PriceEntity;
import com.bcnc.inditex.test.price.infrastructure.entity.ProductEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T17:44:37+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PriceMapperImpl implements PriceMapper {

    @Override
    public Price mapToDto(PriceEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Price price = new Price();

        price.setBrandId( entityBrandId( entity ) );
        price.setProductId( entityProductId( entity ) );
        price.setPriceList( entity.getPriceList() );
        price.setStartDate( entity.getStartDate() );
        price.setEndDate( entity.getEndDate() );
        price.setPrice( entity.getPrice() );
        price.setCurrency( entity.getCurrency() );

        return price;
    }

    private Long entityBrandId(PriceEntity priceEntity) {
        if ( priceEntity == null ) {
            return null;
        }
        BrandEntity brand = priceEntity.getBrand();
        if ( brand == null ) {
            return null;
        }
        Long id = brand.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityProductId(PriceEntity priceEntity) {
        if ( priceEntity == null ) {
            return null;
        }
        ProductEntity product = priceEntity.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
