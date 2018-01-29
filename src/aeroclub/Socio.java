package aeroclub;

import persona.Usuario;

public class Socio extends Piloto{
    private int nSocio = 0;
    private static int counterNSocio = 0;

    public Socio(Usuario user) {
        super(user);
        asignarNSocio();
    }

    public Socio(String dni, String name, String apellido1, String apellido2, String user, String psw) {
        super(dni, name, apellido1, apellido2, user, psw);
        asignarNSocio();
    }

    private void asignarNSocio(){
        nSocio = ++counterNSocio;
    }
}
