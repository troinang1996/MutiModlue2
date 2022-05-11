package com.laptrinh.ImplDAO;

import com.laptrinh.Entities.Product;
import com.laptrinh.IDAO.IProductDAO;
import com.laptrinh.Model.ProductModel;
import com.laptrinh.Repository.ProductRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImplProductDAO extends ImplGarenalDAO<ProductModel, Integer> implements IProductDAO<ProductModel, Integer>{
    @Autowired
    ProductRepositoryJPA productRepositoryJPA;

    @Override
    public List<ProductModel> findByKeywords(String keywords) {
        String hql = "FROM Product p WHERE p.name LIKE ?0 OR p.category.name " + "LIKE ?1 OR p.category.nameVN LIKE ?2";
        String keyWords = "%" + keywords + "%";
        return getResultListParam(hql, keyWords, keyWords, keyWords);
    }

    @Override
    public List<ProductModel> findByCategoryId(Integer id) {
        String hql = "FROM Product p WHERE p.category.id = ?0";
        return getResultList(hql, id);
    }

    @Override
    public List<ProductModel> findItemByHot(String key) {
        String hql = "FROM Product";
        switch (key) {
            case "hangmoi":
                hql = "From Product p where year(current_date()) - year(p.productDate) < 10 ";
                break;
            // sắp xếp chi tiết đơn hàng theo số lượng bán giảm dần
            case "banchay":
                hql = "From Product p order by size (p.orderDetails) DESC";
                break;
            case "xemnhieu":
                hql = "FROM Product p ORDER BY p.viewCount DESC";
                break;
            case "giamgia":
                hql = "From Product p Where p.discount > 0 ORDER BY p.discount DESC";
                break;

            default:
                break;
        }
        return getResultPageOrPagram(hql, 0, 12);
    }

    @Override
    public List<ProductModel> findByIdsInCookie(String id) {
        String hql = "From Product p Where p.id IN ("+ id +")";
        return getResultList(hql);
    }
}
