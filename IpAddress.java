package com.ip.address;

import java.net.*;

public class IpAddress {

	public static void checkHost(String baseAddress) {
		final int timeout = 10000;
		int count = 0;

		try {
			for (int i = 1; i < 255; i++) {
				String host = baseAddress + "." + i;

				if (InetAddress.getByName(host).isReachable(timeout)) {
					InetAddress remoteIp = InetAddress.getByAddress(host.getBytes());
					System.out.print("username : " + remoteIp.getHostName() + "          ");
					System.out.println("ip address : " + remoteIp.getHostAddress());
					count++;
				}
			}
			
			System.out.println(count + " users connected !");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String locaHostName;
		String localIpAddress;
		InetAddress myIP;

		try {
			myIP = InetAddress.getLocalHost();

			localIpAddress = myIP.getHostAddress();
			locaHostName = myIP.getHostName();

			System.out.println("IP address of Localhost is : " + localIpAddress);
			System.out.println("Localhost name is : " + locaHostName + "\n");
			System.out.println("Connected users are...");

			IpAddress.checkHost("192.168.1");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		/*
		 * Enumeration<NetworkInterface> en; try {
		 * 
		 * en = NetworkInterface.getNetworkInterfaces();
		 * 
		 * while(en.hasMoreElements()) { NetworkInterface net = (NetworkInterface)
		 * en.nextElement(); Enumeration<InetAddress> enet = net.getInetAddresses();
		 * while (enet.hasMoreElements()) { InetAddress i = (InetAddress)
		 * enet.nextElement(); System.out.println(i.getHostAddress()); } }
		 * 
		 * } catch (SocketException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}
}