package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConvertidorDeMonedas convertidor = new ConvertidorDeMonedas();

        try {
            System.out.println("=== Conversor de Monedas ===");
            System.out.print("Moneda de origen (ej: USD, EUR, DOP): ");
            String desde = sc.next().toUpperCase();

            System.out.print("Moneda de destino (ej: USD, EUR, DOP): ");
            String hacia = sc.next().toUpperCase();

            System.out.print("Cantidad a convertir: ");
            double cantidad = sc.nextDouble();

            double resultado = convertidor.convertir(desde, hacia, cantidad);
            System.out.printf("%.2f %s = %.2f %s%n", cantidad, desde, resultado, hacia);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}