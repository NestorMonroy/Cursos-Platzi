public class Casting {
    public static void main(String[] args) {
        //1 ano ubicar 30 perritos
        // Cuantos perritos ubique al mes

        double mothlyDogs = 30.0/12.0;
        System.out.println(mothlyDogs);

        //ESTIMACION
        int estimatedMonthkyDogs = (int) mothlyDogs;
        System.out.println(estimatedMonthkyDogs);

        //Exactitud

        int a = 30;
        int b = 12;
        System.out.println((double) a/b);

        double c = (double) a/b;
        System.out.println(c);

        char n = '1';
        int nI = n;
        System.out.println(nI); // Numero 49

        short nS = (short) n;
        System.out.println(nS);

    }
}
