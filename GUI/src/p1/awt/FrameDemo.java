package p1.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FrameDemo {
	public static void main(String[] args) {
		
		Frame f = new Frame("GXC");
		f.setVisible(true);
		
//		f.setSize(500, 400);
//		f.setLocation(400, 150);
		f.setBounds(400, 150, 500, 400);
		f.setLayout(new FlowLayout());
		
		Button button = new Button("一个按钮");
		f.add(button);//将按钮添加到窗体中
		
		System.out.println("over");
		
	}
}
