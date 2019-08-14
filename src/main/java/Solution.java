import java.util.concurrent.Callable;

public class Solution {

    private static boolean once;

    private void foo() {
        if (!once) {
            once = new Callable<Boolean>() {
                @Override
                public Boolean call() {
                    System.out.println("once");
                    return true;
                }
            }.call();
        }
        System.out.println("foo");
    }

    public static void main(String[] args) {
        System.out.println("Create the first instance of Solution");
        Solution soln1 = new Solution();
        System.out.println("call foo for the first time");
        soln1.foo();
        System.out.println("call foo for the seond time");
        soln1.foo();

        System.out.println("Create another instance of Solution");
        Solution soln2 = new Solution();
        System.out.println("call foo for the first time on solution2");
        soln2.foo();
        System.out.println("call foo for the second time on solution2");
        soln2.foo();
    }

}
