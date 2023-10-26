package lesson22.task2;

public class CheckIfAdult {
    public String checkIfAdult(int age) {
        String str = new String();
        if (age >= 18) {
            str = "You are adult";
        } else {
            str = "You aren't adult";
        }
        return str;
    }

}
