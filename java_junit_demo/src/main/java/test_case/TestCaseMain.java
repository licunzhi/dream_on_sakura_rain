package test_case;

import assert_test.AssertTests;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * @author licunzhi
 * @desc 测试TestCaseMain主函数
 * @date 2018-10-11
 */
public class TestCaseMain {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(AssertTests.class);
        result.getFailures().forEach(failure -> System.out.println(failure.toString()));
        System.out.println(result.wasSuccessful());

        result = JUnitCore.runClasses(TestCaseDemo.class);
        result.getFailures().forEach(failure -> System.out.println(failure.toString()));
        System.out.println(result.wasSuccessful());
    }
}
