public class main {
    public static void main(String[] args) {
        Clocks clocks = new Clocks();
        clocks.setTime(25, 61);
        clocks.setPrice(100);
        clocks.setMark("OOO auction");
        clocks.printTime();
        clocks.addTime(23, 59);
        clocks.printTime();
        System.out.println(clocks.getMark());
        System.out.println(clocks.getPrice());
    }
}
