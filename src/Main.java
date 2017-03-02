import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
            new FileReader(
                //new FormulaGenerator().genFile("src\\input.txt")));
                "src\\input.txt"));

        MyParser myParser = new MyParser(reader);
        myParser.readFile();

        reader.close();
    }
}
