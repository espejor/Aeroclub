package aeroclub;

import java.util.EventObject;

public class EventManto extends EventObject {
    private int codigo = 0;
    private String id;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventManto(Object source,int code,String id) {
        super(source);
        codigo = code;
        this.id = id;
    }

    /**
     * Getter de id
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter de id
     *
     * @param id del tipo java.lang.String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter de codigo
     *
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Setter de codigo
     *
     * @param codigo del tipo int
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
