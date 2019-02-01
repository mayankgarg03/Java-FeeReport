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

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	
	public void reset(){
		userField.setText(" ");
		passwordField.setText(null);
		//comboBox.setSelectedItem(" ");
	}
	
	public void loadNext(){
		RegisterView registerview = new RegisterView();
		registerview.setVisible(true);
		//this.setVisible(false);
	}
	
	public void checkLogin(){
		String username = userField.getText();
		String pwd = new String(passwordField.getPassword());
				
		
		UserDAO userdao = new UserDAO();
		try {
			RegisterDTO registerdto = userdao.doLogin(username, pwd);
			if(registerdto==null){
				JOptionPane.showMessageDialog(this, "Invalid username and password");
				return;
			}
			
			DashBoardView dashBoard = new DashBoardView();
			dashBoard.fillDashBoard(registerdto);
			dashBoard.setVisible(true);
			dashBoard.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.setVisible(false);
			this.dispose();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "contact to DB manager");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "contact to System Admin");
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
//				LoginView frame = new LoginView();
//				frame.setVisible(true);
//			}
			
			
	}
	
	
	JLabel lblNewLabel = new JLabel("LOGIN");
	JLabel lblUsername = new JLabel("UserName");
	JLabel lblPassword = new JLabel("Password");
	JButton btnSubmit = new JButton("Submit");
	 JButton btnRegister = new JButton("Register");
	 JButton btnReset = new JButton("Reset");
	public LoginView() {
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				askToClose();
			}
		});
		
		

		setBounds(100, 100, 586, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(130, 23, 255, 14);
		contentPane.add(lblNewLabel);
		
		
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(44, 106, 84, 23);
		contentPane.add(lblUsername);
		
		userField = new JTextField();
		userField.setBounds(219, 109, 246, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(44, 195, 84, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(219, 195, 246, 19);
		contentPane.add(passwordField);
		
		
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnSubmit.setBounds(30, 297, 142, 23);
		contentPane.add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg2){
				checkLogin();
				reset();
			}
		});
		
		btnRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnRegister.setBounds(229, 298, 114, 23);
		
		contentPane.add(btnRegister);
		
		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				loadNext();
			}
		});
		
		
		btnReset.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnReset.setBounds(431, 298, 89, 23);
		
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			            reset();
			}

		
		});
		
	}

}
