import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int bandera = 0, op = 0;
        double temperatura, temperaturaMinima, temperaturaMaxima;
        String ciudad = "", condicionClimatica,  precipitacion;
        do {
            do {
                System.out.println("Challenge Cieloscopio");
                System.out.println("--------------------------------------");
                System.out.println("""
                    Elige una ciudad para obtener los datos meteorológicos: 
                    1. Ciudad de México
                    2. Buenos Aires
                    3. Bogotá
                    4. Lima
                    5. Santiago
                    6. Deseo consultar otra ciudad
                    7. Salir
                    """);
                System.out.print(">>>>");
                op = sc.nextInt();
                sc.nextLine();
                if (op >= 1 && op <= 7){
                    bandera = 1;
                }else {
                    System.out.println("--------------------------------------");
                    System.out.println("Opción Incorrecta, vuelve a intentarlo");
                    System.out.println("--------------------------------------");
                }
            }while (bandera != 1);

            if (op == 1){
                ciudad = "México";
            } else if (op == 2) {
                ciudad = "Buenos Aires";
            } else if (op == 3) {
                ciudad = "Bogotá";
            } else if (op == 4) {
                ciudad = "Lima";
            } else if (op == 5) {
                ciudad = "Santiago";
            } else if (op == 6) {
                System.out.println("Escriba el nombre una ciudad: ");
                ciudad = sc.nextLine();
            } else if (op == 7) {
                System.out.println("Vuelva pronto...");
                bandera =2;
                break;
            }

            Date fecha = new Date();
            ConsultaClima consulta = new ConsultaClima();

            Clima clima = consulta.buscaClima(ciudad);
            if (clima.weather.size() == 0){
                break;
            }
            temperatura =  clima.main.temperatura;
            condicionClimatica = clima.weather.get(0).description;
            temperaturaMinima = clima.main.temp_min;
            temperaturaMaxima = clima.main.temp_max;



            System.out.println("Respuesta"+
                    "\nCiudad: "+ciudad+
                    "\nFecha: "+fecha.getDate()+
                    "\nHorario: "+fecha.getHours()+
                    "\n\nTemperatura actual: "+temperatura+
                    "\nCondicion climática: "+condicionClimatica+
                    "\n\nTemperatura minima: "+temperaturaMinima+
                    "\nTemperatura máxima: "+temperaturaMaxima+
                    "\nPrecipitación: valor no informado"
                    );
        }while (bandera != 2);



    }
}
