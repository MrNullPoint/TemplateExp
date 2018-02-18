public class Main {
    public static void main(String[] args) {
        DisplayTemplate d1 = new DisplayChar('A');
        DisplayTemplate d2 = new DisplayString("Hello,World.");
        d1.display();
        d2.display();
    }
}
