package com.mycompany.gestionrh;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

    private int id;
    private String nombre;
    private List<Empleado> empleados;
    private List<ReporteDesempenio> reportes;

    private static List<Departamento> listaDepartamentos = new ArrayList<>();

    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
        this.reportes = new ArrayList<>();
    }

    
    
       public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setReportes(List<ReporteDesempenio> reportes) {
        this.reportes = reportes;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
    
    
    
    
    
    public static Departamento crearDepartamento(int id, String nombre) {
        Departamento departamento = new Departamento(id, nombre);
        listaDepartamentos.add(departamento);
        System.out.println("Departamento creado exitosamente: " + nombre);
        return departamento;
    }

    public void modificarDepartamento(String nuevoNombre) {
        this.nombre = nuevoNombre;
        System.out.println("Departamento modificado exitosamente: " + this.nombre);
    }

    public void eliminarDepartamento() {
        for (Empleado empleado : empleados) {
            empleado.setDepartamento(null);
        }
        empleados.clear();
        listaDepartamentos.remove(this);
        System.out.println("Departamento eliminado exitosamente: " + this.nombre);
    }

    public static List<Departamento> listarDepartamentos() {
        return new ArrayList<>(listaDepartamentos);
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null && !empleados.contains(empleado)) {
            empleados.add(empleado);
            if (empleado.getDepartamento() != this) {
                empleado.asignarDepartamento(this);
            }
            System.out.println("Empleado " + empleado.getNombre() + " añadido al departamento " + nombre);
        }
    }

    public void agregarReporte(ReporteDesempenio reporte) {
        if (reporte != null) {
            reportes.add(reporte);
            System.out.println("Reporte agregado al departamento " + nombre);
        }
    }

    public void reasignarEmpleado(Empleado empleado, Departamento nuevoDepartamento) {
        try {
            if (empleado == null || nuevoDepartamento == null) {
                throw new IllegalArgumentException("Empleado o departamento destino no pueden ser nulos.");
            }

            if (!empleados.contains(empleado)) {
                throw new IllegalStateException("El empleado no pertenece a este departamento.");
            }

            empleados.remove(empleado);
            nuevoDepartamento.agregarEmpleado(empleado);
            System.out.println("Empleado " + empleado.getNombre() + " ha sido reasignado al departamento " + nuevoDepartamento.getNombre());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error al reasignar empleado: " + e.getMessage());
        }
    }

    public List<ReporteDesempenio> getReportes() {
        return new ArrayList<>(reportes);
    }

    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados);
    }

 

    @Override
    public String toString() {
        return "Departamento: "
                + "id: " + id
                + ", nombre: '" + nombre + '\''
                + ", numero de empleados: " + empleados.size();
    }
}
