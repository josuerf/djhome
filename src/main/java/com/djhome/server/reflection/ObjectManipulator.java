package main.java.com.djhome.server.reflection;

import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * Responsável por manipular {@link Object}
 *
 * @author Josue
 */
public class ObjectManipulator {

    private final Object instance;

    public ObjectManipulator(Object instance) {
        this.instance = instance;

    }

    /**
     * Encontra o método requirido, na instância da classe requirida
     * através do parâmetro 'methodName' e seus parâmetros, através de
     * 'params'. Dentro disto, filtra o array de métodos da instancia
     * pelo nome passado e parâmetros e pega o primeiro.
     * Caso as condições não forem satisfeitas, lança uma exceção.
     *
     * @param methodName
     * @param params
     * @return {@link MethodManipulator}
     */
    public MethodManipulator getMethod(String methodName, Object... params) {

        Stream<Method> methods = Stream.of(instance.getClass().getDeclaredMethods());

        Method selectedMethod = methods.filter(method -> method.getName().equals(methodName)
                && (method.getParameterCount() == params.length)).findFirst().
                orElseThrow(() -> new RuntimeException("Método não Encontrado"));

        return new MethodManipulator(instance, selectedMethod, params);
    }

}
