package com.sample.testClasses.testClasses;

import org.springframework.beans.factory.BeanNameAware;

public interface ITest extends BeanNameAware {
    void setTestString(String testString);

    String getTestName();

}