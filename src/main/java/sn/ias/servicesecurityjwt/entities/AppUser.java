package sn.ias.servicesecurityjwt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100, nullable = false, unique = true)
    private String username;
    @Column(length = 150, nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRoles> roles = new ArrayList<>();


}
