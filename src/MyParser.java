import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

class MyParser {
    private ANTLRInputStream input;
    private CalcLexer lexer;
    private CommonTokenStream tokens;
    private CalcParser parser = new CalcParser(null);

    private int curByte;

    private StringBuilder curStr = new StringBuilder();

    void readFile() {
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream("src\\input.zip"))) {
            zin.getNextEntry();

            while (zin.available() > 0) {
                curStr = new StringBuilder();
                curByte = zin.read();
                if (curByte == -1)
                    return;
                while (curByte != 10 && curByte != -1) {
                    curStr.append((char) curByte);
                    curByte = zin.read();
                }
                newParse(curStr.toString());
            }

            zin.closeEntry();
            zin.close();
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
        System.out.println(str + " = " + parser.result);
    }
}
