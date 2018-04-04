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
import java.awt.print.PrinterException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

class winners extends JFrame
{
	AudioClip click;
	Connection con;
	PreparedStatement pstmt ;
	JPanel pnl,pnl1;
	JLabel lb,lb1,lb2,home;
	Border brd;
	JTable table;
	JButton btn1,btn2,btn3,btn5,btn4;
	public winners()
	{
		con=ConnectionFile.doConnect();
		
		URL urlClick = Prize_console.class.getResource("click_one.wav");
		click = Applet.newAudioClip(urlClick);
		
		setLayout(null);
		setSize(600,720);
		brd=BorderFactory.createLineBorder(Color.decode("#F44336"),1);
		
		lb=new JLabel("ALL WINNERS");
		lb.setFont(new Font("Arial",Font.BOLD,40));
		lb.setBounds(20, 10, 500,100);
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
		pnl1.setBounds(40,150, 500, 100);
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
		
		btn2=new JButton("Show Table");
		btn2.setBounds(50,20,100,50);
		pnl1.add(btn2);
		btn2.setForeground(Color.WHITE);
		btn2.setBackground(Color.decode("#F44336"));
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					click.play();
					String sql = "Select * from winners";
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
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
					pstmt.close();
					table = new JTable(data,columnNames);
					JScrollPane scrollPane = new JScrollPane( table );
					
					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table.setAutoResizeMode( JTable.AUTO_RESIZE_NEXT_COLUMN );//to get horizontal scroll bar
					scrollPane.setBounds(30, 300, 540, 300);
					scrollPane.getViewport ().setScrollMode ( JViewport.BACKINGSTORE_SCROLL_MODE );

					scrollPane.getViewport ().setScrollMode ( JViewport.SIMPLE_SCROLL_MODE );

					
					add( scrollPane );
					
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
			}
		});
		
			
			
	
		
		btn1=new JButton("Print");
		btn1.setBounds(170,20,100,50);
		pnl1.add(btn1);
		btn1.setForeground(Color.WHITE);
		btn1.setBackground(Color.decode("#F44336"));
		btn1.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try {
					click.play();
					table.print();
					} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
			
			}
		});
		
		
		btn4=new JButton("Send Sms");
		btn4.setBounds(470,600,100,30);
		add(btn4);
		btn4.setForeground(Color.WHITE);
		btn4.setBackground(Color.decode("#F44336"));
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
				pstmt=con.prepareStatement("select * from winners");
				ResultSet rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					String mbno=rs.getString("mobileno");
					int lno=rs.getInt("lotteryno");
					String cname=rs.getString("customername");
					int p=rs.getInt("pos");
					 String msg=lno+" "+cname+" "+"has won the "+p+" prize in The National Lottery. ";
					
					
					SST_SMS1.bceSunSoftSend(mbno,msg);
				}
				
				
				}			
							
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
		
				}
				});
		
		btn3=new JButton("Export To Excel");
		btn3.setBounds(290,20,150,50);
		btn3.setBackground(Color.decode("#F44336"));
		pnl1.add(btn3);
		btn3.setForeground(Color.WHITE);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try{
					click.play();
					JFileChooser fc=new JFileChooser();
					fc.showOpenDialog(null);
					String filename=fc.getSelectedFile().getAbsolutePath();
					
					HSSFWorkbook hwb=new HSSFWorkbook();
					HSSFSheet sheet =  hwb.createSheet("new sheet");

					HSSFRow rowhead=   sheet.createRow((short)0);
					rowhead.createCell((short) 0).setCellValue("Agent ID");
					rowhead.createCell((short) 1).setCellValue("Lottery No.");
					rowhead.createCell((short) 2).setCellValue("Customer Name");
					rowhead.createCell((short) 3).setCellValue("Address");
					rowhead.createCell((short) 4).setCellValue("City");
					rowhead.createCell((short) 5).setCellValue("Mobile No.");
					rowhead.createCell((short) 6).setCellValue("Position");


					Connection con;
					con=ConnectionFile.doConnect();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("Select * from winners");
					int i=1;
					while(rs.next()){
					HSSFRow row=   sheet.createRow((short)i);
					row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("agentid")));
					row.createCell((short) 1).setCellValue(rs.getString("lotteryno"));
					row.createCell((short) 2).setCellValue(rs.getString("customername"));
					row.createCell((short) 3).setCellValue(rs.getString("address"));
					row.createCell((short) 4).setCellValue(rs.getString("city"));
					row.createCell((short) 5).setCellValue(rs.getString("mobileno"));
					row.createCell((short) 6).setCellValue(rs.getInt("pos"));
					i++;
					}
					FileOutputStream fileOut =  new FileOutputStream(filename);
					hwb.write(fileOut);
					fileOut.close();
					System.out.println("Your excel file has been generated!");

					} catch ( Exception ex ) {
					    System.out.println(ex);

					}
				
				
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
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setWindowDecorationStyle(JRootPane.WARNING_DIALOG);
		getRootPane().setBorder(brd);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
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
public class allwinners 
{

	
	public static void main(String[] args) 
	{
		winners w=new winners();

	}

}
