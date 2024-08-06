import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Clima {
    public Main main;
    public List<Weather> weather;

    public Clima(Main main, List<Weather> weather) {
        this.main = main;
        this.weather = weather;
    }

    public static class Main {

        @SerializedName("temp")
        public double temperatura;
        public double temp_min;
        public double temp_max;
    }

    public static class Weather {
        public String description;
    }

    @Override
    public String toString() {
        return "Clima{" +
                "temp=" + main.temperatura +
                ", description='" + weather.get(0).description + '\'' +
                ", temp_min=" + main.temp_min +
                ", temp_max=" + main.temp_max +
                '}';
    }
}
