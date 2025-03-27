package model.dao;

import model.entities.Building;

import java.util.List;

public class BuildingDAO implements DaoInterface<Building>
{
	@Override
	public Building findById(Long id)
	{
		return null;
	}

	@Override
	public List<Building> findAll()
	{
		return List.of();
	}

	@Override
	public void save(Building p)
	{

	}

	@Override
	public void delete(Long id)
	{

	}
}
