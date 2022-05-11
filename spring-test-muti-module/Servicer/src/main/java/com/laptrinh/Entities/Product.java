package com.laptrinh.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
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
