package com.djhome.server.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Responsável por manipular e processar métodos das classes refletidas
 *
 * @author Josue
 */
public class MethodManipulator {

    private final Object instance;
    private final Method method;
    private final Object[] params;

    public MethodManipulator(Object instance, Method method, Object... params) {
        this.instance = instance;
        this.method = method;
        this.params = params;
    }

    /**
     * Invoca o método da classe inferenciada por reflection
     * através de sua instância e parametros.
     *
     * @return {@link Object} resultante do método chamado.
     */
    public String build() {

        try {
            if (params != null) {
                List<Object> methodParams = new ArrayList<>(Arrays.asList(params));
                return (String) method.invoke(instance, methodParams.toArray());
            }
            return (String) method.invoke(instance);

        } catch (IllegalAccessException | IllegalArgumentException ex) {

            Logger.getLogger(MethodManipulator.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);

        } catch (InvocationTargetException ex) {

            Logger.getLogger(MethodManipulator.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Invocar o método", ex);

        }
    }
}
