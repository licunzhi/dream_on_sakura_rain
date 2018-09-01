package com.sakura.structuralPatterns.FilterPattern.criteria;

import com.sakura.structuralPatterns.FilterPattern.person.Person;

import java.util.List;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-01
 */
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
