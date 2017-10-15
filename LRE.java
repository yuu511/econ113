import java.lang.StringBuilder;

class LRE{

	String findLRE (double[] args1, double[] args2) {
		MVSC n = new MVSC();
		StringBuilder LRE = new StringBuilder();
		double slope = 0;
		double intercept = 0;
		double variance = n.findVariance (args1);
		double covariance = n.findCovariance (args1,args2);
		slope = covariance / variance;
		double average1 = n.findAverage(args1);
		double average2 = n.findAverage(args2);
        intercept = average2 - (slope * average1);
        System.out.println (slope);
        System.out.println (intercept);
        LRE.append ("Yhat = ");
        LRE.append (Double.toString(slope));
        LRE.append ("X + ");
 		LRE.append (Double.toString(intercept));
 		String returnLRE = LRE.toString();
 		System.out.print (returnLRE);
		return returnLRE;

	}

}