package com.mycompany.gestionrh;

 import java.util.Date;

public abstract class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private Date fechaContratacion;
    private double salarioBase;
    private Departamento departamento;

    public Empleado(int id, String nombre, String apellido, Date fechaContratacion, double salarioBase) {
        if (id <= 0 || nombre == null || nombre.trim().isEmpty() || apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("Datos no validos para el empleado");
        }
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaContratacion = fechaContratacion;
        this.salarioBase = salarioBase;
        this.departamento = null;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public Date getFechaContratacion() { return fechaContratacion; }
    public double getSalarioBase() { return salarioBase; }
    public Departamento getDepartamento() { return departamento; }

    public void setDepartamento(Departamento departamento) {
        if (departamento == null) {
            throw new IllegalArgumentException("El departamento no puede ser nulo.");
        }
        this.departamento = departamento;
    }

    public abstract double calcularSalario();
    
    public void asignarDepartamento(Departamento departamento) {
    try {
        if (departamento == null) throw new IllegalArgumentException("El departamento no puede ser nulo.");
        this.departamento = departamento;
        departamento.agregarEmpleado(this);
        
        String tipoEmpleado = this instanceof EmpleadoPermanente ? "Empleado permanente" : "Empleado temporal";
        
        System.out.println(tipoEmpleado + " " + nombre + " asignado al departamento " + departamento.getNombre());
    } catch (IllegalArgumentException e) {
        System.out.println("Error al asignar departamento: " + e.getMessage());
    }
    }

    @Override
    public String toString() {
        return "Id Empleado =" + id + ", nombre =" + nombre + ", apellido =" + apellido + ", salarioBase =" + salarioBase + ", departamento =" + (departamento != null ? departamento.getNombre() : "Sin departamento");
    }
}
