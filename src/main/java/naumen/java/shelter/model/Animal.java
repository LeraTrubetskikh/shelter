package naumen.java.shelter.model;

import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shelterId")
    private Long shelter;
//    protected String description;

    public Animal(){}

    public Animal(String name){
        this.name = name;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setShelter(Long shelter){
        this.shelter = shelter;
    }


    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Long getShelter(){
        return shelter;
    }



//    public Long getShelterId(){
//        return shelterId;
//    }
//
//    public String getDescription(){
//        return description;
//    }
}
