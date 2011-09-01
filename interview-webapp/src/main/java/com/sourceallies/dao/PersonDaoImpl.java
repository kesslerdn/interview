package com.sourceallies.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sourceallies.model.Person;

@Component("personDao")
@Transactional
@Repository
public class PersonDaoImpl implements PersonDao {

    @Resource
    private SessionFactory sessionFactory;
    
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @SuppressWarnings("unchecked")
	public List<Person> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findByLastName(String lastName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Person where lastName = :lastName");
		query.setString("lastName", lastName);
		return query.list();
	}
}
