package sn.ias.servicesecurityjwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sn.ias.servicesecurityjwt.dto.AppRolesDto;
import sn.ias.servicesecurityjwt.dto.AppUserDto;
import sn.ias.servicesecurityjwt.entities.AppRoles;
import sn.ias.servicesecurityjwt.entities.AppUser;
import sn.ias.servicesecurityjwt.service.AccountService;

import java.util.ArrayList;

@SpringBootApplication

//Methode 2 pour la gestion des authorisations
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ServiceSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSecurityJwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(AccountService userService) {
        return args -> {
            // Enregistrer des utilisateurs
            /*userService.saveUser(new AppUserDto(null, "John Doe", "jDoe","1234", null));
            userService.saveUser(new AppUserDto(null, "Ahmed Bâ", "Ahmed","Passer123", null));
            userService.saveUser(new AppUserDto(null, "Fatim Sy", "Fati","1234", null));
            userService.saveUser(new AppUserDto(null, "Coumba Tall", "CTall","Coumba4", null));

            // Permet d'afficher les utilisateurs créés via leur id ainsi que leur name
            userService.findUsers().forEach(user -> {
                System.out.println(user.getId() + " " + user.getName());
            });

            // Enregistrer un rôle
            userService.saveRoles(new AppRolesDto(null, "Administrateur"));
            userService.saveRoles(new AppRolesDto(null, "Utilisateur"));

            // Ajout d'un rôle à un utilisateur
            userService.addRoleToUser("Ahmed","Administrateur");
            userService.addRoleToUser("Fati","Utilisateur");*/


            /*
            userService.saveRole(new AppRoles(null, "Role_User"));
            userService.saveRole(new AppRoles(null, "Role_Manager"));
            userService.saveRole(new AppRoles(null, "Role_Admin"));
            userService.saveRole(new AppRoles(null, "Role_Super_Admin"));

            userService.saveUser(new AppUser(null, "John Doe", "jDoe","1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Ahmed Bâ", "Ahmed","Passer123", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Fatim Sy", "Fati","1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Coumba Tall", "CTall","Coumba4", new ArrayList<>()));

            userService.addRoleToUser("jDoe", "Role_User");
            userService.addRoleToUser("Ahmed", "Role_Manager");
            userService.addRoleToUser("Fati", "Role_Admin");
            userService.addRoleToUser("CTall", "Role_Super_Admin");*/
        };
    }

}
