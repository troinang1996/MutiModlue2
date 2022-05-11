package com.laptrinh.IDAO;

import com.laptrinh.Entities.Product;

import java.util.List;

public interface IProductDAO<L,K> extends IGarenalDAO<L,K> {
    List<L> findByKeywords(String keywords);
    List<L> findByCategoryId(Integer id);
    List<L> findItemByHot(String key);
    List<L> findByIdsInCookie(String id);
}
