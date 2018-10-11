package assert_test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * @author licunzhi
 * @desc 测试编写类
 * @date 2018-10-11
 */
public class AssertMain {
    public static void main(String[] args) {

        /**
         * in class AssertDemo use the Assert.class methods
         *      - assertEquals
         *      - assertFalse
         *      - assertNotNull
         * in this class have other methods, read the method name we can easily understand
         *
         */
        Result result = JUnitCore.runClasses(AssertDemo.class);
        result.getFailures().forEach(failure -> System.out.println(failure.toString()));
        System.out.println(result.wasSuccessful());
    }
}
