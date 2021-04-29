import Config.SpringConfig;
import Entity_DB_model.AutoEntity;
import Entity_DB_model.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service_layer.UserEntityService;

public class Main {
    public static void main(String[] args) {
//        UserEntity user = new UserEntity("Степан",20);
//        AutoEntity auto = new AutoEntity("Merc","Черная");
//        UserEntityService userEntityService;
//        auto.setUser(user);//действия внутри main вместо явных DTO манипуляций с autoEntity
//        user.addAuto(auto);//действия вместо явных DTO манипуляций с autoEntity
//        userEntityService.saveUser(user);??
//        AutoEntity ford = new AutoEntity("Ford", "Белая");
//        ford.setUser(user);
//        user.addAuto(ford);
//        userEntityService.updateUser(user);
//        user.setName("Pes");
//        user.setAge(150);
//        userEntityService.updateUser(user);
//        userEntityService.deleteUser(user);

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig.class);
//        Comp computer = ctx.getBean(Comp.class);
//        UserEntity user = ctx.getBean(UserEntity.class);

    }
}
