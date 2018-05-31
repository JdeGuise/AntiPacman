import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class IntroScreen extends JFrame {
	
	public IntroScreen(){
		
	    setTitle("Anti-Pacman");
	    
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    double width = screenSize.getWidth();
	    double height = screenSize.getHeight();
	    setSize((int) width, (int) height);
    	
    	//Create and set up the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Set up the content pane.
        addComponentsToPane(getContentPane());
 
        //Display the window.
        setVisible(true);   
	}
	
	public void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
 
        addALabel("ANTI-PACMAN", pane);
        addWarningMessage("THE FOLLOWING GAME WAS CREATED FOR EXPERIMENTAL PROGRAMMING PURPOSES.  THE PROJECT IS NOT MEANT TO DETRACT FROM THE PACMAN BRAND, NOR MISLEAD ANY FALSE ASSOCIATIONS WITH ANTI-PACMAN AND NINTENDO, ATARI, OR ANY COMPANIES OTHERWISE INVOLVED IN THE INTELLECTUAL PROPERTY.", pane);
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
    	final Integer htmlWidth = 300;
    	final String html2 = "px'>";
    	
    	Runnable r = new Runnable() {
    		
    		@Override
    		public void run(){
    			JOptionPane.showMessageDialog(null,  html1  + htmlWidth + html2 + text);
    		}
    	};
    	SwingUtilities.invokeLater(r);
    }
}
