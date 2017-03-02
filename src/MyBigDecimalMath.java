import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class MyBigDecimalMath {
    static BigDecimal mod(BigDecimal first, BigDecimal second) {
        BigInteger divBI;
        BigDecimal divBD;
        if (second.compareTo(BigDecimal.ZERO) == 0)
            return first;
        divBI = first.divide(second, 1, RoundingMode.HALF_UP).toBigInteger();
        divBD = new BigDecimal(divBI);

        if (divBI.compareTo(new BigInteger("1")) > 0)
            first = first.subtract(second.multiply(divBD));
        return first;
    }

    static BigDecimal sqrt(BigDecimal A) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, 3, RoundingMode.HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(new BigDecimal("2"), 3, RoundingMode.HALF_UP);
        }
        return x1;
    }
}
