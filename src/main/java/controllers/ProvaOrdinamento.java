package controllers;

import model.entities.GameCharacter;

import java.util.*;

public class ProvaOrdinamento
{
	public static void main(String[] args)
	{
		GameCharacter a = new GameCharacter();
		a.setName("Stefano");
		a.setPowerLevel(10000000);
		GameCharacter b = new GameCharacter();
		b.setName("Stephano");
		b.setPowerLevel(5000000);
		GameCharacter c = new GameCharacter();
		c.setName("Francesco");
		c.setPowerLevel(200);
		GameCharacter d = new GameCharacter();
		d.setName("Tottinho");
		d.setPowerLevel(30000000);


		List<GameCharacter> personaggi = new ArrayList<>();
		personaggi.add(a);
		personaggi.add(b);
		personaggi.add(c);
		personaggi.add(d);


		System.out.println("Lista iniziale");
		System.out.println(personaggi);

		System.out.println("Lista ordinata per ordinamento naturale, quello del comparable (alfabetico)");
		Collections.sort(personaggi);
		System.out.println(personaggi);
		System.out.println("Lista ordinata per potenza");
//		Comparator<GameCharacter> perPotenza = new ComparePotere();
//		Collections.sort(personaggi,perPotenza);
		//SINTASSI LAMBDA, è STANDALONE
		Collections.sort(personaggi,(o1,o2)->o1.getPowerLevel()- o2.getPowerLevel());
		//Una LAMBDA è una SINTASSI CONCISA per ISTANZIARE UN OGGETTO di una CLASSE ANONIMA che IMPLEMENTA una INTERFACCIA
		//FUNZIONALE sovrascrivendone l'UNICO METODO ASTRATTO
		System.out.println(personaggi);
	}
}
