package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static lambda.SearchAtt.filter;

public class AttachmentSort {

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator comparatorSize =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(comparatorSize);
        System.out.println(attachments);

        Comparator<Attachment> comparatorName =  new Comparator<Attachment>() {
               @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        attachments.sort(comparatorName);
        System.out.println(attachments);


        List attachmentsNameFilter = filter(attachments, (Attachment att) -> att.getName().equals("image 1"));
        System.out.println(attachmentsNameFilter);

        List attachmentsSizeFilter = filter(attachments, (Attachment att) -> att.getSize() < 100);
        System.out.println(attachmentsSizeFilter);

    }


}