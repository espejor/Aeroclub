

import aeroclub.*;
import aeroclub.UseCases.ReserveAFlight;
import fecha.Fecha;

import java.util.GregorianCalendar;


class MainAeroclub {
    public static void main(String[] args) {
        MarcaAvion cessna = new MarcaAvion("Cessna");
        MarcaAvion piper = new MarcaAvion("Pipper");
        MarcaHeli robinson = new MarcaHeli("Robinson");

        ModeloAvion c152 = new ModeloAvion( cessna,"152");
        ModeloAvion c172 = new ModeloAvion(cessna,"172");
        ModeloAvion c172rg = new ModeloAvion( cessna,"172RG");
        ModeloHeli r44 = new ModeloHeli( robinson,"44");
        ModeloAvion pa28 = new ModeloAvion( piper,"PA 28");

        Aeronave ecjbg = new Avion("EC-JBG",c152);
        Aeronave ecqwe = new Avion("EC-QWE",c172);
        Aeronave ecpdf = new Helicoptero("EC-PDF", r44);
        Aeronave ecyth = new Avion("EC-YTH",pa28);

        Piloto pepe = new Socio("12345678G","Pepe","Pérez","Pi","qwerty","asdfg");
        Piloto paco = new Socio("12097678T","Paco","Paco","Quemepaco","qwerty","asdfg");

        pepe.habilitar(c152);
        pepe.habilitar(r44);

        Aeroclub pollo = new Aeroclub("El Pollo");
        pollo.addAeronave(ecjbg);
        pollo.addAeronave(ecqwe);
        pollo.addAeronave(ecpdf);
        pollo.addAeronave(ecyth);
        pollo.addUser(pepe);
        pollo.addUser(paco);

        pollo.listSocios();
        pollo.listAeronaves();

        Taller taller = new Taller();

        pollo.setTaller(taller);

        Fecha horaIni = new Fecha(5,10,1961,15,0);
        Fecha horaFin = new Fecha(5,10,1961,17,30);
        Fecha horaIni2 = new Fecha(5,10,1961,16,0);
        Fecha horaFin2 = new Fecha(5,10,1961,17,20);
        Fecha horaIni3 = new Fecha(5,11,1961,18,0);
        Fecha horaFin3 = new Fecha(5,12,1962,19,30);


        new ReserveAFlight(ecjbg,pepe,horaIni,horaFin);
        ecjbg.reservar(pepe,horaIni2,horaFin2);
        ecjbg.reservar(pepe,horaIni3,horaFin3);
        ecjbg.reservar(pepe,new Fecha(1,11,1999,12,30),new Fecha(1,11,1999,13,0));

        ecpdf.reservar(pepe,horaIni2,horaFin2);
        ecpdf.reservar(pepe,horaIni3,horaFin3);
        ecpdf.listReservas();

        System.out.println(pollo);
        ecjbg.listReservas();
        Vuelo v1 = new Vuelo(horaIni,horaFin,pepe,ecjbg);
        Vuelo vh4 = new Vuelo(horaIni,horaFin,pepe,ecpdf);
        // este vuelo provocará un evento al sobrepasar las horas del overhaul
        Vuelo v2 = new Vuelo(horaIni3,horaFin3,pepe,ecjbg);
        Vuelo vh3 = new Vuelo(horaIni3,horaFin3,pepe,ecpdf);
        // esta reserva no se llevará a cabo al quedar el avión en mantenimiento
        ecjbg.reservar(pepe,new Fecha(10,11,2015,12,30),new Fecha(10,11,2015,13,0));

        ecpdf.reservar(pepe,horaIni,horaFin);


        System.out.println(ecjbg.getTotalHoras());

        ecpdf.setEstado(MantoSource.AVERIADO);

        System.out.println();

        MarcaDron dji = new MarcaDron("Dji");
        ModeloDron phantomIV = new ModeloDron(dji,"Phantom IV");
        Dron d1 = new Dron(phantomIV, "DIJ001");

        d1.reservar(paco,horaIni,horaFin);
        d1.setEstado(MantoSource.AVERIADO);
        d1.reservar(paco,horaIni3,horaFin3);
        d1.listReservas();

        Simulador s1 = new Simulador(c152);

        s1.reservar(pepe,horaIni2,horaFin2);
        s1.reservar(pepe,horaIni,horaFin);
        s1.reservar(paco,horaIni3,horaFin3);
        s1.listReservas();
    }
}
