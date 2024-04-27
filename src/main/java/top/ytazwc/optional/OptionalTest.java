package top.ytazwc.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author 花木凋零成兰
 * @title OptionalTest
 * @date 2024/4/27 17:59
 * @package top.ytazwc.optional
 * @description 测试Optional类常用方法
 */
public class OptionalTest {
    @Test
    public void test1() {
        Girl girl = new Girl();
        // Optional.of(T t) : 创建一个 Optional 实例，t必须非空
        Optional<Girl> optionalGirl = Optional.of(girl);
    }
    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;
        // Optional.ofNullable(T t)：t可以为null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        // T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象
        Girl girlOrElse = optionalGirl.orElse(new Girl("赵丽颖"));
        System.out.println(girlOrElse);
    }

    // 获取女孩的名字
    public String getGirlName(Boy boy) {
        // 使用Optional前
        // 需要判断空值
        // return boy.getGirl().getName();

        // 使用Optional后
        // 包装boy 避免空
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        // 求Boy的实体对象 此时得到的实例必不为空
        Boy orElseBoy = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));
        // 得到girl实例
        Girl girl = orElseBoy.getGirl();
        // 包装girl 避免空
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        // 返回得到的Girl 必不为空
        Girl orElseGirl = girlOptional.orElse(new Girl("古力娜扎"));
        return orElseGirl.getName();
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
        String girlName = getGirlName(null);
        System.out.println(girlName);
    }
}
