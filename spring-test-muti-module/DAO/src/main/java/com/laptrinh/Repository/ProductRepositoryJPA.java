package com.laptrinh.Repository;

import com.laptrinh.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<ProductModel, Integer> {
}
