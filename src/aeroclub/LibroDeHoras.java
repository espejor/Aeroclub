package aeroclub;

import java.util.ArrayList;

public class LibroDeHoras {

    private Aeronave aeronave;
    private double totalHoras;
    private ArrayList<Vuelo> libro = new ArrayList<Vuelo>();

    public LibroDeHoras(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public void addVuelo(Vuelo vuelo){
        libro.add(vuelo);
        totalHoras += vuelo.getHoras();
    }

    public String getMatricula(){
        return aeronave.getMatricula();
    }

    /**
     * Getter de totalHoras
     *
     * @return totalHoras
     */
    public double getTotalHoras() {
        return totalHoras;
    }
}
