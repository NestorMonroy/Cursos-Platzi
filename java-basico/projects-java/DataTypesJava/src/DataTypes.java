public class DataTypes {
    public static void main(String[] args) {
        int n = 1234567890;
        long nL = 123456789001L;
        double nD = 123.4561786957854;
        float nF= 1.23456F;

        var salary = 1000; // int
        // pension 3%
        var pension = salary * 0.03; // double
        // de int - double
        var totalSalary = salary - pension;
        

        System.out.println(salary);
        System.out.println(pension);
        System.out.println(totalSalary);

        var employeeName= "Nestor Monroy";
        System.out.println("EPLOYEE: " + employeeName + " SALARY: " +totalSalary);

    }
}
