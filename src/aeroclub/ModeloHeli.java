package aeroclub;

/**
 * Clase heredada de la Clase Modelo que establece el modelo de un Helicóptero
 */
public class ModeloHeli extends Modelo {
    private int horasBlades = 300;

    /**
     * Getter de horasBlades
     *
     * @return horasBlades
     */
    public int getHorasBlades() {
        return horasBlades;
    }

    /**
     * Setter de horasBlades
     *
     * @param horasBlades del tipo int
     */
    public void setHorasBlades(int horasBlades) {
        this.horasBlades = horasBlades;
    }

    /**
     * Constructor parametrizado del Modelo de un Helicóptero
     * @param marca Marca
     * @param modelo String
     */
    public ModeloHeli(MarcaHeli marca, String modelo) {
        super(marca, modelo);
    }
}
