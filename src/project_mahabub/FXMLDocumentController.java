package project_mahabub;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXMLDocumentController implements Initializable {

    @FXML
    private PasswordField lo_password;
    @FXML
    private Button loginbtn;
    @FXML
    private TextField ca_username;
    @FXML
    private PasswordField ca_password;
    @FXML
    private Button signup_btn;
    @FXML
    private ComboBox<String> ca_quesions;
    @FXML
    private TextField ca_answer;
    @FXML
    private AnchorPane side_form;
    @FXML
    private Button side_haveacbtn;
    @FXML
    private Button side_createacbtn;
    @FXML
    private AnchorPane login_form;
    @FXML
    private TextField lo_username;
    @FXML
    private Hyperlink forgetpass;
    @FXML
    private AnchorPane registerForm;
    @FXML
    private AnchorPane fp_question_form;
    @FXML
    private Button fp_proceedbtn;
    @FXML
    private ComboBox<?> fp_question;
    @FXML
    private TextField fp_answer;
    @FXML
    private Button fp_back;
    @FXML
    private AnchorPane np_rnwPassForm;
    @FXML
    private Button np_changPassBtn;
    @FXML
    private Button np_back;
    @FXML
    private PasswordField np_newPass;
    @FXML
    private PasswordField np_confirmpass;
    @FXML
    private TextField fp_username;

    private Connection connect;
    private PreparedStatement preprare;
    private ResultSet result;
    private Alert alert;

    private String[] questionList = {
        "What is your favorite color?",
        "What is your favorite food?",
        "What is your favorite pet?"
    };

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        regLquestionList();
    }

    public void regLquestionList() {
        List<String> listQ = new ArrayList<>();
        for (String data : questionList) {
            listQ.add(data);
        }
        ObservableList<String> listData = FXCollections.observableArrayList(listQ);
        ca_quesions.setItems(listData);
    }

    @FXML
    public void loginBtn() {
        if (lo_username.getText().isEmpty() || lo_password.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect username/password!");
            alert.showAndWait();
        } else {
            String selectData = "SELECT username, password FROM employee WHERE username=? AND password=?";
            connect = database.connectDB();

            try {
                if (connect == null) {
                    throw new Exception("Database connection failed!");
                }

                preprare = connect.prepareStatement(selectData);
                preprare.setString(1, lo_username.getText());
                preprare.setString(2, lo_password.getText());
                result = preprare.executeQuery();

                if (result.next()) {
                    // to get the username
                   data.username = lo_username.getText();
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully logged in!");
                    alert.showAndWait();
                    
                    //Link your mainForm
                     Parent root = FXMLLoader.load(getClass().getResource("mainForm.fxml"));
                    
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    stage.setTitle("Cafe Shop Management System");
                    stage.setMinWidth(1100);
                    stage.setMinHeight(600);
                    
                    stage.setScene(scene);
                    stage.show();
                    
                    loginbtn.getScene().getWindow().hide();
                    
                    
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect username/password!");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database Error");
                alert.setHeaderText(null);
                alert.setContentText("Database error: " + e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void regBtn(ActionEvent event) {
        if (ca_username.getText().isEmpty() || ca_password.getText().isEmpty()
                || ca_quesions.getSelectionModel().getSelectedItem() == null
                || ca_answer.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields!");
            alert.showAndWait();
        } else {
            String regData = "INSERT INTO employee (username, password, question, answer, date) VALUES (?,?,?,?,?)";
            connect = database.connectDB();

            try {
                if (connect == null) throw new Exception("Database connection failed!");

                String checkUsername = "SELECT username FROM employee WHERE username = ?";
                preprare = connect.prepareStatement(checkUsername);
                preprare.setString(1, ca_username.getText());
                result = preprare.executeQuery();

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(ca_username.getText() + " is already taken!");
                    alert.showAndWait();
                } else if (ca_password.getText().length() < 8) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Password must be at least 8 characters!");
                    alert.showAndWait();
                } else {
                    preprare = connect.prepareStatement(regData);
                    preprare.setString(1, ca_username.getText());
                    preprare.setString(2, ca_password.getText());
                    preprare.setString(3, ca_quesions.getSelectionModel().getSelectedItem());
                    preprare.setString(4, ca_answer.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    preprare.setDate(5, sqlDate);

                    preprare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully registered!");
                    alert.showAndWait();

                    ca_username.setText("");
                    ca_password.setText("");
                    ca_quesions.getSelectionModel().clearSelection();
                    ca_answer.setText("");

                    TranslateTransition slider = new TranslateTransition();
                    slider.setNode(side_form);
                    slider.setToX(0);
                    slider.setDuration(Duration.seconds(0.5));
                    slider.setOnFinished((ActionEvent e) -> {
                        side_haveacbtn.setVisible(false);
                        side_createacbtn.setVisible(true);
                    });
                    slider.play();
                }

            } catch (Exception e) {
                e.printStackTrace();
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database Error");
                alert.setHeaderText(null);
                alert.setContentText("Registration failed: " + e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void switchFogotPass() {
        fp_question_form.setVisible(true);
        login_form.setVisible(false);
        forgotPassQuestionList();
    }

    public void proceedBtn() {
        if (fp_username.getText().isEmpty() || fp_question.getSelectionModel().getSelectedItem() == null
                || fp_answer.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            String selectData = "SELECT username, question, answer FROM employee WHERE username = ? AND question = ? AND answer = ?";
            connect = database.connectDB();

            try {
                preprare = connect.prepareStatement(selectData);
                preprare.setString(1, fp_username.getText());
                preprare.setString(2, (String) fp_question.getSelectionModel().getSelectedItem());
                preprare.setString(3, fp_answer.getText());

                result = preprare.executeQuery();

                if (result.next()) {
                    np_rnwPassForm.setVisible(true);
                    fp_question_form.setVisible(false);
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect Information");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void changePassBtn() {
        if (np_newPass.getText().isEmpty() || np_confirmpass.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else if (!np_newPass.getText().equals(np_confirmpass.getText())) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Passwords do not match");
            alert.showAndWait();
        } else {
            connect = database.connectDB();

            try {
                String getDate = "SELECT date FROM employee WHERE username = ?";
                preprare = connect.prepareStatement(getDate);
                preprare.setString(1, fp_username.getText());
                result = preprare.executeQuery();

                String date = "";
                if (result.next()) {
                    date = result.getString("date");
                }

                String updatePass = "UPDATE employee SET password = ?, question = ?, answer = ?, date = ? WHERE username = ?";
                preprare = connect.prepareStatement(updatePass);
                preprare.setString(1, np_newPass.getText());
                preprare.setString(2, (String) fp_question.getSelectionModel().getSelectedItem());
                preprare.setString(3, fp_answer.getText());
                preprare.setString(4, date);
                preprare.setString(5, fp_username.getText());

                preprare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully changed Password!");
                alert.showAndWait();

                login_form.setVisible(true);
                np_rnwPassForm.setVisible(false);

                np_confirmpass.setText("");
                np_newPass.setText("");
                fp_question.getSelectionModel().clearSelection();
                fp_answer.setText("");
                fp_username.setText("");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void forgotPassQuestionList() {
        List<String> listQ = new ArrayList<>();
        for (String data : questionList) {
            listQ.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listQ);
        fp_question.setItems(listData);
    }

    public void backToLoginForm() {
        login_form.setVisible(true);
        fp_question_form.setVisible(false);
    }

    public void backToQuestionForm() {
        fp_question_form.setVisible(true);
        np_rnwPassForm.setVisible(false);
    }

    @FXML
    private void switchForm(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        slider.setNode(side_form);
        slider.setDuration(Duration.seconds(0.5));

        if (event.getSource() == side_createacbtn) {
            slider.setToX(300);
            slider.setOnFinished((ActionEvent e) -> {
                side_haveacbtn.setVisible(true);
                side_createacbtn.setVisible(false);
                fp_question_form.setVisible(false);
                login_form.setVisible(true);
                np_rnwPassForm.setVisible(false);
                regLquestionList();
            });
            slider.play();
        } else if (event.getSource() == side_haveacbtn) {
            slider.setToX(0);
            slider.setOnFinished((ActionEvent e) -> {
                side_haveacbtn.setVisible(false);
                side_createacbtn.setVisible(true);
                fp_question_form.setVisible(false);
                login_form.setVisible(true);
                np_rnwPassForm.setVisible(false);
            });
            slider.play();
        }
    }

    private void loginAction(ActionEvent event) {
        loginBtn();
    }
}
