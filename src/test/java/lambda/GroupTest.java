package lambda;

import org.junit.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class GroupTest {

    @Test
    public void group() {
        Group group = new Group();

        List<Student> students = List.of(
                new Student("A", Set.of("Football", "Swimming")),
                new Student("B", Set.of("Football", "PowerLifting")),
                new Student("C", Set.of("Baseball", "Swimming")),
                new Student("D", Set.of("Football", "Carting")),
                new Student("E", Set.of("Box", "Swimming"))
        );

        Map<String, Set<String>> result = group.sections(students);

        assertThat(result.get("Swimming"), is(Set.of("A", "C", "E")));


    }

}