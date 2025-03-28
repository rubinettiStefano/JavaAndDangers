package views;

import model.entities.Building;
import model.entities.GameCharacter;

public interface iBuildingView
{
	String render(Building gc);




	static iBuildingView getInstance(String type)
	{
		switch (type.toLowerCase())
		{
			default ->{return null;}
		}
	}
}
