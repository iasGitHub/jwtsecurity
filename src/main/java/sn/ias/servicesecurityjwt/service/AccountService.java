package sn.ias.servicesecurityjwt.service;

import sn.ias.servicesecurityjwt.dto.AppRolesDto;
import sn.ias.servicesecurityjwt.dto.AppUserDto;
import sn.ias.servicesecurityjwt.entities.AppRoles;
import sn.ias.servicesecurityjwt.entities.AppUser;

import java.util.List;

public interface AccountService {

    public AppUserDto saveUser(AppUserDto appUserdto);
    public AppRolesDto saveRoles(AppRolesDto appRolesdto);
    public AppUserDto loadAppUserByUsername (String username);
    public List<AppUserDto> findUsers();
    void addRoleToUser(String username, String roleName);

}
