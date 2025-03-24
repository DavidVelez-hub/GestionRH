package com.mycompany.gestionrh;

public class EmpleadoPermanente extends Empleado {
    private String beneficios;
    private int aniosDeServicio;
    private double bonoAnual;

    public EmpleadoPermanente(int id, String nombre, String apellidos, String fechaContratacion,
            double salarioBase, String beneficios, int aniosDeServicio, double bonoAnual) {
        super(id, nombre, apellidos, fechaContratacion, salarioBase);
        this.beneficios = beneficios;
        this.aniosDeServicio = Math.max(aniosDeServicio, 0);
        this.bonoAnual = Math.max(bonoAnual, 0);
    }

    @Override
    public double calcularSalario() {
        double incremento = getSalarioBase() * 0.02 * aniosDeServicio;
        return getSalarioBase() + incremento;
    }

    public double getBonoAnual() {
        return bonoAnual;
    }

    public int getAniosDeServicio() {
        return aniosDeServicio;
    }

    @Override
    public String toString() {
        return "Empleado Permanente: " +
                "id: " + getId() +
                ", nombre: '" + getNombre() + " " + getApellidos() + '\'' +
                ", fecha de contratacion: " + getFechaContratacion() +
                ", departamento: " + (getDepartamento() != null ? getDepartamento().getNombre() : "Sin asignar") +
                ", años de servicio: " + aniosDeServicio +
                ", salario mensual: " + String.format("%.2f", calcularSalario()) +
                ", beneficios: " + beneficios +
                ", bono anual: " + bonoAnual;
    }
}