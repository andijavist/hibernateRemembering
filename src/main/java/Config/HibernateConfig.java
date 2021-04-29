package Config;

import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan(basePackages = "DAO")//переделать, почему тут ссылка на DAO? разобраться - ответ= так как в SessionFactory будет поставляться СПРИНГОМ БИН LocalSessionFactoryBean sessionFactory
public class HibernateConfig {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";

    @Bean//БИН С ОПИСАНИЕМ ПОДКЛЮЧЕНИЯ К БД, почему аннотация Bean? разобраться
    public DataSource dataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl(URL);
        dataSource.setUsername(LOGIN);
        dataSource.setPassword(PASSWORD);
        //возвращает объект - ресурс
        return dataSource;
    }

    @Bean//БИН конфигурации и порождения фабрики сессий, аналог класса hiberUtilite.HiberSessionFactoryBuilder
        //возвращает СПРИНГОВЫЙ ТИП сеессии hibernate
        public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("Entity_DB_model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        //спринговая фабрика сессий
        return sessionFactory;
    }

    @Bean//объект настройки транзакций
        public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject()/*получает поле сессион фактори
        из обхекта LocalSessionFactoryBean sessionFactory */);
        return transactionManager;
    }

    //метод, конфигурирующий и порождающий объект проперти, аналог Hibernate.cfg.xml
    //НЕСПРИНГОВАЯ ХЭШТАБЛИЦА
    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", "none"); //стартовая стратегия заполнения БД - "ничего н еделать"
        hibernateProperties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect"); //диалект
        //возвращает типа хэштаблицу
        return hibernateProperties;
    }

}
