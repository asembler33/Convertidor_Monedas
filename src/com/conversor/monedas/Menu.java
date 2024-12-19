package com.conversor.monedas;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu extends ApiConvertidor {

    public void menuConversorMonedas() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        ApiConvertidor api = new ApiConvertidor();
        while (!salir) {
            // Mostrar el menú
            System.out.println("**************************************************");
            System.out.println("               Conversor de Moneda                ");
            System.out.println("**************************************************");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("**************************************************");
            System.out.print("Elija una opción válida: ");

            int opcion = scanner.nextInt(); // Leer la opción
            if (validaOpcion(opcion, scanner, api) == 7){
                salir = true;
            }
        }
        scanner.close();
    }

    public int validaOpcion(int opcion, Scanner scanner, ApiConvertidor api) throws IOException {

        double valoraConvertir = 0;
        String tipoMonedaCambio = "";
        String tipoMonedaOrigen = "";
        String respuestaExchangeAPI;


        switch (opcion) {
            case 1:
                System.out.print("\nIngrese el valor en Dólares: ");
                valoraConvertir = scanner.nextDouble();
                tipoMonedaOrigen = "USD";
                tipoMonedaCambio = "ARS";
                break;
            case 2:
                System.out.print("\nIngrese el valor en Pesos argentinos: ");
                valoraConvertir = scanner.nextDouble();
                tipoMonedaOrigen = "ARS";
                tipoMonedaCambio = "USD";
                break;
            case 3:
                System.out.print("\nIngrese el valor en Dólares: ");
                valoraConvertir = scanner.nextDouble();
                tipoMonedaOrigen = "USD";
                tipoMonedaCambio = "BRL";
                break;
            case 4:
                System.out.print("\nIngrese el valor en Reales brasileños: ");
                valoraConvertir = scanner.nextDouble();
                tipoMonedaOrigen = "BRL";
                tipoMonedaCambio = "USD";
                break;
            case 5:
                System.out.print("\nIngrese el valor en Dólares: ");
                valoraConvertir = scanner.nextDouble();
                tipoMonedaOrigen = "USD";
                tipoMonedaCambio = "COP";
                break;
            case 6:
                System.out.print("\nIngrese el valor en Pesos colombianos: ");
                valoraConvertir = scanner.nextDouble();
                tipoMonedaOrigen = "COP";
                tipoMonedaCambio = "USD";
                break;
            case 7:
                System.out.println("\nSaliendo del programa... ¡Gracias por usar el conversor!");
                break;
            default:
                System.out.println("\nOpción inválida. Por favor, intente de nuevo.\n");

        }

        if (opcion <= 7 ){
            respuestaExchangeAPI = api.busquedaMoneda(tipoMonedaOrigen, tipoMonedaCambio, valoraConvertir);
            System.out.printf("El valor de "+ valoraConvertir + " ["+ tipoMonedaOrigen + "] " + "corresponde al valor final de =>> %.2f "+"[" + tipoMonedaCambio  +"]"+ "\n\n", Double.parseDouble(respuestaExchangeAPI));
        }
        
        return opcion;
    }


}
