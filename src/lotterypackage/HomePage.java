package lotterypackage;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.Border;

class hpage extends JFrame
{
	AudioClip click;
	Connection con;
	PreparedStatement pst;
	Border brd;
	JPanel pnl;
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JLabel title,icon,dev;
	JButton btn5;
	
	public hpage()
	{
		con=ConnectionFile.doConnect();
		
		URL urlClick = Prize_console.class.getResource("click_one.wav");
		click = Applet.newAudioClip(urlClick);
		setLayout(null);
		setSize(600,600);
		
		
		pnl=new JPanel();
		pnl.setLayout(null);
		pnl.setSize(600, 65);
		pnl.setBackground(Color.decode("#F44336"));		
		add(pnl);
		
		dev=new JLabel("Developed by Himani ,GZSCCET");
		dev.setBounds(180,40,300,30);
		dev.setForeground(Color.white);
		pnl.add(dev);
		dev.setFont(new Font("Arial",Font.BOLD,15));
		
		brd=BorderFactory.createLineBorder(Color.decode("#F44336"),1);
		
		icon=new JLabel();
		icon.setBounds(0,0,65,65);
		icon.setIcon(resize_img("logo.gif", icon));
		
		pnl.add(icon);
		
		btn5=new JButton("logout");
		btn5.setBounds(520,35,80,30);
		btn5.setBorder(brd);
		btn5.setForeground(Color.white);
		btn5.setBackground(Color.decode("#F44336"));
		pnl.add(btn5);
		btn5.setMnemonic(KeyEvent.VK_C);
		btn5.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent ev) 
			{
				click.play();
				
				int ut=JOptionPane.showConfirmDialog(null, "Are you sure?");
				if(ut==0)
				{
					
					loginform.main(null);
					dispose();
				}
				
			}
		});
		
		title=new JLabel("Welcome to the National Lottery homepage");
		title.setBounds(70, 10, 500, 30);
		title.setFont(new Font("Arial",Font.BOLD,20));
		pnl.add(title);
		title.setForeground(Color.white);
		
		lb1=new JLabel();
		lb1.setBounds(60, 80, 110, 95);
		lb1.setIcon(resize_img("1468351273_trophy.png", lb1));
		add(lb1);
		
		lb1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lb1.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lb1.setBorder(brd);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lb1.setBackground(Color.decode("#F44336"));
				Prize_console.main(null);
				
			}
		});
		
		lb2=new JLabel();
		lb2.setBounds(240, 80, 110, 95);
		lb2.setIcon(resize_img("my-tickets.png", lb2));
		add(lb2);
		
		lb2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lb2.setBorder(null);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lb2.setBorder(brd);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lb2.setBackground(Color.decode("#F44336"));
				lotteryseriesgenerator.main(null);
			}
		});
		
		lb3=new JLabel();
		lb3.setBounds(420, 80, 110, 95);
		lb3.setIcon(resize_img("lot.png", lb3));
		add(lb3);
		
		lb3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lb3.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lb3.setBorder(brd);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				lb3.setBackground(Color.decode("#F44336"));
				Agentconsole.main(null);
				
			}
		});
		
		lb4=new JLabel();
		lb4.setBounds(60, 260, 110, 95);
		lb4.setIcon(resize_img("lot2.png", lb4));
		add(lb4);
		
		lb4.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lb4.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lb4.setBorder(brd);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				lb4.setBackground(Color.decode("#F44336"));
				Customerconsole.main(null);
				
			}
		});
		

		lb5=new JLabel();
		lb5.setBounds(240, 260, 110, 95);
		lb5.setIcon(resize_img("agnt.png", lb5));
		add(lb5);
		
		lb5.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lb5.setBorder(null);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lb5.setBorder(brd);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lb5.setBackground(Color.decode("#F44336"));
				agentquerypanel.main(null);
				
			}
		});
		
		lb6=new JLabel();
		lb6.setBounds(420, 260, 110, 95);
		lb6.setIcon(resize_img("payments_payment_card_credit-256.png", lb6));
		add(lb6);
		
		lb6.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lb6.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lb6.setBorder(brd);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lb6.setBackground(Color.decode("#F44336"));
				LuckyDraw.main(null);
			}
		});
		
		lb7=new JLabel();
		lb7.setBounds(60, 420, 110, 95);
		lb7.setIcon(resize_img("23-dollar-price-recycle-prices-dollars-256.png", lb7));
		add(lb7);
		
		lb7.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lb7.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lb7.setBorder(brd);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lb7.setBackground(Color.decode("#F44336"));
				allprizes.main(null);
			}
		});
		
		
		lb8=new JLabel();
		lb8.setBounds(240, 420, 110, 95);
		lb8.setIcon(resize_img("194-256.png", lb8));
		add(lb8);
		
		lb8.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lb8.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lb8.setBorder(brd);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lb8.setBackground(Color.decode("#F44336"));
				allwinners.main(null);
			}
		});
		
		lb9=new JLabel();
		lb9.setBounds(420, 420, 110, 95);
		lb9.setIcon(resize_img("about_us-128.png", lb9));
		add(lb9);
		
		lb9.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lb9.setBorder(null);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lb9.setBorder(brd);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				lb9.setBackground(Color.decode("#F44336"));
				Aboutus.main(null);
			}
		});
		
		l1=new JLabel("Prize Console");
		l1.setFont(new Font("Arial",Font.BOLD,15));
		l1.setBounds(80, 185, 110, 20);
		add(l1);
		
		l1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				l1.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				l1.setForeground(Color.RED);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				l1.setForeground(Color.decode("#F44336"));
				
				new Prizeform();
				
			}
		});
		
		l2=new JLabel("Generate Tickets");
		l2.setFont(new Font("Arial",Font.BOLD,15));
		l2.setBounds(255, 185, 125, 20);
		add(l2);
		
		l2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				l2.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				l2.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				l2.setForeground(Color.decode("#F44336"));
				lotteryseriesgenerator.main(null);
			}
		});
		
		l3=new JLabel("Add Agent");
		l3.setFont(new Font("Arial",Font.BOLD,15));
		l3.setBounds(450, 185, 125, 20);
		add(l3);
		
		l3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				l3.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				l3.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				l3.setForeground(Color.decode("#F44336"));
				Agentconsole.main(null);
			}
		});
		
		
		l4=new JLabel("Add Customers");
		l4.setFont(new Font("Arial",Font.BOLD,15));
		l4.setBounds(60, 360, 125, 20);
		add(l4);
		
		l4.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				l4.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				l4.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				l4.setForeground(Color.decode("#F44336"));
				Customerconsole.main(null);
			}
		});
		
		
		l5=new JLabel("Agent Enquiry Panel");
		l5.setFont(new Font("Arial",Font.BOLD,15));
		l5.setBounds(220, 357, 155, 20);
		add(l5);
		
		l5.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				l5.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				l5.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				l5.setForeground(Color.decode("#F44336"));
				agentquerypanel.main(null);
			}
		});
		
		
		l6=new JLabel("Get Lucky Draw");
		l6.setFont(new Font("Arial",Font.BOLD,15));
		l6.setBounds(435, 355, 135, 20);
		add(l6);
		
		l6.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				l6.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				l6.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				l6.setForeground(Color.decode("#F44336"));
				LuckyDraw.main(null);
			}
		});
		
		
		l7=new JLabel("Prizes");
		l7.setFont(new Font("Arial",Font.BOLD,15));
		l7.setBounds(80,520,110,20);
		add(l7);
		
		l7.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				l7.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				l7.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				l7.setForeground(Color.decode("#F44336"));
				allprizes.main(null);
			}
		});
		
		l8=new JLabel("Winners");
		l8.setFont(new Font("Arial",Font.BOLD,15));
		l8.setBounds(265,520,110,20);
		add(l8);
		
		l8.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				l8.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				l8.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				l8.setForeground(Color.decode("#F44336"));
				allwinners.main(null);
			}
		});
		
		
		l9=new JLabel("About Us");
		l9.setFont(new Font("Arial",Font.BOLD,15));
		l9.setBounds(430,520,125,20);
		add(l9);
		
		l9.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click.play();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				l9.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				l9.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				l9.setForeground(Color.decode("#F44336"));
				Aboutus.main(null);
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
	
	public ImageIcon resize_img (String p,JLabel j)
	{
		 ImageIcon full=new ImageIcon(p);
		Image img=full.getImage().getScaledInstance(j.getWidth(),j.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon bhai=new ImageIcon(img);
		return bhai;
	
	}
}
public class HomePage
{
	public static void main(String[] args)
	{
		hpage h=new hpage();
	}
}
