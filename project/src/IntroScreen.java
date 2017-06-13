import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.*;

import singleton.SingletonFrame;

public class IntroScreen extends JFrame {
	JLabel introlabel = new JLabel("ANTI-PACMAN");
	JButton start = new JButton();
	
	public IntroScreen(){
		try{
			init();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void init() throws Exception {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		start.setText("Start Game");
		start.setBounds(new Rectangle(120, 300, 220, 40));
		start.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jButtonStart_actionPerformed(e);
			}
		
		});
		
		//add our disclaimer pane, what good it does
		addWarningPane(this.getContentPane());
				
		this.getContentPane().setLayout(null);
		this.getContentPane().add(start, null);
		this.getContentPane().add(introlabel, null);
	}
	
	public static void main(String[] args){
		IntroScreen introscreen = new IntroScreen();
		
		introscreen.setSize(500,500);
		introscreen.setVisible(true);
		
	}
	
	
	//disclaimer "ok" button
	void jButtonClose_actionPerformed(ActionEvent e){
		SingletonFrame singletonFrame = SingletonFrame.getInstance();
		singletonFrame.setVisible(true);
	}
	
	//start button
	void jButtonStart_actionPerformed(ActionEvent e){
		AntiPacman singletonFrame = AntiPacman.getInstance();
		
		singletonFrame.setVisible(true);
		dispose();
	}
	
	public void addWarningPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
 
        addWarningMessage("THE FOLLOWING GAME WAS CREATED FOR EXPERIMENTAL PROGRAMMING PURPOSES ONLY.  THE PROJECT IS NOT MEANT TO DETRACT THE BRAND OF PACMAN, NINTENDO, ATARI, OR ANY COMPANIES OTHERWISE INVOLVED IN THE INTELLECTUAL PROPERTY.", pane);
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
