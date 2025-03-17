package org.example.Practice.Stream;

public class Employee {

    private int id;

    private String name;

    private int age;

    private long salary;

    private String gender;

    private String deptName;

    private String city;

    private int yearOfJoining;

    public Employee(int id, String name, int age, long salary, String gender,

                    String deptName, String city, int yearOfJoining) {

        this.id = id;

        this.name = name;

        this.age = age;

        this.salary = salary;

        this.gender = gender;

        this.deptName = deptName;

        this.city = city;

        this.yearOfJoining = yearOfJoining;

    }

    // Getters and setters omitted for brevity

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getCity() {
        return city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    @Override

    public String toString() {

        return "Employee{" +

                "id=" + id +

                ", name='" + name + '\'' +

                ", age=" + age +

                ", salary=" + salary +

                ", gender='" + gender + '\'' +

                ", deptName='" + deptName + '\'' +

                ", city='" + city + '\'' +

                ", yearOfJoining='" + yearOfJoining + '\'' +

                '}';

    }

}
