package com.bmpl.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewDemo extends JFrame {
	int counter = 0;
	public ViewDemo() {
		setSize(500,500);
//		setLocation(200, 100);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Login Screen");
		
		JLabel title = new JLabel("Welcome to Chat App...");
		title.setFont(new Font("Arial", Font.BOLD, 40));
		title.setBounds(10, 10, 490, 100);
		
		JLabel showCounter = new JLabel("0");
		showCounter.setFont(new Font("Arial", Font.BOLD, 20));
		showCounter.setBounds(140, 120, 50, 20);
		
		JButton btn = new JButton("Count");
		btn.setBounds(30,120, 100, 30);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				counter++;
				showCounter.setText(""+counter);
			}
		});
		
		Container container = this.getContentPane();
		container.setLayout(null);
		container.add(title);
		container.add(btn);
		container.add(showCounter);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		
		ViewDemo view = new ViewDemo();

	}

}
