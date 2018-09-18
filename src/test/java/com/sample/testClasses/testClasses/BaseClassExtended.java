package com.sample.testClasses.testClasses;

import com.sample.annotations.SampleAnnotation;

import javax.inject.Named;

@Named("baseClassExtended")
@SampleAnnotation("test")
public class BaseClassExtended extends BaseClass {
}
