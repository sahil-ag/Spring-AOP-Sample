/*
 * Copyright (c) 2018 Arcesium LLC. All rights reserved.
 *
 * This software is the confidential and proprietary information of Arcesium LLC. ("Confidential Information"). You
 * shall not disclose such Confidential Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with Arcesium LLC.
 */
package com.sample.aspect;

import com.sample.config.AspectsConfig;
import com.sample.testClasses.testClasses.ITest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * @author agarsahi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AspectsConfig.class})
@ActiveProfiles({"aspects"})
public class SampleAspectIT {

    @Inject
    private ApplicationContext context;

    @Test
    public void testAnnotedMethod() throws Exception {

        ITest bean = (ITest) context.getBean("baseMethod");
        bean.getTestName();
    }

    @Test
    public void testAnnotedBean() throws Exception {

        ITest bean = (ITest) context.getBean("baseClass");
        bean.getTestName();
    }


    @Test
    public void testAnnotedBeanExtended() throws Exception {

        ITest bean = (ITest) context.getBean("baseClassExtended");
        bean.getTestName();
    }

}
