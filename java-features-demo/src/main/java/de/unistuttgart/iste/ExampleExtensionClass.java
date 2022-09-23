package de.unistuttgart.iste;

/**
 * This is an exemplary class that extends a sealed class, a permanent feature
 * in JAVA SE 17
 */
public final class ExampleExtensionClass extends ExampleSealedClass {
    private String name;

    public String getName() {
        return name;
    }
}
