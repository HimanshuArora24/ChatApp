package com.bmpl.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.bmpl.chatapp.dao.UserDAO;
import com.bmpl.chatapp.dto.UserDTO;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserScreen extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	public static void main(String[] args) {
		UserScreen window = new UserScreen();
	}

	public UserScreen() {
		setBounds(100, 100, 904, 512);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(361, 21, 189, 46);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your UserID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(67, 141, 249, 38);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter your Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(67, 241, 249, 38);
		getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(387, 132, 312, 60);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(387, 236, 312, 60);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					doLogin();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(153, 338, 221, 81);
		getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doRegister();
			}
		});
		
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnRegister.setBounds(462, 338, 221, 81);
		getContentPane().add(btnRegister);
		setVisible(true);
	}
	
	UserDAO userdao = new UserDAO();
	
	private void doRegister() {
		String userid = textField.getText();
//		String pwd = passwordField.getText();
		char []password = passwordField.getPassword();
//		System.out.println(password);
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			int record = userdao.register(userDTO);
			if(record > 0) {
				JOptionPane.showMessageDialog(this, "Registered Successfully...");
			}
			else {
				JOptionPane.showMessageDialog(this, "Registration UnSuccessfull...");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doLogin() throws UnknownHostException, IOException {
		String userId = textField.getText();
		char []password = passwordField.getPassword();
		UserDTO userDTO = new UserDTO(userId, password);
		try {
			boolean result = userdao.isLogin(userDTO);
			if(result) {
				setVisible(false);
				dispose();
				JOptionPane.showMessageDialog(this, "Login Success...");
				ChatScreen chatWindow = new ChatScreen();
				chatWindow.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(this, "Login Failed...");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
