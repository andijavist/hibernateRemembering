package Entity_DB_model;

import javax.persistence.*;

@Entity//сущность хвост(таргет, отношение многие к ОДНОМУ)
@Table(name = "autos")
public class AutoEntity {
    @Id//в этих Entity id не сетится
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "color")
    private String color;

    //JoinColumn указывает,
    // через какой столбец
    // в таблице autos происходит
    // связь с таблицей usershib (тот самый внешний ключ)
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "user_id")/*имя столбца сущности-таргета*/
    private UserEntity user;//это foreign key




    //COOKING PLATE CODE
//    Чтобы класс мог быть Entity, к нему предъявляются следующие требования:
//    Должен иметь пустой конструктор (public или protected);
//    Не может быть вложенным, интерфейсом или enum;
//    Не может быть final и не может содержать final-полей/свойств;
//    Должен содержать хотя бы одно @Id-поле.
    public AutoEntity() {
    }

    //При этом Entity может:
    //Содержать непустые конструкторы;
    //Наследоваться и быть наследованным;
    //Содержать другие методы и реализовывать интерфейсы.

    public AutoEntity(String model, String color/*,UserEntity userEntity*/) {
        this.model = model;
        this.color = color;
//        this.user=userEntity;
    }

    public int getId() {
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
