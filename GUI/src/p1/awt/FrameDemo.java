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
		f.setLayout(new FlowLayout());	//���ò���
		
		Button button = new Button("һ����ť");
		
		
		f.add(button);//����ť��ӵ�������
		f.addWindowListener(new WindowAdapter() {	//������ע���¼�

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		//�ڰ�ť�ϼ���һ������
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
