import java.util.*;
public class fibonacciClass
{
	public int max_size=100;

	public double curr_size=0;

	
	public double[] fibo=new double[max_size];

	
	public double getcurr_size()
	{
		return this.curr_size;
	}

	public void generateSequence(double N)
	{
		
		if (N<=this.max_size)
		{


		if(N==1)

		{
			this.fibo[0]=0;
			this.curr_size+=1;
			
		}
		else
		{
			this.fibo[0]=0;
			this.fibo[1]=1;
			this.curr_size+=2;
			for(int i=2;i<N;i++)
			{
				this.fibo[i]=this.fibo[i-1]+this.fibo[i-2];
				this.curr_size+=1;
			}
		}
		}
		else
		{
			this.fibo[0]=0;
			this.fibo[1]=1;
			this.curr_size+=2;
			for(int i=2;i<this.max_size;i++)
			{
				this.fibo[i]=this.fibo[i-1]+this.fibo[i-2];
				this.curr_size+=1;
			}
		}
	}

	public void displaySequence()
	{
		for(int i=0;i<curr_size;i++)
		{
			System.out.print(this.fibo[i]+" ");
		}
	}

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter how many fibonacci numbers you want");
		double d=input.nextDouble();
		fibonacciClass fib1=new fibonacciClass();
		
		fib1.generateSequence(d);
		fib1.displaySequence();
		

	}



}
