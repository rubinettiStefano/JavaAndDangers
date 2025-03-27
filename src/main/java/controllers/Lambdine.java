package controllers;

import model.entities.GameCharacter;

import java.util.Comparator;

public class Lambdine
{
	public static void main(String[] args)
	{
		//UNA INTERFACCIA CON UN SOLO METODO ASTRATTO VIENE DETTA FUNZIONALE

		//POSSO CREARE CLASSI ANONIME
		//una classe anonima è una classe senza nome, usa e getta
		Comparator<GameCharacter> comparatore = new Comparator<GameCharacter>()
		{//dalla riga 16 alla 23 sto creando una classe anonima che implementa Comparator
			//la sto direttamente istanziando
			@Override
			public int compare(GameCharacter o1, GameCharacter o2)
			{
				return o1.getPowerLevel()-o2.getPowerLevel();
			}
		};

		//riga 26+file ComparaPotere.java è uguale a scrivere dalla 15 alle 23
		Comparator<GameCharacter> comparatore2 = new ComparePotere();

		//lambda v1
		Comparator<GameCharacter> comparatore3 = (o1,o2) ->
		{
			return o1.getPowerLevel()-o2.getPowerLevel();
		};

		//lambda v2
		Comparator<GameCharacter> comparatore4= (o1,o2) -> o1.getPowerLevel()-o2.getPowerLevel();

	}
}
