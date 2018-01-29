package aeroclub;

/**
 * La Interfaz MantoSource contiene los métodos necesarios para aquellas clases de elementos que deban ser mantenidos.
 * Contempla los métodos de agregar y eliminar listener para comprobar si el elemento está operativo o averiado.
 * Además, se definen las constantes que definen el estatus del elemento
 */
public interface MantoSource {
    int OPERATIVO = 0;
    int MANTENIMIENTO = 1;
    int AVERIADO = 2;

    void addListener(MantoListener listener);
    void removeListener(MantoListener listener);

    boolean isOperativo();
    boolean isAveriado();
}
