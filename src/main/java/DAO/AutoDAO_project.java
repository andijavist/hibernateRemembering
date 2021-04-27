package DAO;

import Entity_DB_model.AutoEntity;
import hiberUtilite.HiberSessionFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AutoDAO_project {
    public AutoEntity findById(int id) {
        //метод поиска по id
        return HiberSessionFactoryBuilder.
                getSessionFactory().
                openSession().
                get(AutoEntity.class, id);
    }

    public void save(AutoEntity autoEntity) {
        //метод сохранения в базу данных
        Session session = HiberSessionFactoryBuilder
                .getSessionFactory()
                .openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(autoEntity);
        tx1.commit();
        session.close();
    }

    public void update(AutoEntity autoEntity) {
        //метод обновления значение DTO
        Session session = HiberSessionFactoryBuilder.getSessionFactory().openSession();
        Transaction tx2 = session.beginTransaction();
        session.update(autoEntity);
        tx2.commit();
        session.close();
    }

    public void delete(AutoEntity autoEntity) {
        //метод удаления DTO
        Session session = HiberSessionFactoryBuilder.getSessionFactory().openSession();
        Transaction tx3 = session.beginTransaction();
        session.delete(autoEntity);
        tx3.commit();
        session.close();
    }}
