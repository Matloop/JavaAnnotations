package org.Matloop.Exemplo;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Ninja", "32030130212", LocalDate.of(2009, 02, 2));

        System.out.println(validador(usuario));
    }

    public static <T> boolean validador(T objeto) {
        Class<?>classe=objeto.getClass();
        for(Field field : classe.getDeclaredFields()){
            if(field.isAnnotationPresent(IdadeMinima.class)){
                IdadeMinima idadeMinima = field.getAnnotation(IdadeMinima.class);
                try{
                    field.setAccessible(true);
                    LocalDate dataNascimento = (LocalDate) field.get(objeto);
                    return Period.between(dataNascimento, LocalDate.now()).getYears() >= idadeMinima.valor();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }

        return false;
    }
}
