package org.Matloop.Questao2;

public class Main {
    public static void main(String[] args) {
        TesteVersion teste = new TesteVersion();

        Class<?>classe = teste.getClass();

        Version version = classe.getAnnotation(Version.class);

        if(version != null) {

            System.out.println("Número: " +version.number());
            System.out.println("Descrição: " + version.description());
        }


    }
}
