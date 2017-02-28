import java.io.*;

class FormulaGenerator {
    private int curSign = 0;

    File genFile(String path) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < 1000000; i++)
                bw.write(genFormula());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(path);
    }

    private String genFormula() {
        StringBuilder formula = new StringBuilder();
        char[] signs = {'^', '/', '*', '+', '%', '-'};
        formula.append(appendDbl()).append(signs[++curSign % 6]);
        formula.append(appendDbl()).append(signs[++curSign % 6]);
        formula.append("(");
        formula.append(appendDbl()).append(signs[++curSign % 6]);
        formula.append(appendDbl()).append(signs[++curSign % 6]);
        formula.append(appendDbl());
        formula.append(")");
        formula.append(signs[++curSign % 6]);
        formula.append(appendDbl()).append(signs[++curSign % 6]);
        formula.append(appendDbl()).append(signs[++curSign % 6]);
        formula.append("sqrt(");
        formula.append(appendDbl()).append(signs[++curSign % 6]);
        formula.append(appendDbl()).append(signs[++curSign % 6]);
        formula.append(appendDbl());
        formula.append(")");
        formula.append(signs[++curSign % 6]);
        formula.append(appendDbl()).append(signs[++curSign % 6]);
        formula.append(appendDbl());
        formula.append("\n");
        //System.out.println(formula);
        return formula.toString();
    }

    private String appendDbl() {
        return String.valueOf(Math.random() * 16E20 - 8E20);
    }
}
