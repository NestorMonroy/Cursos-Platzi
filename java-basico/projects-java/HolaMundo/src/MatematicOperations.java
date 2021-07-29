public class MatematicOperations {
    public static void main(String[] args) {
        double x = 2.1;
        double y = 3;

        System.out.println(Math.PI);
        System.out.println(Math.E);

        //Devuelve un entero hacia arriba
        System.out.println(Math.ceil(x));

        //Devuelve un entero hacia abajo
        System.out.println(Math.floor(x));

        //Devuelve un numero elevado a otro numero
        System.out.println(Math.pow(x,y));

        // Devuelve el numero mayor
        System.out.println(Math.max(x,y));

        //Devuelve la raiz cuadrana
        System.out.println(Math.sqrt(y));

        //Area de un circulo
        //pi*r2
        System.out.println(Math.PI * Math.pow(y,2));

        //Area de una esfera
        //4*PI*r2
        System.out.println(4 * Math.PI * Math.pow(y,2));

        //Volumen de una esfera
        //(4/3)*PI* r3
        System.out.println((4/3) * Math.PI * Math.pow(y,3));
    }
}
