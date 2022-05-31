package sn.ias.servicesecurityjwt.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sn.ias.servicesecurityjwt.dto.AppUserDto;
import sn.ias.servicesecurityjwt.entities.AppRoles;
import sn.ias.servicesecurityjwt.entities.AppUser;
import sn.ias.servicesecurityjwt.service.AccountService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {

    private AccountService userService;

    public UserResource(AccountService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<AppUserDto> getUsers() {

        return userService.findUsers();
    }


    /*private final AccountService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<AppRoles> saveRole(@RequestBody AppRoles role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.ok().body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
    */
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
