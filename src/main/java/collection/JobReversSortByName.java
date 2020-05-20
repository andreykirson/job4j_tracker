package collection;

import java.util.Comparator;

public class JobReversSortByName implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return second.getName().compareTo(first.getName());
    }

}
