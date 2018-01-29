package aeroclub;

import fecha.Fecha;

public interface Reservable {
    void reservar(Piloto piloto, Fecha fechaIni,Fecha fechaFin);
    boolean isReservado(Fecha fechaIni, Fecha fechaFin);
    void listReservas();

}
