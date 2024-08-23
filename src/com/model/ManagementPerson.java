package com.model;

import java.util.Comparator;
import java.util.Arrays;

public class ManagementPerson {
    /**
     * This is method used to input information of Person
     *
     * @param name
     *            of Person
     * @param address
     *            of Person
     * @param sSalary
     *            of Person
     * @return person
     * @throws Exception "Salary is greater than zero"
     *                   "You must input Salary."
     *                   "You must input digit.
     */
    public Person inputPersonInfo(String name, String address, String sSalary) throws Exception {
        double salary = 0;
        try {
            if (sSalary == null) throw new Exception("You must input salary");
            salary = Double.parseDouble(sSalary);
            if (salary <= 0){
                throw new Exception("Salary must be greater than zero");
            }
        } catch (NumberFormatException e) {
            throw new Exception("You must input digit");
        };
        return new Person(name, address, salary);
    }

    /**
     * This is method used to display information of Person you have entered.
     *
     * @param person
     *            Object
     */
    public void displayPersonInfo(Person person) {
        System.out.println("Information of Person you have entered:\n" +
                "Name:" + person.getName() +"\n" +
                "Address:" + person.getAddress() +"\n" +
                "Salary:"+ person.getSalary() + "\n");
    }

    /**
     * This is method used to sort Person entered by gradually increased of
     * Salary.
     *
     * @param people
     *            of Array Person
     * @return Person Object
     * @throws Exception "Can't Sort Person"
     */
    public Person[] sortBySalary(Person[] people) throws Exception {
        Person[] result = Arrays.copyOf(people, people.length, Person[].class);
        try {
            result = Arrays.stream(people).sorted(Comparator.comparingDouble(Person::getSalary)).toArray(Person[]::new);
        } catch (Exception e) {
            throw new Exception("Can't sort people by salary");
        }
        return result;
    }
}

