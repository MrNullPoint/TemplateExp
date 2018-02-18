/**
 * 具体实现模板中的抽象方法，展示字符串
 */
public class DisplayString extends DisplayTemplate {

    private String str;

    public DisplayString(String str) {
        this.str = str;
    }

    private void printLine() {
        for(int i = 0 ; i < str.length(); i++) {
            System.out.print("+");
        }
        System.out.println();
    }

    @Override
    public void print() {
        System.out.println(str);
    }

    @Override
    public void begin() {
        printLine();
    }

    @Override
    public void end() {
        printLine();
    }
}
