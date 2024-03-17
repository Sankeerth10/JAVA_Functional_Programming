import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalProgramming01 {
    public static void main(String[] args) {
        List<Integer> elems = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservices", " AWS", "PCF", "Azure", "Docker", "Kubernetes");
        //matchCourses(courses, courses2);
        //printOddNumbers(elems);
        //printCoursesinArr(courses);
        //printCoursesinArrWithSpring(courses);
        //printCoursesInArrWithCharLengthGreaterThan4(courses);
        //printOddNumbersCubes(elems);
        //printNoOfCharsInCourses(courses);
        //printSumOfSquares(elems);
        //printSumOfCubes(elems);
        //printSumOfOddNumbers(elems);
        //List<Integer> res = ListOfNumbers(elems);
        //List<Integer> res = ListOflenOfCourse(courses);
        //System.out.println(res);
        //functionalInterFace(elems);
        Function<Integer, Integer> integerIntegerFunction = x -> x * x;
        BehaviouralParameterization(elems, integerIntegerFunction);

    }

    private static void sumOfNumbers(List<Integer> elems) {
        int sum = elems.stream().reduce(0, (a, b) -> a + b);
//        int sum = elems.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    private static void printEvenElemsinArr(List<Integer> elems) {
        elems.stream().filter(elem -> elem % 2 == 0).forEach(System.out::println);
    }


    private static void matchCourses(List<String> courses, List<String> courses2) {
        List<List<String>> result = courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2))).collect(Collectors.toList());
        System.out.println(result);
    }

//    Exercise 1
//    Print Only Odd Numbers from the List
    private static void printOddNumbers(List<Integer> numbers) {
        numbers.stream().filter(number -> number%2 != 0).forEach(System.out::println);
    }

//    Exercise 2
//    Print All Courses individually
    private static void printCoursesinArr(List<String> courses) {
        courses.stream().forEach(System.out::println);
    }

//    Exercise 3
//    Print Courses Containing the word "Spring"
    private static void printCoursesinArrWithSpring(List<String> courses) {
         courses.stream()
                .filter(course -> course.toLowerCase().contains("spring"))
                .forEach(System.out::println);
    }

//    Exercise 4
//    Print Courses Whose Name has atleast 4 letters
    private static void printCoursesInArrWithCharLengthGreaterThan4(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

//    Exercise 5
//    Print the cubes of odd numbers
    private static void printOddNumbersCubes(List<Integer> numbers) {
          numbers.stream()
                 .filter(number -> number%2 != 0)
                 .map(num -> num*num*num)
                 .forEach(System.out::println);
    }

//    Exercise 6
//    Print the number of characters in each course name
    private static void printNoOfCharsInCourses(List<String> courses) {
         courses.stream()
                .map(String::length)
                .forEach(System.out::println);
    }

//    Exercise 7
//    Square every number in a list and find the sum of squares
    private static void printSumOfSquares(List<Integer> numbers) {
        int sum = numbers.stream()
                .map(num -> num*num)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

//    Exercise 8
//    Cube every number in a list and find the sum of cubes
    private static void printSumOfCubes(List<Integer> numbers) {
        System.out.println(numbers.stream()
                .map(num -> (int) Math.pow(num, 3))
                .reduce(0, Integer::sum));
    }

//    Exercise 9
//    Find Sum of Odd Numbers in a list
    private static void  printSumOfOddNumbers(List<Integer> numbers) {
        System.out.println(numbers.stream()
                .filter(num -> num % 2 != 0)
                .reduce(0, Integer::sum));
    }

//    Exercise 10
//    Create a List with Even Numbers Filtered from the Numbers List
    private static List<Integer> ListOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num%2 != 0)
                .collect(Collectors.toList());
    }

//    Exercise 11
//    Create a List with lengths of all course titles.
    private static List<Integer> ListOflenOfCourse(List<String> courses) {
        return courses.stream()
                .map(course -> course.length())
                .collect(Collectors.toList());
    }

//    Exercise 12
/*    Find Functional Interface behind the second argument of reduce method.
        Create an implementation for the Functional Interface.
*/
    private static void functionalInterFace(List<Integer> elems) {
        BinaryOperator<Integer> integerBinaryOperator = Integer::sum;
        System.out.println(elems.stream().reduce(0, integerBinaryOperator));
    }

//    Exercise 13
//    Do Behavior Parameterization for the mapping logic.
    private static void BehaviouralParameterization(List<Integer> numbers, Function<Integer, Integer> integerIntegerFunction) {
        List<Integer> squaredNumbers = numbers.stream()
                                              .map(integerIntegerFunction)
                                              .collect(Collectors.toList());
        System.out.println(squaredNumbers);
    }

}