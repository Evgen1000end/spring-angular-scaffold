package com.spring.scaffolding.pojo;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Description of com.spring.scaffolding.pojo
 *
 * @author evgen1000end
 * @since 26.03.2016
 */
public class POJOGenerator {

    public JavaFile generateByExpression (String expression) throws ClassNotFoundException{

        //"Person#String name; int age"
        String [] expr = expression.split("#");

        String classname = expr[0];
        String [] properties = expr[1].split(";");

        List<FieldSpec> fieldSpecs = new ArrayList<>();
        List<MethodSpec> methodSpecs = new ArrayList<>();

        TypeSpec.Builder helloWorld = TypeSpec.classBuilder(classname)
                .addModifiers(Modifier.PUBLIC);

        for (String str:properties){
            String fieldKV [] = str.trim().split(" ");

            //Class<?> clazz = Class.forName(fieldKV[0]);

            FieldSpec fieldSpec= FieldSpec.builder(int.class, fieldKV[1], Modifier.PRIVATE).build();
            helloWorld.addField(fieldSpec);
        }

//        MethodSpec main = MethodSpec.methodBuilder("main")
//                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                .returns(void.class)
//                .addParameter(String[].class, "args")
//                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
//                .build();
        TypeSpec spec = helloWorld.build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", spec)
                .build();

        return javaFile;
    }

}
