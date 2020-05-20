package strategy;

import java.util.StringJoiner;

public class Triangle implements Shape {
    public String draw() {
        StringJoiner pic = new StringJoiner(System.lineSeparator());
        pic.add("   +   ");
        pic.add("  +++  ");
        pic.add(" +++++ ");
        pic.add("+++++++");
        return pic.toString();
    }
}
