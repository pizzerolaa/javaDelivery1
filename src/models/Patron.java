/* este archivo representa el modelo de un patron (usuario de la biblioteca), el cual 
captura informacion como nombre, ID y detalles de contacto */

package models;

public class Patron {
    private String name;
    private String id;
    private String contact;

    public Patron(String name, String id, String contact) {
        this.name = name;
        this.id = id;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
