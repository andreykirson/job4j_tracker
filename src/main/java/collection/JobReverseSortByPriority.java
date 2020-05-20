package collection;

import java.util.Comparator;

public class JobReverseSortByPriority implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return Integer.compare(second.getPriority(), first.getPriority());
    }
}
