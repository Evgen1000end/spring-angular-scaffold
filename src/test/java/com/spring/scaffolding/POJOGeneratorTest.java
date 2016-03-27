package com.spring.scaffolding;

import com.spring.scaffolding.controllers.ControllerGenerator;
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

    private final static String expression = "Person#String name; Integer age";
    private final static String _package = "ru.demkin";

    @Test
    public void pojoTest() throws ClassNotFoundException{

        POJOGenerator generator = new POJOGenerator();
        JavaFile javaFile = generator.generateByExpression(expression, _package);
        System.out.println(javaFile);
    }

    @Test
    public void controllerTest() throws ClassNotFoundException{

        ControllerGenerator generator = new ControllerGenerator();
        JavaFile javaFile = generator.generateByExpression(expression, _package);
        System.out.println(javaFile);
    }

}
