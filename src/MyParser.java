import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedReader;
import java.io.IOException;

class MyParser {
    private ANTLRInputStream input;
    private CalcLexer lexer;
    private CommonTokenStream tokens;
    private CalcParser parser = new CalcParser(null);

    private BufferedReader reader;
    private String str = "";



    MyParser(BufferedReader reader) {
        this.reader = reader;
    }

    void readFile() {
        try {
            while (reader.ready()) {
                str = reader.readLine();
                System.out.print(str);
                newParse(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void newParse(String str) {
        input = new ANTLRInputStream(str);
        lexer = new CalcLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new CalcParser(tokens);
        parser.str();
    }
}