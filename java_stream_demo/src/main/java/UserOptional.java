import java.util.Optional;

/**
 * @ClassName UserOptional
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/07/19 09:52
 */
public class UserOptional {

    private String name;
    private String age;

    private Address address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
