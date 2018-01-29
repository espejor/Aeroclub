package aeroclub;

/**
 * Clase derivada de la Aeronave
 */
public class Helicoptero extends Aeronave implements MantoHeliListener{
    /**
     * Constructor parametrizado
     * @param matricula Matrícula del helicóptero
     * @param modelo ModeloHeli del helicóptero
     */
    public Helicoptero(String matricula, ModeloHeli modelo) {
            super(matricula, modelo);
            addListener(this);
    }

    /**
     * Getter de PALAS
     *
     * @return PALAS
     */
    public int getHorasBlades() {
        return ((ModeloHeli)modelo).getHorasBlades();
    }

    @Override
    public void addVuelo(Vuelo v){
        diarioDeABordo.addVuelo(v);
        checkOverhaulReached();
        checkBladesReached();
    }


    private void checkBladesReached(){
        if (getTotalHoras() >= getHorasBlades()){
            spreadEventBlades(0);
        }
    }

    private void spreadEventBlades(int codigo) {
        EventManto e = new EventManto(this,codigo,getMatricula());
        for (MantoListener l:listeners){
            ((MantoHeliListener)l).onReachTimeBlades(e);
        }
    }


    // ------------ Métodos de la Interfaz MantoListener ------------
    @Override
    public void onReachTimeOverhaul(EventManto e) {
        super.onReachTimeOverhaul(e);
        System.out.println("El helicoptero " + this + " pasa a Mantenimiento de Overhaul al alcanzar las " +
                getHorasOverHaul() + " horas de vuelo");
    }

    @Override
    public void onReachTimeBlades(EventManto e) {
        super.onReachTimeOverhaul(e);
        System.out.println("El helicoptero " + this + " pasa a Mantenimiento de Palas al alcanzar las " +
                getHorasBlades() + " horas de vuelo");
    }
    // ------------ FIN Métodos de la Interfaz MantoListener ------------
}
