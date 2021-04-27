package hiberUtilite;

import DTO_DB_model.AutoDTO;
import DTO_DB_model.UserDTO;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//https://javarush.ru/groups/posts/hibernate-java
//КЛАСС, ПОРОЖДАЮЩИЙ ФБРИКУ СЕССИЙ HIBERNATE
public class HiberSessionFactoryBuilder {
    private static SessionFactory sessionFactory;

    //??
    private HiberSessionFactoryBuilder() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            try {
                //конфигурация hibernate//ОЧЕНЬ НЕОПНЯТНАЯ
                /////////////////////////
                //configure()- здесь зачитывается Hibernate.cfg.xml
                //Hibernate.cfg.xml - стартовая конфигурация Hibernate, АНАЛОГ PROPERTY-файла из бабпки RESOURCES
                //ВНИМАНИЕ! Hibernate.cfg.xml надо запилить руками, но название дефолтовое (см. доку)
                // В нем параметры соединения с БД,
                // и специальный параметр show_sql.
                // Он нужен для того, чтобы все sql-запросы,
                // которые hibernate будет выполнять к нашей БД, выводились в консоль.
                Configuration conf=new Configuration().configure();

                //регистрация Entity (явно добавляем аннотированые классы)
                conf.addAnnotatedClass(UserDTO.class);
                conf.addAnnotatedClass(AutoDTO.class);

                //Builder for standard ServiceRegistry instances.
                // создается билдер для реестра сервисов
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()/*Create a default builder.*/
                                                           .applySettings(conf.getProperties()/* получает проперти из файла Hibernate.cfg.xml*/);
                sessionFactory = conf.buildSessionFactory(builder.build()/*Build the StandardServiceRegistry.
                                                                           создается реестр сервисов*/);
            } catch (Exception e) {
                System.out.println("Исключение - "+ e);
            }
        return sessionFactory;
    }
}