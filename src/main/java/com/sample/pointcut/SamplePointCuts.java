/*
 * Copyright (c) 2018 Arcesium LLC. All rights reserved.
 *
 * This software is the confidential and proprietary information of Arcesium LLC. ("Confidential Information"). You
 * shall not disclose such Confidential Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with Arcesium LLC.
 */
package com.sample.pointcut;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author agarsahi
 */
public class SamplePointCuts {

    @Pointcut("@within(com.sample.annotations.SampleAnnotation)")
    private static void beansWithSampleAnnotationWithin() {
    }

    @Pointcut("@annotation(com.sample.annotations.SampleAnnotation)")
    private static void methodsWithSampleAnnotation() {
    }

    @Pointcut("beansWithSampleAnnotationWithin() || methodsWithSampleAnnotation()")
    public static void publicMethodInSampleBeans() {
    }

}
