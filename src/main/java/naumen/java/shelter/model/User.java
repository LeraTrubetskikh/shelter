package naumen.java.shelter.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String username;
    protected String password;
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    public Long getId()
    {
        return id;
    }

    public String getPassword()
    {
        return password;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public String getUsername()
    {
        return username;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
