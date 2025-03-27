package lamdas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EsercizioLambda
{
	public static void main(String[] args)
	{
		List<Persona> persone = new ArrayList<>();

		persone.add(new Persona(1L,"Stefano","Rubinetti", LocalDate.parse("1995-08-27")));
		persone.add(new Persona(2L,"Domenico","Farano",LocalDate.parse("1999-03-20")));
		persone.add(new Persona(3L,"Edoardo","Sannia",LocalDate.parse("2001-06-11")));
		persone.add(new Persona(4L,"Veronica","Pugliese",LocalDate.parse("2002-11-11")));
		persone.add(new Persona(5L,"Alessandro","Tardiola",LocalDate.parse("2000-01-24")));
		persone.add(new Persona(6L,"Michele","Brugognone",LocalDate.parse("2000-03-15")));
		persone.add(new Persona(7L,"Donato","Morra",LocalDate.parse("2001-11-27")));
		persone.add(new Persona(8L,"Pietro","Mirto",LocalDate.parse("1999-05-05")));
		persone.add(new Persona(9L,"Claudio","Costantino",LocalDate.parse("1999-03-16")));
		persone.add(new Persona(10L,"Simone","Chiriaco",LocalDate.parse("2001-06-21")));

		//stampare nominativo di tutti
		//stampare età di tutti (consiglio, fare metodo calcola eta su persona)
		//stampare nominativo+età di tutti
		//stampare persona con nome Stefano e Cognome Rubinetti
		//stampare tutte le persone nate prima del 2000-01-01
		//stampare eta media
		//stampare eta massima
		//stampare eta minima
		//stampare eta media di tutte le persone il cui nome finisce con "o"
	}
}
