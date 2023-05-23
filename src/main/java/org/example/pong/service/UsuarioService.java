package org.example.pong.service;

import org.example.pong.entity.UsuarioEntity;
import org.example.pong.request.UsuarioRequest;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class UsuarioService {


    public List<UsuarioEntity> getUsuario() {
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("base-leo")
                .createEntityManager();
        try {
            List<UsuarioEntity> usuarioEntities = entityManager.createQuery("SELECT p FROM UsuarioEntity p", UsuarioEntity.class)
                    .getResultList();
            return usuarioEntities;
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }

    public UsuarioEntity getUsuarioById(long id) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("base-leo")
                .createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            usuarioEntity = entityManager.find(UsuarioEntity.class, id);
            transaction.commit();
            return usuarioEntity;
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }
    public void postUsuario(UsuarioRequest usuarioRequest) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("base-leo")
                .createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            usuarioEntity.setId(usuarioRequest.getId());
            usuarioEntity.setNome(usuarioRequest.getNome());
            entityManager.persist(usuarioEntity);
            transaction.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }

    public void updateUsuario(long id, UsuarioRequest usuarioRequest) {
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("base-leo")
                .createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, id);
            if (usuarioEntity != null) {
                usuarioEntity.setNome(usuarioRequest.getNome());
                entityManager.merge(usuarioEntity);
            }
            transaction.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }

    public void deleteUsuarioById(long id) {
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("base-leo")
                .createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, id);
            if (usuarioEntity != null) {
                entityManager.remove(usuarioEntity);
            }
            transaction.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.close();
        }
    }
}
