/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cafeshopmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author MD Mahabubur Rahman
 */
public class mainFormController implements Initializable {

    @FXML
    private AnchorPane main_form;
    @FXML
    private Label username;
    @FXML
    private Button dashboard_btn;
    @FXML
    private Button inventory_btn;
    @FXML
    private Button menu_btn;
    @FXML
    private Button customers_btn;
    @FXML
    private Button logout_btn;
    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private Label dashboard_NC;
    @FXML
    private Label dashboard_TI;
    @FXML
    private Label dashboard_TotalI;
    @FXML
    private Label dashboard_NSP;
    @FXML
    private AreaChart<?, ?> dashboard_incomeChart;
    @FXML
    private BarChart<?, ?> dashboard_CustomerChart;
    @FXML
    private AnchorPane inventory_form;
    @FXML
    private TableView<?> inventory_tableView;
    @FXML
    private TableColumn<?, ?> inventory_col_productID;
    @FXML
    private TableColumn<?, ?> inventory_col_productName;
    @FXML
    private TableColumn<?, ?> inventory_col_type;
    @FXML
    private TableColumn<?, ?> inventory_col_stock;
    @FXML
    private TableColumn<?, ?> inventory_col_price;
    @FXML
    private TableColumn<?, ?> inventory_col_status;
    @FXML
    private TableColumn<?, ?> inventory_col_date;
    @FXML
    private TextField inventory_productID;
    @FXML
    private TextField inventory_productName;
    @FXML
    private ComboBox<?> inventory_type;
    @FXML
    private TextField inventory_stock;
    @FXML
    private TextField inventory_price;
    @FXML
    private ImageView inventory_imageView;
    @FXML
    private Button inventory_importBtn;
    @FXML
    private Button inventory_addBtn;
    @FXML
    private Button inventory_updateBtn;
    @FXML
    private Button inventory_clearBtn;
    @FXML
    private Button inventory_deleteBtn;
    @FXML
    private ComboBox<?> inventory_status;
    @FXML
    private AnchorPane menu_form;
    @FXML
    private ScrollPane menu_scrollPane;
    @FXML
    private GridPane menu_gridPane;
    @FXML
    private TableView<?> menu_tableView;
    @FXML
    private TableColumn<?, ?> menu_col_productName;
    @FXML
    private TableColumn<?, ?> menu_col_quantity;
    @FXML
    private TableColumn<?, ?> menu_col_price;
    @FXML
    private Label menu_total;
    @FXML
    private TextField menu_amount;
    @FXML
    private Label menu_change;
    @FXML
    private Button menu_payBtn;
    @FXML
    private Button menu_removeBtn;
    @FXML
    private Button menu_receiptBtn;
    @FXML
    private AnchorPane customers_form;
    @FXML
    private TableView<?> customers_tableView;
    @FXML
    private TableColumn<?, ?> customers_col_customerID;
    @FXML
    private TableColumn<?, ?> customers_col_total;
    @FXML
    private TableColumn<?, ?> customers_col_date;
    @FXML
    private TableColumn<?, ?> customers_col_cashier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchForm(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void inventorySelectData(MouseEvent event) {
    }

    @FXML
    private void inventoryImportBtn(ActionEvent event) {
    }

    @FXML
    private void inventoryAddBtn(ActionEvent event) {
    }

    @FXML
    private void inventoryUpdateBtn(ActionEvent event) {
    }

    @FXML
    private void inventoryClearBtn(ActionEvent event) {
    }

    @FXML
    private void inventoryDeleteBtn(ActionEvent event) {
    }

    @FXML
    private void menuSelectOrder(MouseEvent event) {
    }

    @FXML
    private void menuAmount(ActionEvent event) {
    }

    @FXML
    private void menuPayBtn(ActionEvent event) {
    }

    @FXML
    private void menuRemoveBtn(ActionEvent event) {
    }

    @FXML
    private void menuReceiptBtn(ActionEvent event) {
    }
    
}
