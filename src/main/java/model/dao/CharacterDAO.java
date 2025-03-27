package model.dao;

import model.entities.GameCharacter;
import org.hibernate.Session;
import utility.exceptions.ObjectNotFoundException;

import java.util.List;

public class CharacterDAO implements DaoInterface<GameCharacter>
{
	private Session session;

	public void yeee()
	{
		System.out.println("STAMPO YEE");
	}


	public CharacterDAO(Session session)
	{
		this.session = session;
	}

	public GameCharacter findById(Long id)
	{
		session.beginTransaction();
		GameCharacter res = session.get(GameCharacter.class,id);
		session.getTransaction().commit();
		return res;
	}

	public List<GameCharacter> findAll()
	{
		session.beginTransaction();
		List<GameCharacter> res = session.createQuery("SELECT p FROM GameCharacter p", GameCharacter.class).getResultList();
		session.getTransaction().commit();
		return  res;
	}

	public void save(GameCharacter s)
	{
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
	}

	public void delete(Long id)
	{
		GameCharacter toDelete =findById(id);
		session.beginTransaction();
		if(toDelete==null)
			throw new ObjectNotFoundException("Non posso cancellare qualcosa che non esiste");

		session.delete(toDelete);
		session.getTransaction().commit();
	}
}
