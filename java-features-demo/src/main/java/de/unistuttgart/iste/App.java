package de.unistuttgart.iste;

/**
 * This class provides the main method to execute examples for Java
 * features from version 8 until 17.
 */
public class App {
    public static void main(String[] args) {
        String startMessage = """
                ##################################################
                #     See Examples of Java features 8 - 17       #
                ##################################################
                """;
        System.out.println(startMessage);

        Examples examples = new Examples();

        /*
         * In the following, remove comment symbol (//) to execute the desired code
         * example
         */

        // examples.SE8_lambdaExpressionExample1();
        // examples.SE8_lambdaExpressionExample2();
        // examples.SE8_streamExample();
        // examples.SE8_timeApiExample();
        // examples.SE11_localTypeInferenceExample();
        // examples.SE14_switchExample();
        // examples.SE15_textBlockExample();
        // examples.SE15_NPEExample();
        // examples.SE16_recordClassExample();
        examples.SE17_sealedClassExample();
    }
}