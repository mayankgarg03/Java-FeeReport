package com.brainmentor.feereport.dashboard.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.brainmentor.feereport.dashboard.DAO.StudentDAO;
import com.brainmentor.feereport.dashboard.DTO.StudentDTO;
import javax.swing.JScrollPane;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JScrollBar;

public class AddStudent extends JFrame {
	

	private JPanel contentPane;
	private JTextField userField;
	private JTextField emailField;
	private JTextField feeField;
	private JTextField paidField;
	private JTextField dueField;
	private JTextField countryField;
	private JTextField phoneField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	
	
	public void doAddStudent(){
		String name = userField.getText();
		String email = emailField.getText();
		String courseType = comboBox.getSelectedItem().toString();
		int fee = new Integer(feeField.getText());
		int paid = new Integer(paidField.getText());
		int due = new Integer(dueField.getText());
		String  cityType =  cityComboBox.getSelectedItem().toString(); 
		String stateType = stateComboBox.getSelectedItem().toString();
		String phone = phoneField.getText();		
		String country = countryField.getText();
		String address = addressArea.getText();
		int rollno = new Integer( textField.getText());
		StudentDTO studentdto = new StudentDTO();
		studentdto.setName(name);
		studentdto.setEmail(email);
		studentdto.setCourse(courseType);
		studentdto.setFee(fee);
		studentdto.setPaid(paid);
		studentdto.setDue(due);
		studentdto.setAddress(address);
		studentdto.setCity(cityType);
		studentdto.setState(stateType);
		studentdto.setCountry(country);
		studentdto.setPhone_number(phone);
		studentdto.setRollno(rollno);
		StudentDAO studentdao = new StudentDAO();
		
		try {
		String msg =studentdao.AddStudent(studentdto);
		JOptionPane.showMessageDialog(this,msg );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Contact to system admin");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Contact to system admin ! something went wrong");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
	
JTextArea addressArea = new JTextArea();
    JComboBox stateComboBox = new JComboBox();
	JComboBox cityComboBox = new JComboBox();
	JComboBox comboBox = new JComboBox();
	JLabel lblRollno = new JLabel("RollNo");
	private JTextField textField;
	
	
	
	private void askToClose(){
		int choice = JOptionPane.showConfirmDialog(this, "Do You Want To Leave This Window",  "feereport", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				this.setVisible(false);
				this.dispose();
			}
//			else{
//				AddStudent frame = new AddStudent();
//				frame.setVisible(true);
//			}
	}
	
	
	public AddStudent() {
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				askToClose();
			}
		});
		
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 525, 596);
		contentPane = new JPanel();
		
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(0, 0, 509, 749);
//		contentPane.add(scrollPane);
		
		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddStudent.setBounds(186, 22, 162, 20);
		contentPane.add(lblAddStudent);
		
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(24, 55, 57, 20);
		contentPane.add(lblName);
		
		userField = new JTextField();
		userField.setBounds(186, 53, 219, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(24, 99, 57, 14);
		contentPane.add(lblEmail);
		
		emailField = new JTextField();
		emailField.setBounds(186, 98, 219, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourse.setBounds(24, 138, 57, 20);
		contentPane.add(lblCourse);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CSE ", "ECE", "EE", "CE", "ME", "IT"}));
		comboBox.setBounds(189, 140, 158, 20);
		contentPane.add(comboBox);
		
		JLabel lblFee = new JLabel("fee");
		lblFee.setHorizontalAlignment(SwingConstants.CENTER);
		lblFee.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFee.setBounds(35, 180, 46, 14);
		contentPane.add(lblFee);
		
		feeField = new JTextField();
		feeField.setBounds(186, 179, 106, 20);
		contentPane.add(feeField);
		feeField.setColumns(10);
		
		JLabel lblPaid = new JLabel("paid");
		lblPaid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaid.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaid.setBounds(35, 205, 46, 19);
		contentPane.add(lblPaid);
		
		paidField = new JTextField();
		paidField.setBounds(186, 210, 106, 20);
		contentPane.add(paidField);
		paidField.setColumns(10);
		
		JLabel lblDue = new JLabel("Due");
		lblDue.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDue.setHorizontalAlignment(SwingConstants.CENTER);
		lblDue.setBounds(35, 251, 46, 14);
		contentPane.add(lblDue);
		
		dueField = new JTextField();
		dueField.setBounds(186, 250, 103, 20);
		contentPane.add(dueField);
		dueField.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setBounds(35, 288, 46, 14);
		contentPane.add(lblCity);
		
		
		cityComboBox.setModel(new DefaultComboBoxModel(new String[] {"Delhi", "Sonipat", "Noida", "Gurgaon", "Faridabad"}));
		cityComboBox.setBounds(178, 287, 162, 20);
		contentPane.add(cityComboBox);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(35, 323, 70, 20);
		contentPane.add(lblAddress);
		
		
		addressArea.setBounds(178, 318, 207, 62);
		contentPane.add(addressArea);
		
		JLabel lblCountry = new JLabel("country");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCountry.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountry.setBounds(35, 386, 70, 20);
		contentPane.add(lblCountry);
		
		countryField = new JTextField();
		countryField.setBounds(178, 391, 209, 20);
		contentPane.add(countryField);
		countryField.setColumns(10);
		
		JLabel lblState = new JLabel("state");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblState.setBounds(46, 432, 46, 20);
		contentPane.add(lblState);
		
		
		stateComboBox.setModel(new DefaultComboBoxModel(new String[] {"Delhi", "Haryana", "UP"}));
		stateComboBox.setBounds(178, 422, 209, 20);
		contentPane.add(stateComboBox);
		
		JLabel lblContactNumber = new JLabel("contact number");
		lblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContactNumber.setBounds(10, 460, 110, 19);
		contentPane.add(lblContactNumber);
		
		phoneField = new JTextField();
		phoneField.setBounds(178, 453, 227, 20);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doAddStudent();
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnSubmit.setBounds(204, 530, 89, 27);
		contentPane.add(btnSubmit);
		
		
		lblRollno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollno.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRollno.setBounds(24, 504, 81, 14);
		contentPane.add(lblRollno);
		
		textField = new JTextField();
		textField.setBounds(178, 499, 227, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
//		JScrollBar scrollBar = new JScrollBar();
//		scrollBar.setBounds(492, 11, 17, 738);
//		contentPane.add(scrollBar);
//		Dimension dimension = scrollBar.getPreferredSize();
//		Dimension a = scrollBar.
//		System.out.println(a);
		
	}
}
