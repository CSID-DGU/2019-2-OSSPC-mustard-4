package com.tetris.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TetrisLogin extends JFrame {
 
    private JPanel contentPane;
    private JTextField idField;
    private JPasswordField pw;
    private JLabel IblResult;
    private Map<String, String> map;
    private JButton joinBtn;
    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                	TetrisLogin frame = new TetrisLogin();
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
    public TetrisLogin() {
        map= new HashMap<String,String>();
        map.put("kim", "1234");
        map.put("park", "1111");
        map.put("hong", "2222");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 452, 439);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("���̵�");
        lblNewLabel.setBounds(12, 34, 57, 15);
        contentPane.add(lblNewLabel);
        
        idField = new JTextField();
        idField.setBounds(95, 31, 116, 21);
        contentPane.add(idField);
        idField.setColumns(10);
        
        JLabel label = new JLabel("��й�ȣ");
        label.setBounds(12, 80, 57, 15);
        contentPane.add(label);
        
        JButton btnNewButton = new JButton("�α���");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result;
                String id = idField.getText();
                String pass = String.valueOf(pw.getPassword());
                if(map.containsKey(id)&&pass.equals(map.get(id))){
                    result=" ȯ���մϴ�.";
                    IblResult.setForeground(Color.green);
                }else{
                    result="���̵� �Ǵ� ����� �߸���";
                    IblResult.setForeground(Color.blue);
                }
                System.out.println(map.containsKey(id));
                System.out.println(map.get(id));
                System.out.println(pass);
                
                IblResult.setText(result);
            }
        });
        btnNewButton.setBounds(95, 120, 97, 23);
        contentPane.add(btnNewButton);
        
        IblResult = new JLabel("New label");
        IblResult.setBounds(12, 176, 199, 92);
        contentPane.add(IblResult);
        
        pw = new JPasswordField();
        pw.setBounds(95, 77, 116, 21);
        contentPane.add(pw);
        
        joinBtn = new JButton("ȸ������");
//        joinBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                JoinForm newOne=new JoinForm();
//                newOne.setVisible(true);
//            }
//        });
        joinBtn.setBounds(237, 120, 97, 23);
        contentPane.add(joinBtn);
    }
}