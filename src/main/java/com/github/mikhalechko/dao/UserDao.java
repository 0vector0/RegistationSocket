package com.github.mikhalechko.dao;

import com.github.mikhalechko.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

@Component
public class UserDao {


    private SessionFactory factory;

    private EntityManager em;

    protected UserDao() {
        this.factory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        em = factory.createEntityManager();
    }

    public List<User> getAll() {
        em.getTransaction().begin();
        List<User> users = em.createQuery("FROM com.github.mikhalechko.entity.User", User.class).getResultList();
        em.getTransaction().commit();
        return users;
    }

    public User getUserByLoginAndPassword(String login, String password) {
        em.getTransaction().begin();
        List<User> us = em.createQuery("SELECT u FROM com.github.mikhalechko.entity.User u "
                + "WHERE u.login = :login AND u.password = :password", User.class)
                .setParameter("login", login)
                .setParameter("password", password)
                .getResultList();
        if (us.isEmpty()) {
            em.getTransaction().commit();
            return null;
        }
        em.getTransaction().commit();
        return us.get(0);
    }

    public void create(User u) {
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }

}
