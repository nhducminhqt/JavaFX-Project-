package org.example.hsf301.controllers.management;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public abstract class Crud<T> {

    protected HBox crudButtons = new HBox(5);

    public Crud() {
        crudButtons.setAlignment(Pos.CENTER);
    }

    // Method to add buttons to the HBox
    protected void setupCrudButtons(T item) {
        Button editButton = createStyledButton("Edit", "#f39c12");
        Button deleteButton = createStyledButton("Delete", "#e74c3c");
        Button viewButton = createStyledButton("View", "#3498db");

        editButton.setOnAction(event -> handleEdit(item));
        deleteButton.setOnAction(event -> handleDelete(item));
        viewButton.setOnAction(event -> handleView(item));

        crudButtons.getChildren().setAll(viewButton, editButton, deleteButton);
    }

    protected Button createStyledButton(String text, String color) {
        Button button = new Button(text);
        button.setStyle(String.format(
            "-fx-background-color: %s; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 12px; " +
                "-fx-padding: 5 10; " +
                "-fx-cursor: hand; " +
                "-fx-background-radius: 3;", color));
        return button;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void handleAdd(T item);

    public abstract void handleEdit(T item);

    public abstract void handleDelete(T item);

    public abstract void handleView(T item);
}
