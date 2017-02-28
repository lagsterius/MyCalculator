import java.io.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        Date start = new Date();
        BufferedReader reader = new BufferedReader(new FileReader(new FormulaGenerator("src\\input.txt").genFile()));
        System.out.println(new Date().getTime() - start.getTime());

        MyParser myParser = new MyParser(reader);
        myParser.readFile();

        reader.close();
    }
}
