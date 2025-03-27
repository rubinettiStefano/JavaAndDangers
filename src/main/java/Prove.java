import model.dao.CharacterDAO;
import model.dao.DaoInterface;
import model.dao.iCharacterDAO;
import model.entities.GameCharacter;
import model.entities.character_enums.Hair;
import model.entities.character_enums.Height;
import model.entities.character_enums.Weapon;
import org.hibernate.Session;
import utility.HibernateUtil;
import views.CharacterViewAsciiArt;
import views.CharacterViewText;
import views.iCharacterView;

import java.util.Scanner;

public class Prove
{
	public static void main(String[] args)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		DaoInterface<GameCharacter> dao = new CharacterDAO(session);

//		GameCharacter prova = new GameCharacter();
//		prova.setName("Mimmo");
//		prova.setHeight(Height.TALL);
//		prova.setHair(Hair.NONE);
//		prova.setWeapon(Weapon.AXE);
//		prova.setShield(false);
//		dao.save(prova);

		GameCharacter gc = dao.findById(1L);

		Scanner sc = new Scanner(System.in);
		System.out.println("Come lo vuoi vedere? (text/ascii)");
		iCharacterView view = iCharacterView.getInstance(sc.nextLine());

		String renderizzato = view.render(gc);

		System.out.println(renderizzato);
	}
}
