package Lesson05;

public class MAIN {
    public static void main(String[] args) {
        Employer [] employerArray = new Employer[5];
        employerArray[0] = new Employer("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 50000, 30);
        employerArray[1] = new Employer("Petrov Petr", "Teamlead", "teamdlead@mail.ru", "892312313", 130000, 45);
        employerArray[2] = new Employer("Danilov Daniil", "QA-Engineer", "qa@mailbox.com", "892312314", 50000, 35);
        employerArray[3] = new Employer("Dmitriev Dmitrij", "Java Developer", "java1@mailbox.com", "892312315", 70000, 38);
        employerArray[4] = new Employer("Pavlov Pavel", "Java Developer", "java2@mailbox.com", "892312317", 70000, 43);

        for (int i = 0; i < employerArray.length; i++) {
            if (employerArray[i].getAge() > 40) {
                employerArray[i].print();
            }
        }
    }
}
