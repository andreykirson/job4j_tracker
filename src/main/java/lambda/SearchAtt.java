package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;


public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter(List<Attachment> attachments, Predicate<Attachment> predicate)
    {
        List<Attachment> result = new ArrayList<>();
        for (Attachment att:attachments)
            if (predicate.test(att))
                result.add(att);
        return result;
    }

}
