package com.boby.onlinecourses.repositories;

import com.boby.onlinecourses.exceptions.EntityNotFoundException;
import com.boby.onlinecourses.models.Course;
import com.boby.onlinecourses.models.User;
import com.boby.onlinecourses.repositories.contracts.CourseRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepoImpl implements CourseRepo {
    private final SessionFactory sessionFactory;

    @Autowired
    public CourseRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createCourse(Course course) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(course);
            session.getTransaction().commit();
        }
    }

    @Override
    public Course get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Course course = session.get(Course.class, id);
            if (course == null) {
                throw new EntityNotFoundException("Course", id);
            }
            return course;
        }
    }

    @Override
    public Course getByTitle(String title) {
        try (Session session = sessionFactory.openSession()) {
            Query<Course> query = session.createQuery("from Course where title = :title", Course.class);
            query.setParameter("title", title);

            List<Course> result = query.list();
            if (result.isEmpty()) {
                throw new EntityNotFoundException("Course", "title", title);
            }

            return result.get(0);
        }
    }
}
