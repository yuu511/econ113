import java.util.Scanner;
class Driver{
	

      void calculateMVSC (Scanner scan){
            MVSC n = new MVSC();
            System.out.println ("\nNOW LOADING MVSC... ");
            System.out.println ("Input data set seperated by spaces to calculate Average, variance, and std Dev");
            String data = scan.nextLine();
            String[] pieces = data.split ("\\s+");
            System.out.println("Your Arguments:");  
            for (int i=0; i<pieces.length; i++){
                  System.out.print (pieces[i]+ " ");
            }
            double[] doubledata=new double[pieces.length];
            for (int i=0;i<pieces.length;i++){
                  doubledata[i]=Double.parseDouble(pieces[i]);
            }
            n.calculateMVS(doubledata);
            
            boolean selected = false;
            while (!selected){
                  System.out.print("Would you like to continue and input a 2nd set of data to calculate the covariance? Y / N\n");
                  String continueQ = scan.nextLine();
                  if (continueQ.equals("Y")){
                        selected=true;
                  }
                  if (continueQ.equals("N")){
                        System.out.println("");
                        return;
                  }
            }


            System.out.println ("Input 2nd data set seperated by spaces to calculate covariance ( of same length to the first)");

           
            String data1 = scan.nextLine();
            String[] pieces1 = data1.split ("\\s+");
            double[] doubledata1=new double[pieces1.length];
            for (int i=0;i<pieces1.length;i++){
                  doubledata1[i]=Double.parseDouble(pieces1[i]);
            }
            System.out.println ("Your Arguments:");  
            for (int i=0; i<pieces1.length; i++){
                  System.out.print (pieces1[i]+ " ");
            }
            System.out.println("");
            double covariance = n.findCovariance(doubledata,doubledata1);
            while (Double.isNaN(covariance)){
                  System.out.println("\n try inputting the numbers again!");
                  data1 = scan.nextLine();
                  pieces1 = data1.split ("\\s+");
                  doubledata1=new double[pieces1.length];
                  for (int i=0;i<pieces1.length;i++){
                    doubledata1[i]=Double.parseDouble(pieces1[i]);
                  }
                  System.out.println ("Your Arguments:");  
                  for (int i=0; i<pieces1.length; i++){
                    System.out.print (pieces1[i]+ " ");
                  }
               covariance = n.findCovariance(doubledata,doubledata1);
            }

            selected = false;
                while (!selected){
                  System.out.print("Would you like a simple breakdown of all of the data? Y / N\n");
                  String continueQ = scan.nextLine();
                  if (continueQ.equals("Y")){
                        n.calculateMVSCSIMPLE(doubledata,doubledata1);
                        return;
                  }
                  if (continueQ.equals("N")){
                        System.out.println("NICO NICO NIIIIIIIIIIIIIIIIIIIIIIIIIIII");
                        return;
                  }
            }


      } 

       void calculateMVSCsimple (Scanner scan){
            MVSC n = new MVSC();
            System.out.println ("\nNOW LOADING MVSC (SIMPLE VERSION) ... ");
            System.out.println ("Input 1st data set\n");
            String data = scan.nextLine();
            String[] pieces = data.split ("\\s+");
            System.out.println("\nYour Arguments:");  
            for (int i=0; i<pieces.length; i++){
                  System.out.print (pieces[i]+ " ");
            }
            double[] doubledata=new double[pieces.length];
            for (int i=0;i<pieces.length;i++){
                  doubledata[i]=Double.parseDouble(pieces[i]);
            }
            System.out.println ("\n\nInput 2nd data set seperated by spaces ( of same length to the first) \nto calculate mean, variance, std deviation , and covariance ");
            String data1 = scan.nextLine();
            String[] pieces1 = data1.split ("\\s+");
            double[] doubledata1=new double[pieces1.length];
            for (int i=0;i<pieces1.length;i++){
                  doubledata1[i]=Double.parseDouble(pieces1[i]);
            }
            System.out.println ("\nYour Arguments:");  
            for (int i=0; i<pieces1.length; i++){
                  System.out.print (pieces1[i]+ " ");
            }         
            n.calculateMVSCSIMPLE(doubledata,doubledata1);
            System.out.println("");
      } 

      void calculateLRE (Scanner scan){
            LRE n = new LRE();
            System.out.println ("\nNOW LOADING LRE ... ");
            System.out.println ("Input 1st data set\n");
            String data = scan.nextLine();
            String[] pieces = data.split ("\\s+");
            System.out.println("\nYour Arguments:");  
            for (int i=0; i<pieces.length; i++){
                  System.out.print (pieces[i]+ " ");
            }
            double[] doubledata=new double[pieces.length];
            for (int i=0;i<pieces.length;i++){
                  doubledata[i]=Double.parseDouble(pieces[i]);
            }
            System.out.println ("\n\nInput 2nd data set seperated by spaces ( of same length to the first)");
            String data1 = scan.nextLine();
            String[] pieces1 = data1.split ("\\s+");
            double[] doubledata1=new double[pieces1.length];
            for (int i=0;i<pieces1.length;i++){
                  doubledata1[i]=Double.parseDouble(pieces1[i]);
            }
            System.out.println ("\nYour Arguments:");  
            for (int i=0; i<pieces1.length; i++){
                  System.out.print (pieces1[i]+ " ");
            }         
            n.findLRE(doubledata,doubledata1);
            System.out.println("");

      }

      public static void main (String[] args){          
            Driver d = new Driver();     
            Scanner scan = new Scanner (System.in);
            boolean running = true;
            boolean notselected = true;
            while (running && notselected){
                System.out.println ("Type out the command you wish to use:\n");
                System.out.println ("MVSC : MEAN VARIANCE STD DEVIATION COVARIANCE PROGRAM\n");
                System.out.println ("MVSC_SIMPLE : MEAN VARIANCE STD DEVIATION COVARIANCE PROGRAM WITHOUT WORK\n");
                System.out.println ("LRE\n");
                System.out.println ("QUIT (EXIT THE PROGRAM)\n");
                String data = scan.nextLine();

                if (data.equals("MVSC")){
                  notselected=false;
                  d.calculateMVSC(scan);
                  notselected=true;
                }

                 if (data.equals("MVSC_SIMPLE")){
                  notselected=false;
                  d.calculateMVSCsimple(scan);
                  notselected=true;
                }

                 if (data.equals("LRE")){
                  notselected=false;
                  d.calculateLRE(scan);
                  notselected=true;
                }



                if (data.equals("QUIT")){
                  running = false;
                  notselected = false;
                }
            }
            scan.close();
      }
}

//             MVSC n = new MVSC();
//             Scanner scan = new Scanner (System.in);
//             System.out.println ("Input 1st data set seperated by spaces to calculate Average, variance, and std Dev");
//             String data = scan.nextLine();
//             String[] pieces = data.split ("\\s+");
//             System.out.println("Your Arguments:");  
//             for (int i=0; i<pieces.length; i++){
//                   System.out.print (pieces[i]+ " ");
//             }
//             double[] doubledata=new double[pieces.length];
//             for (int i=0;i<pieces.length;i++){
//                   doubledata[i]=Double.parseDouble(pieces[i]);
//             }
//             n.calculateMVS(doubledata);
//             System.out.println ("Input 2nd data set seperated by spaces to calculate covariance ( of same length to the first)");
//             String data1 = scan.nextLine();
//             String[] pieces1 = data1.split ("\\s+");
//             double[] doubledata1=new double[pieces1.length];
//             for (int i=0;i<pieces1.length;i++){
//                   doubledata1[i]=Double.parseDouble(pieces1[i]);
//             }
//             System.out.println ("Your Arguments:");  
//             for (int i=0; i<pieces1.length; i++){
//                   System.out.print (pieces1[i]+ " ");
//             }
//             System.out.println("");
//             double covariance = n.findCovariance(doubledata,doubledata1);
//             scan.close();
