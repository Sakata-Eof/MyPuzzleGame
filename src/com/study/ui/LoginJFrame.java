package com.study.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginJFrame extends JFrame implements MouseListener {
    private JDialog JD = new JDialog();
    private JButton loginButton = new JButton();
    private JButton regButton = new JButton();
    private JTextField nameInput = new JTextField();
    private JTextField passwordInput = new JTextField();


    public LoginJFrame() {
        initJFrame();

        initJLabel();

        this.setVisible(true);
    }

    private void initJLabel() {
        //用户名
        JLabel nameJLabel = new JLabel(new ImageIcon("image/login/用户名.png"));
        nameJLabel.setBounds(116, 135, 51, 19);
        this.add(nameJLabel);

        //用户名输入框
        nameInput.setBounds(195, 134, 200, 30);
        this.add(nameInput);

        //密码
        JLabel passwordJLabel = new JLabel(new ImageIcon("image/login/密码.png"));
        passwordJLabel.setBounds(130, 195, 35, 18);
        this.add(passwordJLabel);

        //密码输入框
        passwordInput.setBounds(195, 195, 200, 30);
        this.add(passwordInput);

        //登录按钮
        loginButton.setIcon(new ImageIcon("image/login/登录按钮.png"));
        loginButton.setBounds(133, 260, 90, 40);
        this.add(loginButton);
        loginButton.addMouseListener(this);

        //注册按钮
        regButton.setIcon(new ImageIcon("image/login/注册按钮.png"));
        regButton.setBounds(256, 260, 90, 40);
        this.add(regButton);
        regButton.addMouseListener(this);

        //背景
        JLabel background = new JLabel(new ImageIcon("image/login/background.png"));
        background.setBounds(0, 0, 470, 390);
        this.add(background);
    }

    private void initJFrame() {
        this.setSize(488, 430);
        this.setTitle("登录");
        //置顶
        //this.setAlwaysOnTop(true);
        //居中
        this.setLocationRelativeTo(null);
        //界面关闭，游戏结束
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//3
        this.setLayout(null);
    }
    private void showJDialog(String content){
        if(!JD.isVisible()){
            JD.setSize(100, 100);
            JD.setLocationRelativeTo(null);
            JD.setAlwaysOnTop(true);
            JD.getContentPane().removeAll();
            JLabel contentJLabel = new JLabel(content);
            JD.getContentPane().add(contentJLabel);
            JD.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == loginButton){
            String name = nameInput.getText();
            String password = passwordInput.getText();
            if(name.equals("")&&password.equals("")) {
                showJDialog("用户名和密码为空");
            }
            else if(name.equals("zhangsan")&&password.equals("123456")){
                this.setVisible(false);
                new GameJFrame();
            }
            else{
                showJDialog("用户名和密码错误");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == loginButton){
            loginButton.setIcon(new ImageIcon("image/login/登录按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == loginButton){
            loginButton.setIcon(new ImageIcon("image/login/登录按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
