package daelim.spring_ch06;

public class ImpleCalculator implements Calculator{
    @Override
    public long factorial(long num) {
        //long start = System.currentTimeMillis();

        long result =1;
        for(long i = 1; i <= num; i++){
            result *= i;
        }
/*
        long end = System.currentTimeMillis();
        System.out.printf("ImpleCaculator.fatorial(%d) 실행시간= %d\n", num, (end-start));

 */
        return result;
    }

}
