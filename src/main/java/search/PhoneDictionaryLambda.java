package search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionaryLambda {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> findLambda(String key) {
        Predicate<Person> containName = person -> person.getName().contains(key);
        Predicate<Person> containSurName = person -> person.getSurname().contains(key);
        Predicate<Person> containAddress = person -> person.getAddress().contains(key);
        Predicate<Person> containPhone = person -> person.getPhone().contains(key);
        Predicate<Person> combine = containName.or(containSurName.or(containAddress.or(containPhone)));

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

}