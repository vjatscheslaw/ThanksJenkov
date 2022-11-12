package tutorials.lambdas;

import java.util.concurrent.ThreadLocalRandom;

public interface Yabumba {
    void preent();

    static void prent() {
        System.err.println("Zumbabba");
    }

    default String ying() {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        return String.valueOf(tlr.nextDouble(100.0, 120.0)).transform(number -> "Number is: " + number);

    }

    default String jing() {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        return String.valueOf(tlr.nextBoolean()).transform(number -> "Bool is: " + number);

    }

}
