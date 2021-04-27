package DTO_DB_model;

import javax.persistence.*;

@Entity//сущность хвост(таргет, отношение многие к ОДНОМУ)
@Table(name = "autos")
public class AutoDTO {
    @Id//в этих ДТО id не сетится
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "color")
    private String color;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id"/*имя столбца сущности-таргета*/)
    //JoinColumn указывает,
    // через какой столбец
    // в таблице autos происходит
    // связь с таблицей usershib (тот самый внешний ключ
    private UserDTO user;//это foreign key




    //COOKING PLATE CODE
//    Чтобы класс мог быть Entity, к нему предъявляются следующие требования:
//    Должен иметь пустой конструктор (public или protected);
//    Не может быть вложенным, интерфейсом или enum;
//    Не может быть final и не может содержать final-полей/свойств;
//    Должен содержать хотя бы одно @Id-поле.
    public AutoDTO() {
    }

    //При этом Entity может:
    //Содержать непустые конструкторы;
    //Наследоваться и быть наследованным;
    //Содержать другие методы и реализовывать интерфейсы.

    public AutoDTO(String model, String color) {
        this.model = model;
        this.color = color;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
