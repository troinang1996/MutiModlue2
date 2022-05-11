package com.laptrinh.Cotroller.User;

import com.laptrinh.DTO.ProductDTO;
import com.laptrinh.Entities.Product;
import com.laptrinh.ImplService.ImplProductService;
import com.laptrinh.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductControllerRollUser {
    @Autowired
    ImplProductService implProductService;

    @GetMapping("/getall")
    public ResponseEntity<ProductDTO[]> getAllProduct(){
        List<Product> productList = implProductService.findAll();

        List<ProductDTO> productDTOList = new ArrayList<>();
        productList.forEach(x->{
            ProductDTO productDTO = ProductMapper.toDTO(x);
            productDTOList.add(productDTO);
        });

        return ResponseEntity.ok().body(productDTOList.stream().toArray(ProductDTO[]::new));
    }
}
