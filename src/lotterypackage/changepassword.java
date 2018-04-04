package lotterypackage;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

class chngpswrd extends JFrame
{
	AudioClip click;
	Connection con;
	PreparedStatement pst;
	JPanel pnl,pnl1;
	JLabel lb,lb1,lb2,lb3;
	JPasswordField txt1,txt2,txt3;
	Border brd,brd1;
	JButton btn1;
	public chngpswrd()
	{
		con=ConnectionFile.doConnect();
		
		URL urlClick = Prize_console.class.getResource("click_one.wav");
		click = Applet.newAudioClip(urlClick);
		
		setLayout(null);
		setSize(500,520);
		brd=BorderFactory.createLineBorder(Color.decode("#F44336"),1);
		brd1=BorderFactory.createLineBorder(Color.white,1);
		
		pnl=new JPanel();
		pnl.setLayout(null);
		pnl.setSize(500, 65);
		pnl.setBackground(Color.decode("#F44336"));		
		add(pnl);
		
		JLabel icon=new JLabel();
		icon.setBounds(0,0, 65, 63);
		pnl.add(icon);
		ImageIcon fulll=new ImageIcon("logo.gif");
		ImageIcon smalll=resize_img(fulll,icon.getWidth(),icon.getHeight());
		icon.setIcon(smalll);
		
		
		lb=new JLabel("Change your password");
		lb.setFont(new Font("Arial",Font.BOLD,30));
		lb.setSize( 500,65);
		lb.setForeground(Color.WHITE);
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		pnl.add(lb);
		
		
		pnl1=new JPanel();
		pnl1.setBounds(170,95, 300, 340);
		pnl1.setLayout(null);
		pnl1.setBorder(brd);
		pnl1.setBackground(Color.WHITE);
		add(pnl1);
		

		JLabel icon1=new JLabel();
		icon1.setBounds(10,200, 128,128);
		add(icon1);
		ImageIcon fulll1=new ImageIcon("Lock_Icon_FlatGreen.png");
		ImageIcon smalll1=resize_img(fulll1,icon1.getWidth(),icon1.getHeight());
		icon1.setIcon(smalll1);
		
		lb1=new JLabel("Old Password:");
		lb1.setBounds(30, 30, 160,25);
		lb1.setFont(new Font("Arial",Font.BOLD,20));
		pnl1.add(lb1);
		
		txt1=new JPasswordField();
		txt1.setBounds(30,60,230,40);
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setFont(new Font("AR ESSENCE", Font.PLAIN, 20));
		pnl1.add(txt1);
		
		lb2=new JLabel("New Password:");
		lb2.setBounds(30, 110, 160,25);
		lb2.setFont(new Font("Arial",Font.BOLD,20));
		pnl1.add(lb2);
		
		txt2=new JPasswordField();
		txt2.setBounds(30,140,230,40);
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setFont(new Font("AR ESSENCE", Font.PLAIN, 20));
		pnl1.add(txt2);
		
		lb3=new JLabel("Confirm Password:");
		lb3.setBounds(30, 190, 230,25);
		lb3.setFont(new Font("Arial",Font.BOLD,20));
		pnl1.add(lb3);
		
		txt3=new JPasswordField();
		txt3.setBounds(30,220,230,40);
		txt3.setHorizontalAlignment(SwingConstants.CENTER);
		txt3.setFont(new Font("AR ESSENCE", Font.PLAIN, 20));
		pnl1.add(txt3);
		
		btn1=new JButton("change password");
		btn1.setBounds(30,280,230,25);
		btn1.setBackground(Color.decode("#F44336"));
		btn1.setBorder(brd1);
		btn1.setFont(new Font("AR ESSENCE", Font.PLAIN, 20));
		btn1.setForeground(Color.white);

		pnl1.add(btn1);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				click.play();
				if(txt2.getText().matches(txt3.getText()))
				{
				try {
					PreparedStatement pst1=con.prepareStatement("select* from logininfo");
					ResultSet rs=pst1.executeQuery();
					while(rs.next())
					{
						String pswd=rs.getString("password");
						String mbno=rs.getString("mobileno");

						if(txt1.getText().matches(pswd))
						{
					
						pst=con.prepareStatement("update logininfo set password=?");
						pst.setString(1,txt3.getText());
						
						int res=pst.executeUpdate();
						SST_SMS1.bceSunSoftSend(mbno,"Your Password has been changed successfully");
						if(res==1)
						JOptionPane.showMessageDialog(null, res+" Password changed successfully.");
						loginform.main(null);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Wrong Password");
						}
					}
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"above fields dont  match..");
					}
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setWindowDecorationStyle(JRootPane.ERROR_DIALOG);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);

	}
	ImageIcon resize_img(ImageIcon log,int width,int height)
	{
	Image img=log.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	ImageIcon bhai=new ImageIcon(img);
	return(bhai);
	}
}
public class changepassword {

	public static void main(String[] args) {
		chngpswrd c=new chngpswrd();

	}

}
