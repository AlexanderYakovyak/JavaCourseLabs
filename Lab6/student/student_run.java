package student;

import java.util.Scanner;
import java.util.*;

public class student_run {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Student student1 = new Student(1, "Oleksandr", "Yakoviak", "Victorovich","29-01-2003",
                "Some","099","MMF", "3","2");

        Student student2 = new Student(2, "Name2", "Surname2", "Patronymic2","18-02-2005",
                "Address2","2","Faculty2", "1","1");

        Student student3 = new Student(3, "Name3", "Surname3", "Patronymic3","09-09-2002",
                "Address3","3","Faculty3", "4","2");

        Student student4 = new Student(4, "Name4", "Surname4", "Patronymic4","15-11-2005",
                "Address4","4","Faculty2", "1","1");

        Student student5 = new Student(5, "Name5", "Surname5", "Patronymic5","01-01-2004",
                "Address5","5","MMF", "2","2");

        Student[] students = Student.toList(5,student1,student2,student3,student4,student5);

        System.out.print("Введіть факультет, список студентів якого ви хочете отримати: ");
        String fac = sc.nextLine();

        System.out.println("\nСтуденти, що навчаються на цьому факультеті: ");
        for(Student student:students){
            if(fac.equals(student.getFaculty()))
                System.out.println(student);
        }
        System.out.println('\n');

        Set<String> faculties = new HashSet<String>();
        Set<String> years = new HashSet<String>();

        for(Student student:students){
            faculties.add(student.getFaculty());
            years.add(student.getYear());
        }

        for(String faculty: faculties){
            System.out.printf("Список студентів, що навчаються на %s факультеті \n", faculty);
            for(Student student: students){
                if(student.getFaculty().equals(faculty)){
                    System.out.println(student);
                }
            }
            System.out.println("\n");
        }

        for(String year: years){
            System.out.printf("Список студентів, що навчаються на %s курсі \n", year);
            for(Student student: students){
                if(student.getYear().equals(year)){
                    System.out.println(student);
                }
            }
            System.out.println("\n");
        }

        System.out.print("Введіть рік, щоб отримати список студентів, що народились після цього року: ");
        int year = sc.nextInt();

        System.out.println("\nСтуденти, що народились після цього року: ");
        for(Student student:students){
            String[] date = student.getBirth_date().split("-");
            int birth_year = Integer.parseInt(date[2]);
            if(birth_year>year)
                System.out.println(student);
        }
        System.out.println('\n');

        System.out.print("Введіть групу, список студентів якої ви хочете отримати: ");
        sc.nextLine();
        String group = sc.nextLine();

        System.out.println("\nСтуденти, що навчаються в цій групі: ");
        for(Student student:students){
            if(group.equals(student.getGroup()))
                System.out.println(student);
        }
        System.out.println('\n');

    }
}
