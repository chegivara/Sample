public class Main {
    public static void main(String[] args) {
        Programming programming = new Programming();
        programming.setId(1);
        programming.setName("d");
        Programming programming2 = new Programming();
        programming.setId(12);
        programming.setName("Программирование на C#");
        System.out.println("hash programming " + programming.hashCode() );
        System.out.println("hash programming2 " + programming2.hashCode() );
    }
}
