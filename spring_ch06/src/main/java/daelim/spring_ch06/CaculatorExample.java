package daelim.spring_ch06;

public class CaculatorExample {
    public static void main(String[] args) {
/*
        long start1 = System.currentTimeMillis();
        ImpleCaculator impleCaculator = new ImpleCaculator();
        long iResult = impleCaculator.factorial(4);
        long end1 = System.currentTimeMillis();
        System.out.printf("ImpleCaculator.factorial(%d) 실행시간 = %d\n", 4, (end1 - start1));
        System.out.println("ImpleCaculator: " + iResult);


        long start2 = System.currentTimeMillis();
        RecCaculator reCaculator = new RecCaculator();
        long recResult = reCaculator.factorial(4);
        long end2 = System.currentTimeMillis();
        System.out.printf("ImpleCaculator.factorial(%d) 실행시간 = %d\n", 4, (end2 - start2));
        System.out.println("RecCalculator:" + recResult);

 */

        ExeTimeCalculator calculator1 = new ExeTimeCalculator(new ImpleCalculator());
        long result1 = calculator1.factorial(4);
        ExeTimeCalculator calculator2 = new ExeTimeCalculator(new RecCalculator());
        long result2 = calculator2.factorial(4);

        System.out.println("calculator1: " + result1);
        System.out.println("calculator2: " + result2);

    }
}
