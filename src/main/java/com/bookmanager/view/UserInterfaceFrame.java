package com.bookmanager.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

/**
 * 普通用户界面
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/7 8:30
 * @since JDK17
 */

public class UserInterfaceFrame extends JFrame {

    private JPanel contentPane;
    private JDesktopPane table = null;


    /**
     * Create the frame.
     */
    public UserInterfaceFrame() {

        // 图书管理系统用户界面
        setTitle("\u56fe\u4e66\u7ba1\u7406\u7cfb\u7edf\u7528\u6237\u754c\u9762");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // 用户操作
        JMenu mnNewMenu = new JMenu("用户操作");
        mnNewMenu.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/base.png"))));
        menuBar.add(mnNewMenu);

        // 图书购买
        JMenu mnNewMenu1 = new JMenu("图书购买");
        mnNewMenu1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/bookTypeManager.png"))));
        mnNewMenu.add(mnNewMenu1);

        // 购书记录
        JMenuItem menuItem = new JMenuItem("购书记录");
        menuItem.addActionListener(e -> {
            BookTypeAddInterFrm bookTypeAddInterFrm = new BookTypeAddInterFrm();
            bookTypeAddInterFrm.setVisible(true);
            table.add(bookTypeAddInterFrm);
        });
        menuItem.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/add.png"))));
        mnNewMenu1.add(menuItem);

//        // 图书类别维护
//        JMenuItem menuItem1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
//        menuItem1.addActionListener(e -> {
//            BookTypeManageInterFrm bookTypeManageInterFrm=new BookTypeManageInterFrm();
//            bookTypeManageInterFrm.setVisible(true);
//            table.add(bookTypeManageInterFrm);
//        });
//        menuItem1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/edit.png"))));
//        mnNewMenu1.add(menuItem1);
//
//        // 图书管理
//        JMenu mnNewMenu2 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
//        mnNewMenu2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/bookManager.png"))));
//        mnNewMenu.add(mnNewMenu2);
//
//        // 图书添加
//        JMenuItem menuItem2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
//        menuItem2.addActionListener(arg0 -> {
//            BookAddInterFrm bookAddInterFrm=new BookAddInterFrm();
//            bookAddInterFrm.setVisible(true);
//            table.add(bookAddInterFrm);
//        });
//        menuItem2.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/add.png"))));
//        mnNewMenu2.add(menuItem2);
//
//        // 图书维护
//        JMenuItem menuItem3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
//        menuItem3.addActionListener(arg0 -> {
//            BookManageInterFrm bookManageInterFrm=new BookManageInterFrm();
//            bookManageInterFrm.setVisible(true);
//            table.add(bookManageInterFrm);
//        });
//        menuItem3.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/edit.png"))));
//        mnNewMenu2.add(menuItem3);
//
        // 安全退出
        JMenuItem menuItem4 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
        menuItem4.addActionListener(e -> {
            int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
            if(result==0){
                dispose();
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        menuItem4.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/exit.png"))));
        mnNewMenu.add(menuItem4);

        // 关于我们
        JMenu menu = new JMenu("\u5173\u4E8E");
        menu.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/about.png"))));
        menuBar.add(menu);

        // 关于我们
        JMenuItem jMenuItem = new JMenuItem("\u5173\u4e8e\u6211\u4eec");
        jMenuItem.addActionListener(arg0 -> {
            Java1234InterFrm java1234InterFrm = new Java1234InterFrm();
            java1234InterFrm.setVisible(true);
            table.add(java1234InterFrm);
        });
        jMenuItem.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/about.png"))));
        menu.add(jMenuItem);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        table = new JDesktopPane();
        contentPane.add(table, BorderLayout.CENTER);

        // 设置JFrame最大化
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }



}
