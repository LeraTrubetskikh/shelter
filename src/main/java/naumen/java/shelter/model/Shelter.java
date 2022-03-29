package naumen.java.shelter.model;

import java.util.List;

public class Shelter {

    protected Long id;
    protected String name;
    protected List<Animal> animals;

    public Shelter(String name, Long id)
    {
        this.name = name;
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
