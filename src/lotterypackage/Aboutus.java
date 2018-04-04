
package lotterypackage;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.Border;

class abt extends JFrame
{
	AudioClip click;
	Connection con;
	JPanel pnl1,pnl2,pnl3;
	JLabel title,home,a,b,c,d,e,f,g,h,i,a1,b1,c1,d1,e1,f1,icon,g1,l1,h1;
	Border brd;
	public abt()
	{
		URL urlClick = Prize_console.class.getResource("click_one.wav");
		click = Applet.newAudioClip(urlClick);
		setLayout(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		con=ConnectionFile.doConnect();
		
		
		final Color blue=Color.decode("#F44336");
		final Border brd=BorderFactory.createLineBorder(blue, 1);
		
		pnl1=new JPanel();
	
		pnl1.setBackground(blue);
		pnl1.setLayout(null);
		pnl1.setBounds(0,0,600,65);
		pnl1.setBackground(blue);
		add(pnl1);	
		
		pnl3=new JPanel();
		pnl3.setLayout(null);
		pnl3.setBackground(Color.WHITE);
		//pnl3.setBorder(brd);
		pnl3.setBounds(200,100,300,200);
		add(pnl3);
		
		
		
		pnl2=new JPanel();
		pnl2.setLayout(null);
		pnl2.setBackground(Color.WHITE);
		//pnl2.setBorder(brd);
		pnl2.setBounds(50,350,300,200);
		add(pnl2);
		
		g=new JLabel();
		g.setBounds(360,350,200,198);
		g.setIcon(resize_img("sir.jpg",g));
		
		add(g);
		
		h1=new JLabel();
		h1.setBounds(30,110,200,188);
		h1.setIcon(resize_img("me.jpg",h1));
		add(h1);
		
		h=new JLabel();
		h.setBounds(510,100,90,60);
		h.setIcon(resize_img("find-us-on-facebook-badge-128.png",h));
		h.setToolTipText("himanigoyal24875@gmail.com");
		add(h);
		
		i=new JLabel();
		i.setBounds(530,150,50,40);
		i.setIcon(resize_img("twitter.png",i));
		i.setToolTipText("@himani2481");
		
		add(i);
		
		l1=new JLabel("->>DESIGNED BY:");
		l1.setBounds(50,65,500,50);
		l1.setFont(new Font("AR ESSENCE", Font.PLAIN|Font.BOLD, 20));
		l1.setForeground(blue);
		add(l1);
		
		
		
		title=new JLabel("About Us");
		title.setForeground(Color.WHITE);
		title.setBounds(170, 5, 300, 50);
		title.setFont(new Font("Times New Roman",Font.PLAIN,40));
		pnl1.add(title);
		
		
		
		
		JLabel icon=new JLabel();
		icon.setBounds(0,0,64,64);
		icon.setIcon(resize_img("logo.gif",icon));
		pnl1.add(icon);
		
		home=new JLabel("Home");
		home.setBounds(550, 70, 32,32);
		home.setIcon(resize_img("home.png",home));
		add(home);
		
		home.addMouseListener(new MouseListener() {
			
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
				home.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				home.setBorder(brd);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
		});
		
		a=new JLabel("Rajesh K. Bansal");
		a.setFont(new Font("Arial",Font.BOLD,18));
		a.setBounds(60, 10, 250, 30);
		pnl2.add(a);
		
		b=new JLabel("$ Works at Sun-Soft Technologies");
		b.setFont(new Font("Arial",Font.BOLD,12));
		b.setBounds(20, 40, 250, 30);
		pnl2.add(b);
	
		
		c=new JLabel("$ C.E.O. at Banglore Computer Education");
		c.setFont(new Font("Arial",Font.BOLD,12));
		c.setBounds(20, 70, 250, 30);
		pnl2.add(c);
		
		
		d=new JLabel("$ Author of REAL JAVA"); 
	
		d.setBounds(20, 100, 250, 30);
		pnl2.add(d);
		
		
		e=new JLabel("$  Founder of Banglore Comp. Edu.");
		e.setBounds(20, 130, 250, 30);
		pnl2.add(e);
		
		
		f=new JLabel("$ T&D Head at SST");
		f.setBounds(20, 160, 250, 30);
		pnl2.add(f);
		
		
		a1=new JLabel("Er. Himani");
		a1.setFont(new Font("Arial",Font.BOLD,18));
		a1.setBounds(20, 10, 250, 30);
		pnl3.add(a1);
		
		b1=new JLabel("$ Studies At GZSCCET BTI");
		b1.setFont(new Font("Arial",Font.BOLD,12));
		b1.setBounds(20, 40, 250, 30);
		pnl3.add(b1);
	
		
		c1=new JLabel("$ Doing B.TECH CSE");
		c1.setFont(new Font("Arial",Font.BOLD,12));
		c1.setBounds(20, 70, 250, 30);
		pnl3.add(c1);
		
		
		d1=new JLabel("$ C/++ Programmer"); 
	
		d1.setBounds(20, 100, 250, 30);
		pnl3.add(d1);
		
		
		e1=new JLabel("$  Java Programmer At GZSCCET");
		e1.setBounds(20, 130, 250, 30);
		pnl3.add(e1);
		
		
		f1=new JLabel("$ Project Lottery System");
		f1.setBounds(20, 160, 250, 30);
		pnl3.add(f1);
		
		
		g1=new JLabel("->>UNDER THE GUIDANCE OF:");
		g1.setBounds(50,280,500,80);
		g1.setFont(new Font("AR ESSENCE", Font.PLAIN|Font.BOLD, 20));
		g1.setForeground(blue);
		add(g1);
		
		
		setLocation(400,50);
		setVisible(true);
		setSize(600,600);
		getContentPane().setBackground(Color.white);
	}
	
	
	
	
	
	  public ImageIcon resize_img (String p,JLabel j)
		{
			 ImageIcon full=new ImageIcon(p);
			Image img=full.getImage().getScaledInstance(j.getWidth(),j.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon bhai=new ImageIcon(img);
			return bhai;
		
		}
	}

public class Aboutus
{
	
	public static void main(String[] args)
	{
		abt a=new abt();
	}

}
