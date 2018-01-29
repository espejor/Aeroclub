package aeroclub;

/**
 * Clase abstracta que modela la Marca de una aeronave
 */
public abstract class Marca {
    private String marca;

    /**
     * Constructor parametrizado que admite la cadena del nombre de la Marca
     * @param marca String
     */
    public Marca(String marca) {
        this.marca = marca;
    }

    /**
     * Getter de la Marca
      * @return String
     */
    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return marca;
    }
}
