package secondChance.maths;

import com.custom.BigInt;

import java.math.BigInteger;

public class BigIntegerImpl {
    public static void main(String[] args) {

        BigInteger integer = new BigInteger("12313131");
        BigInteger result = integer.add(new BigInteger("-234234234"));
        System.out.println(result);

    }
}
