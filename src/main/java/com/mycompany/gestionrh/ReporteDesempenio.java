package com.mycompany.gestionrh;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReporteDesempenio {

    private int id;
    private Empleado empleado;
    private Departamento departamento;
    private String fecha;
    private String metrica;
    private String descripcion;

    private static List<ReporteDesempenio> listaReportes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getFecha() {
        return fecha;
    }

    public String getMetrica() {
        return metrica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = (descripcion != null) ? descripcion : "Sin descripcion";
    }

    public ReporteDesempenio(int id, Empleado empleado, Departamento departamento, String metrica, String descripcion) {
        try {
            this.id = id;
            this.empleado = empleado;
            this.departamento = departamento;
            this.fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            this.metrica = (metrica != null) ? metrica : "No especificada";
            this.descripcion = (descripcion != null) ? descripcion : "Sin descripcion";

            if (empleado != null) {
                empleado.agregarReporte(this);
            }
            if (departamento != null) {
                departamento.agregarReporte(this);
            }
            listaReportes.add(this);
        } catch (Exception e) {
            System.out.println("Error al crear el reporte: " + e.getMessage());
        }
    }

    public static ReporteDesempenio generarReporteDepartamental(int id, Departamento departamento, String metrica, String descripcion) {
        if (departamento == null) {
            System.err.println("Error: No se puede generar un reporte sin un departamento.");
            return null;
        }

        ReporteDesempenio reporte = new ReporteDesempenio(id, null, departamento, metrica, descripcion);
        System.out.println("Reporte departamental generado con ID " + id);
        return reporte;
    }

    public static List<ReporteDesempenio> listarReportes() {
        return new ArrayList<>(listaReportes);
    }

    public void visualizar() {
        try {
            System.out.println("\n--------- REPORTE DE DESEMPEÑO ---------");
            System.out.println("ID: " + id);
            System.out.println("Fecha: " + fecha);

            if (empleado != null) {
                System.out.println("Empleado: " + empleado.getNombre() + " " + empleado.getApellidos());
            } else {
                System.out.println("Reporte Departamental");
            }

            System.out.println("Departamento: " + (departamento != null ? departamento.getNombre() : "No asignado"));
            System.out.println("Metrica: " + metrica);
            System.out.println("Descripcion: " + descripcion);
        } catch (Exception e) {
            System.out.println("Error al mostrar el reporte: " + e.getMessage());
        }
    }
}
