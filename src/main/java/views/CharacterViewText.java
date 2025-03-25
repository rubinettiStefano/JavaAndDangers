package views;

import model.entities.GameCharacter;

public class CharacterViewText implements iCharacterView
{
	@Override
	public String render(GameCharacter gc)
	{
		return 	"Id: "+gc.getId()+"\n"+
				"Name: "+gc.getName()+"\n"+
				"Hair: "+gc.getHair()+"\n"+
				"Height: "+gc.getHeight()+"\n"+
				"Weapon: "+gc.getWeapon()+"\n"+
				(gc.hasShield()?"SHIELDED":"");
	}
}
