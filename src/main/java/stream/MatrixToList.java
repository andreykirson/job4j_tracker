package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream.of is generic,  Arrays.stream works with the primitive data type
 */

public class MatrixToList {

   public List<Integer> flatMatrix (Integer[][] data) {
       Stream<Integer[]> temp = Stream.of(data);
       return(temp.flatMap(Arrays::stream)
               .collect(Collectors.toList())
               );
   }
}
