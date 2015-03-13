package ru.dz.lessons;

import junit.framework.TestCase;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

/**
 * Created by blvp on 13.03.15.
 */
@RunWith(Parameterized.class)
public class ParameterizedTests extends Assert {
    private final CharSequence testData;
    private final boolean expected;

    public ParameterizedTests(final CharSequence testData, final boolean expected) {
        this.testData = testData;
        this.expected = expected;
    }

    @Test
    public void testIsEmpty() {
        final boolean actual = StringUtils.isEmpty(testData);
        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static List<Object[]> isEmptyData() {
        return Arrays.asList(new Object[][]{
                {null, true},
                {"", true},
                {" ", false},
                {"some string", false},
        });
    }
}
