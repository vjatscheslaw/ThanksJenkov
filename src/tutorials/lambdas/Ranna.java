package tutorials.lambdas;

public class Ranna {

    public static void main(String... argz) {



        String[] names = { "Igor", "Vitaly", "Theoder" };

        String[] nonames = new String[32];

        System.arraycopy(names, 0, nonames, 13, 3);

        for (var n : nonames) System.out.println("Name is: " + n);


    }
}
