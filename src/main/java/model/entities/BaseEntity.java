package model.entities;

import jakarta.persistence.*;
@MappedSuperclass
public abstract class BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	public BaseEntity()	{	}

	public BaseEntity(Long id)
	{
		this.id = id;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}