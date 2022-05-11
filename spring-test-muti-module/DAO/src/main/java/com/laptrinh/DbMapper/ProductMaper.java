package com.laptrinh.DbMapper;

import com.laptrinh.Entities.Product;
import com.laptrinh.Model.ProductModel;

public class ProductMaper {
    public static Product toEntity(ProductModel productModel){
        if(productModel == null){
            return null;
        }
        Product product = new Product();
        product.setId(productModel.getId());
        product.setName(productModel.getName());
        product.setProductDate(productModel.getProductDate());
        product.setAvailable(productModel.getAvailable());
        product.setDescription(productModel.getDescription());
        product.setDiscount(productModel.getDiscount());
        product.setCategoryID(productModel.getCategory().getId());
        product.setImage(productModel.getImage());
        product.setQuantity(productModel.getQuantity());
        product.setUnitPrice(productModel.getUnitPrice());
        product.setViewCount(productModel.getViewCount());
        return product;


    }
}
