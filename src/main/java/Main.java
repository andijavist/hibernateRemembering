import Entity_DB_model.AutoEntity;
import Entity_DB_model.UserEntity;
import service_layer.UserDTOService;

public class Main {
    public static void main(String[] args) {
        UserEntity user = new UserEntity("Степан",20);
        AutoEntity auto = new AutoEntity("Merc","Черная");
        UserDTOService userDTOService = new UserDTOService();
        auto.setUser(user);//действия внутри main вместо явных DTO манипуляций с autoEntity
        user.addAuto(auto);//действия вместо явных DTO манипуляций с autoEntity
        userDTOService.saveUser(user);
        AutoEntity ford = new AutoEntity("Ford", "Белая");
        ford.setUser(user);
        user.addAuto(ford);
        userDTOService.updateUser(user);
        user.setName("Pes");
        user.setAge(150);
        userDTOService.updateUser(user);
        userDTOService.deleteUser(user);

    }
}
