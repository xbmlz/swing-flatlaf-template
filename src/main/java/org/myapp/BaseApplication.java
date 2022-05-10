package org.myapp;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatInspector;
import com.formdev.flatlaf.extras.FlatUIDefaultsInspector;
import com.formdev.flatlaf.util.SystemInfo;
import org.myapp.ui.MainFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @author xbmlz
 */
public class BaseApplication {

    static final String APP_TITLE = "myapp";

    public static void main(String[] args) {
        // macOS
        if (SystemInfo.isMacOS) {
            // see https://www.formdev.com/flatlaf/macos/

            // enable screen menu bar
            // (moves menu bar from JFrame window to top of screen)
            System.setProperty("apple.laf.useScreenMenuBar", "true");

            // application name used in screen menu bar
            // (in first menu after the "apple" menu)
            System.setProperty("apple.awt.application.name", "Sample Swing App");

            // appearance of window title bars
            // possible values:
            //   - "system": use current macOS appearance (light or dark)
            //   - "NSAppearanceNameAqua": use light appearance
            //   - "NSAppearanceNameDarkAqua": use dark appearance
            // (needs to be set on main thread; setting it on AWT thread does not work)
            System.setProperty("apple.awt.application.appearance", "system");
        }

        // Linux
        if (SystemInfo.isLinux) {
            // enable custom window decorations
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        }

        if (!SystemInfo.isJava_9_orLater && System.getProperty("flatlaf.uiScale") == null) {
            System.setProperty("flatlaf.uiScale", "2x");
        }

        SwingUtilities.invokeLater(() -> {

            // application specific UI defaults
            FlatLaf.registerCustomDefaultsSource("org.myapp");

            // set look and feel
            FlatLightLaf.setup();

            // install inspectors
            FlatInspector.install("ctrl shift alt X");
            FlatUIDefaultsInspector.install("ctrl shift alt Y");

            // create frame
            MainFrame frame = new MainFrame(APP_TITLE);

            frame.setPreferredSize(SystemInfo.isJava_9_orLater
                    ? new Dimension(830, 440)
                    : new Dimension(1660, 880));

            // show frame
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
