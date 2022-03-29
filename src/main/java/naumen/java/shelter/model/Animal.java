package naumen.java.shelter.model;

public class Animal {

    protected Long id;
    protected String name;
    protected Shelter shelter;
    protected String description;

    public Animal(String name, Long id){
        this.name = name;
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Shelter getShelter(){
        return shelter;
    }

    public String getDescription(){
        return description;
    }
}
