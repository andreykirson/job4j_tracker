package pojo;

public class Library {
    public static void main (String[] args){
        Book first = new Book("Clean code", 100);
        Book second = new Book("Algorithm", 400);
        Book third = new Book("Structure of data", 1000);
        Book fourth = new Book("Refactoring", 500);

        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;

        for (int index = 0; index < books.length;  index++) {
            Book buff = books[index];
            System.out.println("Name of book " + buff.getName() + "count of pages " + buff.getCountPages());
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int index = 0; index < books.length;  index++) {
            Book buff = books[index];
            System.out.println("Name of book " + buff.getName() + "count of pages " + buff.getCountPages());
        }

        for (int index = 0; index < books.length;  index++) {
            Book buff = books[index];
            System.out.println("Name of book " + buff.getName() + "count of pages " + buff.getCountPages());
        }

        for (int index = 0; index < books.length;  index++) {
            Book buff = books[index];
            if (buff.getName().equals("Clean code")) {
                System.out.println("Name of book " + buff.getName() + "count of pages " + buff.getCountPages());
            }
        }

    }
}
