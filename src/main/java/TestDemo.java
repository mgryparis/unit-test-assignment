import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a>0 && b>0) {	int sum = a+b;	return sum;	}
		else	{	throw  new IllegalArgumentException("Both parameters must be positive!");	}	
} 	// Method End addPositive

	public boolean divisibleBy(int a, int b) {
		boolean divisible;
		if (a%b==0)	{	divisible=true;		}
		else		{	divisible=false;	}
		return divisible;
	}
	
	@VisibleForTesting
	public int randomNumberSquared()	{
		int randomInt = getRandomInt();
		return randomInt*randomInt;
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;

	}
}
