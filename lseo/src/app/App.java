package app;

public class App {
    public static void main(String[] args) throws Exception {
        boolean ascending = true;
        LSEO<Integer> lseo = new LSEO<Integer>(ascending);

        System.out.println(lseo);
        System.out.println("This list has " + lseo.length() + " elements");
    }
}