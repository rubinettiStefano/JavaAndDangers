package interfaccedef;

public interface Matematica
{

	public static final double pi = 3.14;

	//Interfaccia
	//NO PROPRIETÀ DI OGGETTO
	//metodi public astratti
	//metodi static
	//dalla jdk 1.8 in poi
	//metodi public concreti con default
	//costanti di class, public static final

	int fibonacci(int n);
	int fattoriale(int n);

	default String fattorialeStampaCarina(int n)
	{
		return "Il fattoriale di "+n+" è "+fattoriale(n);
	}

	default String fibonacciStampaCarina(int n)
	{
		return "Il fibonaccio di "+n+" è "+fibonacci(n);
	}

	static void boh()
	{
		System.out.println("CIAO");
	}
}
