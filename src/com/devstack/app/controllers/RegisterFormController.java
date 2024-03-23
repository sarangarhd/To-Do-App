package com.devstack.app.controllers;

import com.devstack.app.db.HibernateUtill;
import com.devstack.app.model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class RegisterFormController {
    public AnchorPane context;
    public TextField txtFullName;
    public PasswordField txtPassword;
    public TextField txtUsername;

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        User user= User.builder()
                .fullName(txtFullName.getText())
                .userName(txtUsername.getText())
                .password(txtPassword.getText())
                .build();

        try (Session session=HibernateUtill.openSession()){
            Transaction transaction=session.beginTransaction();
            session.save(user);
            transaction.commit();
        }

        new Alert(Alert.AlertType.INFORMATION,"User Wads saved...!", ButtonType.CLOSE).show();
    }

    public void btnAlredyHaveAnAccount(ActionEvent actionEvent) {
    }
}
