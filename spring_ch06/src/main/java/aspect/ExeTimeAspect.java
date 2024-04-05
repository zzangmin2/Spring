package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ExeTimeAspect {

    //Pointcut: 공통기능을 적용할 대상 지정
    @Pointcut("execution(public * daelim.spring_ch06..*(..))")
    private void publicTarget(){

    }

    // Advice: AroundAdvice
    @Around("publicTarget()")
    public Object main(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.nanoTime();

        try{
            Object result = joinPoint.proceed();
            return result;
        }finally {
            long end = System.nanoTime();

            Signature sig = joinPoint.getSignature();
            //getTarget(): 대상 객체
            //getArgs(): 파라미터
            //sig.getName() : 호출하는 메서드의 이름을 구함
            System.out.printf("%s.%s(%s) 실행시간: %d\n", joinPoint.getTarget().getClass(), sig.getName(), Arrays.toString(joinPoint.getArgs()),(end - start));
        }
    }
}
