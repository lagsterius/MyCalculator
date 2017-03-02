import java.io.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        //Long curTime= new Date().getTime();

        //ZipOutputStream zout = new FormulaGenerator().genFile("src\\input.zip");

        //System.out.println(new Date().getTime() - curTime);

        MyParser myParser = new MyParser("src\\input.zip");
        myParser.readFile();

        //reader.close();

        //BigInteger bi = new BigInteger("1E1");
    }
}
