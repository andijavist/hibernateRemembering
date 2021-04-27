package DAO;

import DTO_DB_model.AutoDTO;
import DTO_DB_model.UserDTO;
import hiberUtilite.HiberSessionFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

//КЛАСС ОТВЕЧАЮЩИЙ ЗА ДОСТУП К БД

//почему нельзя использовать статическую сессию?
//написать ответ --
public class UserDAO {

    //в отличии от Spring Data, где игра идет через репозитории
    //здесь нужно создавать явный DAO объект, где будут прописаны
    //все методы взаимодействия DTO c БД
    public UserDTO findById(int id){
        //метод поиска по id
        return HiberSessionFactoryBuilder./*созданный нами объект,
        порождающий фабрику сессий hibernate*/
                getSessionFactory()./*
                получение сессии hibernate*/
                openSession().//открытие сессии
                get(UserDTO.class,id);//применение метода hibernate
        //ВАЖНО!смотри доку! в аргументах лежит класс-Entity,
        // плюс аргумент метода findById - int id
        }
    public void save(UserDTO userDTO){
        //метод сохранения в базу данных
        Session/*порождение сессии Hibernate*/
                session = HiberSessionFactoryBuilder
                .getSessionFactory()
                .openSession();
                //ДАЛЬШЕ ПРИМЕНЕНИЕ ТРАНЗАКЦИИ HIBERNATE!
                //ВАЖНО! TRANSACTION MANAGER не настроен??
        Transaction tx1 = session.beginTransaction();//обозначаем начало транзакции
        session.save(userDTO);//метод hibernate!
        tx1.commit();//обозначаем место коммита транзакции
        session.close();//ВАЖНО! ЗДЕСЬ МЫ СЕССИЮ ЗАКРЫЛИ! В ОТЛИЧИИ ОТ метода findBYId
        //почему?
    }

    public  void update(UserDTO userDTO){
        //метод обновления значение DTO
        Session session = HiberSessionFactoryBuilder.getSessionFactory().openSession();
        Transaction tx2 = session.beginTransaction();
        session.update(userDTO);
        tx2.commit();
        session.close();
    }

    public  void delete(UserDTO userDTO){
        //метод удаления DTO
        Session session = HiberSessionFactoryBuilder.getSessionFactory().openSession();
        Transaction tx3 = session.beginTransaction();
        session.delete(userDTO);
        tx3.commit();
        session.close();
    }
    public AutoDTO findAutoById (int id){
        return HiberSessionFactoryBuilder
                .getSessionFactory()
                .openSession()
                .get(AutoDTO.class,id);
        //почему не закрываем сессию?
    }
    public List<UserDTO> findAll() {
        List<UserDTO> listOfUsers =
                (List <UserDTO>)//попробовать без кастинга
                 HiberSessionFactoryBuilder.getSessionFactory()
                .openSession()
                .createQuery("select name from usershib").list();
    return listOfUsers;
        //почему не закрываем сессию?
    }



}
