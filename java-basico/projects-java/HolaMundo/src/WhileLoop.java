public class WhileLoop {

    static boolean isTurnOnLigth = false;
    public static void main(String[] args) {
        turnOnOffLigth();

        int i = 1;
        while (isTurnOnLigth && i<=10){
            printSOS();
            i++;
        }

    }

    // void no regresa nada
    public static void printSOS(){
        System.out.println("... ___ ...");
    }

    public static boolean turnOnOffLigth(){

        // Operador ternario
        isTurnOnLigth = (isTurnOnLigth)?false:true;
        /*
        if (isTurnOnLigth) {
            isTurnOnLigth = false;
        }else {
            isTurnOnLigth = true;
        }
         */
        return  isTurnOnLigth;
    }
}
