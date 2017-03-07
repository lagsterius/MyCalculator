import java.io.*;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class FormulaGenerator {
    private int curSign = 0;
    private int curRnd = 17;

    private String[] signs = {"^", "+", "*", "-", "*", "%", "+"};

    private long[] rndAr = new long[15000];

    ZipOutputStream genFile() {
        genRndAr();

        try {
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("src\\input.zip"));
            ZipEntry zipEntry = new ZipEntry("data.txt");
            zout.putNextEntry(zipEntry);
            for (int i = 0; i < 1; i++) {
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
                zout.write(genFormula().getBytes());
            }
            zout.closeEntry();
            zout.close();
            return zout;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ZipOutputStream(null);
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
