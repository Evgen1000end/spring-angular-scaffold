package com.spring.scaffolding.writer;

import com.squareup.javapoet.JavaFile;

import java.io.File;
import java.io.IOException;

/**
 * Description of com.spring.scaffolding.writer
 *
 * @author evgen1000end
 * @since 26.03.2016
 */
public class FileWriter {

    /**
     *
      * @param rootFolder - path to java file
     * @param file        - generated AST of Java file
     * @throws IOException
     */
    public static void write(String rootFolder, JavaFile file) throws IOException{

        file.writeTo(new File(rootFolder));

    }



}
