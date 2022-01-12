package com.innovargia.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

//import org.apache.log4j.Logger;

//
// inspired by
//    http://forum.java.sun.com/thread.jspa?messageID=902023
//

public final class MacAddresExtractor {
	//private static Logger log = Logger.getLogger(MacAddresExtractor.class);

	private final static String WIN_OSNAME = "Windows";

	private final static String LINUX_OSNAME = "Linux";

	private final static String AIX_OSNAME = "Aix";

	private final static String WIN_MACADDR_REG_EXP = "^[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}$";

	private final static String LINUX_MACADDR_REG_EXP = "^[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}$";

	private final static String AIX_MACADDR_REG_EXP = "^[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}:[0-9A-F]{2}$";

	private final static String WIN_MACADDR_EXEC = "ipconfig /all";

	private final static String LINUX_MACADDR_EXEC = "ifconfig";

	private final static String AIX_MACADDR_EXEC = "netstat -v";

	public final static String getMacAddress() throws IOException {
		String osName = System.getProperty("os.name");

		String configCommand = null;
		String regex = null;
		if (osName.startsWith(WIN_OSNAME)) {
			configCommand = WIN_MACADDR_EXEC;
			regex = WIN_MACADDR_REG_EXP;
		}
		else if (osName.startsWith(LINUX_OSNAME)) {
			configCommand = LINUX_MACADDR_EXEC;
			regex = LINUX_MACADDR_REG_EXP;
		}
		else if (osName.startsWith(AIX_OSNAME)) {
			configCommand = AIX_MACADDR_EXEC;
			regex = AIX_MACADDR_REG_EXP;
		}
		String commandResponse = executeCommand(configCommand);
		return extractMAFromResponse(commandResponse, regex);
	}

	private final static String extractMAFromResponse(String commandResponse, String regex) throws IOException {
		commandResponse = commandResponse.replace(' ', '\t');

		ByteArrayInputStream bais = new ByteArrayInputStream(commandResponse.getBytes());
		InputStreamReader isr = new InputStreamReader(bais);
		BufferedReader reader = new BufferedReader(isr);
		String str;
		String result = null;
		while ((str = reader.readLine()) != null) {
			String[] tokens = str.split("\\\t");
			for (int i = 0; i < tokens.length; i++) {
				if (tokens[i].matches(regex)) {
					//log.debug("[" + tokens[i] + "]" + tokens[i].matches(regex));
					result = tokens[i].replace('-', ':');
					break;
				}
			}
		}
		reader.close();

		return result;
	}

	private final static String executeCommand(String configCommand) throws IOException {
		Process p = Runtime.getRuntime().exec(configCommand);
		InputStream stdoutStream = new BufferedInputStream(p.getInputStream());

		StringBuffer buffer = new StringBuffer();
		for (;;) {
			int c = stdoutStream.read();
			if (c == -1) break;
			buffer.append((char) c);
		}
		String outputText = buffer.toString();
		stdoutStream.close();
		return outputText;
	}

	private static String hosIp;

	public static String getHostIp(){
		if(hosIp==null){
			try {
				hosIp = InetAddress.getLocalHost().getHostAddress();
			}
			catch (UnknownHostException e) {
				hosIp = "No IP available.";
			}
		}
		return hosIp;
	}
	
	public final static void main(String[] args) {
		try {
			System.out.println("MAC ADDRESS");
			System.out.println("  OS          : " + System.getProperty("os.name"));
			System.out.println("  IP/Localhost: " + InetAddress.getLocalHost().getHostAddress());
			System.out.println("  MAC Address : " + getMacAddress());
		}
		catch (Throwable t) {
			t.printStackTrace();
		}
	}
}