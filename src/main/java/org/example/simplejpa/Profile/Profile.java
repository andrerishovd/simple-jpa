package org.example.simplejpa.Profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.simplejpa.Owner.Owner;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(generator = "profile_gen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "profile_gen", sequenceName = "profile_seq", allocationSize = 1)
    @Column(name = "profile_id")
    private Long id;
    @Column(name = "profile_language")
    private String language;
    @Column(name = "profile_timezone")
    private String timezone;

    @OneToOne
    @JoinColumn(name = "profile_owner_id")
    @JsonIgnoreProperties("profile")
    private Owner owner;

}
