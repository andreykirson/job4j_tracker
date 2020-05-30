package stream;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    Comparator<Profile> ascSort = Comparator.comparing(
            address -> address.getAddress().getCity()
    );

    List<Address> collect(List<Profile> profiles) {
        return(profiles.stream().sorted(ascSort)
                .distinct().map((profile) -> profile.getAddress())
                .collect(Collectors.toList()));
    }

}
