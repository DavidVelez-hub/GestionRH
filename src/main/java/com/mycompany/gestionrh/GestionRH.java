package com.mycompany.gestionrh;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class GestionRH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Departamento deptoTI = new Departamento(1, "Tecnologia");
        EmpleadoPermanente emp1 = new EmpleadoPermanente(101, "Juan", "Perez", new Date(), 250000, "Seguro medico", 5, 500000);
        EmpleadoTemporal emp2 = new EmpleadoTemporal(102, "Maria", "Gomez", new Date(), 180000, 160, 180000);

        emp1.asignarDepartamento(deptoTI);
        emp2.asignarDepartamento(deptoTI);
        deptoTI.listarEmpleados();

        System.out.print("Ingrese la fecha del reporte (dd/MM/yyyy): ");
        String fechaStr = scanner.nextLine();
        Date fechaReporte = null;
        try {
            fechaReporte = dateFormat.parse(fechaStr);
        } catch (Exception e) {
            System.out.println("Fecha invalida, se usará la fecha actual.");
            fechaReporte = new Date();
        }

        ReporteDesempenio reporte1 = new ReporteDesempenio(1, emp1, "Eficiencia alta", fechaReporte);
        reporte1.generarReporte();
    }
}
