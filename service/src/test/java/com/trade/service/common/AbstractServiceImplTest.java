package com.trade.service.common;

import com.trade.service.helper.CommonTestHelper;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.runner.RunWith;


@RunWith(EasyMockRunner.class)
public abstract class AbstractServiceImplTest extends EasyMockSupport {

    private CommonTestHelper helper = new CommonTestHelper();

    public AbstractServiceImplTest() {
    }

    public CommonTestHelper getHelper() {
        return helper;
    }
}
