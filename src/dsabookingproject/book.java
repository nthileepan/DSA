/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dsabookingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author thileepan
 */
public class book extends javax.swing.JFrame {

    /**
     * Creates new form book
     */
    int c = 1;
    int reservation = 0;
    int seat = 0;
    int areservation = 0;
    String pname = null;
    String date = "";
    String location = "";
    String realname = "";
    Queue<String> rename = new LinkedList<>();
    Queue<String> renum = new LinkedList<>();
    Queue<String> waitname = new LinkedList<>();
    Queue<String> waitnum = new LinkedList<>();
    Queue<String> crename = new LinkedList<>();
    Queue<String> crenum = new LinkedList<>();
    Queue<String> canname = new LinkedList<>();

    public book() {
        initComponents();
        jButton3.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel17.setVisible(false);
        jLabel18.setVisible(false);
        jButton9.setVisible(false);

    }

    void hides(boolean what) {
        jButton2.setEnabled(what);
        jButton1.setEnabled(what);
        jTextField2.setEnabled(what);

    }

    public void sendfirstmessage(String r) {
        JPanel f = new JPanel();
        JPanel fmessage = new JPanel();
        f.setLayout(new BorderLayout());
        f.setPreferredSize(new Dimension(648, 130));
        f.setMaximumSize(new Dimension(648, 130));
        f.setMinimumSize(new Dimension(648, 130));
        f.setBackground(new Color(11, 20, 26));
        fmessage.setPreferredSize(new Dimension(310, 100));
        fmessage.setMaximumSize(new Dimension(310, 100));
        fmessage.setMinimumSize(new Dimension(310, 100));
        fmessage.setBackground(new Color(0, 92, 75));
        String str = "";
        if (r.equals("1")) {
            str = "<html>Hello, "+realname+" Please confirm your booking: <br>\n"
                    + " Type YES ----- Confirm booking<br>"
                    + " Type NO ----- Cancel booking<br></html>";
        } else if (r.equals("w1")) {
            str = "<html>Hello, "+realname+" ONLY 48 hours left for confirm your booking. Please confirm your booking: <br>\n"
                    + " Type YES ----- Confirm booking<br>"
                    + " Type NO ----- Cancel booking<br></html>";
        } else if (r.equals("w2")) {
            str = "<html>Hello, "+realname+" ONLY 24 hours left for confirm your booking. Please confirm your booking: <br>\n"
                    + " Type YES ----- Confirm booking<br>"
                    + " Type NO ----- Cancel booking<br></html>";
        } else if (r.equals("w3")) {
            str = "<html>Hello, "+realname+" ONLY 1 hours left for confirm your booking. Please confirm your booking: <br>\n"
                    + " Type YES ----- Confirm booking<br>"
                    + " Type NO ----- Cancel booking<br></html>";
        } else if (r.equals("w4")) {
            str = "Booking cancelled";
        }

        JLabel label = new JLabel(str);

        label.setForeground(Color.white);
        label.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        label.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setMinimumSize(new Dimension(310, 100));
        label.setMaximumSize(new Dimension(310, 100));
        label.setPreferredSize(new Dimension(310, 100));
        fmessage.add(label);
        f.add(fmessage, BorderLayout.EAST);
        jPanel2.add(f);
        jPanel2.revalidate();
        jScrollPane1.revalidate();
        jButton3.setVisible(false);
        jTextField2.setEditable(true);
    }

    public void addmessagebox(String name) {
        JPanel l = new JPanel();
        JPanel message = new JPanel();
        l.setLayout(new BorderLayout());
        l.setPreferredSize(new Dimension(648, 40));
        l.setMaximumSize(new Dimension(648, 40));
        l.setMinimumSize(new Dimension(648, 40));
        l.setBackground(new Color(11, 20, 26));
        message.setPreferredSize(new Dimension(150, 40));
        message.setMaximumSize(new Dimension(150, 40));
        message.setMinimumSize(new Dimension(150, 40));
        message.setBackground(new Color(0, 92, 75));
        JLabel label = new JLabel();
        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setText(name);
        message.add(label);
        l.add(message, BorderLayout.WEST);
        jPanel2.add(l);
        jPanel2.revalidate();
        jScrollPane1.revalidate();
    }

    public void response(String name) {
        JPanel r = new JPanel();
        JPanel message = new JPanel();
        r.setLayout(new BorderLayout());
        r.setPreferredSize(new Dimension(648, 40));
        r.setMaximumSize(new Dimension(648, 40));
        r.setMinimumSize(new Dimension(648, 40));
        r.setBackground(new Color(11, 20, 26));
        message.setPreferredSize(new Dimension(380, 40));
        message.setMaximumSize(new Dimension(380, 40));
        message.setMinimumSize(new Dimension(380, 40));
        message.setBackground(new Color(0, 92, 75));
        JLabel label = new JLabel();
        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setText(name);
        message.add(label);
        r.add(message, BorderLayout.EAST);
        jPanel2.add(r);
        jPanel2.revalidate();
        jScrollPane1.revalidate();
    }

    void getname(String yes) {
        if (yes.equals("yes")) {

            pname = waitname.poll();

        } else {
            pname = rename.poll();
        }
        int lh = pname.length();
        char ash = pname.charAt(lh - 1);
        if (Character.isDigit(ash)) {
                int numwait = Character.getNumericValue(ash);
                realname = pname.substring(0, pname.length() - numwait);
                
            } 
        else
                {
                    realname = pname;
                }
        jLabel3.setText(realname);
        send(pname);
    }

    void send(String name) {
        int l = name.length();
        char as = name.charAt(l - 1);
        if (Character.isDigit(as)) {
            int numwait = Character.getNumericValue(as);
            if (as == '1') {
                sendfirstmessage("1");
                sendfirstmessage("w1");

            }
            if (as == '2') {
                sendfirstmessage("1");
                sendfirstmessage("w1");
                sendfirstmessage("w2");

            }
            if (as == '3') {
                sendfirstmessage("1");
                sendfirstmessage("w1");
                sendfirstmessage("w2");
                sendfirstmessage("w3");

            }
            if (as == '4') {
                sendfirstmessage("1");
                sendfirstmessage("w1");
                sendfirstmessage("w2");
                sendfirstmessage("w3");
                sendfirstmessage("w4");
                adder("noresp", name);

            }

        } else {
            sendfirstmessage("1");
        }
    }

    void adder(String response, String name) {
        int l = name.length();
        char as = name.charAt(l - 1);
        if (response.equals("yes")) {
            jButton3.setVisible(true);
            c++;
            addmessagebox(response);
            response("Thank you for booking! have a great day!");
            if (Character.isDigit(as)) {
                int numwait = Character.getNumericValue(as);
                String realname = name.substring(0, name.length() - numwait);
                crename.add(realname);
            } else {
                crename.add(name);
            }
            jTextField2.setEditable(false);
            jTextField2.setText("");
            hides(false);
        } else if (response.equals("no")) {
            jButton3.setVisible(true);
            c++;
            addmessagebox(response);
            response("Booking canceled. Thank you");
            if (Character.isDigit(as)) {
                int numwait = Character.getNumericValue(as);
                String realname = name.substring(0, name.length() - numwait);
                canname.add(realname);
            } else {
                canname.add(name);
            }

            jTextField2.setEditable(false);
            jTextField2.setText("");
            hides(false);
        } else if (response.equals("noresp")) {
            if (Character.isDigit(as)) {
                if (as == '1') {
                    rename.add(name + "2");
                }
                if (as == '2') {
                    rename.add(name + "3");
                }
                if (as == '3') {
                    rename.add(name + "4");
                }
                if (as == '4') {
                    hides(false);
                    if (Character.isDigit(as)) {
                        int numwait = Character.getNumericValue(as);
                        String realname = name.substring(0, name.length() - numwait);
                        canname.add(realname);
                    } else {
                        canname.add(name);
                    }
                    
                    jButton3.setVisible(true);
                }

            } else {
                rename.add(name + "1");
            }
        } else {

            addmessagebox(response);
            response("Invalid input. Please enter yes or no");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(32, 44, 51));

        jTextField2.setBackground(new java.awt.Color(0, 51, 51));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportView(jPanel2);

        jPanel2.setBackground(new java.awt.Color(11, 20, 26));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel2);

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SEND");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("No Response");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(32, 44, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dsabookingproject/image/icons8_left_50px_2.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dsabookingproject/image/icons8_male_user_50px_7.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Thileepan");

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 0, 0));
        jButton10.setText("DASHBOARD");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton10))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTextField2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(2, 2, 2)
                .addComponent(jButton2)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel4.setBackground(new java.awt.Color(138, 180, 248));
        jPanel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(51, 51, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jaffna Travel Online ");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 51, 255));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("USERNAME:");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 110, 31));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 255));
        jLabel7.setText("PASSWORD:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 120, 29));

        jButton4.setBackground(new java.awt.Color(255, 0, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LOGIN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 160, 30));

        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 160, 30));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 370, 260));

        jPanel7.setBackground(new java.awt.Color(0, 51, 255));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("LOGIN");
        jLabel6.setFocusable(false);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 44));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 370, 88));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dsabookingproject/image/Screenshot 2023-08-14 215835.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 70, 600, 640));

        jLayeredPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jLayeredPane1);

        jPanel8.setBackground(new java.awt.Color(138, 180, 248));
        jPanel8.setForeground(new java.awt.Color(51, 153, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(51, 51, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("WELCOME BACK, THILEEPAN");
        jLabel13.setToolTipText("");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 410, 50));

        jButton5.setBackground(new java.awt.Color(0, 0, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Start Reservation");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 190, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("LOCATION:");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 280, 50));

        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 0, 0));
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel8.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 120, 30));

        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 0, 0));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel8.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 120, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("NEW TRIP");
        jLabel9.setToolTipText("");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 181, 80));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("No of Available Seats:");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 190, 50));

        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 0, 0));
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel8.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 120, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Location:");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 90, 50));

        jButton6.setBackground(new java.awt.Color(0, 0, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Open Map");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 120, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("No of Reservation Seats:");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 210, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Reservation End Date:");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 190, 50));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("LOCATION:");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 280, 50));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("LOCATION:");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 280, 50));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("LOCATION:");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 280, 50));

        jTabbedPane1.addTab("tab3", jPanel8);

        jPanel16.setBackground(new java.awt.Color(138, 180, 248));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(51, 51, 255));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("WELCOME BACK, THILEEPAN");
        jLabel30.setToolTipText("");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel19.setBackground(new java.awt.Color(51, 51, 255));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("<html><center>DASHBOARD</center></html>");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 650, 60));

        jPanel17.setBackground(new java.awt.Color(51, 51, 255));
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Cancelled Booking");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("00");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 320, 130));

        jPanel20.setBackground(new java.awt.Color(51, 51, 255));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Confirmed Booking");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("00");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );

        jPanel16.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 320, 130));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("");

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new javax.swing.BoxLayout(jPanel21, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(jPanel21);

        jPanel16.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 320, 390));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane3.setViewportView(jPanel22);

        jPanel16.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 320, 390));

        jButton12.setBackground(new java.awt.Color(255, 51, 51));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("back");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 80, 20));

        jTabbedPane1.addTab("tab5", jPanel16);

        jPanel10.setBackground(new java.awt.Color(138, 180, 248));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(51, 51, 255));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Jaffna Travel Online ");
        jLabel20.setToolTipText("");

        jButton8.setBackground(new java.awt.Color(255, 51, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("STOP");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(23, 23, 23))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, -1));

        jPanel12.setBackground(new java.awt.Color(51, 51, 255));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("<html><center>We're thrilled to announce that our reservations for the upcoming travel season are now open</center></html>");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 650, 60));

        jPanel13.setBackground(new java.awt.Color(51, 51, 255));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("<html><center>Jaffna to nsnvl </center></html>");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 650, 80));

        jPanel14.setBackground(new java.awt.Color(51, 51, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("<html>🌟 Limited Availability: Don't miss out on this opportunity! With limited reserved seats, securing your spot now guarantees your spot on the most anticipated tours in Jaffna.</html>");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        jPanel10.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 650, -1));

        jPanel15.setBackground(new java.awt.Color(51, 51, 255));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Reservation No:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("1");

        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(0, 0, 0));
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });

        jTextField9.setBackground(new java.awt.Color(255, 255, 255));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(0, 0, 0));
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("First Name:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Last Name:");

        jButton7.setBackground(new java.awt.Color(255, 51, 51));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Reserve Seat");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Phone Number:");

        jTextField10.setBackground(new java.awt.Color(255, 255, 255));
        jTextField10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(0, 0, 0));
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel27)
                                .addGap(26, 26, 26)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButton7))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 330, 300));

        jButton9.setBackground(new java.awt.Color(255, 51, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Next");
        jButton9.setOpaque(true);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 660, -1, -1));

        jPanel23.setBackground(new java.awt.Color(51, 51, 255));

        jLabel28.setBackground(new java.awt.Color(51, 51, 255));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Reservation Ends:11/11/11");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 330, 40));

        jTabbedPane1.addTab("tab4", jPanel10);

        jTabbedPane1.setSelectedIndex(1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -36, -1, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String response = jTextField2.getText();
        adder(response, pname);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        hides(false);
        adder("noresp", pname);
        jButton3.setVisible(true);
        jTextField2.setEditable(false);
        jTextField2.setText("");
        jButton2.setEnabled(false);
        jButton3.doClick();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        hides(true);
        jButton2.setEnabled(true);
        Component[] components = jPanel2.getComponents();
        for (Component component : components) {
            jPanel2.remove(component);
        }
        jPanel2.revalidate();
        jPanel2.repaint();
        if (rename.isEmpty()) {

            int cnum = crename.size();
            if (cnum < seat) {
                if (waitname.isEmpty()) {
                    jTabbedPane1.setSelectedIndex(3);
                    jButton10.doClick();
                } else {
                    getname("yes");
                }
            } else {
                jTabbedPane1.setSelectedIndex(3);
                jButton10.doClick();
            }
        } else {
            getname("no");
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        final String password = "thil2003";
        final String username = "thileepan";
        String user = jTextField4.getText();
        String pass = jTextField3.getText();
        if (password.equals(pass) && username.equals(user)) {
            jTabbedPane1.setSelectedIndex(2);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped

    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            evt.consume();
        }

    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            evt.consume();
        }

    }//GEN-LAST:event_jTextField6KeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        NewJDialog p = new NewJDialog(null, true);
        p.jLabel10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jLabel19.setText("Jaffna to Mannar");
                p.dispose();
            }
        });
        p.jLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jLabel19.setText("Jaffna to Kandy");
                p.dispose();
            }
        });
        p.jLabel7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jLabel19.setText("Jaffna to Colombo");
                p.dispose();
            }
        });
        p.jLabel8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jLabel19.setText("Jaffna to Trincomalee");
                p.dispose();
            }
        });
        p.jLabel9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jLabel19.setText("Jaffna to Polonnaruwn");
                p.dispose();
            }
        });
        p.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (jTextField6.getText().isEmpty() || jTextField7.getText().isEmpty() || jTextField5.getText().isEmpty() || jLabel19.getText().equals("LOCATION:")) {
            if (jTextField6.getText().isEmpty()) {
                jLabel18.setText("Set Reservation seat");
                jLabel18.setVisible(true);
            }
            if (jTextField7.getText().isEmpty()) {
                jLabel17.setText("Set seat");
                jLabel17.setVisible(true);

            }
            if (jTextField5.getText().isEmpty()) {
                jLabel11.setText("Set date");
                jLabel11.setVisible(true);

            }
            if (jLabel19.getText().equals("LOCATION:")) {
                jLabel10.setText("Set Location");
                jLabel10.setVisible(true);
                jLabel10.setOpaque(true);
            }
        } else {
            reservation = Integer.parseInt(jTextField6.getText());
            seat = Integer.parseInt(jTextField7.getText());
            date = jTextField5.getText();
            location = jLabel19.getText();
            if (reservation >= seat) {
                jLabel10.setText("");
                areservation = reservation - seat;
                jTabbedPane1.setSelectedIndex(4);
                jLabel28.setText("Reservation Ends:" + jTextField5.getText());
                jButton3.setVisible(false);
                jLabel10.setVisible(false);
                jLabel11.setVisible(false);
                jLabel17.setVisible(false);
                jLabel18.setVisible(false);
                jLabel10.setOpaque(false);
                jLabel21.setText("<html>" + location + "</</html>");

            } else {
                jLabel10.setText("please set reservated seats greater than  seat ");
                jLabel10.setOpaque(true);
                jLabel10.setVisible(true);
            }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        char c = evt.getKeyChar();
        if ((Character.isDigit(c)) || Character.isWhitespace(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        char c = evt.getKeyChar();
        if ((Character.isDigit(c)) || Character.isWhitespace(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || Character.isWhitespace(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField10KeyTyped
    int w = 1;
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        if (jTextField8.getText().isEmpty() || jTextField9.getText().isEmpty() || jTextField10.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "PLease Enter first Name, Last Name and Phone Number!");
        } else {
            String num = jTextField10.getText();
            if (num.length() == 9) {
                if (c > seat) {
                    String fullname = jTextField8.getText() + " " + jTextField9.getText();
                    waitname.add(fullname);
                    waitnum.add(num);
                    jTextField9.setText("");
                    jTextField8.setText("");
                    c++;
                    w++;

                } else {
                    String fullname = jTextField8.getText() + " " + jTextField9.getText();
                    rename.add(fullname);
                    renum.add(num);
                    jTextField9.setText("");
                    jTextField8.setText("");
                    c++;
                    jLabel25.setText(Integer.toString(c));
                }
            } else {
                JOptionPane.showMessageDialog(null, "PLease Invailed Phone Number!");
            }
            if (c > reservation) {
                jButton7.setEnabled(false);
                jButton9.doClick();
            }
            if (c > seat) {
                jLabel23.setText("<html>Our Reservation seats are full but don't worry we will add you in waitlist.<br> We will notify you if booking available!</html>");

                jLabel25.setText(Integer.toString(w));
                jLabel24.setText("Waitlist No: ");
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        System.out.println(rename);
        System.out.println(waitname);
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to extand reservation date?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
        if (choice == JOptionPane.OK_OPTION) {
               jLabel28.setText("Reservation Ends:" + jTextField5.getText());
                
                
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                jButton9.doClick();
            }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        jButton3.doClick();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
        String n = Integer.toString(crename.size());
        jLabel34.setText(n);
        for (String name : crename) {
            JLabel l = new JLabel();

            l.setPreferredSize(new Dimension(330, 36));
            l.setMaximumSize(new Dimension(330, 36));
            l.setMinimumSize(new Dimension(330, 36));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            l.setForeground(Color.black);
            l.setFont(new Font("Arial", Font.BOLD, 24));
            l.setText(name);
            jPanel21.add(l);
        }
        String n1 = Integer.toString(canname.size());
        jLabel35.setText(n1);
        for (String name : canname) {

            JLabel l2 = new JLabel();

            l2.setPreferredSize(new Dimension(330, 36));
            l2.setMaximumSize(new Dimension(330, 36));
            l2.setMinimumSize(new Dimension(330, 36));
            l2.setHorizontalAlignment(SwingConstants.CENTER);
            l2.setForeground(Color.black);
            l2.setFont(new Font("Arial", Font.BOLD, 24));
            l2.setText(name);
            jPanel22.add(l2);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
