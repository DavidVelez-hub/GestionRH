package com.mycompany.gestionrh;

public class GestionRH {

    public static void main(String[] args) {

        Departamento d1 = Departamento.crearDepartamento(1, "Desarrollo");
        Departamento d2 = Departamento.crearDepartamento(2, "Recursos Humanos");

        Empleado e1 = Empleado.crearEmpleado(1, "Juan", "Perez", "23-03-2021", 300000.0, 1, "Seguro todo riesgo, vacaciones", 1, 500000.0);
        Empleado e2 = Empleado.crearEmpleado(2, "Maria", "Gomez", "20-10-2025", 200000.0, 2, "20-11-2025", 120, true, 150000.0);
        Empleado e3 = Empleado.crearEmpleado(3, "Isabel", "Perez Araujo", "11-02-2018", 300000.0, 1, "Seguro todo riesgo, vacaciones", 7, 500000.0);

        d1.agregarEmpleado(e1);
        d1.agregarEmpleado(e3);
        d2.agregarEmpleado(e2);

        System.out.println("\n--- Departamentos ---");
        for (Departamento d : Departamento.listarDepartamentos()) {
            System.out.println(d);
            System.out.println("Empleados en " + d.getNombre() + ":");
            for (Empleado e : d.listarEmpleados()) {
                System.out.println(e);
            }
        }

        e1.actualizarEmpleado("Juan Carlos", "Pérez López", 350000.0);

        d1.reasignarEmpleado(e1, d2);

        ReporteDesempenio r1 = new ReporteDesempenio(1, e1, e1.getDepartamento(), "Productividad", "Excelente desempeño");
        ReporteDesempenio r2 = ReporteDesempenio.generarReporteDepartamental(2, d1, "Eficiencia", "Buen rendimiento general");

        System.out.println("\n--- Reportes ---");
        for (ReporteDesempenio r : ReporteDesempenio.listarReportes()) {
            r.visualizar();
        }

        e2.eliminarEmpleado();
        d1.eliminarDepartamento();

        System.out.println("\n--- Departamentos despues de eliminación ---");
        for (Departamento d : Departamento.listarDepartamentos()) {
            System.out.println(d);
            System.out.println("Empleados en " + d.getNombre() + ":");
            for (Empleado e : d.listarEmpleados()) {
                System.out.println(e);
            }
        }
    }
}
