package lotterypackage;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import org.apache.xmlbeans.impl.piccolo.util.IntStack;

class Customerform extends JFrame
{
	AudioClip click;
	Connection con;
	PreparedStatement pst ;
	JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6,lb7,home;
	JPanel pnl,pnl1;
	Border brd;
	JTextField txta,txtb,txtc,txtd,txte;
	JTextArea addr;
	JComboBox cmb;
	JButton btn1,btn4,btn5,btn6;	
	int indx,ford,res;
	public Customerform()
	{
		// TODO Auto-generated constructor stub
	
	con=ConnectionFile.doConnect();
	URL urlClick = Prize_console.class.getResource("click_one.wav");
	click = Applet.newAudioClip(urlClick);
	
	setLayout(null);
	setSize(600,720);
	brd=BorderFactory.createLineBorder(Color.decode("#F44336"),1);
	
	lb=new JLabel("ADD CUSTOMERS");
	lb.setFont(new Font("Arial",Font.BOLD,40));
	lb.setBounds(30, 10, 500,100);
	lb.setForeground(Color.WHITE);
	lb.setHorizontalAlignment(SwingConstants.CENTER);
	
	pnl=new JPanel();
	pnl.setLayout(null);
	pnl.setSize(600, 100);
	pnl.setBackground(Color.decode("#F44336"));		
	add(pnl);
	pnl.add(lb);
	
	JLabel icon=new JLabel();
	icon.setBounds(0,0, 90, 98);
	pnl.add(icon);
	ImageIcon fulll=new ImageIcon("logo.gif");
	ImageIcon smalll=resize_img(fulll,icon.getWidth(),icon.getHeight());
	icon.setIcon(smalll);
	
	pnl1=new JPanel();
	pnl1.setLayout(null);
	pnl1.setBounds(100,180, 400, 450);
	pnl1.setBackground(Color.WHITE);
	add(pnl1);
	pnl1.setBorder(brd);
	
	lb1=new JLabel("AGENT ID:");
	lb1.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	lb1.setBounds(15,20,100,25);
	pnl1.add(lb1);
	
	home=new JLabel();
	home.setBounds(550,110,32,32);
	add(home);
	ImageIcon homefulll=new ImageIcon("home.png");
	ImageIcon homesmalll=resize_img(homefulll,home.getWidth(),home.getHeight());
	home.setIcon(homesmalll);
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
			// TODO Auto-generated method stub
			home.setBorder(brd);
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			home.setBackground(Color.decode("#F44336"));
			dispose();
			
		}
	});
	
	
	cmb=new JComboBox();
	cmb.setBounds(125,20, 100,40);
	pnl1.add(cmb);
	cmb.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	cmb.setEditable(true);
	
	cmb.addActionListener(new ActionListener()
	{ @Override
	public void actionPerformed(ActionEvent arg0)
	{
	 indx= cmb.getSelectedIndex();
	
	}
	});	
	
	
	lb2=new JLabel("LOTTERY NO.");
	lb2.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	lb2.setBounds(15,80,110,25);
	pnl1.add(lb2);
	
	
	
	txtb=new JTextField();
	txtb.setBounds(125,80,120,25);
	pnl1.add(txtb);
	txtb.setHorizontalAlignment(SwingConstants.CENTER);
	txtb.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	txtb.setToolTipText("Please enter some text here");
	txtb.requestFocusInWindow();
	
	
	lb3=new JLabel("NAME:");
	lb3.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	lb3.setBounds(15,120,100,25);
	pnl1.add(lb3);
	
	
	
	txtc=new JTextField();
	txtc.setBounds(125, 120,120,25);
	pnl1.add(txtc);
	txtc.setHorizontalAlignment(SwingConstants.CENTER);
	txtc.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	txtc.setToolTipText("Please enter some text here");
	txtc.requestFocusInWindow();
	
	
	lb3=new JLabel("ADDRESS:");
	lb3.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	lb3.setBounds(15,160,100,25);
	pnl1.add(lb3);
	
	
	
    addr=new JTextArea("Fill Address Here", 5, 50);
	JScrollPane scroll = new JScrollPane(addr);
	scroll.setBounds(125, 160, 180, 85);
	addr.setBorder(BorderFactory.createLineBorder(Color.black));
	addr.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	pnl1.add(scroll);
	
	lb4=new JLabel("CITY:");
	lb4.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	lb4.setBounds(15,260,100,25);
	pnl1.add(lb4);
	
	txtd=new JTextField();
	txtd.setBounds(125,260,120,25);
	pnl1.add(txtd);
	txtd.setHorizontalAlignment(SwingConstants.CENTER);
	txtd.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	txtd.setToolTipText("Please enter some text here");
	txtd.requestFocusInWindow();
	
	
	
	lb5=new JLabel("Mb No:");
	lb5.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	lb5.setBounds(15,300,120,25);
	pnl1.add(lb5);
	
	txte=new JTextField();
	txte.setBounds(125,300,100,25);
	pnl1.add(txte);
	txte.setHorizontalAlignment(SwingConstants.CENTER);
	txte.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
	txte.setToolTipText("Please enter some text here");
	txte.addFocusListener(new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e)
		{
			String mobile="^[789]\\d{9}$";

			boolean b=txte.getText().matches(mobile);
			if(b==false)
			{
			JOptionPane.showMessageDialog(null,"Invalid mob. no.");
			txte.requestFocusInWindow();
			}
			else
			{
			txte.setBackground(Color.white);
			}
			
			
			
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			txte.setBackground(Color.gray);
		}
	});
	
	btn1=new JButton("Save");
	btn1.setBounds(15,380,80,30);
	btn1.setBackground(Color.decode("#F44336"));
	pnl1.add(btn1);
	btn1.setForeground(Color.WHITE);
	btn1.setMnemonic(KeyEvent.VK_S);
	btn1.addActionListener(new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				click.play();
				ford=Integer.parseInt(txtb.getText());	
		       
				pst=con.prepareStatement("insert into addcustomer values(?,?,?,?,?,?,?)");
				pst.setInt(1,cmb.getSelectedIndex());
				pst.setInt(2,ford);					
				pst.setString(3,txtc.getText());
				pst.setString(4,addr.getText());
				pst.setString(5,txtd.getText());
				pst.setString(6, txte.getText());
				pst.setInt(7,1);
				//pst.setInt(8, getcount());
										 
				int ros=pst.executeUpdate();
				JOptionPane.showMessageDialog(null,ros+"record saved");
			}
			catch(SQLException rx)
			{
				rx.printStackTrace();
			}
			try
			{
				pst.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	});
		
	
	btn4=new JButton("New");
	btn4.setBounds(220,380,80,30);
	btn4.setBackground(Color.decode("#F44336"));
	pnl1.add(btn4);
	btn4.setForeground(Color.WHITE);
	btn4.setMnemonic(KeyEvent.VK_N);
	btn4.addActionListener(new ActionListener()
	{
		
		@Override
		public void actionPerformed(ActionEvent ev)
		{
			click.play();
				cmb.setSelectedIndex(0);
				txtb.setText("");
				addr.setText("");
				txtc.setText("");
				txtd.setText("");
				txte.setText("");
				getid();
				
				
		}
	});
	
	btn5=new JButton("Close");
	btn5.setBounds(315,380,80,30);
	pnl1.add(btn5);
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
				dispose();
			}
			
		}
	});
	
	btn6=new JButton("Add Excel");
	btn6.setBounds(110,380,100,30);
	btn6.setBackground(Color.decode("#F44336"));
	btn6.setForeground(Color.WHITE);
	pnl1.add(btn6);
	
	btn6.addActionListener(new ActionListener()
	{
		
		@Override
		public void actionPerformed(ActionEvent ev)
		{
			click.play();
			JFileChooser fc=new JFileChooser();
			fc.showOpenDialog(null);
			String fileid=fc.getSelectedFile().getAbsolutePath();
			Read_And_Save.Read(fileid);
				
				
		}
	});
	
		
	fillcombo();
	getid();
	
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
	getRootPane().setBorder(brd);
	setLocationRelativeTo(null);
	getContentPane().setBackground(Color.white);
	setUndecorated(true);
	setResizable(false);
	setVisible(true);
	}
	
	void getid()
	{
		int aid=1;
		boolean b=false;
		try
		{
			pst=con.prepareStatement("select max(lotteryno) as 'max' from addcustomer");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				b=true;
				aid=rs.getInt("max");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(b==true)
		{
			aid=aid+1;
		}
		
		txtb.setText(String.valueOf(aid));
	}
	
	
	ImageIcon resize_img(ImageIcon log,int width,int height)
	{
	Image img=log.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	ImageIcon bhai=new ImageIcon(img);
	return(bhai);
	}
	
	void fillcombo()
	{
		cmb.removeAllItems();
		cmb.addItem("select");
		try
		{
			pst=con.prepareStatement("select agentid from addagent");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String id=rs.getString("agentid");
				cmb.addItem(id);
			}
			pst.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}
public class Customerconsole 
{

	public static void main(String[] args)
	{
		Customerform c=new Customerform();
				
	}

}
