public class Arrays {
    public static void main(String[] args) {
        String[] androidVersions = new String[17]; // Se tiene que definir el tamano del arreglo
        int days[] = new  int[7];

        String[][] cities = new String[4][2]; // 4*2 = 8
        /*
        * -------------------------
        * |Country    | City       |
        * --------------------------
        * |Mexico     | CDMX       |
        * |Mexico     | Gudalajara |
        * |Colombia   | Bogota     |
        * |Colombia   | Medellin   |
        * --------------------------
        * */

        int [][][] numbers = new int[2][2][2];
        int [][][][] numbers4 = new int[2][2][2][2];

        androidVersions[0] = "Apple Pie";
        androidVersions[1] = "Bannana Bread";
        androidVersions[2] = "Cupcake";
        androidVersions[3] = "Donut";
                                //17
        for (int i = 0; i < androidVersions.length ; i++) {
            System.out.println(androidVersions[i]);
        }

        System.out.println();
        System.out.println();
        
        for (String androidVersion : androidVersions) {
            System.out.println(androidVersion);
        }

        /*


        for (int i = 0; i < days.length ; i++) {
            System.out.println(i);
        }

        System.out.println(androidVersions[0]);
        System.out.println(androidVersions[1]);
        System.out.println(androidVersions[2]);
        System.out.println(androidVersions[3]);

        */

        System.out.println();
        System.out.println();

        cities[0][0] = "Colombia";
        cities[0][1] = "Medellin";
        cities[1][0] = "Colombia";
        cities[1][1] = "Bogota";
        cities[2][0] = "Mexico";
        cities[2][1] = "Guadalajara";
        cities[3][0] = "Mexico";
        cities[3][1] = "CDMX";

        /*

        System.out.println(cities[0][0]);
        System.out.println(cities[0][1]);
        System.out.println(cities[1][0]);
        System.out.println(cities[1][1]);
        System.out.println(cities[2][0]);
        System.out.println(cities[2][1]);
        System.out.println(cities[3][0]);
        System.out.println(cities[3][1]);

        

        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[i].length; j++) {
                System.out.println(cities[i][j]);
            }
        }
        
        */
        //Return numero de id
        for (String[] pair:cities) {
            for (String name: pair){
                System.out.println(name);
            }
            
        }

        String[][][][] animals = new String[2][3][2][2];
        animals[1][0][0][1] = "Monkey";
        /*
        System.out.println(animals[1][0][0][1]);
         */
        System.out.println();
        System.out.println();
        
        for (int i = 0; i <= 1 ; i++) {
            for (int j = 0; j <=0 ; j++) {
                for (int k = 0; k <= 0; k++) {
                    for (int l = 0; l <=1 ; l++) {
                        System.out.println(animals[i][j][k][l]);
                    }

                }

            }
        }

    }
}
