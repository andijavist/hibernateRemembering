package DAO;

import Entity_DB_model.AutoEntity;
import Entity_DB_model.UserEntity;
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
    public UserEntity findById(int id){
        //метод поиска по id
        return HiberSessionFactoryBuilder./*созданный нами объект,
        порождающий фабрику сессий hibernate*/
                getSessionFactory()./*
                получение сессии hibernate*/
                openSession().//открытие сессии
                get(UserEntity.class,id);//применение метода hibernate
        //ВАЖНО!смотри доку! в аргументах лежит класс-Entity,
        // плюс аргумент метода findById - int id
        }
    public void save(UserEntity userEntity){
        //метод сохранения в базу данных
        Session/*порождение сессии Hibernate*/
                session = HiberSessionFactoryBuilder
                .getSessionFactory()
                .openSession();
                //ДАЛЬШЕ ПРИМЕНЕНИЕ ТРАНЗАКЦИИ HIBERNATE!
                //ВАЖНО! TRANSACTION MANAGER не настроен??
        Transaction tx1 = session.beginTransaction();//обозначаем начало транзакции
        session.save(userEntity);//метод hibernate!
        tx1.commit();//обозначаем место коммита транзакции
        session.close();//ВАЖНО! ЗДЕСЬ МЫ СЕССИЮ ЗАКРЫЛИ! В ОТЛИЧИИ ОТ метода findBYId
        //почему?
    }

    public  void update(UserEntity userEntity){
        //метод обновления значение DTO
        Session session = HiberSessionFactoryBuilder.getSessionFactory().openSession();
        Transaction tx2 = session.beginTransaction();
        session.update(userEntity);
        tx2.commit();
        session.close();
    }

    public  void delete(UserEntity userEntity){
        //метод удаления DTO
        Session session = HiberSessionFactoryBuilder.getSessionFactory().openSession();
        Transaction tx3 = session.beginTransaction();
        session.delete(userEntity);
        tx3.commit();
        session.close();
    }
    public AutoEntity findAutoById (int id){
        return HiberSessionFactoryBuilder
                .getSessionFactory()
                .openSession()
                .get(AutoEntity.class,id);
        //почему не закрываем сессию?
    }
    public List<UserEntity> findAll() {
        List<UserEntity> listOfUsers =
                (List <UserEntity>)//попробовать без кастинга
                 HiberSessionFactoryBuilder.getSessionFactory()
                .openSession()
                .createQuery("select name from usershib").list();
    return listOfUsers;
        //почему не закрываем сессию?
    }



}
