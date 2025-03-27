package model.dao;

import model.entities.Building;

import java.util.List;

public interface iBuildingDAO
{
	Building findById(Long id);
	List<Building> findAll();
	void save(Building p);
	void delete(Long id);
}
