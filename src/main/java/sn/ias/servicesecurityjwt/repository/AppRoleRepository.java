package sn.ias.servicesecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ias.servicesecurityjwt.entities.AppRoles;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRoles, Long> {
    AppRoles findByName(String name);
}
