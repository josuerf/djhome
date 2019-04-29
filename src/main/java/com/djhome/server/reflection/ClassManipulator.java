package com.djhome.server.reflection;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassManipulator {
    private final Class<?> mirroredClass;

    public ClassManipulator(Class<?> mirroredClass) {
        this.mirroredClass = mirroredClass;
    }

    /**
     * Através do uso de reflection, obtém os construtores da classe
     * passada pelo construtor, empacota em um {@link Constructor} e
     * retorna um {@link ConstructorManipulator}
     * @return
     * {@link ConstructorManipulator}
     */
    public ConstructorManipulator getConstructor() {

        Constructor<?> mirroredObject = null;

        try {

            mirroredObject = mirroredClass.getDeclaredConstructor();

        } catch (NoSuchMethodException | SecurityException ex) {

            Logger.getLogger(RequestActionFinder.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);

        }
        return new ConstructorManipulator(mirroredObject);
    }

    public ObjectManipulator newInstance() {
        Object instance = getConstructor().build();

        return new ObjectManipulator(instance);
    }

}
