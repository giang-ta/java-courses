package inheritance;

public class Zoo {
    public static void main(String[] args) {
        Dog rocky = new Dog();
        rocky.fetch();
        rocky.makeSound();

        Animal sasha = new Dog();
        sasha.makeSound();

        sasha = new Cat();
        sasha.makeSound();
        ((Cat)sasha).scratch();

        feed(rocky);
        feed(sasha);
    }
    public static void feed(Animal animal) {
        if (animal instanceof Cat) {
            System.out.println("It's a cat");
        }
        else {
            System.out.println("It's a dog");
        }
    }
}
