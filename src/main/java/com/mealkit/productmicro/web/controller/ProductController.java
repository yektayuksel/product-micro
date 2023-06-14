package com.mealkit.productmicro.web.controller;

import com.mealkit.productmicro.domain.dto.ProductDto;
import com.mealkit.productmicro.domain.service.product.ProductService;
import com.mealkit.productmicro.mapper.ProductMapper;
import com.mealkit.productmicro.web.response.ProductApiOutput;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Tag(name= "Product Service")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;


    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;

    }


    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<ProductApiOutput> getProductById(@PathVariable Long productId) throws Exception {

        ProductApiOutput productApiOutput = productMapper.productDtoToApiOutput(productService.getProductById(productId));
        return new ResponseEntity<>(productApiOutput, HttpStatus.OK);
    }


    @PostMapping("/getByIds")
    public ResponseEntity<List<ProductApiOutput>> getProductsById(@RequestBody List<Long> productIdList) {

        List<ProductApiOutput> productApiOutputList = productMapper.productDtoToApiOutputList(productService.getProductsById(productIdList));
        return new ResponseEntity<>(productApiOutputList, HttpStatus.OK);
    }


    @PostMapping("/getByTags")
    public ResponseEntity<List<ProductApiOutput>> getProductByTag(List<Long> tagIdList) {

        List<ProductApiOutput> productApiOutput = productMapper.productDtoToApiOutputList(productService.getProductsById(tagIdList));
        return new ResponseEntity<>(productApiOutput, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {

        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProduct(productDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto) {
         productService.addProduct(productDto);
         return new ResponseEntity<>(HttpStatus.OK);


    }
}
