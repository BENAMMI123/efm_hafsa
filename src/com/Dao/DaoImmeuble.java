package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utils.HibernateUtils;

import cpm.models.Immeuble;



public class DaoImmeuble implements IDao<cpm.models.Immeuble>{

	@Override
	public List<cpm.models.Immeuble> getAll() {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<cpm.models.Immeuble> Immeubles = session.createQuery("from Immeubles").getResultList();

		t.commit();
		session.close();

		return Immeubles;
	}

	@Override
	public Immeuble getOne(int id) {
		Session session = HibernateUtils.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Immeuble Immeuble = session.get(Immeuble.class, id);

		t.commit();
		session.close();

		return Immeuble;
	}

	@Override
	public boolean save(Immeuble obj) {
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
	public boolean update(Immeuble obj) {
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
	public boolean delete(Immeuble obj) {
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
