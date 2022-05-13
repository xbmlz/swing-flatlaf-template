package org.myapp.ui;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import lombok.extern.slf4j.Slf4j;
import org.myapp.BaseApplication;
import org.myapp.ui.form.MainForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * @author xbmlz
 */
@Slf4j
public class MainFrame extends JFrame {

    public MainFrame(String title) {
        super(title);
        setName(title);
        setContentPane(MainForm.getInstance().getMainPanel());
        initSystemTray();
    }

    private void initSystemTray() {
        if (!SystemTray.isSupported()) {
            log.error("SystemTray is not supported");
        }
        URL url = BaseApplication.class.getResource("/assets/app-icon.png");
        // 创建图标
        ImageIcon icon = new ImageIcon(url);
        // 创建弹出式菜单
        PopupMenu pop = new PopupMenu();
        // 创建 显示菜单项
        MenuItem displayItem = new MenuItem("Show");
        // 给显示窗体菜单项 添加事件处理程序
        displayItem.addActionListener(e -> setVisible(true));
        // 显示菜单项 添加到 弹出式菜单中
        pop.add(displayItem);

        // 创建 退出菜单项
        MenuItem exitItem = new MenuItem("Exit");
        // 给 退出菜单项 添加事件监听器，单击时退出系统
        exitItem.addActionListener(e -> System.exit(0));
        // 添加 退出菜单项 到弹出框中
        pop.add(exitItem);

        // 创建托盘图标程序
        TrayIcon tray = new TrayIcon(icon.getImage(), BaseApplication.APP_TITLE, pop);
        tray.setImageAutoSize(true);
        tray.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    setExtendedState(JFrame.NORMAL);
                }
            }
        });
        // 获得系统托盘对象
        SystemTray systemTray = SystemTray.getSystemTray();
        try {
            // 将托盘图标添加到系统托盘中
            systemTray.add(tray);
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
    }
}
