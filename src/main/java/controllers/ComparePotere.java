package controllers;

import model.entities.GameCharacter;

import java.util.Comparator;

public class ComparePotere implements Comparator<GameCharacter>
{
	@Override
	public int compare(GameCharacter o1, GameCharacter o2)
	{
		return o1.getPowerLevel()-o2.getPowerLevel();
	}
}
