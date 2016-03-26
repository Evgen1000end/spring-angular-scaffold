package com.spring.scaffolding.pojo;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Description of com.spring.scaffolding.pojo
 *
 * @author evgen1000end
 * @since 26.03.2016
 */
public class POJOGenerator {


    public JavaFile generateByExpression (String expression, String packageName) throws ClassNotFoundException{

        //"Person#String name; int age"
        String [] expr = expression.split("#");

        String classname = expr[0];
        String [] properties = expr[1].split(";");

        //List<FieldSpec>  fieldSpecs  = new ArrayList<>();
       // List<MethodSpec> methodSpecs = new ArrayList<>();

        TypeSpec.Builder helloWorld = TypeSpec.classBuilder(classname)
                .addModifiers(Modifier.PUBLIC);



        for (String str:properties){
            String fieldKV [] = str.trim().split(" ");

            String name = fieldKV[1];

            ClassName className = ClassName.get("",fieldKV[0]);

            FieldSpec fieldSpec= FieldSpec.builder(className, name, Modifier.PRIVATE).build();
            helloWorld.addField(fieldSpec);

            MethodSpec getter = MethodSpec.methodBuilder("get"+name)
                .addModifiers(Modifier.PUBLIC)
                .returns(className)
                .addStatement("return  "+name)
                .build();

            MethodSpec setter = MethodSpec.methodBuilder("set"+name)
                    .addModifiers(Modifier.PUBLIC)
                    .returns(void.class)
                    .addParameter(className, name)
                    .addStatement("this."+name+"="+name)
                    .build();

            helloWorld.addMethod(setter);
            helloWorld.addMethod(getter);
        }

        TypeSpec spec = helloWorld.build();
        JavaFile javaFile = JavaFile.builder(packageName, spec).build();
        return javaFile;
    }

}
