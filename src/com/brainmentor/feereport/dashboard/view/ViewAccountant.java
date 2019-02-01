package com.brainmentor.feereport.dashboard.view;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.brainmentor.feereport.dashboard.DAO.AccountantDAO;
import com.brainmentor.feereport.dashboard.DTO.AccountantDTO;

public class ViewAccountant extends JFrame {

	private JPanel contentPane;
	private JTable table;
	//static ArrayList<AccountantDTO> accountlist = new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAccountant frame = new ViewAccountant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	AccountantDAO accountantdao = new AccountantDAO();
	//ArrayList<AccountantDTO> accountlist = accountantdao.viewAccountant();
//       public void  getAccountantDetail() throws ClassNotFoundException, SQLException{
//		
//			ArrayList<AccountantDTO> accountlist = accountantdao.viewAccountant();
//			 String columns[] = {"name","email","phone_number"};
//				int size = 0;
//				String Data[][] = new String[size][3];
//			 size = accountlist.size();
//			
//			int row = 0;
//			for(AccountantDTO a:accountlist){
//				Data[row][0] = a.getName();
//				Data[row][1]=a.getEmail();
//				Data[row][2]=a.getPhoneNumber();
//				row++;
//		
//				
//			}
//		
//		
//		
//		}
	
	
	private void askToClose(){
		int choice = JOptionPane.showConfirmDialog(this, "Do You Want To Leave This Window",  "feereport", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				this.setVisible(false);
				this.dispose();
			}
//			else{
//				ViewAccountant frame;
//				try {
//					frame = new ViewAccountant();
//					frame.setVisible(true);
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
	}
	
	public ViewAccountant() throws ClassNotFoundException, SQLException {
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				askToClose();
			}
		});
		
    //    getAccountantDetail();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 523, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ArrayList<AccountantDTO> accountlist = new ArrayList<AccountantDTO>();
		 accountlist = accountantdao.viewAccountant();
		 String columns[] = {"name","email","phone_number"};
			//int size = 0;
		   int size = accountlist.size();
			String Data[][] = new String[size][3];
		 
		
		int row = 0;
		for(AccountantDTO a:accountlist){
			Data[row][0] = a.getName();
			Data[row][1]=a.getEmail();
			Data[row][2]=a.getPhoneNumber();
			row++;
//		 String columns[] = {"name","email","phone_number"};
//			//int size = 0;
//		
//		AccountantDAO accountantdao = new AccountantDAO();
//		//ArrayList<AccountantDTO> accountlist = accountantdao.viewAccountant();
//	       // public  void getAccountantDetail(){
//	//	String Data[][] ;
//			try {
//				ArrayList<AccountantDTO> accountlist = accountantdao.viewAccountant();
//				int size = accountlist.size();
//				String Data[][] = new String[size][3];
//				int row = 0;
//				for(AccountantDTO a:accountlist){
//					Data[row][0] = a.getName();
//					Data[row][1]=a.getEmail();
//					Data[row][2]=a.getPhoneNumber();
//					row++;
//				}
//			
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				JOptionPane.showMessageDialog(null, this, "cann't load accountant details", 0);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				JOptionPane.showMessageDialog(null, this, "cann't load accountant details something wrong", 0);
//			} 
		
		
		
		table = new JTable(Data,columns);
		table.setBounds(38, 431, 428, 396);
		contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 487, 445);
		contentPane.add(scrollPane);
		
		//table.setModel(Data,columns);
			table.setBounds(20, 66, 531, 328);
			//scrollPane.setViewportView(table);
	}
	}
}
