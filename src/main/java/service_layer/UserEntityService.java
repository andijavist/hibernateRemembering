package service_layer;

import DAO.UserDAO;
import Entity_DB_model.AutoEntity;
import Entity_DB_model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserEntityService {
private UserDAO userDAO;

    @Autowired
    public UserEntityService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserEntity findUserByID (int id){
    return userDAO.findById(id);
    }


    public void saveUser(UserEntity userEntity){

    userDAO.save(userEntity);
    }

    public void deleteUser(UserEntity userEntity){
    userDAO.delete(userEntity);
    }

    public void updateUser (UserEntity userEntity){
    userDAO.update(userEntity);
    }

    public List<UserEntity> findAllUsers (){
    return userDAO.findAll();
    }

    public AutoEntity findAutoById (int id){
    return userDAO.findAutoById(id);
    }

}
