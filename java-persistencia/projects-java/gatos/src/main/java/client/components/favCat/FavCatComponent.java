package client.components.favCat;

import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import java.awt.event.ActionEvent;

import client.components.catList.CatListComponent;
import models.FavouriteCat;
import services.logicServices.CatService;

public class FavCatComponent implements ActionListener {

    private FavCatTemplate favCatTemplate;
    private FavouriteCat cat;
    private CatListComponent catListComponent;
    private CatService sCat;

    public FavCatComponent(CatListComponent catListComponent, FavouriteCat cat) {
        this.catListComponent = catListComponent;
        this.cat = cat;
        this.sCat = CatService.getService();
        this.favCatTemplate = new FavCatTemplate(this, cat);
    }

    public FavCatTemplate getFavCatTemplate() {
        return favCatTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.deleteFavouriteCat();
    }

    public void deleteFavouriteCat() {
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected void done() {
                try {
                    Boolean result = get();
                    if (result) {
                        catListComponent.getCatListTemplate().remove(catListComponent.getCatListTemplate().getPList());
                        catListComponent.getFavouriteCatList();
                        JOptionPane.showMessageDialog(null, "Eliminación Exitosa", "Advertencia", 1);
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    System.out.println(ex);
                }
            }

            @Override
            protected Boolean doInBackground() throws Exception {
                return sCat.deleteFavourite(cat);
            }
        };
        worker.execute();
    }
}
