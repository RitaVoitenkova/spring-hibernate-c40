package by.tms.service;

import by.tms.dao.UserDaoImpl;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserDaoImpl userDao;

    public void save(User user){
        userDao.save(user);
    }

    public List<User> findAll() {
      return userDao.findAll();
    }

    public User findByUserName(String username){
        return userDao.findByUserName(username);
    }

    public void updateName(String name, long id){
        userDao.updateName(name, id);
    }

    public void delete(long id){
        userDao.delete(id);
    }
}
