package com.boby.onlinecourses.repositories;

import com.boby.onlinecourses.exceptions.EntityNotFoundException;
import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.repositories.contracts.UserRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO use jpa repo or crud repo
@Repository
public class UserRepoImpl implements UserRepo {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void register(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        }
    }
    @Override
    public User get(int id) {
        try (Session session = sessionFactory.openSession()) {
            User user = session.get(User.class, id);
            if (user == null) {
                throw new EntityNotFoundException("User", id);
            }
            return user;
        }
    }


    @Override
    public User getByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User where username = :username", User.class);
            query.setParameter("username", username);

            List<User> result = query.list();
            if (result.isEmpty()) {
                throw new EntityNotFoundException("User", "username", username);
            }

            return result.get(0);
        }

    }

    @Override
    public User getByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User where email = :email", User.class);
            query.setParameter("email", email);

            List<User> result = query.list();
            if (result.isEmpty()) {
                throw new EntityNotFoundException("User", "email", email);
            }

            return result.get(0);
        }
    }

}
