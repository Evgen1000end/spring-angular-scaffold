package com.spring.scaffolding.controllers;

import com.squareup.javapoet.*;
import com.sun.xml.internal.org.jvnet.fastinfoset.sax.RestrictedAlphabetContentHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.Modifier;

/**
 * Description of com.spring.scaffolding.controllers
 *
 * @author evgen1000end
 * @since 26.03.2016
 */

public class ControllerGenerator {

    public JavaFile generateByExpression (String expression, String packageName) throws ClassNotFoundException{

        //"Person#String name; int age"
        String [] expr = expression.split("#");

        String classname = expr[0];
        String [] properties = expr[1].split(";");

        AnnotationSpec annotationSpec = AnnotationSpec.builder(RestController.class).build();

        AnnotationSpec spec =
                AnnotationSpec.builder(RequestMapping.class).
                        addMember("value","$S","/"+classname).build();

        TypeSpec.Builder helloWorld = TypeSpec.classBuilder(classname+"Controller")
                .addModifiers(Modifier.PUBLIC).
                        addAnnotation(annotationSpec).addAnnotation(spec);




        TypeSpec spec2 = helloWorld.build();
        JavaFile javaFile = JavaFile.builder(packageName+".controller", spec2).build();
        return javaFile;
    }


}
