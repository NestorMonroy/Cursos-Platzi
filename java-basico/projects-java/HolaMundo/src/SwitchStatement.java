public class SwitchStatement {
    public static void main(String[] args) {

        String colorModeSelected = "1";
        switch (colorModeSelected) {
            case "Ligth":
                System.out.println("Selecionaste Ligth Mode ");
                break;
            case "Nigth": //Ambar
                System.out.println("Selecionaste Nigth Mode ");
                break;
            case "Blue Dark":
                System.out.println("Selecionaste Blue Dark Mode");
            case "Dark":
                System.out.println("Selecionaste Blue Dark Mode");
                break;

            default:
                System.out.println("Seleciona una opcion");
        }
    }
}
