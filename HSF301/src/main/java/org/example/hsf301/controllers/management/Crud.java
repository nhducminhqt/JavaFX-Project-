package org.example.hsf301.controllers.management;

import javafx.scene.control.Button;
import org.example.hsf301.pojo.Tours;

public abstract class Crud<T> {

    protected Button createStyledButton(String text, String color) {
        Button button = new Button(text);
        button.setStyle(
            String.format("-fx-background-color: %s; " +
                              "-fx-text-fill: white; " +
                              "-fx-font-size: 12px; " +
                              "-fx-padding: 5 10; " +
                              "-fx-cursor: hand; " +
                              "-fx-background-radius: 3;", color)
        );
        return button;
    }

    private void handleAdd(T element) {
        System.out.println("Add: ");
        // TODO: Implement edit logic
    }

    public abstract void handleAdd(Tours tour);

    private void handleEdit(T element) {
        System.out.println("Editing: ");
        // TODO: Implement edit logic
    }

    public abstract void handleEdit(Tours tour);

    private void handleDelete(T element) {
        System.out.println("Deleting: ");
    }

    public abstract void handleDelete(Tours tour);

    private void handleView(T element) {
        System.out.println("Viewing ");
    }

    public abstract void handleView(Tours tour);
}
