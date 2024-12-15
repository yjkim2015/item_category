package com.musinsa.category.dto;

import com.musinsa.category.util.FormatUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

public class CategoryPrice {

    @AllArgsConstructor
    @Getter
    public static class QueryDTO {
        private String name;
        private BigDecimal price;

        public Response toResponse() {
            return new Response(
                    this.name,
                    FormatUtils.toThousandsString(this.price)
            );
        }
    }


    @AllArgsConstructor
    @Getter
    public static class Response {
        private String name;
        private String price;
    }
}
