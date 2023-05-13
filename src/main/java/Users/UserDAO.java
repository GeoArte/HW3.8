package Users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public List<User> getUsersByRole(String roleName);

    public void deleteUser(User user);
    public void addUser(User user);

    public void updateUser(User user);
}
