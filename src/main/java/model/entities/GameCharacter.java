package model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import model.entities.character_enums.Hair;
import model.entities.character_enums.Height;
import model.entities.character_enums.Weapon;

//Una Entity è qualcosa del mondo reale che vogliamo modellizzare per poterlo
//utilizzare dentro il nostro programma
//a livello pratico serve a dire: Hibernate questo lo voglio nel db

@Entity
public class GameCharacter extends BaseEntity implements Comparable<GameCharacter>
{

	private String name;

	@Enumerated(EnumType.STRING)
	private Hair hair;
	@Enumerated(EnumType.STRING)
	private Height height;
	@Enumerated(EnumType.STRING)
	private Weapon weapon;

	private boolean shield;

	public GameCharacter(){}

	public GameCharacter(String name, Hair hair, Height height, Weapon weapon, boolean shield)
	{
		this.name = name;
		this.hair = hair;
		this.height = height;
		this.weapon = weapon;
		this.shield = shield;
	}

	public GameCharacter(Long id, String name, Hair hair, Height height, Weapon weapon, boolean shield)
	{
		super(id);
		this.name = name;
		this.hair = hair;
		this.height = height;
		this.weapon = weapon;
		this.shield = shield;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Hair getHair()
	{
		return hair;
	}

	public void setHair(Hair hair)
	{
		this.hair = hair;
	}

	public Height getHeight()
	{
		return height;
	}

	public void setHeight(Height height)
	{
		this.height = height;
	}

	public Weapon getWeapon()
	{
		return weapon;
	}

	public void setWeapon(Weapon weapon)
	{
		this.weapon = weapon;
	}

	public boolean hasShield()
	{
		return shield;
	}

	public void setShield(boolean shield)
	{
		this.shield = shield;
	}

	@Override
	public int compareTo(GameCharacter o)
	{
		//Deve restituire numero positivo quando this>o
		//zero quando this pari ad o
		//negativo quando this<o
		char[] thisCaratterizzato = this.name.toLowerCase().toCharArray();
		char[] oCaratterizzato = o.name.toLowerCase().toCharArray();

		for(int i=0;i<thisCaratterizzato.length;i++)
		{
			char mio = thisCaratterizzato[i];
			if(i==oCaratterizzato.length)//se i sfora il secondo array
				return 1;
			char tuo = oCaratterizzato[i];

			//stepaazzzz  -this
			//stepa       -o      length->5
			//012345
			if(mio>tuo)
				return 1;
			if(tuo>mio)
				return -1;
		}
		if(thisCaratterizzato.length==oCaratterizzato.length)
			return 0;
		return -1;
		//return this.name.compareTo(o.name);
	}
}
