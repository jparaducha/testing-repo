package testNG;

public class MockClass {

    public String helloWorld(){
        return "Hello World";
    }

    public int countOddNumbersInArray(int[] array){
        int counter = 0;

        for ( int i : array){
            if(i%2!=0){
                counter++;
            }
        }

        return counter;
    }


    public boolean isDivisible(int dividend, int divisor){
        return dividend%divisor == 0;
    }

    public boolean isDivisible(double dividend, double divisor){
        return dividend%divisor == 0;
    }

}
