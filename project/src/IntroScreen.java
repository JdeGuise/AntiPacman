import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class IntroScreen extends JFrame {

	private long antiPacmanScore = 500;
	private JPanel pnlButton = new JPanel();
	
	public IntroScreen(){
		
	    setTitle("Anti-Pacman");
	    setSize(500,500);
	    JPanel introScreen = new JPanel();
    	
    	System.out.println("set size...");
    	
    	//Create and set up the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        
        //Set up the content pane.
        addComponentsToPane(getContentPane());
 
        //Display the window.
        setVisible(true);   
	}
	
	public void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
 
        addALabel("ANTI-PACMAN", pane);
        addWarningMessage("THE FOLLOWING GAME WAS CREATED FOR EXPERIMENTAL PROGRAMMING PURPOSES ONLY.  THE PROJECT IS NOT MEANT TO DETRACT THE BRAND OF PACMAN, NINTENDO, ATARI, OR ANY COMPANIES OTHERWISE INVOLVED IN THE INTELLECTUAL PROPERTY.", pane);
        addAButton("Start Game", pane);
    }
 
    private void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e){
        		setContentPane(new AntiPacman());
        		invalidate();
        		validate();
        	}
        });
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
 
    private static void addALabel(String text, Container container){
    	JLabel label = new JLabel(text);
    	label.setAlignmentX(Component.CENTER_ALIGNMENT);
    	container.add(label);
    }
    
    private static void addWarningMessage(String text, Container container){
    	
    	final String html1 = "<html><body style='width: ";
    	final String html2 = "px'>";
    	
    	Runnable r = new Runnable() {
    		
    		@Override
    		public void run(){
    			JOptionPane.showMessageDialog(null,  html1  + "300" + html2 + text);
    		}
    	};
    	SwingUtilities.invokeLater(r);
    }
}
