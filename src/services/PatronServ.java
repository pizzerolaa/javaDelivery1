/* 
** Register Patrons: The system allows librarians to register new patrons, capturing essential 
    information like name, ID, and contact details.
** View Patrons: Librarians can view a list of registered patrons, making it easier to manage user information.
** Edit Patrons: Users can edit a Patron, finding it first by ID, show the current values of the 
    Patron and then allow the user enter new values for the Patron contact. */

package services;

import models.Patron;
import exceptions.PatronExcep;
import java.util.ArrayList;
import java.util.List;

public class PatronServ {
    private List<Patron> patrons = new ArrayList<>();

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void removePatron(int id) throws PatronExcep {
        Patron patron = findPatron(id);
        if (patron == null) {
            throw new PatronExcep("Patron not found");
        }
        patrons.remove(patron);
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public Patron findPatron(int id) {
        for (Patron patron : patrons) {
            if (Integer.parseInt(patron.getId()) == id) {
                return patron;
            }
        }
        return null;
    }

    public void editPatron(int id, String name, String contact) throws PatronExcep {
        Patron patron = findPatron(id);
        if (patron == null) {
            throw new PatronExcep("Patron not found");
        }
        patron.setName(name);
        patron.setContact(contact);
    }
    
    public void viewPatrons() {
        List<Patron> patronList = getPatrons();
        for (Patron patron : patronList) {
            System.out.println("Name: " + patron.getName());
            System.out.println("ID: " + patron.getId());
            System.out.println("Contact: " + patron.getContact());
            System.out.println();
        }
    }

    public void searchPatron(int id) throws PatronExcep {
        Patron patron = findPatron(id);
        if (patron == null) {
            throw new PatronExcep("Patron not found");
        }
        System.out.println("Name: " + patron.getName());
        System.out.println("ID: " + patron.getId());
        System.out.println("Contact: " + patron.getContact());
    }
}
