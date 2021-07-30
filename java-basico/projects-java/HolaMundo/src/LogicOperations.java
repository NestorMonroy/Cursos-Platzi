public class LogicOperations {
    public static void main(String[] args) {
        int a = 8;
        int b = 5;

        //Operadores asignacion
        System.out.println("a es igual a b -> " + (a == b));
        System.out.println("a es diferente a b -> " + (a != b));

        //Operaciones Relacionales
        System.out.println("a es mayor a b -> " + (a > b));
        System.out.println("a es menor a b -> " + (a < b));
        System.out.println("a es mayor o igual a b -> " + (a >= b));
        System.out.println("a es menor o igual a b -> " + (a <= b));

        int i=1, j=2, k=3, m=2; System.out.println ((j >= i) || (k == m));

        if (a==b){
            System.out.println("a es igual a b ");
        }else if((a != b) && (a > b)){
            System.out.println("a es diferente a b");
        }else if(a > b){
            System.out.println("a es menor a b " );
        }else if(a < b){
            System.out.println("a es mayor a b " );
        }else if(a >= b){
            System.out.println("a es mayor o igual a b ");
        }else if(a <= b){
            System.out.println("a es menor o igual a b ");
        }

    }
}
