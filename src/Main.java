public class Main {
    public static void main(String[] args) {
        Range range = new Range(1, false, 10, true);

        System.out.println(range.contains(3));
        System.out.println(range.contains(7));

        System.out.println(range.size());

        System.out.println(range.values());

        System.out.println(range.endPoints());

        Range exempleRange = new Range(6, false, 11, false);
        System.out.println(range.contains(exempleRange));

        System.out.println(range.intersect(exempleRange));
    }
}
