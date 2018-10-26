package assert_test;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author licunzhi
 * @desc AssertDemo 测试
 * @date 2018-10-11
 */
public class AssertDemo extends Assert {

    @Test
    public void testAssertDemoOne() {
        //test data
        int num= 5;
        String temp= null;
        String str= "Junit is working fine";

        //check for equality
        assertEquals("Junit is working fine", str);
        assertEquals("Junit is working fine not ok", str);

        //check for false condition
        assertFalse(num > 6);

        //check for not null value
        assertNotNull(str);
    }
}
