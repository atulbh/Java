package programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP01Functional {

	public static void main(String[] args) {
		printEvenNumInListFunctional(List.of(1, 3, 5, 2, 4, 3, 0, 9, 8, 4));
		printEvenNumInListFunctionalUsingLambda(List.of(1, 3, 5, 2, 4, 3, 0, 9, 8, 4));
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices","AWS","PCF","Azure", "Docker","Kubernates");
		
		courses.stream().forEach(FP01Functional :: printCourses);
		
		courses.stream().filter(course -> course.contains("Spring")).forEach(FP01Functional::printCourses);
		
		courses.stream().filter(course ->course.length()>3).forEach(FP01Functional::printCourses);
		
		//print square of each number
		printSquareOfEachNumber(List.of(1, 3, 5, 2, 4, 3, 0, 9, 8, 4));
		
		//pprint the number of char in each course name 
		courses.stream().map(course-> course +" "+course.length()).forEach(FP01Functional::printCourses);
		
		//calculate sum using reduce 
		int sum = addListFunctional(List.of(1, 3, 5, 2, 4, 3, 0, 9, 8, 4));
		System.out.println(sum);
		
		int sum2 = addListFunctionalLambda(List.of(1, 3, 5, 2, 4, 3, 0, 9, 8, 4));
		System.out.println(sum2);
		
		int sum3 = addListFunctionalLambda2(List.of(1, 3, 5, 2, 4, 3, 0, 9, 8, 4));
		System.out.println(sum3);
		

		int sum4 = addListFunctionalLambda3(List.of(1, 3, 5, 2, 4, 3, 0, 9, 8, 4));
		System.out.println(sum4);
		
		//Square every number in a list and find the sum of squares
	System.out.println(List.of(1, 3, 5, 2, 4, 3, 0, 9, 8, 4).stream().map(x->x*x).reduce(0, Integer::sum));
		
		//print sorted and disctinct 
	
		//print courses in sorted order using comparator 
		courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
	
		//print courses in sorted reverse order using comparator
		courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		//print courses in sorted order by length of String using comparator
		System.out.println("sorted by length");
		courses.stream().sorted(Comparator.comparing(str->str.toString().length())).forEach(System.out::println);
		
		//make square of each number and collect as a diff list
		List<Integer> list = List.of(1, 3, 5, 2, 4, 3, 0, 9, 8, 4).stream().map(x->x*x).collect(Collectors.toList());
		System.out.println(list);
	}
	
	private static int addListFunctionalLambda3(List<Integer> list) {
		return list.stream().reduce(0, (x,y)->x>y?x:y);
	}
	
	private static int addListFunctional(List<Integer> list) {
		return list.stream().reduce(0, FP01Functional :: sum);
	}
	
	private static int addListFunctionalLambda(List<Integer> list) {
		return list.stream().reduce(0, (x,y)->(x+y));
	}
	
	private static int addListFunctionalLambda2(List<Integer> list) {
		return list.stream().reduce(0, Integer::sum);
	}

	private static void printSquareOfEachNumber(List<Integer> of) {
		of.stream().map(x-> x*x).forEach(FP01Functional::print);
		
	}

	public static void print(int i) {
		System.out.println(i);
	}
	
	public static boolean isEven(int i) {
		return i%2==0;
	}
	private static void printEvenNumInListFunctional(List<Integer> of) {

		//Method reference
		of.stream().filter(FP01Functional::isEven). forEach(FP01Functional::print);
	}
	
	private static void printEvenNumInListFunctionalUsingLambda(List<Integer> of) {

		//Method reference
		of.stream().filter(number->number%2==0).forEach(FP01Functional::print);
	}

	private static void printCourses(String string) {
		System.out.println(string);
	}

	private static Integer sum(Integer aggregate, Integer nextNumber) {
		return aggregate + nextNumber;
	}

}
