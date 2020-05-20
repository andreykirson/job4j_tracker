package ex;

import ex.ElementNotFoundException;

public class FindEl {
    public static int indexOf(String[] values, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (String value : values) {
            if (value.equals(key)) {
                rsl = 1;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("The element " + key + " didn't find");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] x = new String[] {"a", "b", "c", "d", "e" };
            int result = indexOf(x, "a");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
