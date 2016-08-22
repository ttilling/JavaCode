import org.jscience.mathematics.number.Real;

/*
 * Copyright (c) 2016, Tom Tillinghast. All rights reserved.
 * 
 * Approximating pi using 14th century method
 * 
 * pi ?= (12^1/2) * SUM[ (-1/3)^k / (2k+1)]
 *        rootTwelve       A           B
 * 
 * 
 * nextTerm = A / (2k+1)
 */
public class Pi {
	
	/*
	 * 
	 */
	static int digits = 200;
	static int N = digits*3;

	public static void main(String[] args) {
		Real.setExactPrecision(N+50);
		Real rootTwelve = Real.valueOf(12);
			rootTwelve = rootTwelve.sqrt();
			
		Real pi = Real.valueOf(0);
		Real tempTerm = rootTwelve.copy();
		/*
		 * we will use tempTerm = (12^1/2) * (-1/3)^k.
		 *    this will be made consistent by dividng by -3 each time.
		 * then term (the actual term in the summation) will be term/(2k+1)
		 */
		for ( int k=0; k<N; k++) {
			Real term = tempTerm.divide(Real.valueOf(2*k+1));
			pi = pi.plus(term);
			tempTerm = tempTerm.divide(Real.valueOf(-3.0));
		}
		System.out.println(pi.toString());//.substring(0, digits+2));
		System.out.println(pi.getPrecision());
	}

}
