package ex;

public class FindMaxLength {
    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (int index = 0; index < shops.length; index++) {
            String el = shops[index];
            if(el.length() > max) {
                max = el.length();
            } else if(shops[index] == null) {
                continue;
            }
        }
        System.out.println("Max length : " + max);
    }
}
