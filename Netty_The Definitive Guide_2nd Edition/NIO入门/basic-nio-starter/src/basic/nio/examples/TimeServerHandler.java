package basic.nio.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable {

	private Socket socket;

	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(), true);
			String currentTime = null;
			String body = null;
			while (true) {
				body = in.readLine();
				if (null == body)
					break;
				System.out.println("The time server receive order: " + body);
				currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)
						? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
				out.println(currentTime);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (in != null) {
				try {
					in.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			if (out != null) {
				out.close();
				out = null;
			}
			if (this.socket != null) {
				try {
					this.socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.socket = null;
			}
		}

	}

}
