package aeroclub;

import fecha.Fecha;

public class Simulador implements Reservable{
    Modelo modelo;
    private LibroReservas reservas = new LibroReservas(this);


    public Simulador(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void reservar(Piloto piloto, Fecha fechaIni, Fecha fechaFin) {
        if (fechaIni.after(fechaFin)){
            System.out.println("La fecha de fin de la reserva debe ser porterior a la de inicio");
            return;
        }
        if (isReservado(fechaIni,fechaFin)){
            System.out.println("El " + this + " no está disponible para ser reservado");
            return;
        }
        addNewReserva(piloto, this, fechaIni, fechaFin);
    }


    private void addNewReserva(Piloto piloto,Reservable aeronave,Fecha inicio,Fecha fin){
        reservas.addReserva(new Reserva(piloto,aeronave,inicio,fin));
    }

    public Marca getMarca(){
        return modelo.getMarca();
    }

    @Override
    public boolean isReservado(Fecha fechaIni, Fecha fechaFin) {
        return reservas.isReservado(fechaIni, fechaFin);
    }

    @Override
    public void listReservas() {
        reservas.listReservas();
    }

    @Override
    public String toString() {
        return "Simulador de " + getMarca() + " " + modelo;
    }
}
