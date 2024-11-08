package com.study.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    public RegisterJFrame() {
        this.setSize(488, 500);
        this.setTitle("注册");
        //置顶
        //this.setAlwaysOnTop(true);
        //居中
        this.setLocationRelativeTo(null);
        //界面关闭，游戏结束
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//3
        this.setVisible(true);
    }
}
