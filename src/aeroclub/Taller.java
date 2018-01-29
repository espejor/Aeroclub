package aeroclub;

import java.util.ArrayList;

public class Taller implements MantoAvionListener,MantoHeliListener {
    private ArrayList<MantoSource> ingresados = new ArrayList<MantoSource>();

    public Taller() {

    }

    @Override
    public void onReachTimeOverhaul(EventManto e) {
        Aeronave a = (Aeronave) e.getSource();
        ingresados.add(a);

        String matricula = a.getMatricula();
        System.out.println("El taller ha recibido la solicitud de ingreso del " + a.getClass().getSimpleName() + " " +
                a + " para realizar un overhaul");
    }

    @Override
    public void onBreakDown(EventManto e) {
        MantoSource a =  (MantoSource) e.getSource();
        String id = e.getId();
        ingresados.add(a);

        System.out.println("El taller ha recibido la solicitud de ingreso del elemento de matrícula " +
                id + " para realizar Mantenimiento correctivo");
    }

    @Override
    public void onReachTimePropeller(EventManto e) {
        Aeronave a = (Aeronave) e.getSource();
        ingresados.add(a);
        String matricula = a.getMatricula();
        System.out.println("El taller ha recibido la solicitud de ingreso del avión " +
                a + " para realizar mantenimiento de hélice");
    }

    @Override
    public void onReachTimeBlades(EventManto e) {
        Aeronave a = (Aeronave) e.getSource();
        ingresados.add(a);

        String matricula = a.getMatricula();
        System.out.println("El taller ha recibido la solicitud de ingreso del helicóptero " +
                a + " para realizar mantenimiento de las palas");
    }
}
