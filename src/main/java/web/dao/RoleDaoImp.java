package web.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImp implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

//    public RoleDaoImp(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
        public RoleDaoImp() {

    }


    @Override
    public Role getRoleByName(String name) {
        Role role = entityManager.createQuery("SELECT r FROM Role r WHERE r.name=:name", Role.class)
                .setParameter("name", name)
                .getSingleResult();

        return role;
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> allRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getDefaultRole() {
        return getRoleByName("ROLE_USER");
    }
}
