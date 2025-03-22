package com.mycompany.gestionrh;


import java.util.Date;

class EmpleadoTemporal extends Empleado {
    private int horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoTemporal(int id, String nombre, String apellido, Date fechaContratacion, double salarioBase, int horasTrabajadas, double tarifaPorHora) {
        super(id, nombre, apellido, fechaContratacion, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (horasTrabajadas * tarifaPorHora);
    }
}
