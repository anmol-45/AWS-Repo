package org.example.Practice.Stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.Collections.max;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = getEmployees();
        if (employees.isEmpty())
            throw new RuntimeException("No employee found");

        //question1:
//    Map<String , List<Employee>> employeeByCity = employees.stream().collect(Collectors.groupingBy(Employee::getCity));
//
//    employeeByCity.forEach((city , employee) ->{
//        System.out.println(city);
//        employee.forEach(System.out::println);
//    });

//        question 2
//    Map<Integer , List<Employee>> employeeByAge = employees.stream().collect(Collectors.groupingBy(Employee::getAge));
//
//    employeeByAge.forEach((city , employee) ->{
//        System.out.println(city);
//        employee.forEach(System.out::println);
//    });


//        question 3
//  int countMale = (int) employees.stream().filter(employee -> employee.getGender().equals("M")).count();
//  int countFemale = (int) employees.stream().filter(employee -> employee.getGender().equals("F")).count();
//  System.out.println("Male: " + countMale);
//  System.out.println("Female: " + countFemale);
//  Map<String , Long> countGender = employees.stream()
//  .collect(Collectors.groupingBy(Employee::getGender , Collectors.counting()));
//
//  countGender.forEach((gender , count) -> System.out.println(gender + " : " + count));

//    Question 4
//
//    List<String> department = employees.stream()
//            .map(Employee::getDeptName)
//            .distinct()
//            .toList();
//    System.out.println("Department: " + department);
//
//    question 5
//    List<Employee> employeeByAgeCriteria  = employees.stream()
//            .filter(employee -> employee.getAge()>=28).toList();
//
//    employeeByAgeCriteria.forEach(System.out::println);

//        question 6        max function returns an optional int value
//    OptionalInt maxi = employees.stream()
//            .mapToInt(Employee::getAge)
//            .max();
//
//    maxi.ifPresentOrElse(
//            System.out::println,
//            () -> System.out.println("No employee found"));


//        question7     //for a given key, it generates the average by collectors.averagingDouble
//        average age of male and female

//    Map<String , Double> averageAge;
//    averageAge = employees.stream()
//            .collect(Collectors.groupingBy(Employee::getGender , Collectors.averagingDouble(Employee::getAge)));
//
//    averageAge.forEach( (k, v) -> System.out.println(k + " : " + v));

//        question 8    //count the records for a given key

//    Map<String , Long> countByDept =
//            employees.stream()
//                    .collect(Collectors.groupingBy(
//                            Employee::getDeptName
//                            , Collectors.counting()
//                    ));
//    countByDept.forEach((k , v) ->
//            System.out.println(k + " : " + v));


//        question 9

//        find the oldest employee
//    Employee employee = employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
//
//    System.out.println(employee);

//        question 10   we can filter the gender and then find the minimum age

//    Optional<Employee> employee = employees.stream()
//            .filter(e -> e.getGender().equals("F"))
//            .min(Comparator.comparingInt(Employee::getAge));
//
//    employee.ifPresent(System.out::println);

//        Question 11: we need to find employee division who are greater and less than 30
//        Find employees whose age is greater than 30 and less than 30

//    Map<Boolean , List<Employee>> ageRangedEmp =
//            employees.stream()
//                    .collect(Collectors.partitioningBy(
//                            e -> e.getAge() >= 30       //it return true if the age exceeds 30 and keep in true key
//                    ));
//
//    ageRangedEmp.forEach(
//            (k , v) ->{
//                if(k){
//                    System.out.println("Age greater than 30");
//                    v.forEach(System.out::println);
//                }
//                else{
//                    System.out.println("Age less than 30");
//                    v.forEach(System.out::println);
//                }
//            }
//    );
//
//      Question 12: Finding Department with Highest Number of Employees

//    String dept = employees.stream()
//            below is used to group based on department name and store the frequency
//            .collect(Collectors.groupingBy(Employee::getDeptName , Collectors.counting()))
//            //this below entry set gives a stream of each key of the map
//            .entrySet()
//            .stream()
//            //finding max based on values
//            .max(Map.Entry.comparingByValue())
//            //get the key of max value
//            .map(Map.Entry::getKey)
//            .orElse("No employee found");
//    System.out.println(dept);


//        Question 13: Finding Employees from HR Department

        //we use find any

//    Optional<Employee> anyEmployeeFromHR = employees.stream()
//            .filter(e -> e.getDeptName().equals("HR"))
//            .findAny();
//
//    anyEmployeeFromHR.ifPresent(System.out::println);


//        Question 14: Finding Departments with Over 3 Employees

//
//        Question 15: Finding Distinct Department Names

//        List<String> deptNames = employees.stream()
//                .map(Employee::getDeptName).distinct().toList();
//
//        deptNames.forEach(System.out::println);

//        Question 16: Finding and Sorting Employees by City

//    employees.stream()
//        .filter(employee -> employee.getCity().equals("Trivandrum"))
//        .sorted(Comparator.comparing(Employee::getName))
//        .forEach(System.out::println);
//
//        Question 17: Counting the Number of Employees in the Organization
//
//        long count = employees.stream().count();
//        System.out.println(count);


//        Question 18: Finding Employee Count in Every Department

//        Map<String , Long> countOfEveryDept = employees
//                .stream()
//                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
//
//        countOfEveryDept.forEach( (deptName, count) -> {
//            System.out.println(deptName + ": " + count);
//        });
//        Question 19: Finding Department with the Highest Number of Employees


//        String department = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDeptName , Collectors.counting()))
//                .entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .orElseThrow().getKey();
//        System.out.println(department);

        //Question 20: Sorting Employees by Name and Age

//        List<Employee> sortedEmployees = employees.stream()
//                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).toList();
//        sortedEmployees.forEach(System.out::println);

        //Question 21: Finding the Highest Experienced Employee

//        Optional<Employee> experiencedEmployee = employees.stream()
//                .min(Comparator.comparing(Employee::getYearOfJoining));
//        experiencedEmployee.ifPresent(System.out::println);

//        Question 22: Printing Average and Total Salary of the Organization

//
//        OptionalDouble averageSalary = employees
//                .stream()
//                .mapToDouble(Employee::getSalary).average();
//
//        averageSalary.ifPresent(System.out::println);

//        OptionalDouble totalSalary = employees
//                .stream()
//                .mapToDouble(Employee::getSalary)
//                .reduce(Double::sum);       //reduce helps us to get the optional
//
//
//        totalSalary.ifPresent(System.out::println);

//

//        DoubleSummaryStatistics empSalary = employees
//                .stream()
//                .collect(Collectors.summarizingDouble(Employee::getSalary));
//
        /*System.out.println(empSalary.getAverage());
        System.out.println(empSalary.getSum());*/

/*//        Question 23: Printing Average Salary of Each Department


        Map<String , Double> avgSalaryOfDept = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));

        avgSalaryOfDept.forEach((entry , avgSalary) -> {
            System.out.println(entry +":" + avgSalary);
        });*/

//        Question 24: Finding the Highest Salary in the Organization
//        OptionalDouble highestSalary = employees
//                .stream()
//                .mapToDouble(Employee::getSalary).max();
//        highestSalary.ifPresent(System.out::println);


//        Question 25: Finding the Second-Highest Salary in the Organization
//        OptionalDouble secondHighestSalary = employees
//                .stream()
//                .mapToDouble(Employee::getSalary)
//                .sorted()
//                .skip(1)
//                .findFirst();
//        secondHighestSalary.ifPresent(System.out::println);


//        Question 26: Finding the Nth Highest Salary in the Organization

//        int n = 5;
//        OptionalDouble nthSalary = employees
//                .stream()
//                .mapToDouble(Employee::getSalary)
//                .sorted()
//                .skip(n-1)
//                .findFirst();
//        nthSalary.ifPresent(System.out::println);

//        Question 27: Finding the Highest Paid Salary in the Organization Based on Gender

//        Map<String, Optional<Employee>> highestSalary = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getGender, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
//
//        highestSalary.forEach((k , v) -> {
//            System.out.print(k + ":   ");
//            System.out.println(v);
//        });

//        Question 28: Finding the Lowest Paid Salary in the Organization Based on Gender

//        Map<String , Optional<Employee>> lowestSalary = employees
//                .stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getGender , Collectors.minBy(Comparator.comparing(Employee::getSalary))));
//
//        lowestSalary.forEach((k , v) -> {
//            System.out.print(k + ":   ");
//            System.out.println(v);
//        });

//        Question 29: Sorting Employees' Salary in Ascending Order

//        List<Employee> sortedEmployee = employees.
//                stream()
//                .sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
//
//        sortedEmployee.forEach(System.out::println);

//        Question 30: Sorting Employees' Salary in Ascending Order

//        List<Employee> descSortedEmployee = employees.
//                stream()
//                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();
//
//        descSortedEmployee.forEach(System.out::println);

//        Question 31: Finding the Highest Salary Based on Department:

//        List<String> nameStr = Arrays.asList("Alice", "Bob", "Annie", "Mark", "Ava");
//
//        //converting to upper case and filtering out name starting with A
//
//        nameStr.stream()
//                .map(String::toUpperCase)
//                .filter(a -> a.startsWith("A"))
//                .forEach(System.out::println);

//        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//        int sum = number.stream()
//                .filter(a -> a % 2 == 0)
//                .mapToInt(a -> a)
//                .sum();
//        System.out.println(sum);


//        List<String> words = Arrays.asList("apple", "orange", "apple", "banana", "orange", "apple");
//
//        Map<String, Long> freqWord = words.stream()
//                .collect(Collectors.groupingBy( a -> a ,  Collectors.counting()));
//
//        freqWord.forEach((k,v) ->{
//            System.out.println(k + "=" + v);
//        });


//        sort using salary in desc then using name in asc
//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getSalary)
//                        .reversed()
//                        .thenComparing(Employee::getName))
//                .forEach(System.out::println);


//        List<Transaction> transactions = Arrays.asList(
//                new Transaction("DEBIT", 1000),
//                new Transaction("CREDIT", 2000),
//                new Transaction("DEBIT", 1500),
//                new Transaction("CREDIT", 3000),
//                new Transaction("DEBIT", 700)
//        );
//
//
//        Map<String, Long> filteredType = transactions.stream()
//                .collect(Collectors.groupingBy(
//                        Transaction::getType , Collectors.counting()
//                ));
//
//        filteredType.forEach((k , v) ->{
//            System.out.println(k +"->" + v);
//        });

//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
//        List<Integer> arrList = Arrays.stream(arr)
//                .boxed()
//                .toList();//this is unmodifiable
//
//        .collect(Collectors.toList())//modifiable list
//
//        Arrays.stream(arr)
//                .filter(a -> a%2 == 0)
//                .forEach(System.out::println);

//        int[] arr = {3, 1, 4, 2};
//        Arrays.stream(arr)
//                .map(a -> a*a)
//                .sorted()
//                .forEach(System.out::println);

//        String[] names = {"john", "jane", "doe"};
//
//        Arrays.stream(names)
//                .map(String::toUpperCase)
//                .forEach(System.out::println);

//        String[] names = {"Apple", "Banana", "Avocado", "Mango", "Apricot"};
//
//        Long cnt = Arrays.stream(names)
//                .filter(s -> s.toUpperCase().startsWith("A"))
//                .count();
//        System.out.println(cnt);

        //given a list of words, group them by their length using streams.

//        List<String> words = new ArrayList<>(Arrays.asList("cat", "dog", "apple", "bat", "banana"));
//
//        words.stream()
//                .collect(Collectors.groupingBy(String::length , Collectors.toList()))
//                .forEach((k , v) -> {
//                    System.out.print(k + " = { "  );
//                    v.forEach( a -> System.out.print(a + " "));
//                    System.out.println("}");
//                });

//        Frequency Count:
//        Count the frequency of each character in a given string.
//
//        Input: "banana"
//        Output: {b=1, a=3, n=2}
//
//        List<String> words = new ArrayList<>(Arrays.asList("cat", "dog", "apple", "bat", "banana"));
//
//        words.stream()
//                .flatMap(word -> Arrays.stream(word.split("")))
//                .collect(Collectors.groupingBy(
//                        c -> c, Collectors.counting()
//                ))
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .forEach(entry ->{
//                    System.out.println(entry.getKey() + ": " + entry.getValue());
//
//                });

//        String word = "anmol";
//        Arrays.stream(word.split(""))
//                .collect(Collectors.groupingBy(
//                        c -> c , Collectors.counting()
//                ))
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .forEach( entry ->{
//                    System.out.println(entry.getKey() + ": " + entry.getValue());
//                });
//
//        //Given a list of integers, find the second-highest number using streams.
//
//        List<Integer> arrList = new ArrayList<>(Arrays.asList(5, 2, 8, 9, 3, 8));
//
//        int ans = arrList.stream()
//                .sorted( (a , b) -> b-a)
//                .skip(1)
//                .findFirst()
//                .orElse(-1);


//        employees.stream()
//                .sorted(
//                        Comparator.comparing(Employee::getSalary)
//                                .thenComparing(
//                                        Comparator.comparing(Employee::getName)
//                                        .reversed()
//                                )
//                )
//                .forEach(System.out::println);

//        List<Integer> arrList = new ArrayList<>(Arrays.asList(5, 2, 8, 9, 3, 8));
//
//        arrList.stream()
//                .collect(Collectors.partitioningBy(x-> x%2 == 0))
//                .forEach((k , v) -> {
//                    System.out.println(k + ": ");
//                    v.forEach(System.out::print);
//                    System.out.println();
//                });

//        //sorting based on longest word
//        List<String> words = new ArrayList<>(Arrays.asList("cat", "dog", "apple", "bat", "banana"));
//
//        String word = words.stream().max(Comparator.comparing(String::length))
//                .orElse("");
//        System.out.println(word);

//        List<List<String>> nestedList = Arrays.asList(
//                Arrays.asList("apple", "banana"),
//                Arrays.asList("cat", "dog")
//        );
//
//        nestedList.stream()
//                .flatMap(List::stream)
//                .map(String::toUpperCase)
//                .forEach(System.out::println);

//        Find and print the sum of all even numbers in a list of integers.

//        List<Integer> numbers = new ArrayList<>(List.of(1,2,32,4,5,6,7));
//
//
//        int sum  = numbers.stream()
//                .filter(x -> x % 2 == 0)
//                .reduce(0 , Integer::sum);
//        System.out.println(sum);

//        Convert a list of Strings to uppercase and filter out the ones starting with 'A
        List<String> words = new ArrayList<>(Arrays.asList("cat", "dog", "apple", "bat", "banana"));
//
//        words.stream()
//                .map(String::toUpperCase)
//                .filter(x -> x.startsWith("A"))
//                .forEach(System.out::println);

//        Calculate the average salary of employees over the age of 30 from a list.

        OptionalDouble avgSalary = employees.stream()
                .filter(emp -> emp.getAge() > 30)
                .mapToDouble(Employee::getSalary)
                .average();

//        Merge two lists of integers into a single sorted list without duplicates.(Done)
//        List<Integer> nums1 = new ArrayList<>(List.of(1,2,32,4,5,6,7));
//        List<Integer> nums2 = new ArrayList<>(List.of(1,2,32,4,5,6,7,5));
//        List<Integer> nums = Stream
//                //this helps us in merging only two streams
//                .concat(nums1.stream() , nums2.stream())
//                .distinct()
//                .sorted()
//                .toList();
//
////        another way
//
//        List<Integer> numsSecond = Stream.of(nums1 , nums2)
//                .flatMap(List::stream)
//                .distinct()
//                .sorted()
//                .toList();
////
////        6. Generate 10 random numbers, filter out even numbers, and print odd numbers.

//        IntStream.range(1 , 11)
//                .filter(x -> x%2 == 1)
//                .forEach(System.out::println);
//
////                7. Group a list of words by length, and print the length along with associated words.(Done)
//
//        Map<Integer , List<String>> wordsByLength = words.stream()
//                .collect(Collectors.groupingBy(String::length));
//
//        wordsByLength.forEach((k , v) -> {
//            System.out.print(k + ": ");
//            v.forEach(System.out::print);
//            System.out.println();
//        });
//      8. Find the most frequent element in a list of integers.

//        List<Integer> nums = new ArrayList<>(List.of(1,32,5,6, 6,7,2,4, 4));
//
//        Optional<Integer> frequentEle = nums.stream()
//                .collect(Collectors.groupingBy(Function.identity() , Collectors.counting()))
//                .entrySet()
//                .stream()
//                .max(Comparator.comparingLong(Map.Entry::getValue))
//                .map(Map.Entry::getKey);

//        System.out.println(frequentEle);

//        int summation = IntStream.range(1 , 11)
//                .reduce(0 , (x , y) -> x+y);
//        .sum();
//
//        System.out.println(summation);

        //print employee name having salary >30k and  dept is IT

        List<String> empList = employees.stream()
                .filter(emp -> emp.getSalary() > 145 && emp.getDeptName().equalsIgnoreCase("IT"))
                .map(Employee::getName)
                .toList();

empList.stream()
        .peek(System.out::println);

//        Iterator it = empList.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
////            it = it.next();
//        }

//        Iterator<String> id = empList.listIterator();
//        while(id.hasNext()){
//            System.out.println(id.next());
//
//        }

//        empList.forEach(System.out::println);
//        Iterator<String> it = empList.iterator();
//        it.forEachRemaining(System.out::println);
//        String[] arrList = empList.toArray(new String[0]);
//
//        System.out.println(arrList.length);
//        for (String name : arrList) {
//            System.out.println(name);
//        }
//        Convert a Map<String, Integer> into a sorted list of "key=value" strings.

//        Map<String, Integer> map = new HashMap<>();

        // Adding some data to the map
//        map.put("Banana", 5);
//        map.put("Date", 15);
//        map.put("Apple", 10);
//        map.put("Elderberry", 30);
//        map.put("Cherry", 20);
//
//        map.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .forEach(System.out::println);
//
//
//        int[] arr =  {1,2,3,4,4,5,7,8};
//        System.out.println(stream(arr)
//                .max().orElseThrow(() -> new RuntimeException("invalid data")));


//        count employee with names starting with 's'

//        System.out.println(employees.stream()
//                .filter(emp -> emp.getName().toUpperCase().startsWith("S"))
//                .count());
//
//        String name = "ajkdjgkshvcboiughejkwgfsdbuoihvjksan asjhdg jashdg";
//        Arrays.stream(name.split(""))
//                .filter(ch -> !ch.equals(" "))
//                .collect(Collectors.groupingBy(x->x , Collectors.counting()))
//                .forEach((k , v) -> {
//                    System.out.println(k + ": " + v);
//                });

//        //15. Convert a list of persons to a map grouping by city with names of people from that city.
//        employees.stream()
//        .collect(Collectors.groupingBy(Employee::getCity , Collectors.mapping(Employee::getName , toList())))
//        .forEach((k , v) -> {
//            System.out.println(k);
//            v.forEach(System.out::println);
//            System.out.println();
//            System.out.println();
//        });

//                16. Find and print the longest string in a list of strings.

//        String maxi = empList.stream()
//                .max(Comparator.comparing(String::length))
////                .map(String::length)
//                .orElse("");
//
//        System.out.println(maxi);

        //17. Identify and print the third highest number from an unsorted list of integers.

//        List<Integer> numbers = Arrays.asList(42, 7, 19, 3, 85, 29, 10, 67, 5, 91);
//
//        int num = numbers.stream()
//                //to eleminate the distinct
////                .distinct()
//                .sorted((a , b) -> b-a)
//                //or
////                .sorted(Comparator.reverseOrder())
//                .skip(2)
//                .findFirst()
//                .orElse(-1);
//        System.out.println(num);

        //18. Transform a list of booleans to 1 for true and 0 for false.

//        List<Boolean> boolList = Arrays.asList(true , false, true, false, false, true);
//
//        boolList.stream()
//                .map(a -> a ? 1: 0)
//                .forEach(System.out::print);

//                19. Print the average order amount for all completed orders from a list of orders.


//        double avg = orderList.stream()
//                .filter(a -> a.getStatus().equalsIgnoreCase("Completed"))
//                .mapToDouble(Order::getAmount)
//                .average()
//                .orElse(0.0);

        //        20. Sum up all integers in a 2D array using Java Streams.
//        double[][] array = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//
//        double sum = Arrays.stream(array)  // Create a stream from the 2D array
//                .flatMapToDouble(Arrays::stream)  // Flatten the 2D array into a DoubleStream
//                .map(d -> (int)d)  // Convert Double to int
//                .sum();
//
//        System.out.println(sum);

        //        21. Concatenate all strings from a list into a single string.

//        String names = empList.stream()
//                .reduce((a , b) -> a + ", " + b)
//        or
//          .reduce((a , b) -> a.concat(", " + b))
//          .orElse("");
//        System.out.println(names);
//        //or we can use collectors.joining or string .join("delimiter")
//        String names3 = String.join(", " , empList);
//        System.out.println(names3);

//or
//        String names2 = empList.stream()
//                        .collect(Collectors.joining(", "));
//        System.out.println(names2);



//        empList.stream()
//                .collect(Collectors.groupingBy((s -> s.substring(0 ,1))))
//                .forEach((k , v) ->{
//                    System.out.println(k);
//                    v.forEach(System.out::print);
//                    System.out.println();
//                });
//        empList.stream()
//                .flatMap(s -> s.chars().mapToObj(c -> (char) c))
//                .distinct()
//                .forEach(System.out::print);

        //24. Find the highest-scoring player in each sport from a list of players

//        players.stream()
//                .collect(Collectors.groupingBy(Player::getSport ,
//                        Collectors.collectingAndThen(
//                            //collecting on the basis of max
//                                Collectors.maxBy(Comparator.comparingInt(Player::getScore))
//                                , Optional::get
//                        )));

//        System.out.println(employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDeptName,
//                        Collectors.collectingAndThen(
//                                Collectors.minBy(Comparator.comparing(Employee::getAge)),
//                                Optional::get
//
//                        ))));

//        employees.stream()
//                .collect(Collectors.groupingBy(Employee::getCity,
//                        Collectors.collectingAndThen(
//                                Collectors.maxBy(Comparator.comparing(Employee::getAge)),
//                                Optional::get
//                        )));
//                        //find the oldest employee in each city);

//                List<Integer> numbers = Arrays.asList(42, 7, 19, 3, 85, 29, 10, 67, 5, 91);
//
//            Set<Integer> st = new TreeSet<>((a , b) -> b-a);
//            st.addAll(numbers);
//            st.sort((a , b) -> b-a);
//            numbers.sort((a , b) -> b-a);
//    numbers.sort((a, b) -> b - a);

//        Map<Integer , Boolean> mp = new TreeMap<>((a , b) -> b-a);
//        mp.put(2 , true);
//        mp.put(1 , false);
//        mp.put(5 , false);
//        mp.put(4 , true);
//        mp.put(3 , false);
//
//        mp.forEach((k , v) -> {
//            System.out.println(k +":" + v);
//        });
//
//        mp.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue())
//                                .collect(Collectors.toMap(
//                                        Map.Entry::getKey,
//                                        Map.Entry::getValue,
//                                        (a ,b) -> a ,
//                                        LinkedHashMap::new
//                                )
//                );
                //                .map(Map.Entry::toMap)
//        Predicate<Integer> p1 = (a ) -> a == 1;
//        Predicate<Integer> p2 = (a ) -> a == 2;
////        Predicate<Integer> p = (a )-> ;
//        p1.or(p2);
////        p.test(3);
//
//        BiPredicate<Integer , Integer> bp1 = (a , b) -> a % b == 0;
//        BiPredicate<Integer , Integer> bp2 = (a , b) -> a == b;
////        bp1.test(3 , 4);
//
//        System.out.println(bp2.and(bp1).negate().test(2, 4));
//
//        //default and static
//
////        default: AND , OR
//
////        Boolean ans = p1.or(p2).test(2);
//
//
//        //AND and OR is used to compare two predicated
//
//
////        static: Negate
//
////        System.out.println(p2.negate().or(p1).test(1));
        //unary and function interface
//        UnaryOperator<Integer> f = (a) -> a/2;
//
////        System.out.println(f.apply(3));
//
//        Function<Integer , Integer> f2 = (a)-> a*a;
//
//        System.out.println(f.compose(f2).apply(2));

        //binary and biFunction Interface

//        BiFunction<Integer , Integer , Integer> bf = (a , b) -> a*b;
//
//        BinaryOperator<Integer> bp2 = BinaryOperator.minBy((a , b) ->{
//            return a>b?a:b;
//        });
//        System.out.println(bp2.apply(2 , 3));
//        bf.compose(f).apply(2 , 2);

//        Consumer<String> c = System.out::println;
////        c.accept("anmol");
//
//        Consumer<String> c2 = System.out::println;
//
//        c.andThen(c2).accept("anmol");

//        BiConsumer<String , String> bc = (a , b) -> System.out.println(a);
//        BiConsumer<String , String> bc1 = (a , b) -> System.out.println(b);
////
////        bc.andThen(bc1).accept("anmol" , "chintu");
//
//        Supplier<Integer> sup = () -> 2;
//
//        System.out.println(sup.get());


    }

    class addUtil{
        int addValue(int x , int b){
            return x+b;
        }
    }
    public static List<Employee> getEmployees() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));

        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));

        empList.add(new Employee(3, "def", 30, 115, "M", "HR", "Chennai", 2014));

        empList.add(new Employee(4, "ghi", 33, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "opq", 28, 150, "F", "IT", "Noida", 2013));

        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));

        empList.add(new Employee(7, "uvw", 26, 145, "F", "IT", "Pune", 2016));

        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandrum", 2015));

        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));

        return empList;

    }

    public static void practice() {
//        Given a list of integers, use map and filter to square all even numbers and then sum them.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 700, 8, 9, 10);

//        int sum = numbers.stream().map((addUtil::add).mapToInt(x -> x).sum();
//        System.out.println(sum);

//        Finding First Non-Empty String

//        List<String> names = Arrays.asList("", "", "John Doe", "Anmol Kumar");
//
//        names.stream().filter(name -> !name.isEmpty()).findFirst().ifPresent(System.out::println);

//        Given a list of integers, check if any number is greater than 100 using anyMatch.

//        boolean b = numbers.stream().anyMatch(number -> number > 100);
//        System.out.println(b);
//
//        int cnt = (int) numbers.stream().mapToDouble(x -> x).filter(number -> number % 3 == 0).count();
//
//        System.out.println(cnt);
    }
}
//.
//        25. Create a frequency map of integers from a list using Java Streams.
//        26. Use Java Streams to filter and print all prime numbers from a list of integers.
//27. Given a list of products (each with a name, price, and category), use Java Streams to find the cheapest product in each category.
//        28. Write a Java Streams expression to flatten a list of lists of integers into a single list of integers.
//29. From a list of scores (doubles), use Java Streams to print all scores that are a new high score, i.e., each score that is higher than all previous scores in the list.
//        30. Use Java Streams to calculate the standard deviation of a list of numbers.
//31. Given a list of transactions, each containing an amount and a currency, use Java Streams to sum all transactions in USD.
//32. Write a Java Stream expression to implement a natural language word frequency analyzer: given a list of sentences, find and print the frequency of each word across all sentences.
//33. Use Java Streams to remove duplicates from an array of strings and print the resulting array.
//        34. Given a set of student records (name, grade), use Java Streams to find and print the name of the student with the highest grade.
//        35. Implement a stream that takes a list of integers, multiplies each integer by 2, and retains only those results that are prime numbers, finally printing out these primes.
//        36. Given a list of Person objects, each with properties name, age, and list of skills, use Java streams to print the name of each person who has "Java" as one of their skills.
//37. Write a Java Streams expression to calculate the product (multiplication) of all elements in a list of integers.
//        38. Use Java Streams to find the longest string in a list of strings that contains the given substring.
//        39. Given a map where each key is a topic and each value is a list of books, use Java Streams to print the total number of books across all topics.
//40. Implement a function using Java Streams that checks if all strings in a list are of length greater than 5.
//        41. Write a Java Streams expression to transform a list of integers into a comma-separated string of their squared values.
//        42. Use Java Streams to find the second lowest integer in a list of integers.
//        43. Given a list of customer transactions (customerId, amount), use Java Streams to calculate and print the total transaction amount for each customer.
//        44. Implement a Java Stream that filters a list of timestamps (Long type), removing any that are from the previous month.
//        45. Use Java Streams to split a list of numbers into two lists: one containing multiples of 3, and the other containing all other numbers.