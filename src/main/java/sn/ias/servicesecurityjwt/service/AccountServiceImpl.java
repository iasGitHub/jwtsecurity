package sn.ias.servicesecurityjwt.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.ias.servicesecurityjwt.dto.AppRolesDto;
import sn.ias.servicesecurityjwt.dto.AppUserDto;
import sn.ias.servicesecurityjwt.entities.AppRoles;
import sn.ias.servicesecurityjwt.entities.AppUser;
import sn.ias.servicesecurityjwt.repository.AppRoleRepository;
import sn.ias.servicesecurityjwt.repository.AppUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service @Transactional
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    private PasswordEncoder passwordEncoder;

    private Converter converter;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, Converter converter, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.converter = converter;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUserDto saveUser(AppUserDto appUserdto) {
        AppUser appUser = appUserRepository.save(converter.AppUserDtoToAppUserEntity(appUserdto));
        String pwd = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pwd));
        return converter.AppUserEntityToAppUserDto(appUser);
    }

    @Override
    public AppRolesDto saveRoles(AppRolesDto appRolesdto) {
        AppRoles appRoles = appRoleRepository.save(converter.appRoleDtoToAppRoleEntity(appRolesdto));
        return converter.appRoleEntityToAppRoleDto(appRoles);
    }

    @Override
    public AppUserDto loadAppUserByUsername(String username) {

        return converter.AppUserEntityToAppUserDto(appUserRepository.findByUsername(username));
    }

    @Override
    public List<AppUserDto> findUsers() {
        List<AppUserDto> appUserDtos = new ArrayList<>();
        appUserRepository.findAll().forEach(appUser -> {
            appUserDtos.add(converter.AppUserEntityToAppUserDto(appUser));
        });
        return appUserDtos;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRoles appRoles = appRoleRepository.findByName(roleName);
        appUser.getRoles().add(appRoles);
    }
}
