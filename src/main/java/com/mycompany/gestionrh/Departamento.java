package com.mycompany.gestionrh;


import java.util.ArrayList;
import java.util.List;

class Departamento {
    private int id;
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(int id, String nombre) {
        if (id <= 0 || nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Datos invalidos para el departamento.");
        }
        this.id = id;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    
    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null || empleados.contains(empleado)) {
            throw new IllegalArgumentException("Empleado invalido o ya registrado.");
        }
        empleados.add(empleado);
    }
    
    public void listarEmpleados() {
        System.out.println("Empleados en el departamento de " + nombre + ":");
        for (Empleado emp : empleados) {
            System.out.println(emp);
        }
    }
}

