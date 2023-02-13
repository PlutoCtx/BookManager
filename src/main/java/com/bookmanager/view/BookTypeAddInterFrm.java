package com.bookmanager.view;

import com.bookmanager.dao.BookTypeDao;
import com.bookmanager.model.BookType;
import com.bookmanager.utils.DBUtil;
import com.bookmanager.utils.StringUtil;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Objects;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

/**
 * 添加图书
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 10:54
 */

public class BookTypeAddInterFrm extends JInternalFrame {

    private JTextField bookTypeNameTxt;
    private JTextArea bookTypeDescTxt;

    private DBUtil dbUtil=new DBUtil();
    private BookTypeDao bookTypeDao=new BookTypeDao();

//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public BookTypeAddInterFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
        setBounds(100, 100, 450, 300);

        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");

        JLabel lblNewLabel1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");

        bookTypeNameTxt = new JTextField();
        bookTypeNameTxt.setColumns(10);

        bookTypeDescTxt = new JTextArea();

        JButton btnNewButton = new JButton("\u6DFB\u52A0");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTypeAddActionPerformed(e);
            }
        });
        btnNewButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/add.png"))));


        JButton btnNewButton1 = new JButton("\u91CD\u7F6E");
        btnNewButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });
        btnNewButton1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/reset.png"))));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(86)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(lblNewLabel)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel1)
                                                        .addComponent(btnNewButton))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(btnNewButton1)
                                                        .addComponent(bookTypeDescTxt))))
                                .addContainerGap(69, GroupLayout.PREFERRED_SIZE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(56)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(29)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel1)
                                        .addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton)
                                        .addComponent(btnNewButton1))
                                .addGap(28))
        );
        getContentPane().setLayout(groupLayout);

        // 设置文本域边框
        bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));

    }

    /**
     * 图书类别添加事件处理
     * @param evt 事件
     */
    private void bookTypeAddActionPerformed(ActionEvent evt) {
        String bookTypeName=this.bookTypeNameTxt.getText();
        String bookTypeDesc=this.bookTypeDescTxt.getText();
        if(StringUtil.isEmpty(bookTypeName)){
            JOptionPane.showMessageDialog(null, "图书类别名称不能为空！");
            return;
        }
        BookType bookType=new BookType(bookTypeName,bookTypeDesc);
        Connection con=null;
        try{
            con=dbUtil.getConnection();
            int n=bookTypeDao.add(con, bookType);
            if(n==1){
                JOptionPane.showMessageDialog(null, "图书类别添加成功！");
                resetValue();
            }else{
                JOptionPane.showMessageDialog(null, "图书类别添加失败！");
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "图书类别添加失败！");
        }finally{
            try {
                dbUtil.closeConnection(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 重置事件处理
     * @param evt
     */
    private void resetValueActionPerformed(ActionEvent evt) {
        this.resetValue();
    }

    /**
     * 重置表单
     */
    private void resetValue(){
        this.bookTypeNameTxt.setText("");
        this.bookTypeDescTxt.setText("");
    }
}
