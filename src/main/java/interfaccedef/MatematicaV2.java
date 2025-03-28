package interfaccedef;

public class MatematicaV2 implements Matematica
{
	@Override
	public int fibonacci(int n) {
		if (n <= 1) return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	@Override
	public int fattoriale(int n) {
		if (n <= 1) return 1;
		return n * fattoriale(n - 1);
	}


}
