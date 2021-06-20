package by.tms.dao;

import by.tms.entity.User;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    public List<User> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession
                .createQuery("from User", User.class)
                .getResultList();
    }

    public User findByUserName(String username){
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession
                .createQuery("from User where username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    public void updateName(String name, long id){
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        user.setName(name);
        System.out.println(user);
        currentSession.update(user);
    }

    public void delete(long id){
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        currentSession.delete(user);
    }

}
