package top.ytazwc.optional;

/**
 * @author 花木凋零成兰
 * @title Girl
 * @date 2024/4/27 17:55
 * @package top.ytazwc.optional
 * @description TODO
 */
public class Girl {
    private String name;

    public Girl() {
    }
    public Girl(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
