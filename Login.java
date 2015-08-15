package authentication;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
public class Login extends JFrame
{
	JLabel l1,l2,l3;
	JTextField tf1,tf2;
	Font f1,f2;
	JPanel p1,p2,p3;
	JButton b1,b2;
	MainScreen ms;
public Login(MainScreen screen){
	super("Login Screen");
	ms = screen;
	ms.setVisible(false);
	p1 = new JPanel();
	f1 = new Font("Monospaced",Font.BOLD,22);
	l1 = new JLabel("<HTML><BODY><CENTER>PRODUCT AUTHENTICATION  SERVICE OF CUSTOMER MOBILE RFID DEVICES</CENTER></BODY></HTML>");
	l1.setForeground(Color.white);
	l1.setFont(f1);
	p1.add(l1);
	p1.setBackground(Color.black);
	getContentPane().add(p1,BorderLayout.NORTH);

	p2 = new JPanel();
	p2.setLayout(new BorderLayout());
	setBackground(new Color(171,100,100));
	
	JPanel jp1 = new JPanel();
	f2 = new Font("Monospaced",Font.BOLD,16);
	l2 = new JLabel("Username  "); 
	l2.setFont(f2);
	jp1.add(l2);
	

	tf1 = new JTextField(20);
	tf1.setFont(f2);
	jp1.add(tf1);

	JPanel jp2 = new JPanel();
	l3 = new JLabel("Password  "); 
	l3.setFont(f2);
	jp2.add(l3);

	tf2 = new JPasswordField(20);
	tf2.setFont(new Font("Monospaced",Font.PLAIN,16));
	jp2.add(tf2);

	
	p2.add(jp1,BorderLayout.NORTH);
	p2.add(jp2,BorderLayout.CENTER);
	

	getContentPane().add(p2,BorderLayout.CENTER);

	p3 = new JPanel();
	p3.setLayout(new BorderLayout());

	JPanel jp8 = new JPanel();
	b1 = new JButton("Login");
	b1.setFont(f2);
	jp8.add(b1);
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			process();
		}
	});
	
	b2 = new JButton("Back");
	b2.setFont(f2);
	jp8.add(b2);
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			setVisible(false);
			ms.setVisible(true);
		}
	});
	
	p3.add(jp8,BorderLayout.SOUTH);
	getContentPane().add(p3,BorderLayout.SOUTH);
}
public void process(){
	String user = tf1.getText();
	String pass = tf2.getText();
	
	if(user == null || user.trim().length() <= 0){
		JOptionPane.showMessageDialog(this,"Username must be enter");
		tf1.requestFocus();
		return;
	}
	if(pass == null || pass.trim().length() <= 0){
		JOptionPane.showMessageDialog(this,"Password must be enter");
		tf2.requestFocus();
		return;
	}
	
	try{
		if(user.equals("admin") && pass.equals("admin")){
			setVisible(false);
			Admin app = new Admin(ms);
            app.setVisible(true);
			app.pack();
		}else{
			JOptionPane.showMessageDialog(this,"Invalid User");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
}
}