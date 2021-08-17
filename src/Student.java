import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {
    String name, uniformSize, uniformColor;

    // Constructor


    public Student(String name, String uniformSize, String uniformColor) {
        this.name = name;
        this.uniformSize = uniformSize;
        this.uniformColor = uniformColor;
    }

    // Used to print student details in main()
    public String toString() {
        return this.uniformColor + " " + this.uniformSize + " "
                + this.name;
    }

//    static class SortByName implements Comparator<Student> {
//        // Used for sorting in ascending order of
//        // name
//        public int compare(Student a, Student b) {
//            return a.name.compareTo(b.name);
//        }
//    }
//
//    static class SortByUniformColor implements Comparator<Student> {
//        public int compare(Student a, Student b) {
//            return a.uniformColor.compareTo(b.uniformColor);
//        }
//    }
//
//    static class SortByUniformSize implements Comparator<Student> {
//        public int compare(Student a, Student b) {
//            return -a.uniformSize.compareTo(b.uniformSize);
//        }
//    }

    static class UniformComparator implements Comparator<Student> {
        public int compare(Student a, Student b) {
            int res = a.uniformColor.compareTo(b.uniformColor);
            if (res == 0) {
                res = a.uniformSize.compareTo(b.uniformSize);

                if (res == 0) {
                    res = a.name.compareTo(b.name);
                } else {
                    res = -res;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Maria Jose", "P", "branco"));
        students.add(new Student("Mangojata Mancuda", "P", "vermelho"));
        students.add(new Student("Cezar Torres Mo", "P", "branco"));
        students.add(new Student("Baka Lhau", "P", "vermelho"));
        students.add(new Student("Juju Mentina", "M", "branco"));
        students.add(new Student("Amaro Dinha", "P", "vermelho"));
        students.add(new Student("Adabi Finho", "G", "branco"));
        students.add(new Student("Severina Rigudinha", "G", "branco"));
        students.add(new Student("Carlos Chade Losna", "P", "vermelho"));


        System.out.println("Unsorted");
        for (Student student : students) {
            System.out.println(student);
        }

        students.sort(new UniformComparator());

        System.out.println("\nSorted: ");
        for (Student student : students) {
            System.out.println(student);
        }


    }
}
