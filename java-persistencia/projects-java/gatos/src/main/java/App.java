import client.mainView.MainViewComponent;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        Runnable runApplication = new Runnable () {
            public void run(){
                MainViewComponent view = new MainViewComponent();
                view.getClass();
            }
        };
        SwingUtilities.invokeLater(runApplication);
    }
}
