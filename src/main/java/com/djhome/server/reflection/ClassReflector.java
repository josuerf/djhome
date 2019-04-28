package main.java.com.djhome.server.reflection;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassReflector {
    /**
     * Utiliza {@link ClassManipulator} para a construção de um
     * objeto do tipo {@link Class}
     * @param qualifiedName
     * @return
     * {@link ClassManipulator}
     */
    public ClassManipulator getMirroredClass(String qualifiedName) {

        Class<?> mirroredClass = null;

        try {

            mirroredClass = Class.forName( qualifiedName );

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(ClassManipulator.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);

        }

        return new ClassManipulator( mirroredClass );
    }

}
