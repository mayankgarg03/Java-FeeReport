package com.brainmentor.feereport.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.brainmentor.feereport.DTO.RegisterDTO;
import com.brainmentor.feereport.user.DAO.UserDAO;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	
	private void askToClose(){
		int choice = JOptionPane.showConfirmDialog(this, "Do You Want To Leave This Window",  "feereport", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				this.setVisible(false);
				this.dispose();
			}
//			else{
//				RegisterView frame = new RegisterView();
//				frame.setVisible(true);
//			}
	}
	public void Register(){
		String username = textField.getText();
		String pwd = new String(passwordField.getPassword());
		//String type = comboBox.getSelectedItem().toString();
		RegisterDTO registerdto = new RegisterDTO();
		registerdto.setUsername(username);
		registerdto.setPassword(pwd);
		//registerdto.setType(type);
		
		UserDAO userdao = new UserDAO();
		try {
			String msg = userdao.doRegister(registerdto);
			JOptionPane.showMessageDialog(this, msg);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "contact to database administrator");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "contact to system database admin");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	JLabel lblRegistration = new JLabel("Registration");
	JLabel lblUsername = new JLabel("UserName");
	JLabel lblpassword = new JLabel("password");
	JButton btnSubmit = new JButton("Submit");
	
	public RegisterView() {
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				askToClose();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 556, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(183, 11, 157, 27);
		contentPane.add(lblRegistration);
		
		
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(34, 96, 96, 19);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(206, 97, 197, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblpassword.setBounds(34, 134, 82, 27);
		contentPane.add(lblpassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(206, 134, 197, 19);
		contentPane.add(passwordField);
		
		
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnSubmit.setBounds(183, 242, 89, 23);
		contentPane.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			          Register();	
			}
			
		});
	}
}
