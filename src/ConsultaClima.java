import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

public class ConsultaClima extends ApiKey {
       public Clima buscaClima(String ciudad){
            String APIKEY = ApiKey;

        try {
            String direccion = "https://api.openweathermap.org/data/2.5/weather?q="+
                    URLEncoder.encode(ciudad, "UTF-8")
                    +"&appid="+APIKEY+"&lang=es&units=metric";

            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(30)).build();


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


            // Deserializar la respuesta JSON
            Clima apiResponse = new Gson().fromJson(response.body(), Clima.class);
            System.out.println(response.body());

            System.out.println("##########################");
            System.out.println(new Gson().toJson(apiResponse));
            System.out.println("#############################");
            return apiResponse;

        } catch (Exception e) {
            /*e.printStackTrace();
            throw new RuntimeException(e);*/
            System.out.println("No pudimos validar "+e.getMessage());
            return new Clima(new Clima.Main(), new ArrayList<>());
        }

    }
}
