package service_layer;

import DAO.UserDAO;
import DTO_DB_model.AutoDTO;
import DTO_DB_model.UserDTO;

import java.util.List;


//на мой взягляд лишний слой, можно для теста и в мэйне было сделать
//здесь может быть еще логика, не связанная с DAO
public class UserDTOService {
private UserDAO userDAO = new UserDAO();
//Зачем явно прописываем пустой конструктор?
public UserDTOService(){}

    public UserDTO findUserByID (int id){
    return userDAO.findById(id);
    }


    public void saveUser(UserDTO userDTO){

    userDAO.save(userDTO);
    }

    public void deleteUser(UserDTO userDTO){
    userDAO.delete(userDTO);
    }

    public void updateUser (UserDTO userDTO){
    userDAO.update(userDTO);
    }

    public List<UserDTO> findAllUsers (){
    return userDAO.findAll();
    }

    public AutoDTO findAutoById (int id){
    return userDAO.findAutoById(id);
    }

}
