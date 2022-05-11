package com.laptrinh.ImplDAO;

import com.laptrinh.IDAO.IGarenalDAO;
import com.laptrinh.Repository.GarenalRepositoryJPA;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class ImplGarenalDAO<L,K> implements IGarenalDAO<L,K> {
    @Autowired
    GarenalRepositoryJPA garenalRepositoryJPA;
    @Autowired
    SessionFactory factory;
    @Override
    public L create(L s) {
        garenalRepositoryJPA.save(s);
        return s;
    }

    @Override
    public void update(L entity) {
        garenalRepositoryJPA.save(entity);

    }

    @Override
    public void delete(K... ids) {
        for (K id : ids) {
            L entity = this.findById(id);
            garenalRepositoryJPA.delete(entity);

        }

    }

    @Override
    public L findById(K id) {
        Session session = factory.getCurrentSession();
        Class<L> entityClass = this.getEntityClass();
        L entity = session.find(entityClass, id);
        return entity;
    }

    @Override
    public List<L> findAll() {
        List<L> entity = garenalRepositoryJPA.findAll();
        return entity;
    }

    @Override
    public <E> List<E> getResultList(String hql, Object... mangParam) {
        return this.getResultPageOrPagram(hql,0,0,mangParam);
    }

    @Override
    public <E> List<E> getResultPageOrPagram(String hql, int page, int size, Object... mangParam) {
        Session session = factory.getCurrentSession();
        @SuppressWarnings("unchecked")
        TypedQuery<E> query =  session.createQuery(hql);
        // size > 0 mới phân trang
        if(size >0)
        {
            query.setFirstResult(page*size);
            query.setMaxResults(size);
        }
        for(int i=0;i<mangParam.length;i++)
        {
            query.setParameter(i, mangParam[i]);
        }
        List<E> list = query.getResultList();
        return list;

    }

    @Override
    public <E> List<E> getResultListParam(String hql, Object... mangParam) {
        return this.getResultPageOrPagram(hql, 0, 0, mangParam);
    }
    private Class<L> getEntityClass() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        return  (Class<L>) type.getActualTypeArguments()[0];
    }
}
