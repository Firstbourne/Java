public class Animal {
    private boolean predator;
    private String name;

    public Animal(boolean predator, String name) {
        this.predator = predator;
        this.name = name;
    }

    public String getType() {
        return predator == true ? "Predator" : "Herbivore";
    }

    public String getName() {
        return name;
    }

    public void voice() {
        System.out.println("Makes some noise");
    }
}
