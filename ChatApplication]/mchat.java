// import java.awt.event.*;      // For utility classes like ArrayList
// import java.io.*;       // For networking classes like Socket
// import java.net.*;        // For input and output streams
// import javax.swing.*;       // For GUI components

// // Main class implementing ActionListener to handle button events
// public class mchat implements ActionListener {
//     // GUI components
//     JFrame loginFrame, chatFrame; // Frames for login and chat windows
//     JLabel loginLabel, sentLabel, wannaSendLabel; // Labels for UI elements
//     JTextField usernameField;    // Text field for username input
//     JTextArea messageArea, sentItemsArea, notificationsArea; // Text areas for messages and logs
//     JScrollPane messageScroll, sentItemsScroll, notificationsScroll; // Scroll panes for text areas
//     JButton loginButton, sendButton, logoutButton; // Buttons for actions

//     // Networking components
//     Socket socket;                // Socket for connecting to the server
//     DataInputStream din;          // Input stream to receive messages
//     DataOutputStream dout;        // Output stream to send messages
//     String username, chatLog = ""; // Stores username and chat log

//     // Constructor to set up the GUI and network connection
//     public mchat() {
//         // Initialize login frame
//         loginFrame = new JFrame("Login Form");
//         loginLabel = new JLabel("Enter Username:"); // Label for username input
//         usernameField = new JTextField();          // Text field for entering username
//         loginButton = new JButton("Log In");       // Button to log in

//         // Set bounds for login frame components
//         loginLabel.setBounds(50, 50, 150, 30);
//         usernameField.setBounds(160, 50, 150, 30);
//         loginButton.setBounds(100, 100, 90, 30);

//         // Add components to the login frame
//         loginFrame.add(loginLabel);
//         loginFrame.add(usernameField);
//         loginFrame.add(loginButton);
//         loginFrame.setLayout(null);
//         loginFrame.setSize(400, 300);
//         loginFrame.setVisible(true); // Display login frame

//         // Initialize chat frame
//         chatFrame = new JFrame("Chat");
//         sentLabel = new JLabel("Sent Items:");          // Label for sent items area
//         wannaSendLabel = new JLabel("Wanna Send?");     // Label for message input area
//         messageArea = new JTextArea();                 // Text area for entering messages
//         sentItemsArea = new JTextArea();               // Text area for displaying sent messages
//         notificationsArea = new JTextArea();           // Text area for displaying server notifications
//         sendButton = new JButton("Send");              // Button to send messages
//         logoutButton = new JButton("Log Out");         // Button to log out

//         // Set up scroll panes for text areas
//         messageScroll = new JScrollPane(messageArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
//                 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//         sentItemsScroll = new JScrollPane(sentItemsArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
//                 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//         notificationsScroll = new JScrollPane(notificationsArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
//                 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

//         // Set bounds for chat frame components
//         sentLabel.setBounds(20, 20, 100, 30);
//         sentItemsScroll.setBounds(130, 20, 300, 150);
//         wannaSendLabel.setBounds(20, 180, 100, 30);
//         messageScroll.setBounds(130, 180, 300, 60);
//         sendButton.setBounds(50, 260, 100, 30);
//         logoutButton.setBounds(200, 260, 100, 30);
//         notificationsScroll.setBounds(130, 300, 300, 100);

//         // Add components to the chat frame
//         chatFrame.add(sentLabel);
//         chatFrame.add(wannaSendLabel);
//         chatFrame.add(messageScroll);
//         chatFrame.add(sentItemsScroll);
//         chatFrame.add(notificationsScroll);
//         chatFrame.add(sendButton);
//         chatFrame.add(logoutButton);

//         chatFrame.setLayout(null);
//         chatFrame.setSize(500, 500);
//         chatFrame.setVisible(false); // Hide chat frame initially

//         // Add action listeners for buttons
//         loginButton.addActionListener(this);
//         sendButton.addActionListener(this);
//         logoutButton.addActionListener(this);

//         // Initialize network connection
//         try {
//             socket = new Socket("13.201.161.138", 8); // Connect to the server
//             din = new DataInputStream(socket.getInputStream()); // Input stream to receive messages
//             dout = new DataOutputStream(socket.getOutputStream()); // Output stream to send messages

//             // Start a thread to listen for messages from the server
//             MessageListener listener = new MessageListener(din);
//             Thread t = new Thread(listener);
//             t.start();
//         } catch (Exception e) {
//             System.out.println("Error: " + e.getMessage());
//         }
//     }

//     // Action handler for button clicks
//     @Override
//     public void actionPerformed(ActionEvent e) {
//         try {
//             if (e.getSource() == loginButton) {
//                 // Handle login
//                 username = usernameField.getText(); // Get entered username
//                 if (!username.isEmpty()) {
//                     loginFrame.setVisible(false); // Hide login frame
//                     chatFrame.setVisible(true);   // Show chat frame
//                     dout.writeUTF(username + " logged in"); // Notify server about login
//                     dout.flush();
//                 }
//             } else if (e.getSource() == sendButton) {
//                 // Handle sending a message
//                 String message = messageArea.getText(); // Get message from input area
//                 if (!message.isEmpty()) {
//                     dout.writeUTF(username + ": " + message); // Send message to server
//                     dout.flush();
//                     sentItemsArea.append("Me: " + message + "\n"); // Append message to sent items
//                     messageArea.setText(""); // Clear input area
//                 }
//             } else if (e.getSource() == logoutButton) {
//                 // Handle logout
//                 dout.writeUTF(username + " logged out"); // Notify server about logout
//                 dout.flush();
//                 System.exit(0); // Exit the application
//             }
//         } catch (Exception ex) {
//             ex.printStackTrace();
//         }
//     }

//     // Main method to start the application
//     public static void main(String[] args) {
//         new mchat(); // Create an instance of mchat
//     }

//     // Inner class to listen for messages from the server
//     class MessageListener implements Runnable {
//         DataInputStream din;

//         // Constructor to initialize input stream
//         public MessageListener(DataInputStream din) {
//             this.din = din;
//         }

//         @Override
//         public void run() {
//             try {
//                 String receivedMessage;
//                 while ((receivedMessage = din.readUTF()) != null) {
//                     // Display received messages in the notification area
//                     chatLog += receivedMessage + "\n";
//                     notificationsArea.setText(chatLog);
//                 }
//             } catch (Exception e) {
//                 System.out.println("Disconnected from server.");
//             }
//         }
//     }
// }



import java.util.*; // For utility classes (not used in this code but kept for completeness)
import java.net.*;  // For networking classes like Socket
import java.io.*;   // For input and output streams
import java.awt.*;  // For GUI components
import java.awt.event.*; // For handling events like button clicks
import javax.swing.*;    // For Swing GUI components

public class mchat implements ActionListener { // Main class implementing ActionListener for button events
    // GUI components
    JFrame f, f1; // Frames for login and chat
    JLabel l, l1, l2; // Labels for user interface
    JTextField tf; // Text field for username input
    JTextArea ta, ta1, ta2; // Text areas for chat input and display
    JScrollPane js, js1, js2; // Scroll panes for text areas
    JButton b, b1, b2; // Buttons for login, send, and logout actions

    // Networking components
    Socket s; // Socket for client-server communication
    DataInputStream din; // Input stream to receive data
    DataOutputStream dout; // Output stream to send data

    // Variables to hold user data and chat messages
    String st = "", name, st1 = ""; 
    int flag = 0;

    // Constructor to initialize GUI and networking
    public mchat() {
        // Create login frame
        f = new JFrame("LOGIN FORM");

        // Create chat frame
        f1 = new JFrame("CHAT");

        // Labels
        l = new JLabel("Enter user name:"); // Label for username input
        l1 = new JLabel("Sent items"); // Label for sent messages
        l2 = new JLabel("Wanna send?"); // Label for chat input prompt
        l.setBounds(50, 50, 100, 30);

        // Text field for entering username
        tf = new JTextField(100); 
        tf.setBounds(160, 50, 100, 30);

        // Buttons
        b = new JButton("LOG IN"); // Button for login
        b.setBounds(100, 100, 90, 30);

        b1 = new JButton("SEND"); // Button for sending messages
        b1.setBounds(75, 300, 80, 30);

        b2 = new JButton("LOG OUT"); // Button for logout
        b2.setBounds(170, 300, 120, 30);

        // Add components to the login frame
        f.getContentPane().add(l);
        f.getContentPane().add(tf);
        f.getContentPane().add(b);

        // Text areas for chat input and display
        ta = new JTextArea(250, 60);  // Chat input
        ta1 = new JTextArea(250, 160); // Chat history display
        ta2 = new JTextArea(250, 160); // Received messages display

        // Scroll panes for text areas
        js = new JScrollPane(ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        js1 = new JScrollPane(ta1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        js2 = new JScrollPane(ta2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Positioning scroll panes
        js.setBounds(160, 230, 250, 60);
        js1.setBounds(160, 50, 250, 160);
        js2.setBounds(450, 50, 100, 160);

        // Positioning labels
        l2.setBounds(40, 230, 80, 30);
        l1.setBounds(40, 50, 80, 30);

        // Add components to chat frame
        f1.getContentPane().add(b1);
        f1.getContentPane().add(b2);
        f1.getContentPane().add(l1);
        f1.getContentPane().add(l2);
        f1.getContentPane().add(js);
        f1.getContentPane().add(js1);
        f1.getContentPane().add(js2);

        // Set layout and size for frames
        f1.getContentPane().setLayout(null);
        f1.setSize(600, 400);
        f1.setVisible(false);

        f.getContentPane().setLayout(null);
        f.setSize(300, 300);
        f.setVisible(true);

        // Add action listeners for buttons
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);

        // Connect to server
        try {
            s = new Socket("13.201.161.138", 8); // Connect to server at specified IP and port
            din = new DataInputStream(s.getInputStream()); // Input stream from server
            dout = new DataOutputStream(s.getOutputStream()); // Output stream to server

            // Start a thread to listen for incoming messages
            my m = new my(din);
            Thread t1 = new Thread(m);
            t1.start();

            // Clear received messages area
            ta2.setText("");
        } catch (Exception e) {
            System.out.println("Error connecting to server: " + e);
        }
    }

    // Handle button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) { // Login button
            try {
                name = tf.getText(); // Get username
                f.setVisible(false); // Hide login frame
                f1.setVisible(true); // Show chat frame
                clientchat1(); // Notify server of login
            } catch (Exception l) {
                l.printStackTrace();
            }
        }
        if (e.getSource() == b1) { // Send button
            try {
                clientchat(); // Send chat message to server
            } catch (Exception j) {
                j.printStackTrace();
            }
        }
        if (e.getSource() == b2) { // Logout button
            try {
                clientchat2(); // Notify server of logout
            } catch (Exception j) {
                j.printStackTrace();
            }
        }
    }

    // Notify server of logout
    public void clientchat2() throws IOException {
        dout.writeUTF(name + " logged out");
        dout.flush();
        System.exit(0); // Close application
    }

    // Notify server of login
    public void clientchat1() throws IOException {
        String s1 = name + " logged in";
        dout.writeUTF(s1);
        dout.flush();
    }

    // Send chat message to server
    public void clientchat() throws IOException {
        String s1 = ta.getText(); // Get message from input area
        dout.writeUTF(name + ": " + s1); // Send message with username
        dout.flush();
        ta.setText(""); // Clear input area
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new mchat();
    }

    // Inner class to handle incoming messages
    class my implements Runnable {
        DataInputStream din;

        // Constructor to initialize input stream
        public my(DataInputStream din) {
            this.din = din;
        }

        // Thread run method to listen for incoming messages
        public void run() {
            String st = "";
            try {
                while (true) {
                    st = din.readUTF(); // Read incoming message
                    ta1.append(st + "\n"); // Append message to chat history
                }
            } catch (Exception e) {
                System.out.println("Disconnected: " + e);
            }
        }
    }
}
