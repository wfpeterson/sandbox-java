package com.kinetix.sandbox.java.concurrency.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ClientThread extends Thread{

    private Socket socket;
    private boolean isStop;
    private BufferedReader in;
    private PrintWriter out;
    private File file;
    final static String CRLF = "\r\n";

    public ClientThread(Socket socket) {
        this.socket = socket;
        this.isStop = false;
    }

    public void run(){
        try{

            while(!isStop){
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                String line;
                String httpHeader = "";
                String htmlFile="";
                while(true){
                    line = in.readLine();
                    if(line.contains(CRLF) || line.equals("")){
                        break;
                    }
                    httpHeader = httpHeader +line+"\n";
                    if(line.contains("GET")){
                        int beginIndex = line.indexOf("/");
                        int endIndex = line.indexOf(" HTTP");
                        htmlFile = line.substring(beginIndex+1, endIndex);

                    }
                    System.out.println(httpHeader);

                    processRequest(htmlFile);
                    closeConnection();

                }
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    private void processRequest(String htmlFile){
        File file = new File(htmlFile);
        if(file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                out.print("HTTP/1.0 200 OK" + CRLF);
                Date date = new Date();
                out.print("Date: " + date.toString());
                out.print("Server: java tiny web server" + CRLF);
                out.print("Content-Type: text/html" + CRLF);
                out.print("Content-Length: " + file.length() + CRLF);
                out.println("Content-Type: text/html; charset=iso-8859-1" + CRLF);

                String line = "";
                while ((line = reader.readLine()) != null) {
                    out.println(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            out.print("HTTP/1.1 404 Not Found" + CRLF);
            Date date = new Date();
            out.print("Date: " + date.toString() + CRLF);
            out.print("Server: java tiny web server" + CRLF);
            out.print("Connection: close" + CRLF);
            out.println("Content-Type: text/html; charset=iso-8859-1" + CRLF);
            //end of http header

            //send file not found message
            out.println("<html><head>");
            out.println("<title>404 Not Found</title>");
            out.println("</head><body>");
            out.println("<h1>Not Found</h1>");
            out.println("<p>The requested URL /" + htmlFile + " was not found on this server.</p>");
            out.println("</body></html>");
            out.println(CRLF);
        }
    }

    private void closeConnection(){
        try{
            out.close();
            in.close();
            socket.close();
            isStop = true;

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
