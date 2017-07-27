package p1.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {
	public static void main(String[] args) {
		
		Frame f = new Frame("GXC");
		
		
//		f.setSize(500, 400);
//		f.setLocation(400, 150);
		f.setBounds(400, 150, 500, 400);	
		f.setLayout(new FlowLayout());	//设置布局
		
		Button button = new Button("一个按钮");
		
		
		f.add(button);//将按钮添加到窗体中
		f.addWindowListener(new WindowAdapter() {	//给窗体注册事件

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		//在按钮上加上一个监听
//		button.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.exit(0);
//			}
//		});
		
		f.setVisible(true);
		System.out.println("over");
		
	}
}
