package model.dao;

import model.entities.Building;

import java.util.List;

public interface DaoInterface<Segnaposto>
{
	Segnaposto findById(Long id);
	List<Segnaposto> findAll();
	void save(Segnaposto p);
	void delete(Long id);
}
