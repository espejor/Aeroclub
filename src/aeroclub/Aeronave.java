package aeroclub;

import fecha.Fecha;

import java.util.ArrayList;

/**
 * Clase abstracta Aeronave que modela una aeronave. Controla si está operativa o no, según su estado. Mantiene los datos de la
 * matrícula, de las horas de vuelo, del Modelo (intrínsecamente de la Marca) y lleva un control de las reservas hechas a la aeronave
 */
public abstract class Aeronave implements MantoListenerAeronave,MantoSource,Reservable{

    private final String matricula;
        protected final Modelo modelo;
    private int estado = OPERATIVO;
    private LibroReservas reservas = new LibroReservas(this);
    protected LibroDeHoras diarioDeABordo;

    ArrayList<MantoListener> listeners = new ArrayList<MantoListener>();

    /**
     * Constructor parametrizado de la Clase Aeronave
     * @param matricula String Matrícula de la aeronave
     * @param modelo Modelo de la aeronave
     */
    public Aeronave(String matricula, Modelo modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
        diarioDeABordo = new LibroDeHoras(this);
    }

    protected int getHorasOverHaul(){
        return modelo.getHorasOverHaul();
    }

    /**
     * Método abstracto para introducir un vuelo en el libro de a bordo
     * @param v Vuelo
     */
    public abstract void addVuelo(Vuelo v);
    /**
     * Método que cambia el estado de la aeronave
     * Si pasa a averiado se lanza un Evento
     * @param estado A establecer (OPERATIVO, MANTENIMIENTO, AVERIADO)
     */
    public void setEstado(int estado) {
        this.estado = estado;
        if (isAveriado()) {
            spreadEventBreakDown(0);
        }
    }

    /**
     * Comprueba si se ha alcanzado el tiempo de hacer un Overhaul
     */
    protected void checkOverhaulReached(){
        if (getTotalHoras() >= getHorasOverHaul()){
            spreadEventOverHaul(0);
        }
    }

    // -------- Métodos para difundir eventos ------------
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

    private void spreadEventOverHaul(int codigo){
        EventManto e = new EventManto(this,codigo,matricula);
        for (MantoListener l:listeners){
            ((MantoListenerAeronave)l).onReachTimeOverhaul(e);
        }
    }
    // -------- FIN Métodos para difundir eventos ------------


    /**
     * Getter que devuelve la mátrícula de la aeronave
     * @return String Matrícula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Getter que devuelve el modelo de la aeronave
     * @return Modelo
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * Método que devuelve la marca de la aeronave
     * @return Marca
     */
    public Marca getMarca(){
        return modelo.getMarca();
    }
//
//    public void reservar(Piloto piloto,Fecha fechaIni,Fecha fechaFin){
//        reservas.reservar(piloto,fechaIni,fechaFin);
//    }


    /**
     * Método que permite reservar una aeronave por parte de un piloto. Comprueba que el piloto esté habilitado para volar
     * esa aeronave
     * @param u Piloto que pretende reservar
     * @param ini Fecha-Hora de inicio de la reserva
     * @param fin Fecha-Hora de fin de la reserva
     */
    public void reservar(Piloto u, Fecha ini, Fecha fin){
        if (ini.after(fin)){
            System.out.println("La fecha de fin de la reserva debe ser porterior a la de inicio");
            return;
        }
        if (isReservado(ini,fin) || !isOperativo()){
            System.out.println("La aeronave " + this + " no está disponible para ser reservada");
            return;
        }
        if (u.isHabilitado(getModelo())) {
            addNewReserva(u, this, ini, fin);
        }else{
            System.out.println(u + " no está habilitado para el modelo de aeronave " + getModelo().getMarca() + " " +
                    getModelo());
        }
    }

    private void addNewReserva(Piloto piloto,Reservable aeronave,Fecha inicio,Fecha fin){
        reservas.addReserva(new Reserva(piloto,aeronave,inicio,fin));
    }

    public boolean isReservado(Fecha fechaIni, Fecha fechaFin){
        return reservas.isReservado(fechaIni, fechaFin);
    }

    public void listReservas(){
        reservas.listReservas();
    }

    /**
     * Método que devuelve el estado de la aeronave
     * @return entero
     */
    public int getEstado() {
        return estado;
    }


    /**
     * Getter de diarioDeABordo
     * @return diarioDeABordo
     */
    public LibroDeHoras getDiarioDeABordo() {
        return diarioDeABordo;
    }


    public double getTotalHoras(){
        return diarioDeABordo.getTotalHoras();
    }

    // ------------ Métodos de la Interfaz MantoSource ------------

    /**
     * Método que devuelve si la aeronave está averiada
     * @return Booleano
     */
    @Override
    public boolean isAveriado(){
        return estado == AVERIADO;
    }

    /**
     * Método que devuelve si la aeronave está operativa
     * @return Booleano
     */
    @Override
    public boolean isOperativo(){
        return estado == OPERATIVO;
    }



    @Override
    public void addListener(MantoListener listener){
        listeners.add(listener);
    }

    @Override
    public void removeListener(MantoListener listener){
        listeners.remove(listener);
    }
    // ------------ FIN Métodos de la Interfaz MantoSource ------------


    // ------------ Métodos de la Interfaz MantoListener ------------
    @Override
    public void onReachTimeOverhaul(EventManto e) {
        setEstado(Aeronave.MANTENIMIENTO);
    }

    @Override
    public void onBreakDown(EventManto e) {
        System.out.println("La aeronave " + this + " pasa a Mantenimiento correctivo por avería");
    }
    // ------------ FIN Métodos de la Interfaz MantoListener ------------

    @Override
    public String toString() {
        return getMarca() + " " + modelo + " " + matricula;
    }
}
