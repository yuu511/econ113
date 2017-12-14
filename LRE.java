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
		System.out.println("YOUR VARIANCE" + variance);
		double average1 = n.findAverage(args1);
		double average2 = n.findAverage(args2);
        intercept = average2 - (slope * average1);
        System.out.println ("Slope = " + slope);
        System.out.println ("intercept = " + intercept);
        LRE.append ("Yhat = ");
        LRE.append (Double.toString(slope));
        LRE.append ("X + ");
 		LRE.append (Double.toString(intercept));
 		String returnLRE = LRE.toString();
 		System.out.print (returnLRE);
		return returnLRE;
	}

	double findSSR (double[] args1,double[] args2){
		MVSC n = new MVSC();
		StringBuilder LRE = new StringBuilder();
		double slope = 0;
		double intercept = 0;
		double variance = n.findVariance (args1);
		double covariance = n.findCovariance (args1,args2);
		slope = covariance / variance;
		System.out.print("This is your Variance" + variance);
		double average1 = n.findAverage(args1);
		double average2 = n.findAverage(args2);
        intercept = average2 - (slope * average1);
        System.out.println ("Slope = " +slope);
        System.out.println ("intercept = "+ intercept);
        LRE.append ("Yhat = ");
        LRE.append (Double.toString(slope));
        LRE.append ("X + ");
 		LRE.append (Double.toString(intercept));
 		String returnLRE = LRE.toString();
 		System.out.println ("Your LRE\n"  + returnLRE);

 		double expecDiff = 0;
 		double totalDiff = 0;
 		double estimate =0;
 		for (int i=0 ;i<args1.length;i++){
 			estimate = intercept + (slope * args1[i]);
 			System.out.print ("estimate " + estimate+ " actual ");
 			System.out.print (args2[i]+" difference ");
 			expecDiff = estimate - args2[i];
 			System.out.print (expecDiff);
            expecDiff = expecDiff * expecDiff;
            System.out.println ("expecDiff ^2 " + expecDiff);
 			totalDiff = totalDiff + expecDiff;
 		}
 		System.out.println ("SSR:" + totalDiff);
 		return totalDiff;
	}

	double findSST (double[] args2){
    	MVSC n = new MVSC();
    	double average2= n.findAverage(args2);
    	double difference = 0;
    	double totalDiff = 0;
    	for (int i=0;i<args2.length;i++){
        	difference= args2[i]-average2;
        	System.out.print ("difference " + difference);
        	difference = difference * difference;
        	System.out.println ("difference ^2 " +difference);
        	totalDiff = totalDiff + difference;
    	}
    	System.out.println ("SST = " + totalDiff);
    	return totalDiff;
	}


	void findSSRTER(double[]args1,double[] args2){
		double SSR = findSSR(args1,args2);
		double SST = findSST(args2);
        double SSE = SST - SSR;
        double Rsquared = 1-SSE/SST;
        System.out.println ("SSE =" + SSE);
        System.out.println ("R^2 = " + Rsquared);
        System.out.println ("SSR = " + SSR);
	}





}

// wat