public class Main {
    public static void main(String[] args) throws Exception {
        new FormulaGenerator().genFile();
        new MyParser().readFile();
    }
}
