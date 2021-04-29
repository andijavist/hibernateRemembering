package DAO;

import Entity_DB_model.AutoEntity;
import Entity_DB_model.UserEntity;
import hiberUtilite.HiberSessionFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//КЛАСС ОТВЕЧАЮЩИЙ ЗА ДОСТУП К БД

//почему нельзя использовать статическую сессию?
//написать ответ --
@Component
public class UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public UserEntity findById(int id) {
        //метод поиска по id
        return sessionFactory.
                openSession().
                get(UserEntity.class, id);
    }

    public void save(UserEntity userEntity) {
        //метод обновления значение Entity
        Session session = sessionFactory.getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.save(userEntity);
        tx1.commit();
        session.close();
    }

    public void update(UserEntity userEntity) {
        //метод обновления значение Entity
        Session session = sessionFactory.getCurrentSession();
        Transaction tx2 = session.beginTransaction();
        session.update(userEntity);
        tx2.commit();
        session.close();
    }

    public void delete(UserEntity userEntity) {
        //метод удаления Entity
        Session session = sessionFactory.getCurrentSession();
        Transaction tx3 = session.beginTransaction();
        session.delete(userEntity);
        tx3.commit();
        session.close();
    }

    public AutoEntity findAutoById(int id) {
        return sessionFactory.getCurrentSession().get(AutoEntity.class, id);
    }

    public List<UserEntity> findAll() {
        List<UserEntity> listOfUsers =
                (List<UserEntity>)//попробовать без кастинга
                        sessionFactory.getCurrentSession()
                                .createQuery("select name from usershib").list();
        return listOfUsers;
    }


}
