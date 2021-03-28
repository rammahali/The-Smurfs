package UI;

import java.awt.*;
import java.awt.event.WindowEvent;

public class GameOver extends javax.swing.JFrame {

    public GameOver() {
        initComponents();
    }
    private void initComponents() {
        javax.swing.JPanel background = new javax.swing.JPanel();
        javax.swing.JButton playAgain1 = new javax.swing.JButton();
        // Variables declaration - do not modify
        javax.swing.JButton exit = new javax.swing.JButton();
        javax.swing.JLabel gameOverLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(51, 51, 51));
        background.setForeground(new java.awt.Color(102, 102, 102));

        playAgain1.setText("Play again");
        playAgain1.addActionListener(this::playAgain1ActionPerformed);

        exit.setText("Exit");
        exit.addActionListener(this::ExitActionPerformed);

        gameOverLabel.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 30)); // NOI18N
        gameOverLabel.setForeground(new java.awt.Color(255, 255, 255));
        gameOverLabel.setText("Game over !");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap(105, Short.MAX_VALUE)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                                .addComponent(playAgain1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(98, 98, 98))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                                .addComponent(gameOverLabel)
                                                .addGap(156, 156, 156))))
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(gameOverLabel)
                                .addGap(46, 46, 46)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(playAgain1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        this.setLocationRelativeTo(null);
    }

    private void playAgain1ActionPerformed(java.awt.event.ActionEvent evt) {
      new PlayerSelection().setVisible(true);
      this.dispose();
    }

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }


}
