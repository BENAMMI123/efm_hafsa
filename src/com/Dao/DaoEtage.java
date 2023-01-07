package com.Dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utils.HibernateUtils;

import cpm.models.Etage;




public class DaoEtage implements IDao<Etage> {

	@Override
	public List<Etage> getAll() {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<Etage> Etages = session.createQuery("from Etage").getResultList();

		t.commit();
		session.close();

		return Etages;
	}

	@Override
	public Etage getOne(int id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Etage Etage = session.get(Etage.class, id);

		t.commit();
		session.close();

		return Etage;
	}

	@Override
	public boolean save(Etage obj) {
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
	public boolean update(Etage obj) {
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
	public boolean delete(Etage obj) {
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
