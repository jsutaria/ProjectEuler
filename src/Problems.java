import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Problems {
	public static void main(String[] args) {
		System.out.println("Input the problem you wish to solve");
		Scanner myscanner = new Scanner(System.in);
		String input = myscanner.nextLine();
		input = "problem" + input;
		try {
			Problems.class.getMethod(input).invoke(args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myscanner.close();
	}
	public static void problem1()
	{
		int sum = 0;
		for(int number = 0; number < 1000; number++) {
			if (number%3 == 0 || number%5 == 0) {
				sum = sum + number;
			}
		}
		System.out.println(sum);
	}
	public static void problem2()
	{
		long[] fibnum = {2,0};
		int i = 0;
		long sum = 0;
		 
		while (fibnum[i] < 4000000) {
		    sum += fibnum[i];
		    i = (i + 1) % 2;
		    fibnum[i] = 4 * fibnum[(i + 1) % 2] + fibnum[i];
		}
		
		System.out.println(sum);
		
	}
	public static int fibonacciRecusion(int number){
        if(number == 1 || number == 2){
            return 1;
        }
 
        return fibonacciRecusion(number-1) + fibonacciRecusion(number -2); //tail recursion
    }
 
    // Java program for Fibonacci number using Loop.
    public static int fibonacciLoop(int number){
        if(number == 1 || number == 2){
            return 1;
        }
        int fibo1=1, fibo2=1, fibonacci=1;
        for(int i= 3; i<= number; i++){
            fibonacci = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci number
            fibo1 = fibo2;
            fibo2 = fibonacci;
 
        }
        return fibonacci; //Fibonacci number
    }     
}
