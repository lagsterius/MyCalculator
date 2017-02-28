import java.io.*;

class FormulaGenerator {
    private static final char[] signs = {'^', '/', '*', '+', '%', '-'};

    private static final int maxSize = 256,
            maxDepth = 3,
            stringCount = 100000000;

    private String path;
    private int curSize = 0,
            curDepth = 1,
            prevSign = -1,
            curSign;

    private boolean[] isParens = new boolean[maxDepth];


    private StringBuilder formula = new StringBuilder();

    FormulaGenerator(String path) {
        this.path = path;
    }

    File genFile() {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < stringCount; i++) {
                genFormula();
                bw.write(formula.toString());
                formula.delete(0, formula.length());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new File(path);
    }

    private void genFormula() {
        curDepth = 1;
        curSize = 0;
        while (curSize < maxSize) {
            if (Math.random() < .1 && curDepth < maxDepth && prevSign != 0)
                parens();
            else
                addRndDbl();

            appendSign();

            curSize += 2;
        }
        addRndDbl();
        formula.append("\n");
    }

    private void parens() {
        curDepth++;
        if (Math.random() < .25)
            formula.append("(");
        else
            formula.append("sqrt(");

        isParens[curDepth - 1] = true;

        for (int i = 0; i < (maxDepth - curDepth) * 2; i++) {
            if (Math.random() < .05 * (maxDepth - curDepth) && prevSign != 0)
                parens();
            else
                addRndDbl();

            appendSign();

            curSize += 2;
        }
        addRndDbl();
        isParens[curDepth - 1] = false;
        formula.append(")");
        curDepth--;
    }

    private void addRndDbl() {
        Double M = Math.random() * 7.9999 + 0.0001;
        int p;

        formula.append(M.toString().substring(0, 5));
        if (curSign == 0)
            p = (int) Math.round(Math.random() * 2);
        else if (prevSign == 1 && isParens[curDepth - 1])
            p = (int) Math.round(Math.random() * 2);
        else
            p = 19 + (int) Math.round(Math.random());
        formula.append("E").append(p);
    }

    private void appendSign() {
        formula.append(signs[generateSign()]);
    }
    private int generateSign() {
        if (isParens[curDepth - 1]) {
            if (prevSign == 1)
                curSign = (int) (Math.round(Math.random() * 2) + 2);
            if (prevSign == 2 || prevSign == 4)
                curSign = 3;
            else
                curSign = (int) (Math.round(Math.random() * 3) + 1);
        }
        else
        {
            if (prevSign == 0)
                curSign = (int) (Math.round(Math.random() * 4) + 1);
            else if (prevSign == 1)
                curSign = (int) (Math.round(Math.random() * 3) + 2);
            else
                curSign = (int) (Math.round(Math.random() * 5));
        }
        prevSign = curSign;
        return curSign;
    }
}