/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disma.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateJdbcException;
import org.springframework.stereotype.Repository;
import com.disma.domain.Usuario;
/**
 *
 * @author HP PC
 */
@Repository
public class UsuarioDao<T> implements Serializable{
    
    @PersistenceContext(unitName = "persistencia")
	private EntityManager entityManager;     


    public Boolean create(java.io.Serializable obj) {
         entityManager.persist(obj);
        return true;
    }

    public Serializable update(java.io.Serializable obj) {
        return entityManager.merge(obj);
    }

    public Boolean delete(java.io.Serializable obj) {
        entityManager.remove(obj);
        return true;
    }
    
    public Usuario getUniqueValue(String query, List<String> parameters){
        Query nativeQuery = entityManager.createNativeQuery(query,Usuario.class);
        int i = 1;
        for(String parameter:parameters){
            nativeQuery.setParameter(i,parameter);
            i++;
        }
        return (Usuario) nativeQuery.getSingleResult();
    }
    
    public List<Object> findAll(String query){
        return entityManager.createNativeQuery(query).getResultList();
    }

    public List<Object> findAll(String query, List<String> parameters){
        Query nativeQuery = entityManager.createNativeQuery(query);
        int i = 1;
        for(String parameter:parameters){
            nativeQuery.setParameter(i, parameter);
            i++;
        }
        return nativeQuery.getResultList();
    }
    
}
