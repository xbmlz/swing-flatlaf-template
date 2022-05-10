package org.myapp.ui;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

/**
 * @author xbmlz
 */
@Slf4j
public class MainFrame extends JFrame {

    public MainFrame(String title) {
        super(title);
        setName(title);
    }
}
