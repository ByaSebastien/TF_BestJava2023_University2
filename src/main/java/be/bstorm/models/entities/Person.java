package be.bstorm.models.entities;

import be.bstorm.models.entities.embedded.Address;
import jakarta.persistence.*;
import lombok.*;

@Entity
//Sert a gerer la strategy d'heritage qu'on veut employer en DB
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
//extends BaseEntity<String> indique que l'id de Person sera un string
public abstract class Person extends BaseEntity<String>{

    @Column(nullable = false,length = 50)
    @Getter @Setter
    private String firstname;
    @Column(nullable = false,length = 50)
    @Getter @Setter
    private String lastname;

    //Annotation qui permet d'embarquer la class Address
    //Toute les column deffinie dans Address deviennent des Column de la table Person
    @Embedded
    @Getter @Setter
    private Address address;
}
