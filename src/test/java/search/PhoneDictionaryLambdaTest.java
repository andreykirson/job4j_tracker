package search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryLambdaTest {
    @Test
    public void whenFindByName() {
        PhoneDictionaryLambda phones = new PhoneDictionaryLambda();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.findLambda("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

}