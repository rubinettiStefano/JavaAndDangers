package lamdas;

public class Utilizzatore
{
	public static void main(String[] args)
	{
//		Matematica m = new Sommatore();

//		System.out.println(m.calcola(10,20));

		//la prima evoluzione è il togliere Classe Sommatore
		//la classe Sommatore non esiste più, al suo posto ho una
		//classe ANONIMA, usa e getta, dichiarata subito qui sotto
		Matematica m2 = new Matematica()
			//public class SENZANOME implements Matematica
		{
			@Override
			public int calcola(int a, int b)
			{
				return a+b;
			}
		};
//		System.out.println(m2.calcola(10,20));


		Matematica m3 = (mimmo,pippo)->
		{
			return mimmo*pippo;
		};
		System.out.println(m3.calcola(10,20));

		//forma finale		INPUT		OUTPUT
		Matematica m4 = (mimmo,pippo)->mimmo*pippo;
		System.out.println(m4.calcola(10,20));
	}
}
