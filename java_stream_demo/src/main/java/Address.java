import java.util.Locale;
import java.util.Optional;

/**
 * @ClassName Address
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/07/19 09:52
 */
public class Address {
    private String color;
    private String years;

    private Location location;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public Optional<Location> getLocation() {
        return Optional.ofNullable(location);
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
