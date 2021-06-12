package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

/**
 * klein Application that allows us to select File in the  Explorer.
 */
public class Controller {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private ListView<String> listview;

    public void Button1Action(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\sylva\\OneDrive\\Bilder\\Saved Pictures"));//i want to choose the file Save pictures with the path
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File selectedFile = fc.showOpenDialog(null);


        if (selectedFile != null) {
            //listview.getItems().add(selectedFile.getName());
            listview.getItems().add(selectedFile.getAbsolutePath());
        } else {
            System.out.println("file is not valid");
        }
    }

    public void Button2Action(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\sylva\\OneDrive\\Bilder\\Saved Pictures"));//i want to choose the file Save pictures with the path
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);


        if (selectedFiles != null) {
            //listview.getItems().add(selectedFile.getName());
            for (int i = 0; i < selectedFiles.size(); i++) {
                listview.getItems().add(selectedFiles.get(i).getAbsolutePath());
            }
        } else {
            System.out.println("file is not valid");
        }
    }

}
