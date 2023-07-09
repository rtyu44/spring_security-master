package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager em;

//    public UserDaoImp(EntityManager em) {
//        this.em = em;
//    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        try {
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
            }
        } catch (NullPointerException e) {
            System.out.println("User not found");
        }
    }

    @Override
    public void editUser(User user) {
        em.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserByUsername(String name) {
        return em.createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getSingleResult();

    }
}
