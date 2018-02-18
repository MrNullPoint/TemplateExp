/**
 * 抽象类 DisplayTemplate
 */
public abstract class DisplayTemplate {

    public abstract void print();
    public abstract void begin();
    public abstract void end();

    //  调用抽象方法组成模板
    public final void display() {
        begin();
        for(int i = 0 ; i < 10 ; i++) {
            print();
        }
        end();
    }
}
