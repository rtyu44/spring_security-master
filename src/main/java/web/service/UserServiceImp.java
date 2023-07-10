package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao ud;

//    @Autowired
//    public UserServiceImp(UserDaoImp ud) {
//        this.ud = ud;
//    }

    @Override
    public void addUser(User user) {
        ud.addUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        ud.deleteUser(id);
    }

    @Override
    public void editUser(User user) {
        ud.editUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return ud.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return ud.getAllUsers();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ud.getUserByUsername(username);
    }
}
