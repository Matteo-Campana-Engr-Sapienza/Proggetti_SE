package it.sapienza.softeng.rest.json.ws;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


@JacksonXmlRootElement
public class Ateneo {

    private String id;
    private String name;
    private List<Studente> studenti;

    public Ateneo() {
    }

    public Ateneo(String id, String name) {
        this.id = id;
        this.name = name;
        studenti = new LinkedList<Studente>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

    public void addStudente(Studente s) {
        studenti.add(s);
    }

    public boolean removeStudente(String Id) {
        for (Studente s : this.studenti) {
            if (s.getId().equals(Id)) {
                studenti.remove(s);
                return true;
            }
        }
        return false;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ateneo other = (Ateneo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ateneo{" + "id=" + id + ", name=" + name + '}';
    }

}
