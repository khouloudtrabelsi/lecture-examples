package de.unistuttgart.iste;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This class provides methods with examples using Java features from version 8
 * until 17
 */
public class Examples {
    /**
     * Exemplifies the usage of lambda expressions, a permanent feature in JAVA SE 8
     */
    public void SE8_lambdaExpressionExample1() {
        System.out.println("> Java SE 8 | Example: Lambda expression");

        // Runnable: functional interface
        Runnable runnableObj1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("My runnable object 1, not using lambda expression");
            }
        };
        runnableObj1.run();

        // Lambda-expression syntax: (argument) -> (body)
        Runnable runnableObj2 = () -> {
            System.out.println("My runnable object 2, using lambda expression");
        };
        runnableObj2.run();

        Runnable runnableObj3 = () -> System.out.println("My runnable object 3, using lambda expression");
        runnableObj3.run();
    }

    /**
     * Exemplifies the usage of lambda expressions, a permanent feature in JAVA SE 8
     */
    public void SE8_lambdaExpressionExample2() {

        // a functional interface, i.e., contains only one method
        interface Calculate {
            boolean isPrime(int number);
        }

        // Lambda-expression syntax: (argument) -> (body)
        Calculate calcObj = (int number) -> {
            if (number < 2) {
                return false;
            }

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        };

        int numberToCheck = 911;
        boolean result = calcObj.isPrime(
                numberToCheck);
        System.out.println("\n> Java SE 8 | Example: Lambda expression");
        System.out.println("is " + numberToCheck + " a prime number? " + result);

        numberToCheck = 77;
        result = calcObj.isPrime(numberToCheck);
        System.out.println("is " + numberToCheck + " a prime number? " + result);
    }

    /**
     * Exemplifies the usage of Stream, a permanent feature in JAVA SE 8
     */
    public void SE8_streamExample() {
        System.out.println("\n> Java SE 8 | Example: stream");

        // generate a IntStream from a Random object
        Random random = new Random();
        IntStream randomIntStream = random.ints(50, 0, 90);

        // filter and iterate using lambda expression
        IntStream filteredStream = randomIntStream.filter(value -> (value >= 0 && value < 18));
        filteredStream.forEach(resultedValue -> System.out.println("Ex 1 - Filtered value: " + resultedValue));

        System.out.println("\n");

        // create a list object
        List<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            myList.add(i);
        }

        // get sequential stream with the list as source
        Stream<Integer> sequentialStream = myList.stream();

        // filter and iterate using lambda expression
        Stream<Integer> underageSequence = sequentialStream.filter(value -> (value >= 0 && value < 18));
        underageSequence.forEach(value -> System.out.println("Ex 2 - Filtered value: " + value));
    }

    /**
     * Exemplifies the usage of time API, classes added in JAVA SE 8
     */
    public void SE8_timeApiExample() {
        LocalDate today1 = LocalDate.now();
        LocalTime today2 = LocalTime.now();
        LocalDateTime today3 = LocalDateTime.now();
        System.out.println("\n> Java SE 8 | Example: Time API");
        System.out.println("Today 1: " + today1);
        System.out.println("Today 2: " + today2);
        System.out.println("Today 3: " + today3);
        DateTimeFormatter formatterObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Today 3 formatted: " + today3.format(formatterObj));
    }

    /**
     * Exemplifies the usage of local variable inference type, a permanent feature
     * in JAVA SE 11
     */
    public void SE11_localTypeInferenceExample() {
        var name = "my name";
        var year = 2021;

        System.out.println("> Java SE 11 | Example: Local type inference");
        System.out.println("var name: " + name);
        System.out.println("var year: " + year);
        System.out.println();

        // not allowed:
        // var day; // error: not initialized
        // year = "2021"; // error: not possible to change type from int to string
    }

    /**
     * Exemplifies the usage of switch expressions, a permanent feature in JAVA SE
     * 14
     */
    public void SE14_switchExample() {
        enum Day {
            SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
        }
        Day day = Day.FRIDAY;
        int numLetters1 = 0, numLetters2 = 0;

        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters1 = 6;
                break;
            case TUESDAY:
                numLetters1 = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters1 = 8;
                break;
            case WEDNESDAY:
                numLetters1 = 9;
                break;
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }

        // Using new kind of case "->"
        numLetters2 = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalArgumentException("Invalid day: " + day);
        };

        System.out.println("> Java SE 14 | Example: Switch");
        System.out.println("First switch: " + numLetters1);
        System.out.println("Second switch: " + numLetters2);
        System.out.println();
    }

    /**
     * Exemplifies the usage of Text blocks, a permanent feature in JAVA SE 15
     */
    public void SE15_textBlockExample() {
        String doubleQuotedString = "{\"name\": \"my name\"}";
        String textBlockString = """
                {
                	"name": "my name" \
                }
                """;

        System.out.println("> Java SE 15 | Example: Text block");
        System.out.println("- This is a string:\n" + doubleQuotedString);
        System.out.println("- This is a text block:\n" + textBlockString);
    }

    /**
     * Triggers a NullPointerException, to see improved message added in JAVA SE 15
     */
    public void SE15_NPEExample() {

        try {
            System.out.println("\n> Java SE 15 | Example: NPE description");
            ExampleExtensionClass exObj = new ExampleExtensionClass();
            System.out.println(exObj.getName().trim().toUpperCase().length());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Exemplifies the usage of a record class, a permanent feature in JAVA SE 16
     */
    public void SE16_recordClassExample() {

        // ATTENTION: this class is located within this method just for example purpose
        // define a record class
        record ExampleRecordClass(String name, int releaseYear) {
        }

        // instantiate records of created class
        ExampleRecordClass java16releaseRecord = new ExampleRecordClass("Java SE 16", 2021);
        ExampleRecordClass java17releaseRecord = new ExampleRecordClass("Java SE 17", 2021);

        System.out.println("\n> Java SE 16 | Example: record example");
        System.out.println("Auto-created toString(): " + java16releaseRecord.toString());
        System.out.println("Auto-created name(): " + java16releaseRecord.name());
        System.out.println("Auto-created releaseYear(): " + java16releaseRecord.releaseYear());

        System.out.println("Auto-created toString(): " + java17releaseRecord.toString());
        System.out.println("Auto-created name(): " + java17releaseRecord.name());
        System.out.println("Auto-created releaseYear(): " + java17releaseRecord.releaseYear());
        System.out.println("Auto-created field: " + java17releaseRecord.releaseYear);
    }

    /**
     * Exemplifies the usage of a sealed class, a permanent feature in JAVA SE 17
     */
    public void SE17_sealedClassExample() {

        ExampleExtensionClass extensionClassObj = new ExampleExtensionClass();
        extensionClassObj.printMessage("\n> Java SE 17 | Example: sealed class example");
    }
}
