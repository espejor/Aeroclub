package aeroclub;


/**
 * Clase derivada de la Aeronave
 */
public class Avion extends Aeronave implements MantoAvionListener{
    /**
     * Constructor parametrizado
     * @param matricula Matrícula del avión
     * @param modelo Modelo del avión
     */
    public Avion(String matricula, ModeloAvion modelo) {
        super(matricula, modelo);
        addListener(this);
    }

    public void addVuelo(Vuelo v){
        diarioDeABordo.addVuelo(v);
        checkOverhaulReached();
        checkPropellerReached();
    }

    private int getHorasHelice(){
        return ((ModeloAvion)getModelo()).getHorasHelice();
    }

    private void checkPropellerReached(){
        if (getTotalHoras() >= getHorasHelice()){
            spreadEventPropeller(0);
        }
    }

    private void spreadEventPropeller(int codigo) {
        EventManto e = new EventManto(this,codigo,getMatricula());
        for (MantoListener l:listeners){
            ((MantoAvionListener)l).onReachTimePropeller(e);
        }
    }

    // ------------ Métodos de la Interfaz MantoListener ------------
    @Override
    public void onReachTimeOverhaul(EventManto e) {
        //Avion a = ((LibroDeHoras) e.getSource()).aeronave;
        //String tipoManto = e.codigo == LibroDeHoras.MOTOR?"Motor":"Hélice";
        int horas = getHorasOverHaul();
        super.onReachTimeOverhaul(e);
        System.out.println("El avión " + this + " pasa a Mantenimiento de Overhaul al alcanzar las " +
                horas + " horas de vuelo");
    }

    @Override
    public void onReachTimePropeller(EventManto e) {
        int horas = getHorasHelice();
        super.onReachTimeOverhaul(e);
        System.out.println("El avión " + this + " pasa a Mantenimiento de Hélice al alcanzar las " +
                horas + " horas de vuelo");
    }
    // ------------ FIN Métodos de la Interfaz MantoListener ------------

}
