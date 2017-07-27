package p1.awt;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseAndKeyDemo {
	
	private Frame f;
	private TextField tf;
	
	public MouseAndKeyDemo() {
		init();
	}

	public void init() {
		
		f = new Frame("ÑÝÊ¾Êó±êºÍ¼üÅÌ¼àÌý");
		f.setBounds(400, 200, 500, 400);
		f.setLayout(new FlowLayout());
		
		myEvent();
		
		tf = new TextField(15);
		f.add(tf);
		
		f.setVisible(true);
	}

	public void myEvent() {
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}

	public static void main(String[] args) {
		
		new MouseAndKeyDemo();
		
	}
}
