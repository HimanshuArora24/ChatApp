package com.bmpl.chatapp.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.bmpl.chatapp.dao.ConfigReader;

public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	ClientWorker worker;
	JTextArea textArea;
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		// We need server machine Ip and Port
		socket = new Socket(ConfigReader.getValue("SERVER_IP"), PORT);
		System.out.println("Client Arrived...");
		out = socket.getOutputStream();	// write bytes on Network - send message
		in = socket.getInputStream();	// read bytes from Network - receive message
		this.textArea = textArea;
		readMessage();
		
		
//		System.out.println("Enter your message : ");
//		Scanner scanner = new Scanner(System.in);
//		String message = scanner.nextLine();
//		OutputStream out = socket.getOutputStream();	// write bytes on Network
//		out.write(message.getBytes()); // convert message into bytes
//		out.close();
//		socket.close();
//		scanner.close();
	}
	
	public void readMessage() {
		// client worker will read message from network
		worker = new ClientWorker(in, textArea);
		worker.start();
	}
	
	public void sendMessage(String message) throws IOException {
//		write message on network
		out.write((message + "\n").getBytes());
	}

//	public static void main(String[] args) throws UnknownHostException, IOException {
//		Client client = new Client();
//	}

}
