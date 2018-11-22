package KaratsubaMult;

import java.math.BigInteger;

public class Karatsuba {

    public static long karatsubaMult (long x, long y) {
        if(x < 10 && y < 10){
            return x * y;
        }

        int length = Math.max(calculateLenght((int)x), calculateLenght((int)y));//Only works if the length of both number are the same.


        int fh = length / 2;
        int sh = length - fh;

        if(fh == 0) fh = 1;

        //Divide each number in two parts
        long xL = (long)Math.floor(x / Math.pow(10, sh));
        long xR = (long)Math.floor(x % Math.pow(10, fh));
        long yL = (long)Math.floor(y / Math.pow(10, sh));
        long yR = (long)Math.floor(y % Math.pow(10, fh));

        long op1 = karatsubaMult(xL, yL);
        long op2 = karatsubaMult(xR, yR);
        long op3 = karatsubaMult((xL + xR), (yL + yR));

        return (long)((Math.pow(10, length) * op1) + op2 + (Math.pow(10, fh) * (op3 - op2 - op1))) ;

    }

    public static int calculateLenght(long num){
        return String.valueOf(num).length();
    }
}
