package fr.utt.lo02.projet.strategy;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MyButton extends JButton {
		 
	    private static final long serialVersionUID = 1L;
	 
	    public MyButton(String txt, String icon, String iconHover, String iconPressed) {
	        super(txt);
	        setForeground(Color.WHITE);
	         
	        setOpaque(false);
	        setContentAreaFilled(false); // On met � false pour emp�cher le composant de peindre l'int�rieur du JButton.
	        setBorderPainted(false); // De m�me, on ne veut pas afficher les bordures.
	        setFocusPainted(false); // On n'affiche pas l'effet de focus.
	         
	        setHorizontalAlignment(SwingConstants.CENTER);
	        setHorizontalTextPosition(SwingConstants.CENTER);
	         
	        ImageIcon imgIcon = new ImageIcon(icon);
	        ImageIcon imgIconHover = new ImageIcon(iconHover);
	        ImageIcon imgIconPressed = new ImageIcon(iconPressed);
	        setIcon(imgIcon);
	        setRolloverIcon(imgIconHover);
	        this.setPressedIcon(imgIconPressed);
	    }
}