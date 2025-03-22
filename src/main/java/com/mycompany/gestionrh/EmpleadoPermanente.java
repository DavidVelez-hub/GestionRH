
package com.mycompany.gestionrh;

import java.util.Date;
class EmpleadoPermanente extends Empleado {
    private String beneficios;
    private int aniosDeServicio;
    private double bonoAnual;

    public EmpleadoPermanente(int id, String nombre, String apellido, Date fechaContratacion, double salarioBase, String beneficios, int aniosDeServicio, double bonoAnual) {
        super(id, nombre, apellido, fechaContratacion, salarioBase);
        this.beneficios = beneficios;
        this.aniosDeServicio = aniosDeServicio;
        this.bonoAnual = bonoAnual;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonoAnual + (aniosDeServicio * 100);
    }
}

