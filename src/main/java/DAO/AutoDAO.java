package DAO;

import DTO_DB_model.AutoDTO;
import hiberUtilite.HiberSessionFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AutoDAO {
    public AutoDTO findById(int id) {
        //метод поиска по id
        return HiberSessionFactoryBuilder.
                getSessionFactory().
                openSession().
                get(AutoDTO.class, id);
    }

    public void save(AutoDTO autoDTO) {
        //метод сохранения в базу данных
        Session session = HiberSessionFactoryBuilder
                .getSessionFactory()
                .openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(autoDTO);
        tx1.commit();
        session.close();
    }

    public void update(AutoDTO autoDTO) {
        //метод обновления значение DTO
        Session session = HiberSessionFactoryBuilder.getSessionFactory().openSession();
        Transaction tx2 = session.beginTransaction();
        session.update(autoDTO);
        tx2.commit();
        session.close();
    }

    public void delete(AutoDTO autoDTO) {
        //метод удаления DTO
        Session session = HiberSessionFactoryBuilder.getSessionFactory().openSession();
        Transaction tx3 = session.beginTransaction();
        session.delete(autoDTO);
        tx3.commit();
        session.close();
    }}
