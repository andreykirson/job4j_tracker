package lambda;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Group {

    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream().flatMap(e -> e.getUnits().stream()
                .map(x -> new Holder(x, e.getName())))
                .collect(Collectors.groupingBy(el -> el.key, // определяем группировку
                        Collector.of(
                                HashSet::new,
                                (set, name) -> set.add(name.value), // как добавлять данные.
                                (left, right) -> {
                                    left.addAll(right);
                                    return left;
                                } // для агрегации.
                        )
                        )
                );
    }

        static class Holder {
            String key, value;

            Holder(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }

}









