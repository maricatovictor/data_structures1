package app;

public class App {
    public static void main(String[] args) throws Exception {
        boolean ascending = true;
        LSEO<Integer> lseo = new LSEO<Integer>(ascending);
        lseo.insert(2);
        lseo.insert(3);
        lseo.insert(5);
        lseo.insert(9);
        lseo.insert(6);
        lseo.insert(1);
        lseo.insert(7);
        lseo.insert(5);
        lseo.remove(5);
        lseo.remove(7);
        lseo.remove(5);
        lseo.insert(8);
        System.out.println(lseo);
        System.out.println("This list has " + lseo.length() + " elements");
    }
}