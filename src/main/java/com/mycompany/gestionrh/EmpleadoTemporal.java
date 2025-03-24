package com.mycompany.gestionrh;

public class EmpleadoTemporal extends Empleado {

    private String fechaFinContrato;
    private int horasTrabajadas;
    private boolean renovable;
    private double tarifaPorHora;

    public EmpleadoTemporal(int id, String nombre, String apellidos, String fechaContratacion,
            double salarioBase, String fechaFinContrato, int horasTrabajadas, boolean renovable, double tarifaPorHora) {
        super(id, nombre, apellidos, fechaContratacion, salarioBase);
        this.fechaFinContrato = fechaFinContrato;
        this.horasTrabajadas = horasTrabajadas;
        this.renovable = renovable;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * tarifaPorHora;
    }

    @Override
    public String toString() {
        return "Empleado Temporal "
                + "id: " + getId()
                + ", nombre: '" + getNombre() + " " + getApellidos() + '\''
                + ", fecha de contratacion: " + getFechaContratacion()
                + ", fecha fin contrato: " + fechaFinContrato
                + ", departamento: " + (getDepartamento() != null ? getDepartamento().getNombre() : "Sin asignar")
                + ", horas trabajadas: " + horasTrabajadas
                + ", tarifa por hora: " + String.format("%,.2f", tarifaPorHora)
                + ", salario: " + String.format("%,.2f", calcularSalario());
    }
}
