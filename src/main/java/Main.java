import Entity_DB_model.UserEntity;
import hiberUtilite.HiberSessionFactoryBuilder;
import service_layer.UserDTOService;

public class Main {
    public static void main(String[] args) {
        UserEntity user = new UserEntity("Степан",20);
        UserDTOService userDTOService = new UserDTOService();
        userDTOService.saveUser(user);
        System.out.println(HiberSessionFactoryBuilder.getSessionFactory());
    }
}
