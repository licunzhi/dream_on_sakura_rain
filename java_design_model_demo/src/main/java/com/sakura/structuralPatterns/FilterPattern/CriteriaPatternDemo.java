package com.sakura.structuralPatterns.FilterPattern;

import com.sakura.structuralPatterns.FilterPattern.criteria.AndCriteria;
import com.sakura.structuralPatterns.FilterPattern.criteria.Criteria;
import com.sakura.structuralPatterns.FilterPattern.criteria.CriteriaFemale;
import com.sakura.structuralPatterns.FilterPattern.criteria.CriteriaMale;
import com.sakura.structuralPatterns.FilterPattern.criteria.CriteriaSingle;
import com.sakura.structuralPatterns.FilterPattern.criteria.OrCriteria;
import com.sakura.structuralPatterns.FilterPattern.person.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-01
 */
public class CriteriaPatternDemo {
    public static void main(String[] args) {
        /**
         * conclusion:
         *  CriteriaPattern is used filter collections by one or some criteria
         *
         *  in this demo, we create a interface named Criteria
         *  we can implement this interface and override the method
         *  different kind standards of filter we can create different class
         *
         *  in java8 stream operation has a method named filter
         *  just use the way to do
         */
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John","Male", "Married"));
        persons.add(new Person("Laura","Female", "Married"));
        persons.add(new Person("Diana","Female", "Single"));
        persons.add(new Person("Mike","Male", "Single"));
        persons.add(new Person("Bobby","Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons){
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                            +", Gender : " + person.getGender()
                            +", Marital Status : " + person.getMaritalStatus()
                            +" ]");
        }
    }
}
