public class QuartoDesafio {
    public static void main(String[] args) {

        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double faturamentoTotal = sp + rj + mg + es + outros;

        double perSP = (sp / faturamentoTotal) * 100;
        double perRJ = (rj / faturamentoTotal) * 100;
        double perMG = (mg / faturamentoTotal) * 100;
        double perES = (es / faturamentoTotal) * 100;
        double perOutros = (outros / faturamentoTotal) * 100;

        System.out.printf("Percentual de representação de SP: %.2f%%\n", perSP);
        System.out.printf("Percentual de representação de RJ: %.2f%%\n", perRJ);
        System.out.printf("Percentual de representação de MG: %.2f%%\n", perMG);
        System.out.printf("Percentual de representação de ES: %.2f%%\n", perES);
        System.out.printf("Percentual de representação de Outros: %.2f%%\n", perOutros);

    }
}
