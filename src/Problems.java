import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Problems {
	public static void main(String[] args) {
		System.out.println("Input the problem you wish to solve");
		Scanner myscanner = new Scanner(System.in);
		String input = myscanner.nextLine();
		input = "problem" + input;
		try
		{
			Problems.class.getMethod(input).invoke(args);
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException 
				| SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myscanner.close();
	}
	
	
	public static void problem1()
	{
		/*If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
		 * The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
		 * */
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
		/*Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
		 * By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... 
		 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, 
		 * find the sum of the even-valued terms.
		 * */
		long[] fibnum = {2,0};
		int i = 0;
		long sum = 0;
		 
		while (fibnum[i] < 4000000) {
		    sum += fibnum[i];
		    i = (i+1) % 2;
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
    public static int fibonacciLoop(int number){
        if(number == 1 || number == 2){
            return 1;
        }
        int fibo1=1, fibo2=1, fibonacci=1;
        for(int i= 3; i<= number; i++){
            fibonacci = fibo1 + fibo2; 
            fibo1 = fibo2;
            fibo2 = fibonacci;
 
        }
        return fibonacci; 
    }    
    public static void problem3()
	{
    	/* The prime factors of 13195 are 5, 7, 13 and 29. 
    	 * What is the largest prime factor of the number 600851475143 ? 
    	 * */
    	double n = 6.00851475143;
    	double m = Math.pow(10, 11);
    	int largest = 0;
    	n *= m;
    	int i=2;
    	while(n>1)
    	{
    		if(n%i == 0)
    		{
    			if (i > largest) {
    				largest = i;
    			}
    			n=n/i;
    		}
    		else {
    			i++;
    		}
    	} 
    	System.out.println(largest);
	}
    public static void problem4()
    {
    	/*A palindromic number reads the same both ways. The largest palindrome made from the product of 
    	 * two 2-digit numbers is 9009 = 91 × 99. Find the largest palindrome made from the product of 
    	 * two 3-digit numbers.
    	 * */
    	
    	String palindromeString;
        int strln;
        int answer = 0;
        
        for (int c1 = 100; c1<=999; c1++)
        {
        	for (int c2 = 100; c2<=999; c2++)
        	{
        		int prod = c1*c2;
        		palindromeString = "" + prod;
        		strln = palindromeString.length();
            
        		for(int x = 1; x<=strln/2 ; x++)
        		{
        			if (palindromeString.charAt(x-1) == palindromeString.charAt(strln-(x)) && (x)!= (strln/2))
        			{
        				continue;
        			}
              
        			else if (palindromeString.charAt(x-1) != palindromeString.charAt(strln -(x)))
        			{
        				break;
        			}
        			else if (palindromeString.charAt(x-1) == palindromeString.charAt(strln-(x)) && (x)== (strln/2))
        			{
        				if(answer<prod)
        				{
        					answer = prod;
        					continue;
        				}
        				else
        				{
        					continue;
        				}
        			}
        		}
        	}
        }
        System.out.println(answer);
    }
    public static void problem5()
    {
    	/*2520 is the smallest number that can be divided by each of the numbers from 
    	 * 1 to 10 without any remainder. What is the smallest positive number that is 
    	 * evenly divisible by all of the numbers from 1 to 20?
    	 * */
    	int[] numberlist = new int[20];
        for(int i=0; i<20; i++){
            numberlist[i] = i+1;
        }
        int answer =1;
        for(int i =0; i<numberlist.length;i++){
                if(numberlist[i]!=1){
                    answer *= numberlist[i];
                    for(int j=numberlist.length-1; j>=i ;j--){
                        if(numberlist[j]%numberlist[i]==0){
                            numberlist[j]=numberlist[j]/numberlist[i];
                        }
                    }
                }
        }
        System.out.println(answer); 
    }
}
