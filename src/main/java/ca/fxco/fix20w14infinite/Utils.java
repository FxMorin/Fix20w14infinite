package ca.fxco.fix20w14infinite;

public class Utils {

    public static int posBound(int bound) {
        return bound < 1 ? Math.abs(bound)+1 : bound;
    }
}
