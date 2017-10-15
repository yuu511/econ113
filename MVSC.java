import java.util.Scanner;
import java.lang.Object;
import java.io.OutputStream;
import java.io.FilterOutputStream;
import java.io.PrintStream;

class MVSC {
   
    PrintStream dummyStream = new PrintStream(new OutputStream(){
    public void write(int b) {
        // NO-OP
    }
    });
   PrintStream originalStream = System.out;

    double findAverage(double[] args){
      double total = 0;	
      double average = 0;
      System.out.println("Calculating Average ..");
      for (int i=0; i<args.length; i++){
      	total= total + args[i];
        System.out.print (args[i]+ " ");
      }
      average = total / args.length;
      System.out.println ("\n" + total + " / " +args.length);
      System.out.println ("\nThis is your average: " + average +"\n\n");
      return average;     
    }

    double findVariance(double[] args){
      double variance = 0;
      double sumDiff = 0;
      silencePrintStream();
      double average = findAverage(args);
      restorePrintStream();
      System.out.println ("Calculating variance....\n(sumdiff)^2:");
      for (int i=0; i<args.length; i++){
      	sumDiff= (args[i]) - average;
      	sumDiff = sumDiff * sumDiff;
      	System.out.println (sumDiff);
      	variance = variance + sumDiff;
      }
      System.out.println ("Sum of all sumdiff:" + variance+ "\nSumsumdiff / (size -1) = "+ variance +"/"+(args.length-1));
      variance = variance / (args.length -1);
      
      System.out.println ("\nThis is your variance: " + variance +"\n\n");
      return variance;
    }

    double findStdDeviation(double[] args){
      double stdDeviation= 0;
      double variance = 0;
      double sumDiff = 0;
      silencePrintStream();
      double average = findAverage(args);
      restorePrintStream();
      for (int i=0; i<args.length; i++){
        sumDiff= (args[i]) - average;
        sumDiff = sumDiff * sumDiff;
        variance = variance + sumDiff;
      }
      variance = variance / (args.length -1);
      stdDeviation = Math.sqrt(variance);
      System.out.println ("Calculating stdDev, Input variance: " + variance);
      System.out.println ("This is your Standard Deviation: (SQRT VARIANCE) " + stdDeviation  + "\n\n");
      return stdDeviation;
    }

    double findCovariance(double[] args, double[] args1){

      if (args.length != args1.length){
      	System.out.println ("invalid 2nd length");
        return Double.NaN;
      }
      double average1 = 0;
      double average2 = 0;
      double diff1 = 0;
      double diff2 = 0;
      double times = 0;
      double totalSum = 0;
      double covariance;

      System.out.println("Calculating Covariance...");
      average1= findAverage(args);
      average2= findAverage(args1);
      System.out.println ("Average set1: " + average1);
      System.out.println ("Average set2: "+ average2);

      System.out.println ("x -xbar times y-ybar: ");
      System.out.println("x y x*y");
      System.out.println("- - ---");
      for (int i=0; i<args.length; i++){
      	diff1= args[i] - average1;
      	diff2= args1[i] - average2;
      	times = diff1 * diff2;
        totalSum = totalSum + times;

      	System.out.print (diff1 + " / ");
      	System.out.print (diff2 + " ");
      	System.out.println ("// " +times);
      }
      System.out.println ("\ntotal sum x-xbar times y-ybar:" + totalSum);
      System.out.println ("totalSum x-xbar times y-ybar:" + totalSum + "\ntotalSum / (size -1) = "+ totalSum +"/"+(args.length-1));
      covariance = totalSum / (args.length -1);
      System.out.println("\nThis is your covariance:" + covariance+ "\n\n");
      return covariance;
    }


	void calculateMVS(double[] args){
	    double average = 0;
      double variance = 0;
      double stdDeviation = 0;
      average = findAverage(args);
      variance = findVariance (args);
      stdDeviation = findStdDeviation(args);
    }

  void calculateMVSCSIMPLE(double[] args, double[] args2){
    silencePrintStream();
    double average = 0;
    double average2 = 0;
    double variance = 0;
    double variance2 = 0;
    double stdDeviation = 0;
    double stdDeviation2 = 0;
    double covariance = 0;
    average = findAverage(args);
    average2 = findAverage(args2);
    variance = findVariance (args);
    variance2 = findVariance (args2);
    stdDeviation = findStdDeviation(args);
    stdDeviation2 = findStdDeviation(args2);
    covariance = findCovariance(args,args2);
    restorePrintStream();
    System.out.println ("\n\nAverage (1st set): " +average);
    System.out.println ("Average (2nd set): " +average2);
    System.out.println ("Variance (1st set): " +variance);
    System.out.println ("Variance (2nd set): " +variance2);
    System.out.println ("Standard Deviation (1st set): " +stdDeviation);
    System.out.println ("Standard Deviation (2nd set): " +stdDeviation);
    System.out.println ("Covariance: " +covariance+"\n");
  }

  void silencePrintStream(){
    System.setOut(dummyStream);
  }

  void restorePrintStream(){
    System.setOut(originalStream);
  }

}