package com.test;

import java.util.Scanner;

import com.Dao.DaoAppartement;
import com.Dao.DaoEtage;
import com.Dao.DaoFactory;
import com.Dao.DaoImmeuble;
import com.Dao.DaoRue;
import com.Dao.TypeDao;

import cpm.models.Appartement;
import cpm.models.Etage;
import cpm.models.Immeuble;
import cpm.models.Rue;



public class Main {

	public static void main(String[] args) {
	   int i= 0;
	   Scanner rs =new Scanner(System.in);
	   while(i != 0) {
		   System.out.println("0- Quitter");
		   System.out.println("1- Afficher Tous Les immeuble");
		   System.out.println("2- Les Immeuble d'un rue");
		   System.out.println("3- Supprimer un appartement par id");
		   System.out.println("4- Modifier un Etage");
		   i = rs.nextInt();
		   switch (i) {
		case 0:
			System.out.println("GoodBye");
			break;
		case 1:
			DaoImmeuble doaImm= (DaoImmeuble) DaoFactory.getDAO(TypeDao.Immeuble);
			for(Immeuble em : doaImm.getAll())
				System.out.println(em);
			break;
		case 2:
			System.out.println("Donner un id de rue");
			int id=rs.nextInt();
			DaoRue doaRue= (DaoRue) DaoFactory.getDAO(TypeDao.Rue);
			Rue rue = doaRue.getOne(id);
			for(Immeuble em : rue.getImmeubles())
				System.out.println(em);
			break;
		case 3:
			System.out.println("Donner un id de Appartement");
			String ids  = rs.next();
			DaoAppartement daoApp= (DaoAppartement) DaoFactory.getDAO(TypeDao.Appartement);
			Appartement app=new Appartement(ids,0);
			if(daoApp.delete(app))
				System.out.println("supprimer avec success");
			else
				System.out.println("can't delete");
			break;
		case 4:
			System.out.println("Donner un id de etage");
			id  = rs.nextInt();
			DaoEtage daoEtage= (DaoEtage) DaoFactory.getDAO(TypeDao.Etage);
			
			System.out.println("Donner un nb App");
			int  nbApp = rs.nextInt();
			Etage et=new Etage(0, nbApp);
			if(daoEtage.update(et))
				System.out.println("mofifier avec success");
			else
				System.out.println("can't update");
			break;

		default:
			break;
		}
	   }
	}

}
