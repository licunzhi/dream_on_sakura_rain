package test_case;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-10-11
 */
public class TestCaseDemo extends TestCase {

    protected double fValue1;
    protected double fValue2;

    @Before
    public void setUp() {
        fValue1= 2.0;
        fValue2= 3.0;
    }

    @Test
    public void testAdd() {
        //count the number of test cases
        System.out.println("No of Test Case = "+ this.countTestCases());

        //test getName
        String name= this.getName();
        System.out.println("Test Case Name = "+ name);

        //test setName
        this.setName("testNewAdd");
        String newName= this.getName();
        System.out.println("Updated Test Case Name = "+ newName);
    }

    //tearDown used to close the connection or clean up activities
    public void tearDown(  ) {
    }
}
