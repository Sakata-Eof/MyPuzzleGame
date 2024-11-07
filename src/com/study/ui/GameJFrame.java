package com.study.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    private int [][] Arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    private int row,col;//空白的坐标位置
    public GameJFrame() {
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据(打乱)
        initData();
        //初始化图片
        initImage();

        //显示界面
        this.setVisible(true);
    }

    private void initData() {
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){

                int temp=Arr[i][j];
                int tempi=new Random().nextInt(4);
                int tempj=new Random().nextInt(4);
                if(i==3&&j==3){
                    row = tempi;
                    col = tempj;
                }
                Arr[i][j] = Arr[tempi][tempj];
                Arr[tempi][tempj] = temp;
            }
        }
    }

    private void initImage() {
        //清空
        this.getContentPane().removeAll();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                    String path = "image/animal/animal3/" + Arr[i][j] + ".jpg";
                    JLabel label = new JLabel(new ImageIcon(path));
                    //指定位置
                    label.setBounds(105 * j+83, 105 * i+134, 105, 105);
                    //设置边框
                    label.setBorder(new BevelBorder(BevelBorder.LOWERED));
                    this.getContentPane().add(label);
            }
        }
        //背景图片
        JLabel bg=new JLabel(new ImageIcon("image/background.png"));
        bg.setBounds(40,40, 508, 560);
        this.getContentPane().add(bg);
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        //初始化菜单
        JMenuBar menuBar = new JMenuBar();

        JMenu funcJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于");

        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem relogItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem coderItem = new JMenuItem("作者信息");

        funcJMenu.add(replayItem);
        funcJMenu.add(relogItem);
        funcJMenu.add(closeItem);

        aboutJMenu.add(coderItem);

        menuBar.add(funcJMenu);
        menuBar.add(aboutJMenu);

        this.setJMenuBar(menuBar);
    }

    private void initJFrame() {
        //设置宽高
        this.setSize(603, 680);
        this.setTitle("我的拼图游戏");
        //置顶
        this.setAlwaysOnTop(true);
        //居中
        this.setLocationRelativeTo(null);
        //界面关闭，游戏结束
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//3
        //取消默认居中
        this.setLayout(null);

        //添加界面映射
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //左 37， 右 39， 上 38， 下 40
        int code = e.getKeyCode();
        if(code == 38){
            if(row<3){
                int temp=Arr[row][col];
                Arr[row][col] = Arr[row + 1][col];
                Arr[row + 1][col] = temp;
                row++;
                initImage();
            }
        }else if(code == 40){
            if(row>0){
                int temp=Arr[row][col];
                Arr[row][col] = Arr[row - 1][col];
                Arr[row - 1][col] = temp;
                row--;
                initImage();
            }
        }else if(code == 37){
            if(col<3){
                int temp=Arr[row][col];
                Arr[row][col] = Arr[row][col+1];
                Arr[row][col+1] = temp;
                col++;
                initImage();
            }
        }else if(code == 39){
            if(col>0){
                int temp=Arr[row][col];
                Arr[row][col] = Arr[row][col-1];
                Arr[row][col-1] = temp;
                col--;
                initImage();
            }
        }
    }
}
