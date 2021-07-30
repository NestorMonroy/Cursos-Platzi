public class Funciones {
    public static void main(String[] args) {
        double y = 3;
        //Area de un circulo
        //pi*r2

        System.out.println(circleArea(y));

        //Area de una esfera
        //4*PI*r2
        System.out.println(spheraArea(y));

        //Volumen de una esfera
        //(4/3)*PI* r3
        System.out.println(spheraVolume(y));


        //Pesos a dolores
        System.out.println("PESOS A DOLARES " + converToDolar(1000, "COP"));
    }

    public static double circleArea(double r){
        return Math.PI * Math.pow(r,2);
    }

    public static double spheraArea(double r){
        return  4 * Math.PI * Math.pow(r,2);
    }

    public static double spheraVolume(double r){
        return  (4/3) * Math.PI * Math.pow(r,3);
    }

    /**
     * Descripcion: Funcion que especificando su moneda convierte a dolores
     *
     * @param quantity Cantidad de dinero
     * @param currency Tipo de moneda: Solo acepta MXN o Cop
     * @return quantity Devuelve la cantidad en dolares
     *
     * */
    public static  double converToDolar(double quantity, String currency){
        switch (currency){
            case "MXN":
                quantity = quantity * 0.82;
                break;
            case "COP":
                quantity = quantity * 0.0031;
                break;
        }
        return  quantity;
    }
}
