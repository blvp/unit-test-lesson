package ru.dz.lessons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.dz.lessons.config.CoreConfig;
import ru.dz.lessons.config.DataSourceConfig;
import ru.dz.lessons.config.PersistenceConfig;

/**
 * Created by blvp on 13.03.15.
 */
@ContextConfiguration(classes = {
        CoreConfig.class,
        DataSourceConfig.class,
        PersistenceConfig.class
})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleTests {


    @Test
    public void shouldAlwaysPassed(){

    }
}
