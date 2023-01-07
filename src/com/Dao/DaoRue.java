package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utils.HibernateUtils;

import cpm.models.Rue;



public class DaoRue implements IDao<Rue>{

	@Override
	public List<Rue> getAll() {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<Rue> Rue = session.createQuery("from Rue").getResultList();

		t.commit();
		session.close();

		return Rue;
	}

	@Override
	public Rue getOne(int id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Rue Rue = session.get(Rue.class, id);

		t.commit();
		session.close();

		return Rue;
	}
	
	
	

	@Override
	public boolean save(Rue obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			Object o = session.save(obj);

			System.out.println(o);

			t.commit();
			session.close();

			if (o == null)
				return false;
			else
				return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Rue obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.update(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Rue obj) {
		try {
			Session session = HibernateUtils.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
  
}
