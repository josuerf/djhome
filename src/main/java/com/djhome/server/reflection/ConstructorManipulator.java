package com.djhome.server.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConstructorManipulator {
    private final Constructor<?> constructor;

    public ConstructorManipulator(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    /**
     * Através do objeto {@link Constructor}, passado pelo construtor
     * da classe, cria e retorna uma instância da classe do mesmo
     * objeto passado.
     * @return
     * {@link Object}
     */
    public Object build() {

        try {
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException |
                IllegalArgumentException ex) {

            Logger.getLogger(ConstructorManipulator.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);

        } catch (InvocationTargetException ex) {
            throw new RuntimeException("Erro ao Construir", ex.getTargetException());
        }

    }

}
