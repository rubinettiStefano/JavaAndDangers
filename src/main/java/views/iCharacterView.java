package views;

import model.entities.GameCharacter;

import java.util.List;

public interface iCharacterView
{
	/**
	 * Metodo che riceve in ingresso un Character e ne produce
	 * la versione graficata
	 */
	String render(GameCharacter gc);

	default String renderList(List<GameCharacter> gc)
	{
		String res = "";

		for(GameCharacter c:gc)
			res+=render(c)+"\n";

		return res;
	}


	static iCharacterView getInstance(String type)
	{
		switch (type.toLowerCase())
		{
			case "ascii" -> {return new CharacterViewAsciiArt();}
			default ->{return new CharacterViewText();}
		}
	}
}
