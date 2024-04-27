package top.ytazwc.optional;

/**
 * @author 花木凋零成兰
 * @title Boy
 * @date 2024/4/27 17:55
 * @package top.ytazwc.optional
 * @description TODO
 */
public class Boy {

    private Girl girl;
    public Boy() {
    }
    public Boy(Girl girl) {
        this.girl = girl;
    }
    public Girl getGirl() {
        return girl;
    }
    public void setGirl(Girl girl) {
        this.girl = girl;
    }

}
