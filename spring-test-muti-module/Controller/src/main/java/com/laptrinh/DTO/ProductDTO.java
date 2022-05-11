package com.laptrinh.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class ProductDTO {
    Integer id;
    String name;
    String image ;
    Double unitPrice;
    Double discount ;
    Integer quantity ;
    Date productDate ;
    Boolean available ;
    String description;
    Integer viewCount ;
    Integer categoryID;
}
