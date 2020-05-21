package Socket;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("127.0.0.1",9999);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
            //String str = "Hello , this is first socket";

            while (true) {
                String str = br.readLine();
            bw.write(str);
            bw.write("\n");
            bw.flush();
//            bw.close();
//            socket.shutdownOutput();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
