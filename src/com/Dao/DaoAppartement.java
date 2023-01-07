package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utils.HibernateUtils;

import cpm.models.Appartement;


public class DaoAppartement implements IDao<Appartement> {

	@Override
	public List<Appartement> getAll() {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<Appartement> Appartements = session.createQuery("from Appartement").getResultList();

		t.commit();
		session.close();

		return Appartements;
	}

	@Override
	public Appartement getOne(int id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Appartement Appartement = session.get(Appartement.class, id);

		t.commit();
		session.close();

		return Appartement;
	}

	@Override
	public boolean save(Appartement obj) {
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
	public boolean update(Appartement obj) {
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
	public boolean delete(Appartement obj) {
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
