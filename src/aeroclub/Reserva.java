package aeroclub;


import fecha.Fecha;
import persona.Usuario;

import javax.naming.spi.ResolveResult;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase que modela una reserva de una aeronave hecha por un piloto.<br>
 * Tiene un contador de reservas para crear y almacenar el número de reserva.<br>
 * Guarda la fecha-hora de inicio y fin de la reserva<br>
 * Los datos del piloto<br>
 * Y los datos de la aeronave a alquilar
 */
class Reserva {
    private int nReserva;
    private Fecha fhInicio;
    private  Fecha fhFin;
    private  Piloto socio;
    private Reservable aeronave;
    private static int counterReserva = 0;

    /**
     * Constructor parametrizado de la Clase Reserva
     * @param socio Piloto que hace la reserva
     * @param aeronave Aeronave sobre la que se hace la reserva
     * @param fhInicio Feha-Hora de inicio de la reserva
     * @param fhFin Fecha-Hora de Fin de la reserva
     */
    public Reserva(Piloto socio, Reservable aeronave,Fecha fhInicio, Fecha fhFin) {
        this.fhInicio = fhInicio;
        this.fhFin = fhFin;
        this.socio = socio;
        this.aeronave = aeronave;
        nReserva = ++counterReserva;
    }

    /**
     * Getter del número de Reserva
     * @ return Entero
     */
    public int getnReserva() {
        return nReserva;
    }

    /**
     * Getter de la fecha-hora  de inicio de la reserva
      * @return devuelve una Fecha-Hora
     */
    Calendar getFhInicio() {
        return fhInicio;
    }

    /**
     * Getter de la fecha-hora  de fin de la reserva
     * @return devuelve una Fecha-Hora
     */
    Calendar getFhFin() {
        return fhFin;
    }

    /**
     * Getter del Piloto que hace la reserva
     * @return Piloto
     */
    private Usuario getSocio() {
        return socio;
    }

    /**
     * Getter de la aeronave de la reserva
     * @return devuelve una Aeronave
     */
    public Reservable getAeronave() {
        return aeronave;
    }

    @Override
    public String toString() {
        return (getSocio().getNombreYApellidos() + " "
                + getAeronave()+ " " + fhInicio + " <--> " + fhFin);
    }
}
