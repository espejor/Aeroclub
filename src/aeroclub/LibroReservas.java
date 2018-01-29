package aeroclub;

import fecha.Fecha;

import java.util.ArrayList;

public class LibroReservas {
    private Reservable aeronave;
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public LibroReservas(Reservable aeronave) {
        this.aeronave = aeronave;
    }




    /**
     * Método que comprueba si la aeronave está reservada en un intervalo de tiempo
     * @param fechaIni Momento de inicio del intervalo
     * @param fechaFin Momento de fin del intervalo
     * @return Booleano
     */
    boolean isReservado(Fecha fechaIni, Fecha fechaFin) {
        for (Reserva r: reservas){
            if (fechaIni.after(r.getFhInicio()) && fechaIni.before(r.getFhFin()))
                return true;
            if (fechaFin.after(r.getFhInicio()) && fechaFin.before(r.getFhFin()))
                return true;
            if (fechaIni.before(r.getFhInicio()) && fechaFin.after(r.getFhFin()))
                return true;
        }
        return false;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }


    /**
     * Método que lista las reservas del aeroclub
     */
    public void listReservas(){
        for (Reserva r:reservas) {
            if (r == null) break;
            System.out.println("Nº Reserva: " + (reservas.indexOf(r) + 1) + " -- " + r);
        }
    }



}
