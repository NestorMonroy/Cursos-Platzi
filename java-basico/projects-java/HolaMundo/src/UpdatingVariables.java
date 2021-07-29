public class UpdatingVariables {
    public static void main(String[] args) {
        int salary = 1000;
        //Salario total
        //bono $200
        salary = salary + 200;
        System.out.println(salary);

        //pension $50 pesos
        salary = salary - 50; // operaciones matematicas para alterar sus datos
        System.out.println(salary);

        //2 horas extra $30
        //Comida: $45

        salary = salary + (30*2) - 45;
        System.out.println(salary);
        
        //Actualizando cadenas de texto
        String employeeName  = "Nestor Monroy";
        employeeName = employeeName + " Valero"; //concatenar un valor +
        System.out.println(employeeName);

        employeeName = "David " + employeeName;
        System.out.println("Tu nombre es " + employeeName);
    }
}
