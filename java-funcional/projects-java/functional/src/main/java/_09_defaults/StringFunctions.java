package _09_defaults;

public class StringFunctions {

    @FunctionalInterface
    interface StringOperation{
        int getAmount();

        default void operate(String text){
            int x = getAmount();
            while (x-- > 0){
                System.out.println(text);
            }
        }
    }

    @FunctionalInterface
    interface DoOperation{
        void take(String text);
        default void execute(Integer x, String text) {
            while (x-- > 0){
                take(text);
            }
        }
    }

    //Interface que realice querys a base de datos y tener un metodo defaul que haga la conexion
    //Operar sobre un archivo
    //Definir un metodo, para despues pasarle datos
    public static void main(String[] args) {
        StringOperation six = () -> 6;
        six.operate("Alumno");

        DoOperation operationFive = text -> System.out.println(text);
        operationFive.execute(5,"Nestor");
    }
}
