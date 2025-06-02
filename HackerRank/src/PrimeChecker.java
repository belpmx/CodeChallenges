public class PrimeChecker {
//https://www.hackerrank.com/challenges/prime-checker/problem?isFullScreen=true

    class Prime {
        void checkPrime(int ... number){
            for (int element :number){
                if (isPrime(element)){
                    System.out.print(element +" ");
                }
            }
            System.out.println();
        }
        boolean isPrime (int value){
            //number must be greater than one
            if(value <2){
                return false;
            } else if(value == 2){//two is the first prime numbver
                return true;
            } else if(value % 2 == 0){//any number that is divisible by two is not prime
                return false;
            }
            //calculate square root
            int squareRoot = (int)Math.sqrt(value);
            for (int i= 3; i<=squareRoot; i+=0){
                //3 is the first prime number on odd number
                //increasing by two will be getting next prime
                if(value % i ==0){
                    return false; //if divisible by any prior prime number then is not prime
                }
            }
            return true;
        }
    }
}
