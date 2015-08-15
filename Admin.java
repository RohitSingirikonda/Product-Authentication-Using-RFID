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
import java.awt.Dimension;
import java.awt.Toolkit;
public class Admin extends JFrame implements Runnable
{
	JLabel l1,l2;
	JButton b1,b2,b3;
	Font f1,f2;
	JPanel p1,p2,p3;
	Thread thread;
	MainScreen main;
	Dimension d1;
public Admin(MainScreen ms){
	main = ms;
	d1 = Toolkit.getDefaultToolkit().getScreenSize();
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
	

	b1 = new JButton("Item Tagging");
	b1.setFont(f2);
	p3.add(b1);
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			ItemTagging it = new ItemTagging(d1);
			it.setVisible(true);
			it.setSize(500,400);
			it.setResizable(false);
		}
	});

	b2 = new JButton("Product Authentication");
	b2.setFont(f2);
	p3.add(b2);
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			AuthenticationDetails ad = new AuthenticationDetails();
			ad.setVisible(true);
			ad.setSize(600,400);
		}
	});

	b3 = new JButton("Logout");
	b3.setFont(f2);
	p3.add(b3);
	b3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			setVisible(false);
			main.setVisible(true);
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

}