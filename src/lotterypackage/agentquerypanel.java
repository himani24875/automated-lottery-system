package lotterypackage;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.mysql.jdbc.PreparedStatement;

class aquery extends JFrame
{
	AudioClip click;
	Connection con;
	java.sql.PreparedStatement pst;
	JPanel pnl,pnl1;
	JLabel lb,lb1,lb2,home;
	Border brd;
	JComboBox cmb,cmb2;
	JTable table;
	JButton btn1,btn2,btn3,btn5;
	public aquery() 
	{
		con=ConnectionFile.doConnect();
		URL urlClick = Prize_console.class.getResource("click_one.wav");
		click = Applet.newAudioClip(urlClick);
		
		setLayout(null);
		setSize(600,720);
		brd=BorderFactory.createLineBorder(Color.decode("#F44336"),1);
		
		lb=new JLabel("AGENT QUERY PANEL");
		lb.setFont(new Font("Arial",Font.BOLD,30));
		lb.setBounds(30, 10, 600,100);
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
		
		pnl1=new JPanel();
		pnl1.setLayout(null);
		pnl1.setBounds(50,180, 500, 150);
		pnl1.setBackground(Color.WHITE);
		add(pnl1);
		pnl1.setBorder(brd);
		
		lb1=new JLabel("CITY:");
		lb1.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,25));
		lb1.setBounds(30,15,70,35);
		pnl1.add(lb1);
		
		cmb=new JComboBox();
		cmb.setBounds(180,15,100,25);
		pnl1.add(cmb);
		cmb.setEditable(true);
		cmb.setFont(new Font("AR ESSENCE", Font.PLAIN|Font.BOLD, 15));
		
		lb2=new JLabel("AGENT ID:");
		lb2.setFont(new Font("Arial",Font.ITALIC|Font.BOLD,25));
		lb2.setBounds(30,60,130,35);
		pnl1.add(lb2);
		
		cmb2=new JComboBox();
		cmb2.setBounds(180,60,100,25);
		pnl1.add(cmb2);
		cmb2.setEditable(true);
		cmb2.setFont(new Font("AR ESSENCE", Font.PLAIN|Font.BOLD, 15));
		
		btn3=new JButton("Tickets Sold");
		btn3.setBounds(300,60,130,25);
		btn3.setBackground(Color.decode("#F44336"));
		btn3.setForeground(Color.WHITE);
		pnl1.add(btn3);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				click.play();
				
				filltbl2();
				
			}
		});
		
		
		btn1=new JButton("Show All");
		btn1.setBounds(200,100,120,40);
		btn1.setBackground(Color.decode("#F44336"));
		btn1.setForeground(Color.WHITE);
		pnl1.add(btn1);
		btn1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try {
					click.play();
					pst=con.prepareStatement("select * from addagent");
					ResultSet rs = pst.executeQuery();
					ResultSetMetaData md = rs.getMetaData();
					Vector<String> columnNames = new Vector<String>();
					int columns = md.getColumnCount();
					for (int i = 1; i <= columns; i++)
					{
					columnNames.addElement( md.getColumnName(i) );
					}
					//--------------------------------------------------
					Vector<Object> data = new Vector<Object>();
					while (rs.next())
					{
					Vector<Object> row = new Vector<Object>(columns);
					for (int i = 1; i <= columns; i++)
					{
					row.addElement( rs.getObject(i) );
					}
					data.addElement(row);
					}
					rs.close();
					pst.close();
					table = new JTable(data,columnNames);
					JScrollPane scrollPane = new JScrollPane( table );
					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table.setAutoResizeMode( JTable.AUTO_RESIZE_NEXT_COLUMN);//to get horizontal scroll bar
					scrollPane.setBounds(30, 350, 540, 300);
					scrollPane.getViewport ().setScrollMode ( JViewport.BACKINGSTORE_SCROLL_MODE );

					scrollPane.getViewport ().setScrollMode ( JViewport.SIMPLE_SCROLL_MODE );
					add( scrollPane );

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btn2=new JButton("Search");
		btn2.setBounds(300,15,130,25);
		btn2.setBackground(Color.decode("#F44336"));
		btn2.setForeground(Color.WHITE);
		pnl1.add(btn2);
		btn2.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				click.play();
				filltbl();
				
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
		fillcombo2();
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		getRootPane().setBorder(brd);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
	}
	
	void filltbl()
	{
		try
		{
		pst=con.prepareStatement("select * from addagent where city=?");			 
		pst.setString(1,String.valueOf(cmb.getSelectedItem()));

		 ResultSet rs=pst.executeQuery();
		 System.out.println("come");
		 ResultSetMetaData md = rs.getMetaData();
			Vector<String> columnNames = new Vector<String>();
			int columns = md.getColumnCount();
			for (int i = 1; i <= columns; i++)
			{
				columnNames.addElement( md.getColumnName(i) );
			}
			Vector<Object> data = new Vector<Object>();
			
		 while(rs.next())
		 	{
			 	Vector<Object> row = new Vector<Object>(columns);
				for (int i = 1; i <= columns; i++)
				{
					row.addElement( rs.getObject(i) );
				}
				data.addElement(row);
          
		 }
		 rs.close();
		 pst.close();
		 System.out.println("added");
		 table = new JTable(data,columnNames);
		 JScrollPane scrollPane = new JScrollPane( table );
			
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_NEXT_COLUMN );//to get horizontal scroll bar
		scrollPane.setBounds(30, 350, 540, 300);
		//scrollPane.getViewport ().setScrollMode ( JViewport.BACKINGSTORE_SCROLL_MODE );

		//scrollPane.getViewport ().setScrollMode ( JViewport.SIMPLE_SCROLL_MODE );

		
		add( scrollPane );
		System.out.println("all done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void filltbl2()
	{
		try
		{
		pst=con.prepareStatement("select * from addcustomer where agentid=?");			 
		pst.setString(1,String.valueOf(cmb2.getSelectedItem()));

		 ResultSet rs=pst.executeQuery();
		 System.out.println("come");
		 ResultSetMetaData md = rs.getMetaData();
			Vector<String> columnNames = new Vector<String>();
			int columns = md.getColumnCount();
			for (int i = 1; i <= columns; i++)
			{
				columnNames.addElement( md.getColumnName(i) );
			}
			Vector<Object> data = new Vector<Object>();
			
		 while(rs.next())
		 	{
			 	Vector<Object> row = new Vector<Object>(columns);
				for (int i = 1; i <= columns; i++)
				{
					row.addElement( rs.getObject(i) );
				}
				data.addElement(row);
          
		 }
		 rs.close();
		 pst.close();
		 System.out.println("added");
		 table = new JTable(data,columnNames);
		 JScrollPane scrollPane = new JScrollPane( table );
			
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_NEXT_COLUMN );//to get horizontal scroll bar
		scrollPane.setBounds(30, 350, 540, 300);
		//scrollPane.getViewport ().setScrollMode ( JViewport.BACKINGSTORE_SCROLL_MODE );

		//scrollPane.getViewport ().setScrollMode ( JViewport.SIMPLE_SCROLL_MODE );

		
		add( scrollPane );
		System.out.println("all done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	ImageIcon resize_img(ImageIcon log,int width,int height)
	{
	Image img=log.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	ImageIcon bhai=new ImageIcon(img);
	return(bhai);
	}
	
	void fillcombo2()
	{
		cmb2.removeAllItems();
		cmb2.addItem("select");
		
		try
		{
			pst=con.prepareStatement("select agentid from addagent");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String id=rs.getString("agentid");
				cmb2.addItem(id);
			}
			pst.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	void fillcombo()
	{
		cmb.removeAllItems();
		cmb.addItem("select");
		
		try
		{
			pst=con.prepareStatement("select distinct city from addagent");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String id=rs.getString("city");
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
public class agentquerypanel
{
	public static void main(String[] args)
	{
		aquery a=new aquery();
	}

}
