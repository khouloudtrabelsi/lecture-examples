package de.unistuttgart.iste;

/**
 * This is an exemplary sealed class, a permanent feature in JAVA SE 17
 */
public sealed class ExampleSealedClass permits ExampleExtensionClass {

    public void printMessage(String message) {
        System.out.println("ExampleSealedClass::printMessage(): " + message);
    }
}
