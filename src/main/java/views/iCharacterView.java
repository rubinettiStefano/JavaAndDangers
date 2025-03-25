package views;

import model.entities.GameCharacter;

public interface iCharacterView
{
	/**
	 * Metodo che riceve in ingresso un Character e ne produce
	 * la versione graficata
	 */
	String render(GameCharacter gc);

	static iCharacterView getInstance(String type)
	{
		switch (type.toLowerCase())
		{
			case "ascii" -> {return new CharacterViewAsciiArt();}
			default ->{return new CharacterViewText();}
		}

	}
}
