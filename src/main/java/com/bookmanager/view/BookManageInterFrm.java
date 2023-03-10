package com.bookmanager.view;

import com.bookmanager.dao.BookDao;
import com.bookmanager.dao.BookTypeDao;
import com.bookmanager.model.Book;
import com.bookmanager.model.BookType;
import com.bookmanager.utils.DBUtil;
import com.bookmanager.utils.StringUtil;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 12:04
 */
public class BookManageInterFrm extends JInternalFrame {
    private JTable bookTable;
    private JTextField s_bookNameTxt;
    private JTextField s_authorTxt;
    private JComboBox s_bookTypeJcb;
    private JRadioButton manJrb ;
    private JRadioButton femaleJrb ;
    private JTextArea bookDescTxt;
    private JComboBox bookTypeJcb ;

    private DBUtil dbUtil=new DBUtil();
    private BookTypeDao bookTypeDao=new BookTypeDao();
    private BookDao bookDao=new BookDao();
    private JTextField idTxt;
    private JTextField bookNameTxt;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField priceTxt;
    private JTextField authorTxt;

    /**
     * Create the frame.
     */
    public BookManageInterFrm() {
        setClosable(true);
        setIconifiable(true);
        setTitle("\u56FE\u4E66\u7BA1\u7406");
        setBounds(100, 100, 677, 487);
        JScrollPane scrollPane = new JScrollPane();
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(panel_1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.LEADING, groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(scrollPane)))
                                .addContainerGap(66, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(28)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addContainerGap())
        );
        JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
        idTxt = new JTextField();
        idTxt.setEditable(false);
        idTxt.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
        bookNameTxt = new JTextField();
        bookNameTxt.setColumns(10);

        JLabel label_3 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
        manJrb = new JRadioButton("\u7537");
        buttonGroup.add(manJrb);
        manJrb.setSelected(true);
        femaleJrb = new JRadioButton("\u5973");
        buttonGroup.add(femaleJrb);

        JLabel label_4 = new JLabel("\u4EF7\u683C\uFF1A");
        priceTxt = new JTextField();
        priceTxt.setColumns(10);
        JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
        authorTxt = new JTextField();
        authorTxt.setColumns(10);

        JLabel label5 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
        bookTypeJcb = new JComboBox();
        JLabel label_6 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
        bookDescTxt = new JTextArea();

        JButton button_1 = new JButton("\u4FEE\u6539");
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                bookUpdateActionPerformed(evt);
            }
        });

        JButton button_2 = new JButton("\u5220\u9664");
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                bookDeleteActionPerformed(evt);
            }
        });

        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(19)
                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addComponent(button_1)
                                                .addGap(18)
                                                .addComponent(button_2)
                                                .addGap(386))
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                .addComponent(label_6)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(bookDescTxt))
                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(label_4)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(priceTxt))
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(lblNewLabel)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(26)
                                                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(authorTxt)))
                                                                .addGap(26)
                                                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(label_3)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(manJrb)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(femaleJrb))
                                                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                                                .addComponent(label5)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                .addContainerGap(86, Short.MAX_VALUE))))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(21)
                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_3)
                                        .addComponent(manJrb)
                                        .addComponent(femaleJrb))
                                .addGap(18)
                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_4)
                                        .addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label5)
                                        .addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(label_6)
                                        .addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(gl_panel_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button_1)
                                        .addComponent(button_2)))
        );
        panel_1.setLayout(gl_panel_1);

        JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

        s_bookNameTxt = new JTextField();
        s_bookNameTxt.setColumns(10);

        JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");

        s_authorTxt = new JTextField();
        s_authorTxt.setColumns(10);

        JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");

        s_bookTypeJcb = new JComboBox();

        JButton button = new JButton("\u67E5\u8BE2");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookSearchActionPerformed(e);
            }
        });

        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(19)
                                .addComponent(label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(label_1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(button)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_1)
                                        .addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_2)
                                        .addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button))
                                .addGap(16))
        );
        panel.setLayout(gl_panel);

        bookTable = new JTable();
        bookTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent met) {
                bookTableMousePressed(met);
            }
        });
        scrollPane.setViewportView(bookTable);
        bookTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        bookTable.getColumnModel().getColumn(5).setPreferredWidth(119);
        getContentPane().setLayout(groupLayout);

        // ?????????????????????
        bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));

        this.fillBookType("search");
        this.fillBookType("modify");
        this.fillTable(new Book());
    }





    /**
     * ????????????????????????
     * @param evt
     */
    private void bookDeleteActionPerformed(ActionEvent evt) {
        String id=idTxt.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "???????????????????????????");
            return;
        }
        int n=JOptionPane.showConfirmDialog(null, "???????????????????????????");
        if(n==0){
            Connection con=null;
            try{
                con=dbUtil.getConnection();
                int deleteNum=bookDao.delete(con, id);
                if(deleteNum==1){
                    JOptionPane.showMessageDialog(null, "????????????");
                    this.resetValue();
                    this.fillTable(new Book());
                }else{
                    JOptionPane.showMessageDialog(null, "????????????");
                }
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "????????????");
            }finally{
                try {
                    dbUtil.closeConnection(con);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }





    /**
     * ????????????????????????
     * @param evt
     */
    private void bookUpdateActionPerformed(ActionEvent evt) {
        String id=this.idTxt.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null, "???????????????????????????");
            return;
        }

        String bookName=this.bookNameTxt.getText();
        String author=this.authorTxt.getText();
        String price=this.priceTxt.getText();
        String bookDesc=this.bookDescTxt.getText();

        if(StringUtil.isEmpty(bookName)){
            JOptionPane.showMessageDialog(null, "????????????????????????");
            return;
        }

        if(StringUtil.isEmpty(author)){
            JOptionPane.showMessageDialog(null, "????????????????????????");
            return;
        }

        if(StringUtil.isEmpty(price)){
            JOptionPane.showMessageDialog(null, "????????????????????????");
            return;
        }

        String sex="";
        if(manJrb.isSelected()){
            sex="???";
        }else if(femaleJrb.isSelected()){
            sex="???";
        }

        BookType bookType=(BookType) bookTypeJcb.getSelectedItem();
        int bookTypeId=bookType.getId();

        Book book=new Book(Integer.parseInt(id),  bookName, author, sex, Float.parseFloat(price),  bookTypeId,  bookDesc);

        Connection con=null;
        try{
            con=dbUtil.getConnection();
            int addNum=bookDao.update(con, book);
            if(addNum==1){
                JOptionPane.showMessageDialog(null, "??????????????????");
                resetValue();
                this.fillTable(new Book());
            }else{
                JOptionPane.showMessageDialog(null, "??????????????????");
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "??????????????????");
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
     * ????????????
     */
    private void resetValue(){
        this.idTxt.setText("");
        this.bookNameTxt.setText("");
        this.authorTxt.setText("");
        this.priceTxt.setText("");
        this.manJrb.setSelected(true);
        this.bookDescTxt.setText("");
        if(this.bookTypeJcb.getItemCount()>0){
            this.bookTypeJcb.setSelectedIndex(0);
        }
    }


    /**
     * ???????????????????????????
     * @param met
     */
    private void bookTableMousePressed(MouseEvent met) {
        int row=this.bookTable.getSelectedRow();
        this.idTxt.setText((String)bookTable.getValueAt(row, 0));
        this.bookNameTxt.setText((String)bookTable.getValueAt(row, 1));
        this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
        String sex=(String)bookTable.getValueAt(row, 3);
        if("???".equals(sex)){
            this.manJrb.setSelected(true);
        }else if("???".equals(sex)){
            this.femaleJrb.setSelected(true);
        }
        this.priceTxt.setText((Float)bookTable.getValueAt(row, 4)+"");
        this.bookDescTxt.setText((String)bookTable.getValueAt(row, 5));
        String bookTypeName=(String)this.bookTable.getValueAt(row, 6);
        int n=this.bookTypeJcb.getItemCount();
        for(int i=0;i<n;i++){
            BookType item=(BookType)this.bookTypeJcb.getItemAt(i);
            if(item.getBookTypeName().equals(bookTypeName)){
                this.bookTypeJcb.setSelectedIndex(i);
            }
        }
    }





    /**
     * ????????????????????????
     * @param evt
     */
    private void bookSearchActionPerformed(ActionEvent evt) {
        String bookName=this.s_bookNameTxt.getText();
        String author=this.s_authorTxt.getText();
        BookType bookType=(BookType) this.s_bookTypeJcb.getSelectedItem();
        int bookTypeId=bookType.getId();

        Book book=new Book(bookName,author,bookTypeId);
        this.fillTable(book);
    }




    /**
     * ??????????????????
     * @param type ???????????????
     */
    private void fillBookType(String type){
        Connection con=null;
        BookType bookType=null;
        try{
            con=dbUtil.getConnection();
            ResultSet rs=bookTypeDao.list(con, new BookType());
            if("search".equals(type)){
                bookType=new BookType();
                bookType.setBookTypeName("?????????...");
                bookType.setId(-1);
                this.s_bookTypeJcb.addItem(bookType);
            }
            while(rs.next()){
                bookType=new BookType();
                bookType.setBookTypeName(rs.getString("bookTypeName"));
                bookType.setId(rs.getInt("id"));
                if("search".equals(type)){
                    this.s_bookTypeJcb.addItem(bookType);
                }else if("modify".equals(type)){
                    this.bookTypeJcb.addItem(bookType);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
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
     * ?????????????????????
     * @param book
     */
    private void fillTable(Book book){
        DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
        dtm.setRowCount(0); // ?????????0???
        Connection con=null;
        try{
            con=dbUtil.getConnection();
            ResultSet rs=bookDao.list(con, book);
            while(rs.next()){
                Vector v=new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("bookName"));
                v.add(rs.getString("author"));
                v.add(rs.getString("sex"));
                v.add(rs.getFloat("price"));
                v.add(rs.getString("bookDesc"));
                v.add(rs.getString("bookTypeName"));
                dtm.addRow(v);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                dbUtil.closeConnection(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
