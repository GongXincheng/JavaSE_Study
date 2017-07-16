package 接口;

interface USB// 暴露的规则。
{
	public void open();
	public void close();
}

public class InterfaceDemo {
	public static void main(String[] args) {
		method(new UPan());
		method(new UsbMouse());
	}
	
	public static void method(USB usb){	//多态
		usb.open();
		usb.close();
	}
}

class UPan implements USB
{
	public void open()
	{
		System.out.println("upan open");
	}
	public void close()
	{
		System.out.println("upan close");
	}
}

class UsbMouse implements USB
{
	public void open()
	{
		System.out.println("UsbMouse open");
	}
	public void close()
	{
		System.out.println("UsbMouse close");
	}

}

