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

    @Column(name = "address")
    private String address;

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

    public String getAddress(){return address;}

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
