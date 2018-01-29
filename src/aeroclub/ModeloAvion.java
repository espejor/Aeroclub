package aeroclub;

/**
 * Clase heredada de la Clase Modelo que establece el modelo de un Avión
 */
public class ModeloAvion extends Modelo {
    private int horasHelice = 500;

    /**
     * Constructor parametrizado del Modelo de un Avión
     * @param marca Marca
     * @param modelo String
     */
    public ModeloAvion(MarcaAvion marca, String modelo) {
        super(marca, modelo);
    }


    /**
     * Getter de horasHelice
     *
     * @return horasHelice
     */
    public int getHorasHelice() {
        return horasHelice;
    }

}
