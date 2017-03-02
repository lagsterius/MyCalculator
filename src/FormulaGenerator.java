import java.io.*;
import java.util.Random;

class FormulaGenerator {
    private int curSign = 0;
    private int curRnd = 17;

    private String[] signs = {"^", "+", "*", "-", "*", "%", "+"};

    private long[] rndAr = new long[15000];

    File genFile(String path) {
        BufferedWriter bw;

        genRndAr();

        try {
            bw = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < 100; i++) {
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
                bw.write(genFormula());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(path);
    }

    private void genRndAr() {
        for (int i = 0; i < 15000; i++)
            rndAr[i] = new Random().nextLong();
    }

    private String genFormula() {
        StringBuilder formula = new StringBuilder();
        formula.append(appendLong()).append(appendSign());
        formula.append(appendLong()).append(appendSign());
        formula.append("(");
        formula.append(appendLong()).append(appendSign());
        formula.append(appendLong()).append(appendSign());
        formula.append(appendLong());
        formula.append(")");
        formula.append(appendSign());
        formula.append(appendLong()).append(appendSign());
        formula.append(appendLong()).append(appendSign());
        formula.append("sqrt(");
        formula.append(appendLong()).append(appendSign());
        formula.append(appendLong()).append(appendSign());
        formula.append(appendLong());
        formula.append(")");
        formula.append(appendSign());
        formula.append(appendLong()).append(appendSign());
        formula.append(appendLong()).append(appendSign());
        formula.append(appendLong());
        formula.append("\n");
        return formula.toString();
    }

    private String appendLong() {
        curRnd = curRnd * 13 % 15000;
        return String.valueOf(rndAr[curRnd]);
    }

    private String appendSign() {
        return signs[++curSign % 7];
    }
}
