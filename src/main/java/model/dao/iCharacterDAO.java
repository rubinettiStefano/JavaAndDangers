package model.dao;

import model.entities.GameCharacter;

import java.util.List;

public interface iCharacterDAO
{
	GameCharacter findById(Long id);
	List<GameCharacter> findAll();
	void save(GameCharacter p);
	void delete(Long id);
}
