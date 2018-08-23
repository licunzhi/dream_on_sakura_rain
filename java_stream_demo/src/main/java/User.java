/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-23
 */
public class User {

    private String id;
    private String name;
    private int sex;
    private int age;
    private double salary;

    public User() {
    }

    public User(String id, String name, int sex, int age, double salary) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", sex=" + sex + ", age=" + age + ", salary="
                        + salary + '}';
    }
}
