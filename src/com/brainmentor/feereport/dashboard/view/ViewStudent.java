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

import com.brainmentor.feereport.dashboard.DAO.StudentDAO;
import com.brainmentor.feereport.dashboard.DTO.AccountantDTO;
import com.brainmentor.feereport.dashboard.DTO.StudentDTO;

public class ViewStudent extends JFrame {

	private JPanel contentPane;
	
	
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudent frame = new ViewStudent();
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
	

	
	
	
	
	
	StudentDAO studentdao = new StudentDAO();
	private void askToClose() throws ClassNotFoundException, SQLException {
		int choice = JOptionPane.showConfirmDialog(this, "Do You Want To Leave This Window",  "feereport", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				this.setVisible(false);
				this.dispose();
			}
//			else{
//			ViewStudent frame = new ViewStudent();
//	        frame.setVisible(true);
//			}
	}
	

	public ViewStudent() throws ClassNotFoundException, SQLException {
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				try {
					askToClose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1087, 496);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
	
				
				ArrayList<StudentDTO> studentlist = new ArrayList<>();
				 studentlist = studentdao.viewStudent();
				 String columns[] = {"name","rollno","email","course","fee","paid","due","city","country","state","address","phone_number"};
					
				   int size = studentlist.size();
					String Data[][] = new String[size][12];
				 
				
				int row = 0;
				for(StudentDTO a:studentlist){
					Data[row][0] = a.getName();
					Data[row][1]=  String.valueOf(a.getRollno());
					Data[row][2]=  a.getEmail();
					Data[row][3]=  a.getCourse();
					Data[row][4]=  String.valueOf(a.getFee());
					Data[row][5]=  String.valueOf(a.getPaid());
					Data[row][6]=   String.valueOf(a.getDue());
					Data[row][7]=  a.getCity();
					Data[row][8]=  a.getCountry();
					Data[row][9]=  a.getState();
					Data[row][10]=  a.getAddress();
					Data[row][11]=  a.getPhone_number();
					row++;
	
				table = new JTable(Data,columns);
				table.setBounds(38, 431, 980, 396);
				contentPane.add(table);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 10, 1050, 445);
				contentPane.add(scrollPane);
				table.setEnabled(false);
				
				
				//table.setModel(Data,columns);
					//table.setBounds(20, 66, 531, 328);
					//scrollPane.setViewportView(table);
			}
			}
	

		
		
		
		
	}


