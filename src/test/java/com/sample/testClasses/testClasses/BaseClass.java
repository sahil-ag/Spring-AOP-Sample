package com.sample.testClasses.testClasses;

import com.sample.annotations.SampleAnnotation;

import javax.inject.Named;

@Named("baseClass")
public class BaseClass implements ITest {
    private String testString;

    public BaseClass() {
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
    public String getTestName() {
        return testString;
    }
}
