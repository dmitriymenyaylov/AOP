package org.example;

import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
@Aspect
public class AOP {
    @Autowired
    public void TestAOP(Convert convert) {
        this.convert = convert;
    }
    Convert convert;

    @Pointcut("@annotation(AnnotationMessage)")
    public void message(){
    }
    @Before("message()")
    public void runTest(JoinPoint joinPoint) {
        List messageList = Arrays.stream(joinPoint.getArgs()).collect(Collectors.toList());
        convert.convertToPdf(messageList.toString());
    }

}
