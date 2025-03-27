package lamdas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StreamELambda
{
	public static void main(String[] args)
	{
		List<Persona> persone = new ArrayList<>();

		persone.add(new Persona(1L,"Stefano","Rubinetti",29));
		persone.add(new Persona(2L,"Domenico","Farano",26));
		persone.add(new Persona(3L,"Edoardo","Sannia",23));
		persone.add(new Persona(4L,"Veronica","Pugliese",22));
		persone.add(new Persona(5L,"Alessandro","Tardiola",25));
		persone.add(new Persona(6L,"Michele","Brugognone",25));
		persone.add(new Persona(7L,"Donato","Morra",23));
		persone.add(new Persona(8L,"Pietro","Mirto",25));
		persone.add(new Persona(9L,"Claudio","Costantino",26));
		persone.add(new Persona(10L,"Simone","Chiriaco",23));
		//RICERCA 	-> estrazione unico ELEMENTO in base condizione univoca
		Persona daTrovare;
		for(Persona p:persone)
			if(p.getId()==10L)
				daTrovare=p;
		//FILTRO 	-> estrazione di un SOTTOINSIEME dall'insieme di partenza in base ad una condizione
		List<Persona> res = new ArrayList<>();
		for(Persona p:persone)
			if(p.getEta()<25)
				res.add(p);
		//RIDUZIONE -> (in termini sql un GROUP BY), estrazione di un singolo VALORE dall'insieme
		double mediaEta=0;
		for(Persona p:persone)
			mediaEta+=p.getEta();
		mediaEta/=persone.size();
		//MAPPATURA -> trasformazione applicata a tutti gli elementi di un insieme
		List<String> nominativi = new ArrayList<>();
		for(Persona p:persone)
			nominativi.add(p.getNome()+" "+p.getCognome());

		//filtro
		//noi per motivi di standardizzazione e performance vogliamo usare un altro modo
		//uno stream è una COLLEZIONE DI LAVORO, qualcosa di AMORFO che ha metodi per
		//eseguire operazioni sui dati
		List<Persona> meno25 = 	persone. //prendiamo la lista
								stream().//la trasformiamo in Stream
								filter(p->p.getEta()<25).//filtriamo
								toList();//ritrasformiamo in lista
		//filter(p->p.getEta()<25)
		//questo metodo foreaccha in automatico la lista
		//e applica la funzione che scriviamo ad ogni elemento in essa, chiamato p
		//qui stiamo sovrascrivendo il metodo test() di una interfaccia funzionale
		//standard chiamata Predicate
		//test è un metodo che deve produrre un booleano
		//se produce true applicato all'elemento, l'elemento viene tenuto, altrimenti
		//viene scartato

		//mappatura
		List<String> nominativi2 = 	persone. //prendiamo la lista
									stream().//la trasformiamo in Stream
									map(p->p.getNome()+" "+p.getCognome()).//mappiamo
									toList();


		List<String> nominativiMeno25 = persone. //prendiamo la lista
										stream().//la trasformiamo in Stream
										filter(p->p.getEta()<25).//filtriamo
										map(p->p.getNome()+" "+p.getCognome()).//mappiamo
										toList();

		List<String> tanteDateExcelose = new ArrayList<>();
		tanteDateExcelose.add("2024-01-15");
		tanteDateExcelose.add("2024-02-10");
		tanteDateExcelose.add("2024-03-05");
		tanteDateExcelose.add("2024-04-12");
		tanteDateExcelose.add("2024-05-20");
		tanteDateExcelose.add("2024-06-25");
		tanteDateExcelose.add("2024-07-04");
		tanteDateExcelose.add("2024-08-19");
		tanteDateExcelose.add("2024-09-03");
		tanteDateExcelose.add("2024-10-11");
		tanteDateExcelose.add("2024-11-06");
		tanteDateExcelose.add("2024-12-21");
		tanteDateExcelose.add("2025-01-09");
		tanteDateExcelose.add("2025-02-14");
		tanteDateExcelose.add("2025-03-18");
		tanteDateExcelose.add("2025-04-27");
		tanteDateExcelose.add("2025-05-30");
		tanteDateExcelose.add("2025-06-08");
		tanteDateExcelose.add("2025-07-22");
		tanteDateExcelose.add("2025-08-31");

		//voglio averle come date e tenere solo quelle future

		List<LocalDate> dateFuture = 	tanteDateExcelose.stream().
										map(d -> LocalDate.parse(d))
										.filter(d-> d.isAfter(LocalDate.now()))
										.toList();

		//Optional

		Scanner sc = new Scanner(System.in);
		System.out.println("Dammi id");
		Long id = Long.parseLong(sc.nextLine());

		Optional<Persona> boxettonePersona = persone.stream()
											.filter(p->p.getId()==id)
											.findFirst();

		//un optional è una scatola che può contenere o no una persona
		if(boxettonePersona.isPresent())//se c'è una persona nella scatola
		{
			Persona p = boxettonePersona.get();//prendo la persona nella scatola
			//faccio ciò che voglio
		}
		else
		{
			System.out.println("Persona non trovata");
		}


		//riduzione
		double media = 	persone.stream().
						mapToInt(p->p.getEta())//mappa tutte persone alla loro età
						.average()//calcola la media
						.orElse(0);//se la lista è vuota e non ci riesci metti 0

	}
}
