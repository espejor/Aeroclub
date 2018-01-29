package aeroclub;

/**
 * Clase abstracta que modela el Modelo de una aeronave. Tiene una referencia a la Marca de la aeronave
 */
public abstract class Modelo {
    private final Marca marca;
    protected final String modelo;
    private int horasOverHaul = 2000;


    /**
     * Constructor parametrizado de la Clase.
     * @param marca Marca de la aeronave
     * @param modelo String nombre del Modelo de la aeronave
     */
    public Modelo(Marca marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * Getter de horasOverHaul
     *
     * @return horasOverHaul
     */
    public int getHorasOverHaul() {
        return horasOverHaul;
    }

    /**
     * Setter de horasOverHaul
     *
     * @param horasOverHaul del tipo int
     */
    public void setHorasOverHaul(int horasOverHaul) {
        this.horasOverHaul = horasOverHaul;
    }

    /**
     * Getter de la marca correspondiente al modelo de la aeronave
     * @return Marca
     */
    Marca getMarca() {
        return marca;
    }

    /**
     * Getter del Modelo de la Aeronave
     * @return String
     */
    public String getModelo() {
        return modelo;
    }

    @Override
    public boolean equals(Object obj) {
        //Reflexivo
        if ( this == obj ) return true;

        //No nulo
        if ( obj == null ) return false;

        //Simetrico
        //La máquina virtual mantiene una única instancia de cada clase, por lo que esta comparación es correcta
        //Usar instanceof no garantiza la simetría porque es true para una clase y sus hijos
        if ( this.getClass() != obj.getClass() ) return false;

        // una vez que sabemos que son del mismo tipo hacemos cast para que el compilador lo sepa también
        if ( this.marca.equals(this.getClass().cast(obj).getMarca()) && this.modelo.equals(this.getClass().cast(obj).getModelo())) return true;

        if ( !this.modelo.equals("") )
            return this.marca.equals(((Modelo)obj).getMarca()) && this.modelo.equals(((Modelo)obj).getModelo());
        return false;
    }
    @Override
    public String toString() {
        return modelo;
    }
}
