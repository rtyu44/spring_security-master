package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDaoImp;
import web.model.Role;

import java.util.List;


@Service
@Transactional
public class RoleServiceImp implements RoleService{
//    @Autowired
    private RoleDaoImp roleDaoImp;

//    @Autowired
//    public RoleServiceImp(RoleDaoImp roleDaoImp) {
//        this.roleDaoImp = roleDaoImp;
//    }

    @Override
    public Role getRoleByName(String name) {
        return roleDaoImp.getRoleByName(name);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDaoImp.getRoleById(id);
    }

    @Override
    public List<Role> allRoles() {
        return roleDaoImp.allRoles();
    }

    @Override
    public Role getDefaultRole() {
        return roleDaoImp.getDefaultRole();
    }

}
