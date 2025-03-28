package interfaccedef;

public class MatematicaV1 implements Matematica
{
	@Override
	public int fibonacci(int n)  //0 1 1 2 3 5 8 13
	{
		double pigreco =Matematica.pi;
		if(n<2)
			return n;
		int a = 0;
		int b = 1;
		int c = 1;
		for(int i=2;i<=n;i++)
		{
			c = b+a;
			a=b;
			b= c;
		}
		return c;
	}

	@Override
	public int fattoriale(int n)
	{
		//1*2*3*....*n
		int res = 1;

		for(int i=2;i<=n;i++)
			res*=i;

		return res;
	}


}
