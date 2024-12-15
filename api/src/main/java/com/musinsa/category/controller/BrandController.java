package com.musinsa.category.controller;


import com.musinsa.category.dto.Brand;
import com.musinsa.category.dto.BrandRequest;
import com.musinsa.category.dto.GlobalApiResponse;
import com.musinsa.category.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/brand")
public class BrandController {
    private final BrandService brandService;

    @Operation(
            summary = "Brand 조회",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 브랜드 정보가 조회됨"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    @GetMapping(value = "/{brandId}")
    public GlobalApiResponse<Brand.QueryDTO> getBrand(@PathVariable("brandId") Long brandId) {
        return GlobalApiResponse.ok(brandService.getBrand(brandId));
    }

    @Operation(
            summary = "Brand 추가",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 브랜드 정보가 저장됨"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    @PostMapping(value = "")
    public GlobalApiResponse<Boolean> addBrand(@RequestBody BrandRequest.Add request) {
        return GlobalApiResponse.ok(brandService.addBrand(request.getName()));
    }

    @Operation(
            summary = "Brand 수정",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 브랜드 정보가 수정됨"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    @PatchMapping(value = "")
    public GlobalApiResponse<Boolean> updateBrand(@RequestBody BrandRequest.Update request) {
        return GlobalApiResponse.ok(brandService.updateBrand(request.getId(), request.getName()));
    }

    @Operation(
            summary = "Brand 삭제",
           responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 브랜드 정보가 삭제됨"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    @DeleteMapping(value = "")
    public GlobalApiResponse<Boolean> deleteBrand(@RequestBody BrandRequest.Delete request) {
        return GlobalApiResponse.ok(brandService.deleteBrand(request.getId()));
    }
}
