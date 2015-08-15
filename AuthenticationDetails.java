package authentication;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Font;
public class AuthenticationDetails extends JFrame
{
	JTextArea area;
	JScrollPane jsp;
	RFID rfid;
public AuthenticationDetails(){
	setTitle("Product Authentication Details");
	area = new JTextArea();
	jsp = new JScrollPane(area);
	getContentPane().add(jsp);
	area.setEditable(false);
	Font f1 = new Font("Tahoma",Font.BOLD,14);
	area.setFont(f1);
	rfid = new RFID(area);
	rfid.setPort("COM1");
	rfid.setRate(9600);
	rfid.initialize();
}
}