/**
 * 实现模板中的抽象方法，展示字符
 */
public class DisplayChar extends DisplayTemplate{

    private char ch;

    public DisplayChar(char ch) {
        this.ch = ch;
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void begin() {
        System.out.print("<");
    }

    @Override
    public void end() {
        System.out.println(">");
    }

}
