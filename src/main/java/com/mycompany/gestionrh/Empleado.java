package com.mycompany.gestionrh;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {

    private int id;
    private String nombre;
    private String apellidos;
    private String fechaContratacion;
    private double salarioBase;
    private Departamento departamento;
    private List<ReporteDesempenio> reportes;

    private static List<Empleado> listaEmpleados = new ArrayList<>();

    public Empleado(int id, String nombre, String apellidos, String fechaContratacion, double salarioBase) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaContratacion = fechaContratacion;
        this.salarioBase = salarioBase;
        this.reportes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ReporteDesempenio> getReportes() {
        return reportes;
    }

    public void setReportes(List<ReporteDesempenio> reportes) {
        this.reportes = reportes;
    }

    public static Empleado crearEmpleado(int id, String nombre, String apellidos, String fechaContratacion, double salarioBase, int tipo, Object... params) {
        Empleado empleado;
        if (tipo == 1) {
            String beneficios = (String) params[0];
            int aniosDeServicio = (int) params[1];
            double bonoAnual = (double) params[2];
            empleado = new EmpleadoPermanente(id, nombre, apellidos, fechaContratacion, salarioBase, beneficios, aniosDeServicio, bonoAnual);
        } else {
            String fechaFinContrato = (String) params[0];
            int horasTrabajadas = (int) params[1];
            boolean renovable = (boolean) params[2];
            double tarifaPorHora = (double) params[3];
            empleado = new EmpleadoTemporal(id, nombre, apellidos, fechaContratacion, salarioBase, fechaFinContrato, horasTrabajadas, renovable, tarifaPorHora);
        }
        listaEmpleados.add(empleado);
        System.out.println("Empleado creado exitosamente: " + empleado.getNombre() + " " + empleado.getApellidos());
        return empleado;
    }

    public void actualizarEmpleado(String nombre, String apellidos, double salarioBase) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salarioBase = salarioBase;
        System.out.println("Empleado actualizado exitosamente: " + this.nombre + " " + this.apellidos);
    }

    public void eliminarEmpleado() {
        listaEmpleados.remove(this);
        if (this.departamento != null) {
            this.departamento.getEmpleados().remove(this);
        }
        System.out.println("Empleado eliminado exitosamente: " + this.nombre + " " + this.apellidos);
    }

    public static List<Empleado> listarEmpleados() {
        return new ArrayList<>(listaEmpleados);
    }

    public abstract double calcularSalario();

    public void asignarDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void agregarReporte(ReporteDesempenio reporte) {
        if (reporte != null) {
            reportes.add(reporte);
        }
    }
}
