package aeroclub;

import fecha.Fecha;

import java.util.ArrayList;

/**
 * Clase Dron
 */
public class Dron implements Reservable,MantoSource{
    private ModeloDron modelo;
    private LibroReservas reservas = new LibroReservas(this);
    private int state = OPERATIVO;
    private ArrayList<MantoListener> listeners = new ArrayList<MantoListener>();
    private String matricula;
    /**
     * Constructor parametrizado
     * @param modelo Modelo del dron
     */
    public Dron(ModeloDron modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
    }
    @Override
    public void reservar(Piloto piloto, Fecha fechaIni, Fecha fechaFin) {
        if (fechaIni.after(fechaFin)){
            System.out.println("La fecha de fin de la reserva debe ser porterior a la de inicio");
            return;
        }
        if (isReservado(fechaIni,fechaFin) || !isOperativo()){
            System.out.println("El Dron " + this + " no está disponible para ser reservado");
            return;
        }
        addNewReserva(piloto, this, fechaIni, fechaFin);
    }

    public boolean isOperativo() {
        return state == OPERATIVO;
    }

    public boolean isAveriado(){
        return state == AVERIADO;
    }


    /**
     * Método que cambia el estado de la aeronave
     * Si pasa a averiado se lanza un Evento
     * @param estado A establecer (OPERATIVO, MANTENIMIENTO, AVERIADO)
     */
    public void setEstado(int estado) {
        this.state = estado;
        if (isAveriado()) {
            spreadEventBreakDown(0);
        }
    }

    /**
     * Método para difundir entre los listeners la avería de la aeronave
     * @param codigo de avería
     */
    private void spreadEventBreakDown(int codigo) {
        EventManto e = new EventManto(this,codigo,matricula);
        for (MantoListener l:listeners){
            l.onBreakDown(e);
        }
    }


    private void addNewReserva(Piloto piloto,Reservable aeronave,Fecha inicio,Fecha fin){
        reservas.addReserva(new Reserva(piloto,aeronave,inicio,fin));
    }

    public Marca getMarca(){
        return modelo.getMarca();
    }

    @Override
    public boolean isReservado(Fecha fechaIni, Fecha fechaFin) {
        return reservas.isReservado(fechaIni, fechaFin);
    }

    @Override
    public void listReservas() {
        reservas.listReservas();
    }

    @Override
    public void addListener(MantoListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(MantoListener listener) {
        listeners.remove(listener);
    }

    @Override
    public String toString() {
        return getMarca() + " " + modelo + " " + matricula;
    }
}
