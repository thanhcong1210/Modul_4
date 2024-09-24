package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> products = BaseRepository.entityManager.createQuery("select s from  product s", Product.class).getResultList();
        return products;
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public Product findById(int id) {
       Product product = BaseRepository.entityManager.find(Product.class, id);
       return product;
    }

    @Override
    public void update(int id, Product product) {
        BaseRepository.entityManager.merge(product);
    }

    @Override
    public void remove(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        transaction.commit();
    }

    @Override
    public List<Product> findByName(String name) {
       String hql = "from product p where p.name like :name";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(hql, Product.class);
        query.setParameter("name", "%" + name + "%");
        List<Product> products = query.getResultList();
        return products;
    }
}
