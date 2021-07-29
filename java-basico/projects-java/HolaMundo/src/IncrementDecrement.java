public class IncrementDecrement {
    public static void main(String[] args) {
        int lives = 5;
        lives = lives -1;
        System.out.println(lives); // 4
        // Postfija
        lives--; //Decremento
        System.out.println(lives); // 3

        lives++; // Incremento   //4
        System.out.println(lives);

        //Gana un regalo por ganar una vida
//        int gift = 100 + lives++; // potsfijo
//        System.out.println(gift);
//        System.out.println(lives);

        //Prefijo
        int giftPost = 100 + ++lives; // potsfijo
        System.out.println(giftPost);
        System.out.println(lives);

    }
}
