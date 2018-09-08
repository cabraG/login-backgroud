package cabra.login.service;

import cabra.login.dao.UserDao;
import cabra.login.enity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User selectByLoginname(User record){

        return userDao.selectByLoginname(record);
    }

}
