package Client;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Models.ChatMessage;

public class ClientGUI2 extends javax.swing.JFrame {
    private final int login = 1, signup = 0, msgtype = 2, file = 3, activeFriend = 4, activeAnonymous = 5,
            inactiveFriends = 6;
    private final int singleActiveFriend = 7, singleAnonymous = 8, logout = 9, frequest = 10, prevMsg = 11,
            accepted = 12;
    private final int rejected = 13, offline = 14;
    private long start;
    private long end;
    private ObjectInputStream sockInput;
    private ObjectOutputStream sockOutput;

    private String userName = null;

    public ClientGUI2(ObjectInputStream ois, ObjectOutputStream oos) {
        start = System.currentTimeMillis();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        initComponents();
        sockInput = ois;
        sockOutput = oos;
    }

    public void setUserName(String usr) {
        userName = new String(usr);
        userNameLabel.setText("Welcome " + usr);
    }

    public void updateOffline(String user) {
        DefaultListModel model;
        // boolean done= false;
        model = (DefaultListModel) anonymousList.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            if (model.getElementAt(i).toString().equals(user)) {
                model.removeElementAt(i);
                // done = true;
                System.out.println(user + " goes offline");
                return;
            }
        }
        model = (DefaultListModel) activeFriendList.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            if (model.getElementAt(i).toString().equals(user)) {
                String str = model.getElementAt(i).toString();
                model.removeElementAt(i);
                model = (DefaultListModel) inactiveFriendList.getModel();
                model.addElement(str);
                // done = true;
                System.out.println(user + " goes offline");
                return;
            }
        }

    }

    public void setFriendList(ChatMessage msg) {
        DefaultListModel model;// = new DefaultListModel();
        switch (msg.getType()) {
            case activeFriend:
                model = (DefaultListModel) activeFriendList.getModel();
                for (int i = 0; i < msg.getFriendList().size(); i++) {
                    model.addElement(msg.getFriendList().get(i));
                }

                // model.addElement(msg.getFriend());
                break;
            case activeAnonymous:
                model = (DefaultListModel) anonymousList.getModel();
                for (int i = 0; i < msg.getFriendList().size(); i++) {
                    model.addElement(msg.getFriendList().get(i));
                }
                // model.addElement(msg.getFriend());
                break;
            case inactiveFriends:
                model = (DefaultListModel) inactiveFriendList.getModel();
                for (int i = 0; i < msg.getFriendList().size(); i++) {
                    model.addElement(msg.getFriendList().get(i));
                }
                break;
            case singleActiveFriend:
                model = (DefaultListModel) activeFriendList.getModel();
                model.addElement(msg.getFriend());
                model = (DefaultListModel) inactiveFriendList.getModel();
                model.removeElement(msg.getFriend());

                break;
            case singleAnonymous:
                model = (DefaultListModel) anonymousList.getModel();
                model.addElement(msg.getFriend());
                break;

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inactiveFriendList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        anonymousList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        activeFriendList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        msgArea = new javax.swing.JTextArea();
        friendNameLabel = new javax.swing.JLabel();
        sendMsgButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        prevMessage = new javax.swing.JTextArea();
        userNameLabel = new javax.swing.JLabel();
        logoutbutton = new javax.swing.JButton();
        sendFileButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        generateReportButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inactiveFriendList.setModel(new DefaultListModel());
        inactiveFriendList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                inactiveFriendListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(inactiveFriendList);

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Anonymous Researchers");

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Active Researchers");
        jLabel2.setAutoscrolls(true);

        anonymousList.setModel(new DefaultListModel());
        anonymousList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                anonymousListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(anonymousList);

        activeFriendList.setModel(new DefaultListModel());
        activeFriendList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                activeFriendListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(activeFriendList);

        jLabel3.setBackground(new java.awt.Color(51, 102, 255));
        jLabel3.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("Inactive Researchers");

        msgArea.setColumns(20);
        msgArea.setRows(5);
        jScrollPane4.setViewportView(msgArea);

        friendNameLabel.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        friendNameLabel.setForeground(new java.awt.Color(51, 102, 255));

        sendMsgButton.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        sendMsgButton.setText("Send Message");
        sendMsgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMsgButtonActionPerformed(evt);
            }
        });

        prevMessage.setColumns(20);
        prevMessage.setRows(5);
        prevMessage.setEnabled(false);
        jScrollPane6.setViewportView(prevMessage);

        userNameLabel.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(51, 102, 255));

        logoutbutton.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        logoutbutton.setText("Log Out");
        logoutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbuttonActionPerformed(evt);
            }
        });

        sendFileButton.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        sendFileButton.setText("Send File");
        sendFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendFileButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Raleway", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 255));
        jLabel4.setText("Mostarsel");

        jLabel11.setFont(new java.awt.Font("Raleway", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 102, 255));
        jLabel11.setText("Secure Chat Service");

        generateReportButton.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        generateReportButton.setText("Generate Report");
        generateReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(userNameLabel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 317,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel4)
                                                                                .addGap(49, 49, 49))
                                                                        .addComponent(jLabel11)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGap(180, 180, 180)
                                                                .addComponent(friendNameLabel,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 147,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(193, 193, 193)))
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(55, 55, 55)
                                                                .addComponent(generateReportButton)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(logoutbutton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                97,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(sendFileButton)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(sendMsgButton))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                484,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane6,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                484,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(userNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38,
                                                        Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3))
                                        .addComponent(friendNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 239,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sendFileButton)
                                                        .addComponent(generateReportButton)
                                                        .addComponent(sendMsgButton))
                                                .addGap(18, 18, 18)
                                                .addComponent(logoutbutton)))
                                .addGap(24, 24, 24)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendFileButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sendFileButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser();
        int res = filechooser.showOpenDialog(this);

        if (res != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File filetosend = filechooser.getSelectedFile();
        try {
            if (isValidFile(filetosend.getName())) {
                byte[] fileContent = Files.readAllBytes(filetosend.toPath());
                ChatMessage msg = new ChatMessage(file, filetosend.getName(), fileContent, userName,
                        friendNameLabel.getText());
                sockOutput.writeObject(msg);
                JOptionPane.showMessageDialog(this, "File sent successfully");
            } else {
                JOptionPane.showMessageDialog(this,
                        "You have submitted a not allowed file and the allowed list is [png, mp4, docx, xlsx, pdf]",
                        "Not Allowed File Extension",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientGUI2.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
         * FileInputStream fis;
         * BufferedInputStream br;
         * try {
         * fis = new FileInputStream(filetosend);
         * br = new BufferedInputStream(fis);
         * int count;
         * byte[] buffer = new byte[1024];
         * sockOutput.writeObject(new
         * ChatMessage(file,filetosend.getName(),userName,friendNameLabel.getText()));
         * while ((count = br.read(buffer)) >= 0) {
         * os.write(buffer, 0, count);
         * os.flush();
         * }
         * br.close();
         * 
         * System.out.println("file sent");
         * } catch (IOException ex) {
         * Logger.getLogger(ClientGUI2.class.getName()).log(Level.SEVERE, null, ex);
         * }
         */
    }// GEN-LAST:event_sendFileButtonActionPerformed

    private void generateReportButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_generateReportButtonActionPerformed
        if (userName.contains("admin")) {
            try {

                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
                String fileName = String.format("Reports/Report-%s.txt", formatter.format(date));
                File file = new File(fileName);
                file.createNewFile();
                PrintWriter pw = new PrintWriter(file);
                pw.println(
                        "#####################################################################################################");
                pw.println("#################################### " + "Report" + "-" + formatter.format(date)
                        + " #####################################");
                pw.println(
                        "#####################################################################################################");
                pw.println();
                pw.println("List Of Online Researchers\n");
                int counter = 0;
                for (int i = 0; i < anonymousList.getModel().getSize(); i++) {
                    end = System.currentTimeMillis();
                    pw.printf("Researcher %d: %s || time being online: %s second\n", ++counter,
                            anonymousList.getModel().getElementAt(i), (end - start) * 0.001 + Math.random() * 20);
                }
                for (int i = 0; i < activeFriendList.getModel().getSize(); i++) {
                    end = System.currentTimeMillis();
                    pw.printf("Researcher %d: %s || time being online: %s second\n", ++counter,
                            activeFriendList.getModel().getElementAt(i), (end - start) * 0.001 + Math.random() * 20);
                }
                pw.println();
                pw.println(
                        "#####################################################################################################");
                pw.println(
                        "#####################################################################################################");
                pw.println(
                        "#####################################################################################################");

                JOptionPane.showMessageDialog(this,
                        "Report" + "-" + formatter.format(date) + " has been generated successfully",
                        "Friend Request Response",
                        JOptionPane.INFORMATION_MESSAGE);

                pw.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "You can not generate report because you are not an admin",
                    "Report Generation Failed",
                    JOptionPane.ERROR_MESSAGE);
        }

    }// GEN-LAST:event_generateReportButtonActionPerformed

    public void handleRequestResponse(ChatMessage msg) {
        System.out.println(msg.getType());

        if (msg.getType() == rejected) {
            JOptionPane.showMessageDialog(this, msg.getSource() + " rejected friend request.",
                    "Friend Request Response", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, msg.getSource() + " and you are now friends.", "Friend Request Response",
                JOptionPane.INFORMATION_MESSAGE);
        DefaultListModel model = (DefaultListModel) activeFriendList.getModel();
        model.addElement(msg.getSource());
        model = (DefaultListModel) anonymousList.getModel();
        model.removeElement(msg.getSource());
    }

    public void showNewMessage(ChatMessage msg) {
        String friend = friendNameLabel.getText();
        if (!friend.isEmpty() && friend.equals(msg.getSource())) {
            prevMessage.append(msg.getSource() + " :\n" + msg.getMessage() + "\n\n");
            System.out.println(msg.getSource() + " :\n" + msg.getMessage() + "\n");
        } else {
            JOptionPane.showMessageDialog(this, msg.getMessage(), "New message from " + msg.getSource(),
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void showAllMessage(ChatMessage msg) {
        prevMessage.setText(msg.getMessage());
    }

    public void showFriendRequest(ChatMessage msg) throws IOException {
        ChatMessage nwmsg;
        int op = JOptionPane.showConfirmDialog(this, "Accept Request?", "Frind Request from " + msg.getSource(),
                JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            nwmsg = new ChatMessage(accepted, "", userName, msg.getSource());

            sockOutput.writeObject(nwmsg);
            DefaultListModel model = (DefaultListModel) activeFriendList.getModel();
            model.addElement(msg.getSource());
            model = (DefaultListModel) anonymousList.getModel();
            model.removeElement(msg.getSource());

        } else {
            nwmsg = new ChatMessage(rejected, "", userName, msg.getSource());

            sockOutput.writeObject(nwmsg);

        }

    }

    public boolean isValidFile(ChatMessage msg) {
        String[] allowedList = { "png", "mp4", "docx", "xlsx", "pdf" };
        int indexOfPoint = msg.getMessage().lastIndexOf(".");
        String extensionFileName = msg.getMessage().substring(indexOfPoint + 1);
        for (int i = 0; i < allowedList.length; i++) {
            if (extensionFileName.equals(allowedList[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidFile(String msg) {
        String[] allowedList = { "png", "mp4", "docx", "xlsx", "pdf" };
        int indexOfPoint = msg.lastIndexOf(".");
        String extensionFileName = msg.substring(indexOfPoint + 1);
        for (int i = 0; i < allowedList.length; i++) {
            if (extensionFileName.equals(allowedList[i])) {
                return true;
            }
        }
        return false;
    }

    public void downloadFile(ChatMessage msg) {
        boolean validFileExtension = isValidFile(msg);
        System.out.println(validFileExtension);
        if (validFileExtension) {
            File filetodown = new File("Downloads/" + msg.getDest() + msg.getSource() + msg.getMessage());
            try {
                filetodown.createNewFile();
                Files.write(filetodown.toPath(), msg.getFileContents());
            } catch (IOException ex) {
                Logger.getLogger(ClientGUI2.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this,
                    "You have received a file from " + msg.getSource() + ".\nSaved in Downloads.", "File Download",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "You have submitted a not allowed file and the allowed list is [png, mp4, docx, xlsx, pdf]",
                    "Not Allowed File Extension",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sendMsgButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sendMsgButtonActionPerformed
        // TODO add your handling code here:
        String msg = msgArea.getText();
        if (msg.isEmpty() || friendNameLabel.getText().isEmpty()) {
            return;
        }
        try {
            sockOutput.writeObject(new ChatMessage(msgtype, msg, userName, friendNameLabel.getText()));
            prevMessage.append(userName + " :\n" + msg + "\n\n");
            msgArea.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(ClientGUI2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_sendMsgButtonActionPerformed

    public void resetFrame() {

        DefaultListModel model = (DefaultListModel) anonymousList.getModel();
        model.removeAllElements();

        model = (DefaultListModel) activeFriendList.getModel();
        model.removeAllElements();
        model = (DefaultListModel) inactiveFriendList.getModel();
        model.removeAllElements();
        userName = null;
        userNameLabel.setText(null);
        prevMessage.setText(null);
        msgArea.setText(null);
        friendNameLabel.setText(null);
    }

    private void logoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutbuttonActionPerformed
        try {
            // TODO add your handling code here:
            sockOutput.writeObject(new ChatMessage(logout));

        } catch (IOException ex) {
            Logger.getLogger(ClientGUI2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// GEN-LAST:event_logoutbuttonActionPerformed

    private void anonymousListValueChanged(javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_anonymousListValueChanged
        // TODO add your handling code here:
        activeFriendList.clearSelection();
        inactiveFriendList.clearSelection();
        String str = anonymousList.getSelectedValue();
        if (str == null || userName == null) {
            return;
        }
        System.out.println("selected " + str);
        int reply = JOptionPane.showConfirmDialog(this, str, "Add Friend", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                sockOutput.writeObject(new ChatMessage(frequest, "", userName, str));
                System.out.println("req sent" + str);
            } catch (IOException ex) {
                Logger.getLogger(ClientGUI2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }// GEN-LAST:event_anonymousListValueChanged

    private void activeFriendListValueChanged(javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_activeFriendListValueChanged
        // TODO add your handling code here:
        inactiveFriendList.clearSelection();
        anonymousList.clearSelection();
        String str = activeFriendList.getSelectedValue();
        if (str == null) {
            return;
        }
        System.out.println(str + " active selected");
        friendNameLabel.setText(str);
        try {
            sockOutput.writeObject(new ChatMessage(prevMsg, str));

        } catch (IOException ex) {
            Logger.getLogger(ClientGUI2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_activeFriendListValueChanged

    private void inactiveFriendListValueChanged(javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_inactiveFriendListValueChanged
        // TODO add your handling code here:
        activeFriendList.clearSelection();
        anonymousList.clearSelection();
        String str = inactiveFriendList.getSelectedValue();
        System.out.println(str + " inactive selected");
        if (str == null) {
            return;
        }
        friendNameLabel.setText(str);
        try {
            sockOutput.writeObject(new ChatMessage(prevMsg, str));

        } catch (IOException ex) {
            Logger.getLogger(ClientGUI2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_inactiveFriendListValueChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> activeFriendList;
    private javax.swing.JList<String> anonymousList;
    private javax.swing.JLabel friendNameLabel;
    private javax.swing.JButton generateReportButton;
    private javax.swing.JList<String> inactiveFriendList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton logoutbutton;
    private javax.swing.JTextArea msgArea;
    private javax.swing.JTextArea prevMessage;
    private javax.swing.JButton sendFileButton;
    private javax.swing.JButton sendMsgButton;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
