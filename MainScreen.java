package authentication;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
public class MainScreen extends JFrame implements Runnable
{
	JLabel l1,l2;
	JButton b1,b2;
	Font f1,f2;
	JPanel p1,p2,p3;
	Thread thread;
public MainScreen(){
	setTitle("Product Authentication");
	getContentPane().setLayout(new BorderLayout());
	f1 = new Font("Monospaced",Font.BOLD,22);
	
	p1 = new JPanel();
    l1 = new JLabel("<HTML><BODY><CENTER>PRODUCT AUTHENTICATION  SERVICE OF CUSTOMER MOBILE RFID DEVICES</CENTER></BODY></HTML>");
	l1.setFont(this.f1);
    l1.setForeground(new Color(125,54,2));
	p1.setBackground(Color.black);
    p1.add(l1);
	
	p2 = new JPanel();
	l2 = new JLabel();
	l2.setIcon(new ImageIcon("img/images.jpg"));
	p2.add(l2);

    f2 = new Font("Courier New",Font.PLAIN,16);
    	
	p3 = new JPanel();
	p3.add(new JLabel("<HTML><BODY>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</BODY></HTML>"));
	

	b1 = new JButton("Login");
	b1.setFont(f2);
	p3.add(b1);
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			Login login = new Login(MainScreen.this);
			login.setVisible(true);
			login.pack();
		}
	});

	b2 = new JButton("Exit");
	b2.setFont(f2);
	p3.add(b2);
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			System.exit(0);
		}
	});

	
	
    getContentPane().add(p1, BorderLayout.NORTH);
    getContentPane().add(p2, BorderLayout.CENTER);
	getContentPane().add(p3, BorderLayout.SOUTH);
	thread = new Thread(this);
	thread.start();
}
public void run(){
	try{
		while(true){
			l1.setForeground(Color.white);
			l2.setForeground(new Color(125,54,2));
			thread.sleep(500);
			l1.setForeground(new Color(125,54,2));
			l2.setForeground(Color.white);
			thread.sleep(500);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
}

public static void main(String a[])throws Exception{
	 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	 MainScreen screen = new MainScreen();
	 screen.pack();
	 screen.setLocationRelativeTo(null);
	 screen.setVisible(true);
	 
}
}