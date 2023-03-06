import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TerceiroDesafio {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        List<Double> valores = new ArrayList<>();

        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader("src/dados.json"));
            for (Object objeto : array) {
                JSONObject jsonObject = (JSONObject) objeto;
                Double valor = (Double) jsonObject.get("valor");
                valores.add(valor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Double menorValor = Double.MAX_VALUE;
        Double maiorValor = Double.MIN_VALUE;

        for (Double valor : valores) {
            if (valor < menorValor) {
                menorValor = valor;
            }
            if (valor > maiorValor) {
                maiorValor = valor;
            }
        }

        Double somaValores = 0.0;
        int numeroDias = 0;

        for (Double valor : valores) {
            if (valor > 0) {
                somaValores += valor;
                numeroDias++;
            }
        }

        Double mediaMensal = somaValores / numeroDias;
        int numeroDiasSuperiorMedia = 0;

        for (Double valor : valores) {
            if (valor > mediaMensal) {
                numeroDiasSuperiorMedia++;
            }
        }

        System.out.println("Menor valor de faturamento ocorrido em um dia do mês: " + menorValor);
        System.out.println("Maior valor de faturamento ocorrido em um dia do mês: " + maiorValor);
        System.out.println("Número de dias no mês com faturamento diário superior à média mensal: "
                + numeroDiasSuperiorMedia);
    }
}