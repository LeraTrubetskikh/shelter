package naumen.java.shelter.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shelter")
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "name")
    protected String name;

    //protected List<Long> animals;

    public Shelter(){}

    public Shelter(String name)
    {
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
