package aeroclub;

import fecha.Fecha;


/**
 * Clase que modela los datos de los vuelos que realizan las aeronaves
 */
public class Vuelo {
    private Fecha inicio;
    private Fecha fin;
    private  Piloto piloto;
    private Aeronave aeronave;
    private double horas;

    public Vuelo(Fecha inicio, Fecha fin, Piloto piloto, Aeronave aeronave) {
        this.inicio = inicio;
        this.fin = fin;
        this.piloto = piloto;
        this.aeronave = aeronave;
        horas = (double)(fin.getTimeInMillis()-inicio.getTimeInMillis())/3600000;
        aeronave.addVuelo(this);
    }

    /**
     * Getter de horas
     *
     * @return horas
     */
    public double getHoras() {
        return horas;
    }
}
