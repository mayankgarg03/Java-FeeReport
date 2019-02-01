package com.brainmentor.feereport.dashboard.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.brainmentor.feereport.dashboard.DAO.DueFeeDAO;
import com.brainmentor.feereport.dashboard.DTO.StudentDTO;

public class DueFee extends JFrame {

	private JPanel contentPane;
	private JTextField rollField;
	private JTextField userField;
	private JTextField feeField;
	private JTextField paidField;
	private JTextField dueField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DueFee frame = new DueFee();
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
	
	
	
	
	public void checkDueFee(){
		int rollno = new Integer(rollField.getText());
		DueFeeDAO duedao = new DueFeeDAO();
		
		try {
		StudentDTO studentdto =	duedao.dueFee(rollno);
		if(studentdto==null){
			JOptionPane.showMessageDialog(this, "Invalid rollno");
		}
	       userField.setText(studentdto.getName());
	       feeField.setText(String.valueOf(studentdto.getFee()));
	       paidField.setText(String.valueOf(studentdto.getPaid()));
	       dueField.setText(String.valueOf(studentdto.getDue()));
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "something went wrong please contact system admin");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "some error occur contact system admin");
			e.printStackTrace();
		}
		
	}
	
	
	public void doSubmitDueFee(){
		int rollno = new Integer(rollField.getText());
		String name = userField.getText();
		int fee = new Integer(feeField.getText());
		int paid = new Integer(paidField.getText());
		int due = new Integer(dueField.getText());
		DueFeeDAO duedao = new DueFeeDAO();
		try {
			String msg = duedao.submitDueFee(rollno,paid,due);
			JOptionPane.showMessageDialog(this, msg);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "something went wrong please contact system admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "some error occur contact system admin");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	private void askToClose(){
		int choice = JOptionPane.showConfirmDialog(this, "Do You Want To Leave This Window",  "feereport", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				this.setVisible(false);
				this.dispose();
			}
//			else{
//				DueFee frame = new DueFee();
//				frame.setVisible(true);
//			}
	}
	
	
	public DueFee() {
		
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				askToClose();
			}
		});
		
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 518, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDueFee = new JLabel("DUE FEE");
		lblDueFee.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDueFee.setHorizontalAlignment(SwingConstants.CENTER);
		lblDueFee.setBounds(210, 24, 78, 14);
		contentPane.add(lblDueFee);
		
		JLabel lblRollno = new JLabel("rollno");
		lblRollno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRollno.setBounds(21, 74, 67, 17);
		contentPane.add(lblRollno);
		
		rollField = new JTextField();
		rollField.setBounds(202, 74, 159, 20);
		contentPane.add(rollField);
		rollField.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(36, 146, 46, 14);
		contentPane.add(lblName);
		
		userField = new JTextField();
		userField.setBounds(202, 145, 159, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblFee = new JLabel("fee");
		lblFee.setHorizontalAlignment(SwingConstants.CENTER);
		lblFee.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFee.setBounds(36, 212, 46, 14);
		contentPane.add(lblFee);
		
		feeField = new JTextField();
		feeField.setBounds(202, 211, 159, 20);
		contentPane.add(feeField);
		feeField.setColumns(10);
		
		paidField = new JTextField();
		paidField.setColumns(10);
		paidField.setBounds(202, 260, 159, 20);
		contentPane.add(paidField);
		
		JLabel lblPaid = new JLabel("paid");
		lblPaid.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaid.setBounds(36, 263, 46, 17);
		contentPane.add(lblPaid);
		
		JLabel lblDue = new JLabel("due");
		lblDue.setHorizontalAlignment(SwingConstants.CENTER);
		lblDue.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDue.setBounds(36, 315, 46, 17);
		contentPane.add(lblDue);
		
		dueField = new JTextField();
		dueField.setColumns(10);
		dueField.setBounds(202, 315, 159, 20);
		contentPane.add(dueField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
			doSubmitDueFee();
			
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnSubmit.setBounds(210, 374, 124, 23);
		contentPane.add(btnSubmit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(53, 121, 406, 14);
		contentPane.add(separator);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
				checkDueFee();
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnLoad.setBounds(403, 73, 89, 23);
		contentPane.add(btnLoad);
	}

}
