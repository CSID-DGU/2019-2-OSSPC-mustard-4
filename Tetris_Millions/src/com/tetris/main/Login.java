package com.tetris.main;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import com.tetris.main.Response;
import com.tetris.window.Tetris;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends JFrame implements ActionListener{
	
	    JLabel lbl,la1,la2,la3;
	    JTextField id;
	    JPasswordField passwd;
	    JPanel idPanel,paPanel,loginPanel;
	    JButton b1,b2;
	    
	    RetrofitApi retrofitApi;
	    
	    
	    
	 
	    public Login()
	    {
	          setTitle("�α���");
	          
	         // hellooooooo
	         	         
	          
	          // FlowLayout���
	          setLayout( new FlowLayout() );
	          // Border�� ���� ����
	          EtchedBorder eborder =  new EtchedBorder();
	          // ���̺� ����     
	          lbl = new JLabel( "���̵�� �н����带 �Է��� �ּ���" );
	          // ���̺� ���� �����
	          lbl.setBorder(eborder);
	          // ���̺� �߰�
	          add( lbl );
	          // id�гΰ� pw �гλ���
	          idPanel = new JPanel();
	          paPanel = new JPanel();
	          la3 = new JLabel("���̵�");
	          la2 = new JLabel("�н�����");
	          // id�ؽ�Ʈ�ʵ�� pw�ؽ�Ʈ �ʵ� ����
	          id = new JTextField(10);
	          passwd = new JPasswordField(10);
	          idPanel.add(la3);
	          idPanel.add(id);
	          paPanel.add( la2 );
	          paPanel.add( passwd );
	          // �α��ΰ� ȸ�������� ���� �г� ����
	          loginPanel = new JPanel();
	          b1 = new JButton("�α���");
	          b2 = new JButton("ȸ������");
	          loginPanel.add( b1 );
	          loginPanel.add( b2 );
	          
	          
	          add(idPanel);
	          add(paPanel);
	          add(loginPanel);
	          // 3�� 20�� ������ ��)��Ʈ����� 
	          setSize( 250, 200)  ;
	          setVisible(true);
	          
	          setLocationRelativeTo(null);
	          setDefaultCloseOperation(EXIT_ON_CLOSE);
	          
	          
	          
	          /**
	           *  �̺�Ʈ ������ ���(�α���, ȸ������ ��ư)
	           */
	          
	          b1.addActionListener(this);
	          b2.addActionListener(this);
	          
	          
	          
	          Retrofit retrofit = new Retrofit.Builder()
	        		  .baseUrl("http://" + IPClass.ServerIp + "/")
	        		  .addConverterFactory(GsonConverterFactory.create())
	        		  .build();
	          
	          retrofitApi = retrofit.create(RetrofitApi.class);
	          
	          
	          
	    }


	    
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == b2)// ȸ������ ��ư ����
			{
				new Register();
			}
			else { // �α��� ��ư ����
				/**
				 *  ����ó��
				 *  ���̵� �Է����� �ʾ��� ���
				 *
				 */
				
				// ���̵� �ƹ��͵� �Է����� �ʾ��� ���
				if(String.valueOf(id.getText()).equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null,"���̵� �Է��ϼ���");
					return;
					
				// ��й�ȣ �Է����� �ʾ��� ���
				}else if(String.valueOf(passwd.getPassword()).equalsIgnoreCase(""))
				{
					// ��й�ȣ �Է��϶�� ���̾�α� ����
					JOptionPane.showMessageDialog(null,"��й�ȣ�� �Է��ϼ���");
					return;
					
				// ���� ��� ���� �Է����� ��� ������ ������ ���� �α��� ���� ����
				}else {
					// ���� RESTApi endpoint �� �ش� ���̵�� ��й�ȣ�� ����
					LoginCheck(String.valueOf(id.getText()), String.valueOf(passwd.getPassword()));
					
				}
			}
			
			
			
	
		}
		
		
		
		/**
		 *  ��� �׽�Ʈ
		 */
		public void LoginCheck(String id, String pwd) {
			Call<Response> call = retrofitApi.login_call(id, pwd);
			call.enqueue(new Callback<Response>() {
				
				@Override
				public void onResponse(Call<Response> arg0, retrofit2.Response<Response> response) {
					// TODO Auto-generated method stub
					if(!response.isSuccessful()) { // ���� ����
						System.out.println("���� ���� : " + response.body());
					}
					
					
					System.out.println("���� ���� : " + response.body());
					System.out.println("���� ���� : " + response.code());
					Response response2 = response.body();
					if(response2.getSuccess().equalsIgnoreCase("ok")) {
						JOptionPane.showMessageDialog(null,"�α��μ���");
						new Tetris();
						
					}else {
						 
						JOptionPane.showMessageDialog(null,"�������� �ʴ� ȸ���̰ų� �߸��� ���̵�� ��й�ȣ�� �Է��Ͽ����ϴ�.");
							
					}
				}
				
				@Override
				public void onFailure(Call<Response> arg0, Throwable response) {
					System.out.println("���� ��ä? : " + response.getMessage());
				}
			});
		}
	    
	    
}

