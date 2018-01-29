package aeroclub.UseCases;

import aeroclub.Aeronave;
import aeroclub.Piloto;
import fecha.Fecha;

public class ReserveAFlight {
    public ReserveAFlight(Aeronave aeronave, Piloto piloto, Fecha fechaIni,Fecha fechaFin) {
        aeronave.reservar(piloto,fechaIni,fechaFin);
    }
}
