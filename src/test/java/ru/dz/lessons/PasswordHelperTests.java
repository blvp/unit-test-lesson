package ru.dz.lessons;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import ru.dz.lessons.service.PasswordHelper;

/**
 * Created by blvp on 13.03.15.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class PasswordHelperTests extends Assert{

    @Test
    public void testNullPassword(){
        String pwd = null;
        String salt = "123";

        String actual = PasswordHelper.generateHash(pwd, salt);

        assertEquals(null, actual);
    }

    @Test
    public void testEmptyPassword(){
        String pwd = "";
        String salt = "123";

        String actual = PasswordHelper.generateHash(pwd, salt);

        assertEquals("", actual);
    }
    @Test
    public void testRightGenerated(){
        String pwd = "123";
        String salt = "123";

        String actual = PasswordHelper.generateHash(pwd, salt);

        assertEquals("4297f44b13955235245b2497399d7a93", actual);
    }
}
