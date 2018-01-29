package aeroclub;


import fecha.Fecha;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Clase que modela un aeroclub.<br>
 * Tiene como atributos:<br>
 * private final String name. Nombre del aeroclub<br>
 * private final ArrayList aeronaves. Lista de aeronaves del aeroclub<br>
 * private final ArrayList socios. Lista de Pilotos socios del aeroclub<br>
 * private final ArrayList reservas. Lista de reservas hechas en el aeroclub
 */
public class Aeroclub {
    private final String name;
    private final ArrayList<Aeronave> aeronaves = new ArrayList<Aeronave>();
    private final ArrayList<Piloto> socios = new ArrayList<Piloto>();
    private Taller taller;

   // ArrayList<MantoListener> listeners = new ArrayList<MantoListener>();


    /**
     * Constructor parametrizado que recibe el nombre del aeroclub
     * @param n String (Cadena) con el nombre del aeroclub
     */
    public Aeroclub(String n) {
        name = n;
    }

    /**
     * Método para agregar un usuario (Piloto o socio) a la lista de pilotos del aeroclub
     * @param u Usuario de tipo Piloto
     */
    public void addUser(Piloto u){
        socios.add(u);
    }

    /**
     * Método que agrega una aeronave a la lista de aeronaves del aeroclub
     * @param a aeronave a agregar de la clase abstracta Aeronave
     */
    public void addAeronave(Aeronave a){
        aeronaves.add(a);
    }

    /**
     * Método que devuelve la lista de aeronaves del club
     * @return ArrayList de Aeronaves
     */
    public ArrayList<Aeronave> getAeronaves() {
        return aeronaves;
    }

    /**
     * Getter de taller
     * @return taller
     */
    public Taller getTaller() {
        return taller;
    }

    /**
     * Setter de taller
     * Ademas, al agregar un taller se le asignan automáticamente a todas las aeronaves como listener
     * @param taller del tipo aeroclub.Taller
     */
    public void setTaller(Taller taller) {
        this.taller = taller;
        asignarListener();
    }

    private void asignarListener(){
        for (Aeronave a:aeronaves){
            a.addListener(taller);
        }
    }

    /**
     * Método que lista los socios del aeroclub
     */
    public void listSocios(){
        for (Piloto p: socios) {
            if (p == null) break;
            System.out.println(p);
        }
    }

    /**
     * Método que lista las aeronaves del aeroclub
     */
    public void listAeronaves(){
        for (Aeronave a: aeronaves) {
            if (a == null) break;
            System.out.println(a);
        }
    }



    @Override
    public String toString() {
        return "Aeroclub " + name ;
    }
}
