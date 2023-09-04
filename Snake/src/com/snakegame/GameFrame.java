package com.snakegame;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JPanel cards; // A panel that uses CardLayout
    private CardLayout cardLayout;
    private GamePanel gamePanel;
    private ButtonPanel buttonPanel;

	GameFrame() {
		
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
		
		GamePanel gamePanel = new GamePanel();
		ButtonPanel buttonPanel = new ButtonPanel(gamePanel);
		
        cards.add(buttonPanel, "BUTTON_PANEL");
        cards.add(gamePanel, "GAME_PANEL");
        
        setContentPane(cards);
		
        cardLayout.show(cards, "BUTTON_PANEL");
		
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		buttonPanel.getStartButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "GAME_PANEL");
                gamePanel.startGame();
			}
		});
		
	}
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GameFrame();
            }
        });
    }

}
