package org.example.simplejpa.Owner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.simplejpa.Cat.Cat;
import org.example.simplejpa.Profile.Profile;

import java.util.List;

@Entity
@Setter @Getter @NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "owner_gen")
    @SequenceGenerator(name = "owner_gen", sequenceName = "owner_seq", allocationSize = 1)
    @Column(name = "owner_id")
    private Long id;
    @Column(name = "owner_last_name")
    private String lastName;
    @Column(name = "owner_first_name")
    private String firstName;
    @Column(name = "owner_email")
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("owner")
    private List<Cat> cats;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("owner")
    private Profile profile;


    public Owner(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }
}