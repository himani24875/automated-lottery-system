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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.StyledEditorKit.BoldAction;

class Agentform extends JFrame
{
	AudioClip click;
	Connection con;
	PreparedStatement pst ;
	JTextField txtb,txtc,txtd,txte;
	JTextArea addr;
	JPanel pnl,pnl1;
	JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6,lb7,home;
	JComboBox cmb;
	Border brd;
	JButton btn1,btn2,btn3,btn4,btn5,btn,btn6;	
	int indx,ford,ford2,res;
	JList langs;
	DefaultListModel dlm;
	String lng;
	public Agentform()
	{
		URL urlClick = Prize_console.class.getResource("click_one.wav");
		click = Applet.newAudioClip(urlClick);
		
		con=ConnectionFile.doConnect();
		
		
		setLayout(null);
		setSize(600,720);
		brd=BorderFactory.createLineBorder(Color.decode("#F44336"),1);
		
		lb=new JLabel("ADD AGENTS");
		lb.setFont(new Font("Arial",Font.BOLD,40));
		lb.setBounds(10, 10, 500,100);
		lb.setForeground(Color.WHITE);
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		pnl=new JPanel();
		pnl.setLayout(null);
		pnl.setSize(600, 100);
		pnl.setBackground(Color.decode("#F44336"));		
		add(pnl);
		pnl.add(lb);
		
		pnl1=new JPanel();
		pnl1.setLayout(null);
		pnl1.setBounds(100,180, 400, 450);
		pnl1.setBackground(Color.WHITE);
		add(pnl1);
		pnl1.setBorder(brd);
		
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
		
		JLabel icon=new JLabel();
		icon.setBounds(0,0, 90, 98);
		pnl.add(icon);
		ImageIcon fulll=new ImageIcon("logo.gif");
		ImageIcon smalll=resize_img(fulll,icon.getWidth(),icon.getHeight());
		icon.setIcon(smalll);
		
		lb1=new JLabel("AGENT ID:");
		lb1.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		lb1.setBounds(15,3,100,25);
		pnl1.add(lb1);
		
		cmb=new JComboBox();
		cmb.setBounds(115,3, 100,25);
		pnl1.add(cmb);
		//txta.setHorizontalAlignment(SwingConstants.CENTER);
		cmb.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		cmb.setEditable(true);
		
		btn=new JButton("Fetch");
		btn.setBounds(220, 4, 70,25);
		btn.setBackground(Color.decode("#F44336"));
		btn.setForeground(Color.white);
		//btn.setIcon(new ImageIcon("fetch.png"));
		pnl1.add(btn);
		btn.setMnemonic(KeyEvent.VK_F);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				try {
					click.play();
					dlm.removeAllElements();
					
					
					ford=Integer.parseInt(String.valueOf(cmb.getSelectedItem()));			
					pst=con.prepareStatement("SELECT * from addagent where agentid=?");
					pst.setInt(1,ford);
					
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
						cmb.setSelectedItem(rs.getString(1));
						txtb.setText(rs.getString(2));
						addr.setText(rs.getString(3));
						txtc.setText(rs.getString(4));
						txtd.setText(rs.getString(5));
						txte.setText(rs.getString(6));
						String[] sa=rs.getString(7).split(",");					
						for(String v:sa)	
						dlm.addElement(v);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		lb2=new JLabel("NAME:");
		lb2.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		lb2.setBounds(15,33,100,25);
		pnl1.add(lb2);
		
		
		
		txtb=new JTextField();
		txtb.setBounds(115,33,140,25);
		pnl1.add(txtb);
		txtb.setHorizontalAlignment(SwingConstants.CENTER);
		txtb.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		txtb.setToolTipText("Please enter some text here");
		txtb.requestFocusInWindow();
		
		
		lb3=new JLabel("ADDRESS:");
		lb3.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		lb3.setBounds(15,62,120,25);
		pnl1.add(lb3);
		
		
		
	    addr=new JTextArea("Fill Address Here", 5, 50);
		JScrollPane scroll = new JScrollPane(addr);
		addr.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		scroll.setBounds(115, 62, 200, 100);
		addr.setBorder(BorderFactory.createLineBorder(Color.black));
		pnl1.add(scroll);
		
		lb4=new JLabel("CITY:");
		lb4.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		lb4.setBounds(15,172,120,25);
		pnl1.add(lb4);
		
		txtc=new JTextField();
		txtc.setBounds(115,172,140,25);
		pnl1.add(txtc);
		txtc.setHorizontalAlignment(SwingConstants.CENTER);
		txtc.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		txtc.setToolTipText("Please enter some text here");
		txtc.requestFocusInWindow();
		
		lb5=new JLabel("MB NO:");
		lb5.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		lb5.setBounds(15,207,120,25);
		pnl1.add(lb5);
		
		txtd=new JTextField();
		txtd.setBounds(115,207,140,25);
		pnl1.add(txtd);
		txtd.setHorizontalAlignment(SwingConstants.CENTER);
		txtd.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		txtd.setToolTipText("Please enter some text here");
		txtd.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) 
			{
				String mobile="^[789]\\d{9}$";

				boolean b=txtd.getText().matches(mobile);
				if(b==false)
				{
				JOptionPane.showMessageDialog(null,"Invalid mob. no.");
				txtd.requestFocusInWindow();
				}
				else
				{
				txtd.setBackground(Color.white);
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtd.setBackground(Color.gray);
				
			}
		});
		
		
		lb6=new JLabel("Email ID:");
		lb6.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		lb6.setBounds(15,242,100,25);
		pnl1.add(lb6);
		
		txte=new JTextField();
		txte.setBounds(115,242,160,25);
		pnl1.add(txte);
		txte.setHorizontalAlignment(SwingConstants.CENTER);
		txte.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		txte.setToolTipText("Please enter some text here");
		txte.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String EMAIL_PATTERN =
						"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
						
				boolean b=txte.getText().matches(EMAIL_PATTERN);
				if(b==false)
				{
					JOptionPane.showMessageDialog(null,"Invalid Email Address:");
					txte.requestFocusInWindow();
				}
				else
				{
					txte.setBackground(Color.white);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txte.setBackground(Color.gray);
				
			}
		});
		
		
		lb7=new JLabel("SERIES:");
		lb7.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,15));
		lb7.setBounds(15,287,100,25);
		pnl1.add(lb7);
		
		
		dlm=new DefaultListModel();
		langs=new JList(dlm);
		JScrollPane scroll1 = new JScrollPane(langs);
		scroll1.setBounds(115,287, 150,80);
		pnl1.add(scroll1);
		langs.addListSelectionListener(new ListSelectionListener()
		{
		@Override
		public void valueChanged(ListSelectionEvent e)
		{
		//lng=langs.getSelectedValue().toString();
		//int indx=langs.getSelectedIndex();
		
		//JOptionPane.showMessageDialog(null, "Index:"+indx+" Value: "+lng);
		

		}
		});
		
		btn6=new JButton("Get Series");
		btn6.setBounds(270,287,100,30);
		btn6.setBackground(Color.decode("#F44336"));
		//btn6.setIcon(new ImageIcon("update.png"));
		pnl1.add(btn6);
		btn6.setForeground(Color.white);
		btn6.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				click.play();
				updateseries();
			}
		});
		
		
		
		btn1=new JButton("Save");
		btn1.setBounds(20,390,80,30);
		//btn1.setIcon(new ImageIcon("save.png"));
		btn1.setBackground(Color.decode("#F44336"));
		pnl1.add(btn1);
		btn1.setForeground(Color.white);
		btn1.setMnemonic(KeyEvent.VK_S);
		btn1.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					click.play();
						Object[] all=langs.getSelectedValues();
						String ss="";
						for(Object s:all)
						ss+=s.toString()+",";
						
						ford=Integer.parseInt(String.valueOf(cmb.getSelectedItem()));	
				       
						pst=con.prepareStatement("insert into addagent values(?,?,?,?,?,?,?)");
						
						pst.setInt(1,ford);
						pst.setString(2,txtb.getText());
						pst.setString(3,addr.getText());
						pst.setString(4,txtc.getText());
						pst.setString(5,txtd.getText());
						pst.setString(6, txte.getText());
						pst.setString(7,ss);						 
						int ros=pst.executeUpdate();
						if(ros==1)
						JOptionPane.showMessageDialog(null,ros+"record saved");
						else
							JOptionPane.showMessageDialog(null,ros+"record already existed:");
						
						
					    pst=con.prepareStatement("update lotteryseries set agentid=? where series=?");
					    pst.setInt(1,ford);
					    for(int i=0;i<all.length;i++)
						{
					    	pst.setInt(1,ford);
					    	pst.setString(2,String.valueOf(all[i]));
					    	res=pst.executeUpdate();
						}
					    	
						//JOptionPane.showMessageDialog(null,res+"record updated");
					
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
		

		btn3=new JButton("Update");
		btn3.setBounds(110,390,100,30);
		btn3.setBackground(Color.decode("#F44336"));
		btn3.setForeground(Color.white);
		//btn3.setIcon(new ImageIcon("update.png"));
		pnl1.add(btn3);
		btn3.setMnemonic(KeyEvent.VK_U);
	    btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					click.play();
				ford=Integer.parseInt(String.valueOf(cmb.getSelectedItem()));
				String p="";
				dlm.removeAllElements();
				pst=con.prepareStatement("update addagent set agentname=?,address=?,city=?,mobile=?,email=?,series=concat(series,?) where agentid=?");
				pst.setInt(7,ford);
				pst.setString(1,txtb.getText());
				pst.setString(2,addr.getText());
				pst.setString(3,txtc.getText());
							
				pst.setString(4,txtd.getText());				
				pst.setString(5, txte.getText());
				int []d=langs.getSelectedIndices();
				for(int v:d)
				p=dlm.getElementAt(v)+","+p;
				pst.setString(6,p);
				
				int res=pst.executeUpdate();
				if(res==1)
				JOptionPane.showMessageDialog(null, res+" records Updated");
				}
				catch (SQLException ex)
				{
				ex.printStackTrace();
				}
				try{
					updateseries();
				pst.close();
				}
				catch (Exception ev)
				{
				ev.printStackTrace();
				}
				}
				
			
		});
		
		btn4=new JButton("New");
		btn4.setBounds(230,390,80,30);
		btn4.setBackground(Color.decode("#F44336"));
		btn4.setForeground(Color.white);
		//btn4.setIcon(new ImageIcon("new2.png"));
		pnl1.add(btn4);
		btn4.setMnemonic(KeyEvent.VK_N);
		btn4.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent ev)
			{
				    click.play();
					cmb.setSelectedItem("select");
					txtb.setText("");
					addr.setText("");
					txtc.setText("");
					txtd.setText("");
					txte.setText("");
					updateseries();
					fillcombo();
					getid();
					
			}
		});
		
		
		
		
		btn5=new JButton("Close");
		btn5.setBounds(490,650,80,30);
		add(btn5);
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
		
		fillcombo();
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		getRootPane().setBorder(brd);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	void getid()
	{
		int aid=1;
		boolean b=false;
		try
		{
			pst=con.prepareStatement("select max(agentid) as 'max' from addagent");
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
		
		cmb.setSelectedItem(aid);
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
		getid();
		try
		{
			pst=con.prepareStatement("select agentid from addagent");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				cmb.addItem(rs.getInt("agentid"));
			}
			pst.close();
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
		}
	}
	
	void updateseries()
	{
		try {
			dlm.removeAllElements();
			pst=con.prepareStatement("SELECT * from lotteryseries where agentid=0");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				dlm.addElement(rs.getString(3));
			}
			pst.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}


public class Agentconsole
{
	public static void main(String[] args)
	{
	Agentform c=new Agentform();
	}
}
