package DTO_DB_model;

import javax.persistence.*;
import java.util.List;
//https://javarush.ru/groups/posts/hibernate-java
@Entity//сущность-тело(сурс, отношение ОДИН-ко многим)
@Table(name = "usershib")
public class UserDTO {
    @Id//в этих DTO id не сетится
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name="name")
    private int age;
    @OneToMany(mappedBy = "user",/*это имя поля
                в классе-хвосте(таргете) - AutoDTO*/
                cascade = CascadeType.ALL,
                orphanRemoval = true/*почитать
                Настройка orphanRemoval
                вполне хорошо переводится с английского —
                "удалять сирот".
                Если мы удалим юзера из БД —
                все связанные с ним автомобили также будут удалены. */)
    //В реальной базе такой колонки нет,
    // мы просто осуществляем связь с объектами-хвостами(таргетами),
    // при помощи листа
    private List<AutoDTO> autos;

    //МЕТОД ДЛЯ МОДИФИКАЦИИ DTO ИЗ main()
    public void addAuto(AutoDTO autoDTO) {
        autoDTO.setUser(this);//????
        autos.add(autoDTO);//добавляем в список авто
    }

    //МЕТОД ДЛЯ МОДИФИКАЦИИ DTO ИЗ main()
    public void removeAuto(AutoDTO autoDTO){
        autos.remove(autoDTO);
    }

//    Чтобы класс мог быть Entity, к нему предъявляются следующие требования:
//    Должен иметь пустой конструктор (public или protected);
//    Не может быть вложенным, интерфейсом или enum;
//    Не может быть final и не может содержать final-полей/свойств;
//    Должен содержать хотя бы одно @Id-поле.
    public UserDTO(){}

//    При этом Entity может:
//    Содержать непустые конструкторы;
//    Наследоваться и быть наследованным;
//    Содержать другие методы и реализовывать интерфейсы.

    public UserDTO(String name, int age, List<AutoDTO> autos) {
        this.name = name;
        this.age = age;
        this.autos = autos;
    }

    //COOKING PLATE CODE





    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAutos(List<AutoDTO> autos) {
        this.autos = autos;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<AutoDTO> getAutos() {
        return autos;
    }


}
