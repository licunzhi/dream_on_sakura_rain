package com.sakura.structuralPatterns.CompositePattern;

/**
 * @author licunzhi
 * @desc the demo shows the test results
 * @date 2018-09-01
 */
public class CompositePatternDemo {
    public static void main(String[] args) {
        /**
         * conclusion :
         *  CompositePattern is to deify a Object
         *  the object may have param can include other object
         *  the object can be itself or other
         *  anf the in the param object may also have another object
         *
         *  just for loop can not have the ending
         *
         */

        //create different kind people
        Employee CEO = new Employee("John","CEO", 30000);

        Employee headSales = new Employee("Robert","Head Sales", 20000);

        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //打印该组织的所有员工
        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
