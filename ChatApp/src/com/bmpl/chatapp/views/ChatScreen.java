package com.bmpl.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.bmpl.chatapp.networking.Client;

import javax.swing.JButton;
import java.awt.Font;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatScreen extends JFrame {
	private JTextField textField;
	private Client client;
	private JTextArea textArea = new JTextArea();
	
	private void sendMessage() throws IOException {
		String message = textField.getText();
		client.sendMessage(message);
	}
	
	public ChatScreen() throws UnknownHostException, IOException {
		setBounds(100, 100, 904, 512);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		client = new Client(textArea);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(10, 10, 870, 350);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(10, 392, 655, 73);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send Message");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sendMessage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(675, 392, 194, 73);
		getContentPane().add(btnNewButton);

	}

//	public static void main(String[] args) throws UnknownHostException, IOException {
//		ChatScreen window = new ChatScreen();
//		window.setVisible(true);
//	}
}
