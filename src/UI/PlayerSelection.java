package UI;

import Core.LazySmurf;
import Core.SmartSmurf;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class PlayerSelection extends javax.swing.JFrame {


    public PlayerSelection() {
        initComponents();
    }


    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JLabel jLabel2 = new JLabel();
        JLabel selectCharLable = new JLabel();
        JLabel jLabel3 = new JLabel();
        JButton smartSmurf = new JButton();
        javax.swing.JButton lazySmurf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Smurfs");
        setBackground(new java.awt.Color(0, 102, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon("src/resources/logo.png")); // NOI18N

        selectCharLable.setFont(new java.awt.Font("Arial", Font.PLAIN, 20)); // NOI18N
        selectCharLable.setForeground(new java.awt.Color(255, 255, 255));
        selectCharLable.setText("Select a character to start the game ");

        jLabel3.setIcon(new javax.swing.ImageIcon("src/resources/smartSmurfStart.png")); // NOI18N

        smartSmurf.setBackground(new java.awt.Color(0, 102, 204));
        smartSmurf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 13)); // NOI18N
        smartSmurf.setForeground(new java.awt.Color(255, 255, 255));
        smartSmurf.setText("Go with Smart Smurf");
        smartSmurf.addActionListener(this::onSmartSmurfSelected);

        lazySmurf.setBackground(new java.awt.Color(0, 102, 204));
        lazySmurf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 13)); // NOI18N
        lazySmurf.setForeground(new java.awt.Color(255, 255, 255));
        lazySmurf.setText("Go with Lazy Smurf");
        lazySmurf.addActionListener(this::onLazySmurfSelected);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lazySmurf, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(smartSmurf, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(70, 70, 70))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(selectCharLable, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(63, 63, 63))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(53, 53, 53))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(selectCharLable, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(smartSmurf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lazySmurf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(109, Short.MAX_VALUE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void onLazySmurfSelected(java.awt.event.ActionEvent evt) {
        try{
             new GameBoard(new LazySmurf());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.dispose();
    }

    private void onSmartSmurfSelected(java.awt.event.ActionEvent evt) {
        try{
            new GameBoard(new SmartSmurf());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.dispose();
    }

}

