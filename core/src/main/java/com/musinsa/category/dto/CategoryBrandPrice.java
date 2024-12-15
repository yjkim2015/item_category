package com.musinsa.category.dto;

import com.musinsa.category.util.FormatUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

public class CategoryBrandPrice {

    @AllArgsConstructor
    @Getter
    public static class QueryDTO {
        private String categoryName;
        private String brandName;
        private BigDecimal price;

        public Response toResponse() {
            return new Response(
                   this.categoryName,
                   this.brandName,
                    FormatUtils.toThousandsString(this.price)
            );
        }
    }


    @AllArgsConstructor
    @Getter
    public static class Response {
        private String categoryName;
        private String brandName;
        private String price;
    }
}
