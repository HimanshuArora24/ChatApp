package com.bmpl.chatapp.networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.bmpl.chatapp.dao.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers = new ArrayList<ServerWorker>();
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		while(true) {
			System.out.println("Server Stared...Waiting for Client");
			handleClient();
		}
	}
	
	public void handleClient() throws IOException {
		Socket socket = serverSocket.accept();	// Handshaking with client
		System.out.println("Client Connected with Server...");
		
		// Thread Per Client
		ServerWorker serverWorker = new ServerWorker(socket, this);
		workers.add(serverWorker);
		serverWorker.start();
	}
	
	//	For Single Client
//	public Server() throws IOException {
//		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
//		serverSocket = new ServerSocket(PORT);
//		System.out.println("Sever Started...Waiting for Client...");
//		Socket socket = serverSocket.accept();	// Handshaking with client
//		System.out.println("Client Connected with Server...");
//		InputStream in = socket.getInputStream();	// read bytes from Network
//		byte []arr = in.readAllBytes();
//		String str = new String(arr);
//		System.out.println("Client : " + str);
//		in.close();
//		socket.close();
//	}
	
	

	public static void main(String[] args) throws IOException {
		Server server = new Server();
	}

}
