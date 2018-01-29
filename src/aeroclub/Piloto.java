package aeroclub;

import persona.Usuario;

import java.util.ArrayList;

/**
 * Clase que modela un Piloto. Hereda de la Clase Usuario ya que para operar y reservar debe registrarse
 * Conoce la Licencia del piloto así como las habilitaciones de vuelo que tiene.
 */
public class Piloto extends Usuario {
    private String licencia;
    private ArrayList<Modelo> habilitado = new ArrayList<Modelo>();

    /**
     * Constructor parametrizado de la Clase. Constructor de copia
     * @param user Usuario
     */
    public Piloto(Usuario user) {
        super(user);
    }

    /**
     * Constructor parametrizado de la clase. recibe los datos de la Persona y Usuario
     * @param dni Sting
     * @param name String
     * @param apellido1  String
     * @param apellido2 String
     * @param user String
     * @param psw String
     */
    public Piloto(String dni, String name, String apellido1, String apellido2, String user, String psw) {
        super(dni, name, apellido1, apellido2, user, psw);
    }

    /**
     * Getter de la Licencia
     * @return String
     */
    public String getLicencia() {
        return licencia;
    }

    /**
     * Setter de la Licencia
     * @param licencia  String
     */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    /**
     * Agrega una habilitación a la lista
     * @param aeronave Modelo de aeronave a habilitar
     */
    public void habilitar(Modelo aeronave){
        habilitado.add(aeronave);
    }

    /**
     * Compruba si el piloto está habilitado para volar un modelo de aeronave
     * @param aeronave Modelo de la aeronave
     * @return Boolean
     */
    boolean isHabilitado(Modelo aeronave){
        return habilitado.contains(aeronave);
    }

    @Override
    public String toString() {
        return getName() + " " + getApellido1() + " " + getApellido2();
    }
}
