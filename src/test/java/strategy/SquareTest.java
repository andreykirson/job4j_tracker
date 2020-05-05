package strategy;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;

public class SquareTest {
    @Test
        public void whenDrawSquare() {
            Square square = new Square();
            assertThat(
                    square.draw(),
                    is(
                            new StringJoiner(System.lineSeparator())
                                    .add("+++++++")
                                    .add("+     +")
                                    .add("+     +")
                                    .add("+++++++")
                                    .toString()
                    )
            );
        }
}

