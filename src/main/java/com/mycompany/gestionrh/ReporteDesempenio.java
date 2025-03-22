package com.mycompany.gestionrh;

import java.util.Date;
public class ReporteDesempenio {
    

    private int id;
    private Empleado empleado;
    private String metrica;
    private Date fecha;

    public ReporteDesempenio(int id, Empleado empleado, String metrica, Date fecha) {
        if (id <= 0 || empleado == null || metrica == null || metrica.trim().isEmpty()) {
            throw new IllegalArgumentException("Datos invalidos para el reporte.");
        }
        this.id = id;
        this.empleado = empleado;
        this.metrica = metrica;
        this.fecha = fecha;
    }
    
    public void generarReporte() {
    try {
        if (empleado == null) throw new IllegalArgumentException("El empleado no puede ser nulo.");
        System.out.println("Reporte generado para " + empleado.getNombre() + " con metrica: " + metrica + ", reporte generado el " + fecha);
    } catch (IllegalArgumentException e) {
        System.out.println("Error al generar reporte: " + e.getMessage());
    }
}
    
}

