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
		
		Button button = new Button("һ����ť");
		f.add(button);//����ť��ӵ�������
		
		System.out.println("over");
		
	}
}
