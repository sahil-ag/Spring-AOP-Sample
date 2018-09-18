package com.sample.testClasses.testClasses;

import com.sample.annotations.SampleAnnotation;

import javax.inject.Named;

@Named("baseMethod")

public class BaseMethod implements ITest {
    private String testString;

    public BaseMethod() {
        setTestString("hello world");
    }

    @Override
    public void setTestString(String testString) {
        this.testString = testString;
    }

    @Override
    public void setBeanName(String name) {
        setTestString(name);
    }

    @Override
    @SampleAnnotation("test")
    public String getTestName() {
        return testString;
    }
}
