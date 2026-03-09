import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApiClient {
    private static final String API_KEY = "chave_da_api";
    public static double getConvertedAmount(String from, String to, double quantidade) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + from + "/" + to + "/" + quantidade;
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> resposta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            JsonElement elemento = JsonParser.parseString(resposta.body());
            JsonObject objectRoot = elemento.getAsJsonObject();
            double conversao = objectRoot.get("conversion_result").getAsDouble();
            return conversao;
        } catch (Exception e) {
            System.out.println("Erro ao acessar a API: " + e.getMessage());
            return -1;
        }
    }
}