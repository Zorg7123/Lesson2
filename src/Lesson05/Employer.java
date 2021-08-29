package Lesson05;

public class Employer {
    public String name;
    public String post;
    public String email;
    public String telephone;
    public int salary;
    public int age;

    public int getAge() {
        return age;
    }

    public Employer(String name, String post, String email, String telephone, int salary, int age) {
    this.name = name;
    this.post = post;
    this.email = email;
    this.telephone = telephone;
    this.salary = salary;
    this.age = age;
    }

    public void  print() {
        System.out.println("Имя:" + name + " | " + "Должность:" + post + " | " + "e-mail:" + email + " | "
                + "Тел.:" + telephone + " | " + "з/п:" + salary + " | " + "Возраст:" + age);
    }
}
