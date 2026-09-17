
package storager;

import storager.Item;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

  @FXML
  TextField searchBar;

  @FXML
  TextField insertBar;

  @FXML
  TextField insertBarQt;

  @FXML
  Button btAdd;

  @FXML
  Button btSearch;

  @FXML
  Button btRemove;

  @FXML
  Button btEdit;

  @FXML
  private TableView<Item> tableView;

  @FXML
  private TableColumn<Item, String> nameItem;

  @FXML
  private TableColumn<Item, Integer> qtdItem;

  public void initialize(URL url, ResourceBundle resourceBundle) {
    nameItem.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
    qtdItem.setCellValueFactory(new PropertyValueFactory<Item, Integer>("ItemQt"));
    tableView.setEditable(true);

    nameItem.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
    nameItem.setCellFactory(TextFieldTableCell.forTableColumn());

    qtdItem.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemQt"));
    qtdItem.setCellFactory(TextFieldTableCell.forTableColumn(new javafx.util.converter.IntegerStringConverter()));

    nameItem.setOnEditCommit(event -> {
      Item item = event.getTableView().getItems().get(event.getTablePosition().getRow());
      item.setItemName(event.getNewValue());
    });

    qtdItem.setOnEditCommit(event -> {
      Item item = event.getTableView().getItems().get(event.getTablePosition().getRow());
      item.setItemQt(event.getNewValue());
    });
  }

  @FXML
  public void submit(ActionEvent event) {
    Item item = new Item(insertBar.getText(), Integer.parseInt(insertBarQt.getText()));
    ObservableList<Item> items = tableView.getItems();
    items.add(item);
    tableView.setItems(items);
  }

  @FXML
  public void removeItem(ActionEvent event) {
    Item selectedItem = tableView.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
      tableView.getItems().remove(selectedItem);
    }

  }

}
