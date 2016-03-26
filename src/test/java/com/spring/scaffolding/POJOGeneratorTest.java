package com.spring.scaffolding;

import com.spring.scaffolding.pojo.POJOGenerator;
import com.squareup.javapoet.JavaFile;
import org.junit.Test;

/**
 * Description of com.spring.scaffolding
 *
 * @author evgen1000end
 * @since 26.03.2016
 */
public class POJOGeneratorTest {

    @Test
    public void firstTest() throws ClassNotFoundException{

        POJOGenerator generator = new POJOGenerator();
        JavaFile javaFile = generator.generateByExpression("Person#String name; Integer age", "ru.demkin");
        System.out.println(javaFile);

    }
}
