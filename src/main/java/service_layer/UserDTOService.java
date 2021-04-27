package service_layer;

import DAO.UserDAO;
import Entity_DB_model.AutoEntity;
import Entity_DB_model.UserEntity;

import java.util.List;


//на мой взягляд лишний слой, можно для теста и в мэйне было сделать
//здесь может быть еще логика, не связанная с DAO
public class UserDTOService {
private UserDAO userDAO = new UserDAO();
//Зачем явно прописываем пустой конструктор?
public UserDTOService(){}

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
