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

//    @Column(name = "animalsId")
//    protected List<Long> animals;

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

    public void setId(Long id){
        this.id = id;
    }

    public void getName(String name){
        this.name = name;
    }
}
