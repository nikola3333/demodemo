package com.example.demodemo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.example.demodemo.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	@Override
	public List<User> getUsers() {

		// get the current hibernate session
		Session curentSession = getSession();

		// create a query ... sort by last name
		Query<User> theQuery = curentSession.createQuery("from User order by id", User.class);

		// get the list of users from the query
		List<User> users = theQuery.getResultList();

		// return the list of customers
		return users;
	}

	@Override
	public User getUserByUsername(String username) {

		String usernamesent = username;

		// get the current hibernate session
		Session curentSession = getSession();

		String hql = "FROM User E WHERE E.username = :user_username";
		Query query = curentSession.createQuery(hql);
		query.setParameter("user_username", usernamesent);
		List results = query.list();

		// get the list of users from the query
		User user = (User) results.get(0);

		// return the list of customers
		return user;

	}

	@Override
	public void addUser(User user) {
		
		String o = "nista";
		try {
			o = user.getId().toString();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("EXCEPTIONNN");
		}
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA" + o);
		if(o.equals("sadsad")) {
		
		Query query = getSession().createSQLQuery(
				"INSERT INTO User (id, first_name, last_name, username, password) VALUES (:id, :firstName, :lastName, :username, :password)");
		query.setParameter("id", user.getId());
		query.setParameter("firstName", user.getFirst_name());
		query.setParameter("lastName", user.getLast_name());
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		query.executeUpdate();
		}else {
			Query query = getSession().createSQLQuery(
					"INSERT INTO User (first_name, last_name, username, password) VALUES (:firstName, :lastName, :username, :password)");
			query.setParameter("firstName", user.getFirst_name());
			query.setParameter("lastName", user.getLast_name());
			query.setParameter("username", user.getUsername());
			query.setParameter("password", user.getPassword());
			query.executeUpdate();
		}

	}

	@Override
	public void deleteUser(User user) {

		user = entityManager.merge(user);
		entityManager.remove(user);
	}

	@Override
	public void updateUser(User user) {

		Query query = getSession().createQuery("update User set first_name = :first_name, last_name = :last_name, password = :password, username = :username" + " where id = :id");
		query.setParameter("id", user.getId());
		query.setParameter("first_name", user.getFirst_name());
		query.setParameter("last_name", user.getLast_name());
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		query.executeUpdate();

	}

}
