import org.jscience.mathematics.number.Real;

/*
 * An Indian from the 14th century gives us this one.
 * 
 * @author TomT
 */

public class Pi {

	public static Real threePower(int i) {
		if( i==0)
			return Real.valueOf(1);
		Real r = Real.valueOf(3);
		return r.pow(i);
	}
	public static void main(String[] args) {
		Real p = Real.valueOf(0);
		int digits = 4002;
		Real.setExactPrecision(digits);
		int n=500;
		
		for ( int i=0; i<n; i++) {
			int numerator=1;
			if ( i%2 == 1)
				numerator =-1;
			Real term = Real.valueOf(numerator);
			Real denom = Real.valueOf(2*i+1);
			denom = denom.times(threePower(i));
			term = term.divide(denom);
			p=p.plus(term);
		}
		Real twelveRoot = Real.valueOf(12).sqrt();
		p = p.times(twelveRoot);
		System.out.println(p);

	}

}
