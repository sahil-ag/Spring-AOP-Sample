package com.sample.aspect;

import com.sample.annotations.SampleAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import javax.inject.Named;

@Aspect
@Named("sampleAspect")
public class SampleAspect {
    private static final String PUBLIC_METHOD_IN_SAMPLE_ASPECT_BEANS = "com.sample.pointcut.SamplePointCuts.publicMethodInSampleBeans()";

    @Around(PUBLIC_METHOD_IN_SAMPLE_ASPECT_BEANS)
    public Object processAroundPointCut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return processAspect(proceedingJoinPoint);
    }

    private Object processAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(proceedingJoinPoint.toLongString());
        return proceedingJoinPoint.proceed();
    }

    private final SampleAnnotation getSampleAnnotationFromProceedingJoinPoint(ProceedingJoinPoint proceedingJoinPoint) {
        SampleAnnotation sampleAnnotation = getSampleAnnotationAtClassLevel(proceedingJoinPoint);
        if (sampleAnnotation == null) {
            sampleAnnotation = getSampleAnnotationAtMethodLevel(proceedingJoinPoint);
        }
        if (sampleAnnotation == null) {
            throw new IllegalStateException("Couldn't find Sample Annotation");
        }
        return sampleAnnotation;
    }

    private final SampleAnnotation getSampleAnnotationAtClassLevel(ProceedingJoinPoint proceedingJoinPoint) {
        return proceedingJoinPoint.getTarget().getClass().getAnnotation(SampleAnnotation.class);
    }

    private final SampleAnnotation getSampleAnnotationAtMethodLevel(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        try {
            return proceedingJoinPoint.getTarget().getClass().getMethod(methodName, parameterTypes).getAnnotation(
                    SampleAnnotation.class);
        } catch (NoSuchMethodException | SecurityException e) {
            return null;
        }
    }
}
