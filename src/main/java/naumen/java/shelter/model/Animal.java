package naumen.java.shelter.model;

import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "name")
    protected String name;

//    protected Long shelterId;
//    protected String description;

    public Animal(){}

    public Animal(String name){
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

//    public Long getShelterId(){
//        return shelterId;
//    }
//
//    public String getDescription(){
//        return description;
//    }
}
