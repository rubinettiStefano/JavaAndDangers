package controllers;

import model.dao.CharacterDAO;
import model.dao.iCharacterDAO;
import model.entities.GameCharacter;
import model.entities.character_enums.Hair;
import model.entities.character_enums.Height;
import model.entities.character_enums.Weapon;
import org.hibernate.Session;
import utility.HibernateUtil;
import views.iCharacterView;

import java.util.Scanner;

public class Controller
{
	//resto di utilities
	static Scanner sc = new Scanner(System.in);
	static Session session = HibernateUtil.getSessionFactory().openSession();
	//model
	static iCharacterDAO cDao = new CharacterDAO(session);
	//view
	static iCharacterView cView = iCharacterView.getInstance("text");

	public static void main(String[] args)
	{
		String cmd;
		do
		{
			System.out.println("Insert Command");
			cmd = sc.nextLine().toUpperCase();

			switch (cmd)
			{
				case "INSERT" -> create();
				case "READ" -> readAll();
				case "QUIT" -> System.out.println("Bye bye");
				default -> System.out.println("Invalid command");

			}
		} while (!cmd.equals("QUIT"));
	}

	private static void create()
	{
		try
		{
			GameCharacter newChar = new GameCharacter();
			System.out.println("Insert name");
			newChar.setName(sc.nextLine());
			System.out.println("Insert height(short,medium,tall)");
			newChar.setHeight(Height.valueOf(sc.nextLine().toUpperCase()));
			System.out.println("Insert hair(none,short,long)");
			newChar.setHair(Hair.valueOf(sc.nextLine().toUpperCase()));
			System.out.println("Insert weapon(dagger,sword,axe)");
			newChar.setWeapon(Weapon.valueOf(sc.nextLine().toUpperCase()));
			System.out.println("Shield?(y/n)");
			String response = sc.nextLine().toLowerCase();
			if(!response.equals("y") && !response.equals("n"))
				throw new RuntimeException("Buffoon, y or n");
			newChar.setShield(response.equals("y"));
			cDao.save(newChar);
		}
		catch (Exception e)
		{
			System.out.println("Invalid data");
		}
	}

	private static void readAll()
	{
		System.out.println("How do you want to render the characters? (text/ascii)");
		cView = iCharacterView.getInstance(sc.nextLine());

		for(GameCharacter gc:cDao.findAll())
			System.out.println(cView.render(gc));
	}
}
