package lamdas;

import java.time.LocalDate;

public class Persona
{
	private Long id;
	private String nome,cognome;
	private LocalDate dob;

	public Persona(Long id, String nome, String cognome, LocalDate dob)
	{
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
	}

	public Persona()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}

	public LocalDate getDob()
	{
		return dob;
	}

	public int getEta()
	{
		//TODO, fate voi il calcolo qui
		return 0;
	}
}

