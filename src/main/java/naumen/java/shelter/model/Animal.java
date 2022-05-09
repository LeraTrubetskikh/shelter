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
    private Long shelterId;

    @Column(name = "breed")
    private String breed;

    @Column(name = "description")
    private String description;

    @Column(name = "age")
    private String age;

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

    public void setShelter(Long shelterId){
        this.shelterId = shelterId;
    }

    public void setBreed(String breed){this.breed = breed;}

    public void setDescription(String description){this.description = description;}

    public void setAge(String age){this.age = age;}

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Long getShelter(){
        return shelterId;
    }

    public String getBreed(){return breed;}

    public String getDescription(){return description;}

    public String getAge(){return age;}
}
