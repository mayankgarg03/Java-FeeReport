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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.brainmentor.feereport.dashboard.DAO.AccountantDAO;
import com.brainmentor.feereport.dashboard.DTO.AccountantDTO;
import com.brainmentor.feereport.view.DashBoardView;

public class AddAccountant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField emailField;
	private JTextField phoneField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAccountant frame = new AddAccountant();
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
	
	public void accountant(){
		String name = textField.getText();
		String pwd = new String(passwordField.getPassword());
		String email = emailField.getText();
		String phone = phoneField.getText();
		AccountantDTO accountantdto = new AccountantDTO();
		accountantdto.setName(name);
		accountantdto.setPassword(pwd);
		accountantdto.setEmail(email);
		accountantdto.setPhoneNumber(phone);
		AccountantDAO accountantdao = new AccountantDAO();
		
		try {
			String msg = accountantdao.addAccountant(accountantdto);
			JOptionPane.showMessageDialog(this, msg);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "contact system admin ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "contact system admin because something went wrong");
		}
		
	}
	
	JLabel lblAddAccountant = new JLabel("Add Accountant");
	JLabel lblEmailid = new JLabel("Email-id");
	JLabel lblName = new JLabel("Name");
	JLabel lblPassword = new JLabel("password");
	JLabel lblContactNo = new JLabel("contact no");
	JButton btnSubmit = new JButton("Submit");
	
	private void askToClose(){
		int choice = JOptionPane.showConfirmDialog(this, "Do You Want To Leave This Window",  "feereport", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				this.setVisible(false);
				this.dispose();
			}
//			else{
//				AddAccountant frame  = new AddAccountant();
//				frame.setVisible(true);
//			}
	}
	
	
	public AddAccountant() {
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				askToClose();
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 488, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblAddAccountant.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAddAccountant.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAccountant.setBounds(147, 22, 165, 21);
		contentPane.add(lblAddAccountant);
		
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(29, 86, 46, 14);
		contentPane.add(lblName);
		
		
		lblEmailid.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailid.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmailid.setBounds(29, 220, 61, 21);
		contentPane.add(lblEmailid);
		
		
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(10, 160, 80, 21);
		contentPane.add(lblPassword);
		
		
		lblContactNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContactNo.setBounds(10, 286, 90, 21);
		contentPane.add(lblContactNo);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountant();
			}
		});
		
		
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnSubmit.setBounds(161, 341, 108, 23);
		contentPane.add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(161, 85, 235, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 160, 235, 22);
		contentPane.add(passwordField);
		
		emailField = new JTextField();
		emailField.setBounds(161, 222, 235, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setBounds(161, 288, 235, 20);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
	}
}
