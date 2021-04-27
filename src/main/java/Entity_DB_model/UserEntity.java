package Entity_DB_model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//https://javarush.ru/groups/posts/hibernate-java
@Entity//сущность-тело(сурс, отношение ОДИН-ко многим)
@Table(name = "usershib")
public class UserEntity {
    @Id//в этих DTO id не сетится
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name="age")
    private int age;


    @OneToMany(mappedBy = "user", /*это имя поля в классе-хвосте(таргете) - AutoDTO*/
                cascade = CascadeType.ALL,
                fetch =FetchType.LAZY)/*orphanRemoval = trueпочитать
                Настройка orphanRemoval
                вполне хорошо переводится с английского —
                "удалять сирот".
                Если мы удалим юзера из БД —
                все связанные с ним автомобили также будут удалены. */
    //В реальной базе такой колонки нет,
    // мы просто осуществляем связь с объектами-хвостами(таргетами),
    // при помощи листа
    private List<AutoEntity> autos;

    //МЕТОД ДЛЯ МОДИФИКАЦИИ DTO ИЗ main()
    public void addAuto(AutoEntity autoDTO) {
        autoDTO.setUser(this);//????
        autos.add(autoDTO);//добавляем в список авто
    }

    //МЕТОД ДЛЯ МОДИФИКАЦИИ DTO ИЗ main()
    public void removeAuto(AutoEntity autoDTO){
        autos.remove(autoDTO);
    }

//    Чтобы класс мог быть Entity, к нему предъявляются следующие требования:
//    Должен иметь пустой конструктор (public или protected);
//    Не может быть вложенным, интерфейсом или enum;
//    Не может быть final и не может содержать final-полей/свойств;
//    Должен содержать хотя бы одно @Id-поле.

    public UserEntity(){}

//    При этом Entity может:
//    Содержать непустые конструкторы;
//    Наследоваться и быть наследованным;
//    Содержать другие методы и реализовывать интерфейсы.

    public UserEntity(String name, int age) {
        this.name = name;
        this.age = age;
        autos = new ArrayList<>();//ВАЖНАЯ ЧАСТЬ!
    }



    //COOKING PLATE CODE

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAutos(List<AutoEntity> autos) {
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

    public List<AutoEntity> getAutos() {
        return autos;
    }


}
