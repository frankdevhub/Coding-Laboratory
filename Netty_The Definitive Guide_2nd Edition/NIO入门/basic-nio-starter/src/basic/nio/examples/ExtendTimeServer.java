package basic.nio.examples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ExtendTimeServer {
	public static void main(String[] args) throws IOException {
		int port = 8080;
		try {
			if (args != null && args.length > 0) {
				port = Integer.valueOf(args[0]);
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The time server is start in port in : " + port);
			Socket socket = null;
			TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);
			while (true) {
				socket = server.accept();
				singleExecutor.execute(new TimeServerHandler(socket));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (server != null) {
				System.out.println("The time server close");
				server.close();
				server = null;
			}

		}
	}
}
