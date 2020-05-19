package collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobSortByName().thenComparing(new JobSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
        System.out.println(rsl);
    }

    @Test
    public void whenCompatorByProrityAndName() {
        Comparator<Job> cmpNamePriority = new JobSortByPriority().thenComparing(new JobSortByName());
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("B", 0)
        );
        assertThat(rsl, lessThan(0));
        System.out.println(rsl);
    }

    @Test
    public void whenCompatorByNameAndDescPrority() {
        Comparator<Job> cmpNamePriority = new JobSortByName().thenComparing(new JobReverseSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("A", 1)
        );
        assertThat(rsl, greaterThan(0));
        System.out.println(rsl);
    }

    @Test
    public void whenCompatorByProrityAndDescName() {
        Comparator<Job> cmpNamePriority = new JobSortByPriority().thenComparing(new JobReversSortByName());
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("B", 0)
        );
        assertThat(rsl, greaterThan(0));
        System.out.println(rsl);
    }



    @Test
    public void PrintResult() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 2),
                new Job("A", 4),
                new Job("A", 5),
                new Job("A", 2)
        );
        Collections.sort(jobs, new JobSortByPriority().thenComparing(new JobReversSortByName()));
        System.out.println(jobs.toString());

        Collections.sort(jobs, new JobSortByName().thenComparing(new JobSortByPriority()));
        System.out.println(jobs.toString());

        Collections.sort(jobs, new JobSortByPriority().thenComparing(new JobSortByName()));
        System.out.println(jobs.toString());

        Collections.sort(jobs, new JobSortByName().thenComparing(new JobReverseSortByPriority()));
        System.out.println(jobs.toString());

        Collections.sort(jobs, new JobReversSortByName().thenComparing(new JobReverseSortByPriority()));
        System.out.println(jobs.toString());

    }
}

