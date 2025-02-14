import java.net.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class Client extends JFrame {

    Socket socket;

    BufferedReader br;
    PrintWriter out;

    //declare component
    private JLabel heading=new JLabel("Client Area");
    private JTextArea messageArea=new JTextArea();
    private JTextField messageInput=new JTextField();
    private Font font=new Font("Roboto",Font.PLAIN,20);

    public Client()
    {
        try {
           // System.out.println("Sending request to server");
           // socket=new Socket("127.0.0.1",7777);
          //  System.out.println("connection done.");

           // br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
           // out=new PrintWriter(socket.getOutputStream());
    
            createGUI();
            handleEvents();
                                   // startReading();
                                   // startWriting();
                        
                                } catch (final Exception e){
                        
                                }
                            }
                        
                            private void handleEvents() {
                    messageInput.addKeyListener(new KeyListener() {

                        @Override
                        public void keyTyped(KeyEvent e) {
                            
                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                            
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                            System.out.println();
                        }
                        
                    });
                }
            
                            private void createGUI()
    {
        //GUI Code

        this.setTitle("Client Messager[END]");
        this.setSize(600,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // coding for component
        heading.setFont(font);
        messageArea.setFont(font);
        messageInput.setFont(font);
        
        messageInput.setHorizontalAlignment(SwingConstants.CENTER);
        // set the frame layout
        this.setLayout(new BorderLayout());

        //adding the components to frame
        this.add(heading,BorderLayout.NORTH);
        this.add(messageArea,BorderLayout.CENTER);
        this.add(messageInput,BorderLayout.SOUTH);


        this.setVisible(true);
    }

    // start reading method
    public void startReading()
    {
        // thread-read is given
        final Runnable r1=()->{

            System.out.println("reader started...");

        while(true){
            try {
                final String msg=br.readLine();
                if(msg.equals("exit")){
                System.out.println("Server terminated the chat");
                break;
            }
                System.out.println("Server : "+msg);

            }catch(final Exception e) 
            {
            e.printStackTrace();
            }
        }
    };

    new Thread(r1).start();
}
public void startWriting(){
    // thread - data user take & send the client 
    final Runnable r2=()->{
        System.out.println("Writer started...");
        while(true)
        {
            try {
                
                final BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                final String content=br1.readLine();
                out.println(content);
                out.flush();

            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    };

    new Thread(r2).start();
}

public static void main(final String args[]){
    System.out.println("this is client...");
    new Client();
}
}
