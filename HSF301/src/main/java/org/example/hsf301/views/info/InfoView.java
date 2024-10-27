package org.example.hsf301.views.info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.hsf301.views.utils.AppAlert;

public class InfoView implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        AppAlert.IS_ABOUT_ME();
    }

}
