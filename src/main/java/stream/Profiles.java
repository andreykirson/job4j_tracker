package stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    List<Address> collect(List<Profile> profiles) {
        return(profiles.stream().map((profile) -> profile.getAddress()).collect(Collectors.toList()));
    }
}
