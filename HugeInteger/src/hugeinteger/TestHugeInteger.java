package hugeinteger;
import java.math.BigInteger;
public class TestHugeInteger {

    public static void main(String[] args) {
////////        //declaration of strings
////////        String str0 = "1006";//an example of borrowing + leading 0's
////////        String str1 = "0009";
////////        String str2 = "123";//an example of adding and subtracting 2 positive numbers
////////        String str3 = "23";
////////        String str4 = "-500";//2 negatives
////////        String str5 = "-105";
////////        String str6 = "54321";//1 negative, 1 positive that are the same size but off by 1 digit
////////        String str7 = "-54325";
////////        String str8 = "-100";//1 negative, 1 positive
////////        String str9 = "99";
////////        String str10 = "12e";//invalid string: exception should be thrown
////////        
////////        //test constructors
////////        HugeInteger huge0 = new HugeInteger(str0);
////////        HugeInteger huge1 = new HugeInteger(str1);
////////        HugeInteger huge2 = new HugeInteger(str2);
////////        HugeInteger huge3 = new HugeInteger(str3);
////////        HugeInteger huge4 = new HugeInteger(str4);
////////        HugeInteger huge5 = new HugeInteger(str5);
////////        HugeInteger huge6 = new HugeInteger(str6);
////////        HugeInteger huge7 = new HugeInteger(str7);
////////        HugeInteger huge8 = new HugeInteger(str8);
////////        HugeInteger huge9 = new HugeInteger(str9);
////////        //HugeInteger huge10 = new HugeInteger(str10);//invalid number: exception should be thrown
////////        HugeInteger huge11 = new HugeInteger(20);//random number generator
////////        HugeInteger huge12 = new HugeInteger(40);
////////        //HugeInteger huge13 = new HugeInteger(-2);//invalid input for second constructor (random generator)
////////        
////////        //Tests add/subtract methods as well as any methods called by add and subtract
////////        HugeInteger sum0 = huge0.add(huge1);//borrowing + leading 0's
////////        HugeInteger sub0 = huge0.subtract(huge1);
////////        HugeInteger sum1 = huge2.add(huge3);//adding and subtracting 2 positive numbers
////////        HugeInteger sub1 = huge2.subtract(huge3);
////////        HugeInteger sum2 = huge4.add(huge5);//2 negatives
////////        HugeInteger sub2 = huge4.subtract(huge5);
////////        HugeInteger sum3 = huge6.add(huge7);//1 negative, 1 positive that are the same size but off by 1 digit
////////        HugeInteger sub3 = huge6.subtract(huge7);
////////        HugeInteger sum4 = huge8.add(huge9);//1 negative, 1 positive
////////        HugeInteger sub4 = huge8.subtract(huge9);
////////        HugeInteger sum5 = huge11.add(huge12);//sum and subtraction of random numbers
////////        HugeInteger sub5 = huge11.subtract(huge12);
////////        
////////        
////////        //print statements
////////        System.out.println("Sum: "+huge0+" + "+huge1+" = "+sum0);//borrowing + leading 0's
////////        System.out.println("Subtraction: "+huge0+" - "+huge1+" = "+sub0);
////////        System.out.println();
////////        System.out.println("Sum: "+huge2+" + "+huge3+" = "+sum1);//adding and subtracting 2 positive numbers
////////        System.out.println("Subtraction: "+huge2+" - "+huge3+" = "+sub1);
////////        System.out.println();
////////        System.out.println("Sum: "+huge4+" + "+huge5+" = "+sum2);//2 negatives
////////        System.out.println("Subtraction: "+huge4+" - "+huge5+" = "+sub2);
////////        System.out.println();
////////        System.out.println("Sum: "+huge6+" + "+huge7+" = "+sum3);//1 negative, 1 positive that are the same size but off by 1 digit
////////        System.out.println("Subtraction: "+huge6+" - "+huge7+" = "+sub3);
////////        System.out.println();
////////        System.out.println("Sum: "+huge8+" + "+huge9+" = "+sum4);//1 negative, 1 positive
////////        System.out.println("Subtraction: "+huge8+" - "+huge9+" = "+sub4);
////////        System.out.println();
////////        System.out.println("Sum: "+huge11+" + "+huge12+" = "+sum5);//sum and subtraction of random numbers
////////        System.out.println("Subtraction: "+huge11+" - "+huge12+" = "+sub5);
////////        System.out.println();
//        
//
//        //Lab 2, test multiply, divide and compareTo methods
//        //declare strings
////        String st0 = "1111111111";//an example of multiplying and dividing 2 positive numbers
////        String st1 = "111";
////        String st2 = "-999";//an example of 2 negatives
////        String st3 = "-999";
//        String st4 = "432983400734823766";//1 negative, 1 positive
////        String st5 = "-50";
////        String st6 = "54321";//1 negative, 1 positive that are the same size but off by 1 digit
////        String st7 = "-54325";
////        String st8 = "-100";//
////        String st9 = "99";
//        
//        //call constructors
////        HugeInteger hug0 = new HugeInteger(st0);
////        HugeInteger hug1 = new HugeInteger(st1);
////        HugeInteger hug2 = new HugeInteger(st2);
////        HugeInteger hug3 = new HugeInteger(st3);
//        HugeInteger hug4 = new HugeInteger(st4);
////        HugeInteger hug5 = new HugeInteger(st5);
////        HugeInteger hug6 = new HugeInteger(st6);
////        HugeInteger hug7 = new HugeInteger(st7);
////        HugeInteger hug8 = new HugeInteger(st8);
////        HugeInteger hug9 = new HugeInteger(st9);
////        HugeInteger hug10 = new HugeInteger("0");//zero
////        HugeInteger hug11 = new HugeInteger(30);//random number generator
////        HugeInteger hug12 = new HugeInteger(30);
////        //extra strings for division
//        HugeInteger hug13 = new HugeInteger("60");
////        HugeInteger hug14 = new HugeInteger("999");
//        
//        //Tests multiply and divide methods 
////        HugeInteger prod0 = hug0.multiply(hug1);
////        HugeInteger prod1 = hug2.multiply(hug3);
////        HugeInteger prod2 = hug4.multiply(hug5);
////        HugeInteger prod3 = hug6.multiply(hug7);
////        HugeInteger prod4 = hug8.multiply(hug9);
////        HugeInteger prod5 = hug10.multiply(hug10);
////        HugeInteger prod6 = hug10.multiply(hug5);
//        
//        HugeInteger div0 = hug4.divide(hug13);//2 positives
////        HugeInteger div1 = hug13.divide(hug4);
////        HugeInteger div2 = hug4.divide(hug4);
////        HugeInteger div3 = hug7.divide(hug5);//2 negatives
////        HugeInteger div4 = hug5.divide(hug7);
////        HugeInteger div5 = hug7.divide(hug7);
////        HugeInteger div6 = hug0.divide(hug7);//1 pos, 1 neg
////        HugeInteger div7 = hug7.divide(hug0);
////        HugeInteger div8 = hug3.divide(hug14);
//        
//        //print statements
////        System.out.println("Multiplication: "+hug0+" * "+hug1+" = "+prod0);//borrowing + leading 0's
////        System.out.println("Multiplication: "+hug2+" * "+hug3+" = "+prod1);//adding and subtracting 2 positive numbers
////        System.out.println("Multiplication: "+hug4+" * "+hug5+" = "+prod2);//2 negatives
////        System.out.println("Multiplication: "+hug6+" * "+hug7+" = "+prod3);//1 negative, 1 positive that are the same size but off by 1 digit
////        System.out.println("Multiplication: "+hug8+" * "+hug9+" = "+prod4);//1 negative, 1 positive
////        System.out.println("Multiplication: "+hug10+" * "+hug10+" = "+prod5);//sum and subtraction of random numbers
////        System.out.println();
//        System.out.println("Division: "+hug4+" / "+hug13+" = "+div0);//larger positive number over smaller positive
////        System.out.println("Division: "+hug13+" / "+hug4+" = "+div1);//smaller positive number over larger positive
////        System.out.println("Division: "+hug4+" / "+hug4+" = "+div2);//2 positive numbers of the same magnitude
////        System.out.println("Division: "+hug7+" / "+hug5+" = "+div3);//larger negative number over smaller negative
////        System.out.println("Division: "+hug5+" / "+hug7+" = "+div4);//smaller negative number over larger negative
////        System.out.println("Division: "+hug7+" / "+hug7+" = "+div5);//2 negative numbers of the same magnitude
////        System.out.println("Division: "+hug0+" / "+hug7+" = "+div6);//larger positive number over smaller negative
////        System.out.println("Division: "+hug7+" / "+hug0+" = "+div7);//smaller negative number over larger positive
////        System.out.println("Division: "+hug3+" / "+hug14+" = "+div8);//2 numbers of same magnitude different sign
//        System.out.println();
//        
////        //test compareToMagnitude
////        HugeInteger large0 = new HugeInteger("954321");
////        HugeInteger large1 = new HugeInteger("954335");
////        HugeInteger large2 = new HugeInteger("999");
////        HugeInteger large3 = new HugeInteger("-1000");
////        HugeInteger large4 = new HugeInteger("-500");
////        
////        int comp0 = large0.compareTo(large0);//compares to the same number (should return 0)
////        int comp1 = large0.compareTo(large1);//compares to a larger number thats the same size(should return -1)
////        int comp2 = large0.compareTo(large2);//compares to a smaller number (should return 1)
////        int comp3 = large1.compareTo(large0);//compares to a smaller number thats the same size(should return 1)
////        int comp4 = large2.compareTo(large1);//compares to a larger number (should return -1)
////        int comp5 = large2.compareTo(large3);//compares to a smaller (negative) number (should return 1)
////        int comp6 = large3.compareTo(large2);//compares to a larger(positive) number (should return -1)
////        int comp7 = large3.compareTo(large3);//compares to same size and magnitude (should return 0)
////        int comp8 = large4.compareTo(large3);//compares to something larger in magnitude but smaller in sign (should return 1)
//        
////        System.out.println("Compares: "+large0+" > "+large0+" ? "+comp0);//(should return 0)
////        System.out.println("Compares: "+large0+" > "+large1+" ? "+comp1);//(should return -1)
////        System.out.println("Compares: "+large0+" > "+large2+" ? "+comp2);//(should return 1)
////        System.out.println("Compares: "+large1+" > "+large0+" ? "+comp3);//(should return 1)
////        System.out.println("Compares: "+large2+" > "+large1+" ? "+comp4);//(should return -1)
////        System.out.println("Compares: "+large2+" > "+large3+" ? "+comp5);//(should return 1)
////        System.out.println("Compares: "+large3+" > "+large2+" ? "+comp6);//(should return -1)
////        System.out.println("Compares: "+large3+" > "+large3+" ? "+comp7);//(should return 0)
////        System.out.println("Compares: "+large4+" > "+large3+" ? "+comp8);//(should return 1)

        
        HugeInteger huge1,huge2,huge3;
        int n = 500,MAXNUMINTS = 100,MAXRUN = 500, compare;
        long startTime,endTime;
        double runTime = 0.0;
        for(int numInts=0;numInts<MAXNUMINTS;numInts++){
            huge1 = new HugeInteger(n);
            huge2 = new HugeInteger(n);
            startTime = System.currentTimeMillis();
            for(int numRun=0;numRun<MAXRUN;numRun++){
                huge3 = huge1.multiply(huge2);
                }
            endTime = System.currentTimeMillis();
            runTime += (double) (endTime - startTime)/((double) MAXRUN);
            //System.out.println((double) (endTime - startTime));
            
        }
        runTime = runTime/(double)MAXNUMINTS;
        System.out.println(runTime);
        
        BigInteger big1,big2,big3;
        int n2 = 500,MAXNUMINTS2 = 100,MAXRUN2 = 500, compare2;
        long startTime2,endTime2;
        double runTime2 = 0.0;
        for(int numInts2=0; numInts2<MAXNUMINTS; numInts2++){
            big1 = new BigInteger(new HugeInteger(n2).toString());
            big2 = new BigInteger(new HugeInteger(n2).toString());
            startTime2 = System.currentTimeMillis();
            for(int numRun2=0; numRun2<MAXRUN2; numRun2++){
                big3 = big1.multiply(big2);
                }
            endTime2 = System.currentTimeMillis();
            runTime2 += (double) (endTime2 - startTime2)/((double) MAXRUN2);
            //System.out.println((double) (endTime2 - startTime2));
            
        }
        runTime2 = runTime2/(double)MAXNUMINTS2;
        System.out.println(runTime2);
    }   
    
}//end of test class
