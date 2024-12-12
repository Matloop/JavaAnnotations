package org.Matloop.questao1;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        MyClass usuario = new MyClass("Ninja");
        Class<?>classe=usuario.getClass();
        Info info = classe.getAnnotation(Info.class);

        System.out.println("Author: "+ info.autor());
        System.out.println("Data: " + info.data());



    }
}
