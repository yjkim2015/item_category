package com.musinsa.category.controller;


import com.musinsa.category.dto.GlobalApiResponse;
import com.musinsa.category.dto.Product;
import com.musinsa.category.dto.ProductRequest;
import com.musinsa.category.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Operation(
            summary = "Product 조회",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 상품 정보가 조회됨"),
                    @ApiResponse(responseCode = "203", description = "Product 정보가 없습니다."),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    @GetMapping(value = "/{productId}")
    public GlobalApiResponse<Product.QueryDTO> getProduct(@PathVariable("productId") Long productId) {
        return GlobalApiResponse.ok(productService.getProduct(productId));
    }

    @Operation(
            summary = "Product 추가",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 상품 정보가 저장됨"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    @PostMapping(value = "")
    public GlobalApiResponse<Boolean> addProduct(@RequestBody ProductRequest.Add request) {
        return GlobalApiResponse.ok(productService.addProduct(request.getCategoryId(), request.getBrandId(), request.getPrice()));
    }

    @Operation(
            summary = "Product 수정",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 상품 정보가 수정됨"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    @PatchMapping(value = "")
    public GlobalApiResponse<Boolean> updateProduct(@RequestBody ProductRequest.Update request) {
        return GlobalApiResponse.ok(productService.updateProduct(request.getProductId(), request.getBrandId(), request.getCategoryId(), request.getPrice()));
    }
    @Operation(
            summary = "Product 삭제",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 상품 정보가 삭제됨"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    @DeleteMapping(value = "")
    public GlobalApiResponse<Boolean> deleteProduct(@RequestBody ProductRequest.Delete request) {
        return GlobalApiResponse.ok(productService.deleteProduct(request.getProductId()));
    }
}
