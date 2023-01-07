package com.Dao;

public class DaoFactory {
	
	
	public static IDao getDAO(TypeDao type) {
		switch (type) {
			case Rue: return new DaoRue();
			case Immeuble: return new DaoImmeuble();
			case Etage: return new DaoEtage();
			case Appartement: return new DaoAppartement();
			
		}
		return null;
	}

}
