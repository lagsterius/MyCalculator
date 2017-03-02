import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

class MyParser {
    private ANTLRInputStream input;
    private CalcLexer lexer;
    private CommonTokenStream tokens;
    private CalcParser parser = new CalcParser(null);

    private String path;

    private int curByte;

    private StringBuilder curStr = new StringBuilder();

    MyParser(String path) {
        this.path = path;
    }

    void readFile() {
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(path))) {
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
