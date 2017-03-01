import java.io.*;
import java.math.BigDecimal;
import java.util.Date;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
/*        Date start = new Date();
        BufferedReader reader = new BufferedReader(new FileReader(new FormulaGenerator().genFile("src\\input.txt")));
        //BufferedReader reader = new BufferedReader(new FileReader("src\\input.txt"));

        System.out.println(new Date().getTime() - start.getTime());

        MyParser myParser = new MyParser(reader);
        myParser.readFile();

        reader.close();*/
        BigDecimal bi = new BigDecimal("8E6");
        BigDecimal bi2 = new BigDecimal("8E20");
        bi2 = bi2.pow(bi.intValue());
        System.out.println(bi2);
    }
}
