package com.kinetix.sandbox.java.concurrency.email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class EmailSocket {

    private static Socket smtpSocket;
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args){
        try {
            smtpSocket = new Socket("localhost", 25);
            in = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
            out = new PrintWriter(smtpSocket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(smtpSocket != null && out != null && in != null){
            try{
                String responseLine;
                while((responseLine = in.readLine()) != null){
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("220") != -1){
                        break;
                    }
                }

                out.println("HELO "+ InetAddress.getLocalHost().getHostAddress());
                System.out.println("HELO "+InetAddress.getLocalHost().getHostAddress());
                while ((responseLine = in.readLine()) != null){
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("250") != -1){
                        break;
                    }
                }

                out.println("MAIL From: mytest@test.com");
                while((responseLine = in.readLine()) != null){
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("250") != -1){
                        break;
                    }
                }

                out.println("RCPT TO: wfpeterson2@gmail.com");
                while((responseLine = in.readLine()) != null){
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("250") != -1){
                        break;
                    }
                }

                out.println("DATA");
                while((responseLine = in.readLine()) != null){
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("354") != -1){
                        break;
                    }
                }

                out.println("From: mytest@test.com");
                out.println("To: wfpeterson2@gmail.com");
                //out.println("Subject: TEST EMAIL");
                out.println();
                out.println("Subject: TEST EMAIL"); // message body
                out.println("This is a test message"); // message body
                out.println("Thanks,"); // message body
                out.println("Java Network Programming course"); // message body
                out.println();
                out.println(".");

                while((responseLine = in.readLine()) != null){
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("250") != -1){
                        break;
                    }
                }

                out.println("QUIT");
                while((responseLine = in.readLine()) != null){
                    System.out.println("Server: "+responseLine);
                    if(responseLine.indexOf("221") != -1){
                        break;
                    }
                }

                System.out.println("Email successfully sent!");

                out.close();
                in.close();
                smtpSocket.close();


            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
