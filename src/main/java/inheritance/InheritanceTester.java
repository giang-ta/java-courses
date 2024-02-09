package inheritance;

public class InheritanceTester {
    public static void main(String[] args) {
        Person person = new Person();
        Employee employee = new Employee();
        Square square = new Square();
        square.setLength(25);
        square.calculatePerimeter();
    }
}
