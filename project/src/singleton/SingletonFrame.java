package singleton; 

import javax.swing.*;

public class SingletonFrame extends JFrame {

	private static SingletonFrame instance;
	
	private SingletonFrame(){
		this.setSize(500,500);
		this.setTitle("Anti-Pacmayn");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public static SingletonFrame getInstance() {
		if(instance == null){
			instance = new SingletonFrame();
		}
		return instance;
	}
	
}
