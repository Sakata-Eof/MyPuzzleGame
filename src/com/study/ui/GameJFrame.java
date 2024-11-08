package com.study.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener{
    private int [][] Arr={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };
    private int [][] Win=new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    private int count=0;
    private int row,col;//空白的坐标位置
    private String path = "image/animal/animal3/";//路径
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
        Arr=new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){

                int temp=Arr[i][j];
                int tempi=new Random().nextInt(4);
                int tempj=new Random().nextInt(4);
                Arr[i][j] = Arr[tempi][tempj];
                Arr[tempi][tempj] = temp;
            }
        }
    }

    private void initImage() {
        //清空
        this.getContentPane().removeAll();

        if(isVictory()){//胜利结算画面
            JLabel winJLable = new JLabel(new ImageIcon("image/win.png"));
            winJLable.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLable);

        }

        JLabel stepCount = new JLabel("步数：" + count);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel label;
                if(Arr[i][j]==16){
                    row=i;
                    col=j;
                    label = new JLabel();
                }else {
                    label = new JLabel(new ImageIcon(path + Arr[i][j] + ".jpg"));
                }
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

        JMenu changeJMenu = new JMenu("更换图片");
        JMenuItem animalImg = new JMenuItem("动物");
        JMenuItem sportImg = new JMenuItem("运动");
        changeJMenu.add(animalImg);
        changeJMenu.add(sportImg);


        JMenuItem replayItem = new JMenuItem("重新游戏");
        //JMenuItem relogItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem coderItem = new JMenuItem("作者信息");

        funcJMenu.add(changeJMenu);
        funcJMenu.add(replayItem);
        //funcJMenu.add(relogItem);
        funcJMenu.add(closeItem);

        aboutJMenu.add(coderItem);

        animalImg.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //更改图片目录为随机动物
                        path="image/animal/animal"+new Random().nextInt(1,9)+"/";
                        //重新开始
                        count=0;
                        initData();
                        initImage();
                    }
                }
        );
        sportImg.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //更改图片目录为随机动物
                        path="image/sport/sport"+new Random().nextInt(1,11)+"/";
                        //重新开始
                        count=0;
                        initData();
                        initImage();
                    }
                }
        );
        replayItem.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //重新开始
                        count=0;
                        initData();
                        initImage();
                    }
                }
        );
        /*relogItem.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //重新登录
                        //关闭游戏界面
                        GameJFrame.this.setVisible(false);
                        //打开登陆界面
                        new LoginJFrame();
                    }
                }
        );*/
        closeItem.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //关闭游戏
                        System.exit(0);
                    }
                }
        );
        coderItem.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //关于作者
                        JDialog dialog = new JDialog();
                        JLabel label = new JLabel(new ImageIcon("image/about.jpg"));
                        label.setBounds(0,0,479,479);
                        dialog.getContentPane().add(label);
                        dialog.setSize(500,500);
                        dialog.setLocationRelativeTo(null);
                        dialog.setAlwaysOnTop(true);
                        dialog.setModal(true);
                        dialog.setVisible(true);
                    }
                }
        );

        menuBar.add(funcJMenu);
        menuBar.add(aboutJMenu);

        this.setJMenuBar(menuBar);
    }

    private void initJFrame() {
        //设置宽高
        this.setSize(603, 680);
        this.setTitle("我的拼图游戏");
        //置顶
        //this.setAlwaysOnTop(true);
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
        if(isVictory()){
            return;
        }
        int code = e.getKeyCode();
        if(code==65){//按下a显示完整图片
            System.out.println("按下a键");
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            JLabel bg=new JLabel(new ImageIcon("image/background.png"));
            bg.setBounds(40,40, 508, 560);
            this.getContentPane().add(bg);
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(isVictory()){//胜利则结束操作
            return;
        }
        //左 37， 右 39， 上 38， 下 40
        int code = e.getKeyCode();
        if(code == 38){
            //⬆
            System.out.println("向上");
            if(row<3){
                count++;
                Arr[row][col] = Arr[row + 1][col];
                Arr[row + 1][col] = 0;
                row++;
                initImage();
            }
        }else if(code == 40){
            //⬇
            System.out.println("向下");
            if(row>0){
                count++;
                Arr[row][col] = Arr[row - 1][col];
                Arr[row - 1][col] = 0;
                row--;
                initImage();
            }
        }else if(code == 37){
            //⬅
            System.out.println("向左");
            if(col<3){
                count++;
                Arr[row][col] = Arr[row][col+1];
                Arr[row][col+1] = 0;
                col++;
                initImage();
            }
        }else if(code == 39){
            //➡
            System.out.println("向右");
            if(col>0){
                count++;
                Arr[row][col] = Arr[row][col-1];
                Arr[row][col-1] = 0;
                col--;
                initImage();
            }
        }
        else if (code==65) {
            //a
            System.out.println("松开a键");
            initImage();
        }
        else if (code==87) {
            //w
            System.out.println("w键作弊");
            Arr = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            };
            initImage();

        }
    }
    public boolean isVictory(){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(Arr[i][j]!=Win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}
