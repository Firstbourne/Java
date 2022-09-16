public class main {
    public static void main(String[] args) {
        Animal animal = new Animal(true, "miska");
        System.out.println(animal.getType());
        System.out.println(animal.getName());
        animal.voice();
    }
}
