import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Created by Lagster on 21.02.2017.
 */
public class MyBigDecimalMath {
    public static BigDecimal mod(BigDecimal first, BigDecimal second) {
        BigInteger divBI;
        BigDecimal divBD;
        if (second.compareTo(BigDecimal.ZERO) == 0)
            return first;
        divBI = first.divide(second, 5, RoundingMode.HALF_UP).toBigInteger();
        divBD = new BigDecimal(divBI);

        if (divBI.compareTo(new BigInteger("1")) > 0);
            first = first.subtract(second.multiply(divBD));
        return first;
    }
}
