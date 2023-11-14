package be.bstorm.models.entities;

import be.bstorm.models.entities.embedded.Address;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
//Sert a gerer la strategy d'heritage qu'on veut employer en DB
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "UserType")
@DiscriminatorValue("PERSON")
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
//extends BaseEntity<String> indique que l'id de Person sera un string
//pour mettre en place spring security je dois etendre UserDetails a ma class d'auth
public class Person extends BaseEntity<String> implements UserDetails {

    @Column(nullable = false,length = 50)
    @Getter @Setter
    private String firstname;
    @Column(nullable = false,length = 50)
    @Getter @Setter
    private String lastname;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;
    //ADMIN,STUDENT,TEACHER
    @Getter @Setter
    private String role;
    @Getter @Setter
    private boolean isActive;

    //Annotation qui permet d'embarquer la class Address
    //Toute les column deffinie dans Address deviennent des Column de la table Person
    @Embedded
    @Getter @Setter
    private Address address;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(this.role);
        authorities.add(grantedAuthority);
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isActive;
    }
}
