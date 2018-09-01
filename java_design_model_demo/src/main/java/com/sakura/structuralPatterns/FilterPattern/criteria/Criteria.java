package com.sakura.structuralPatterns.FilterPattern.criteria;

import com.sakura.structuralPatterns.FilterPattern.person.Person;

import java.util.List;

/**
 * @author licunzhi
 * @desc the standard of filter
 * @date 2018-09-01
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
