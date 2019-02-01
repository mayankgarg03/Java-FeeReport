package com.brainmentor.feereport.dashboard.view;

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
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.brainmentor.feereport.dashboard.DAO.EditStudentDAO;
import com.brainmentor.feereport.dashboard.DAO.StudentDAO;
import com.brainmentor.feereport.dashboard.DTO.StudentDTO;

public class EditStudent extends JFrame {

	private JPanel contentPane;
	
	private JTextField userField;
	private JTextField emailField;
	private JTextField feeField;
	private JTextField paidField;
	private JTextField dueField;
	private JTextField countryField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudent frame = new EditStudent();
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
	
	
	
	
	JTextArea addressArea = new JTextArea();
    JComboBox stateComboBox = new JComboBox();
	JComboBox cityComboBox = new JComboBox();
	JComboBox comboBox = new JComboBox();
	private JTextField contactField;
	private JTextField rollField;

	
	public void getStudent(){
		int rollno = new Integer(rollField.getText());
		System.out.println(rollno);
		EditStudentDAO editdao = new EditStudentDAO();
		
		try {
			 StudentDTO studentdto = editdao.loadStudent(rollno);
			 if(studentdto==null){
				 JOptionPane.showMessageDialog(this, "Invalid rollno");
			 }
			 userField.setText(studentdto.getName());
			 emailField.setText(studentdto.getEmail());
			 feeField.setText(String.valueOf(studentdto.getFee()));
			 dueField.setText(String.valueOf(studentdto.getDue()));
			 paidField.setText(String.valueOf(studentdto.getPaid()));
			 countryField.setText(studentdto.getCountry());
			 contactField.setText(studentdto.getPhone_number());
			 addressArea.setText(studentdto.getAddress());
			 comboBox.setSelectedItem(studentdto.getCourse());
			 cityComboBox.setSelectedItem(studentdto.getCity());
			 stateComboBox.setSelectedItem(studentdto.getState());
			 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			 JOptionPane.showMessageDialog(this, "something went wrong please call system admin");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 JOptionPane.showMessageDialog(this, "some database problem call database administrator");
		}
		
	}
	
	
	private void askToClose(){
		int choice = JOptionPane.showConfirmDialog(this, "Do You Want To Leave This Window",  "feereport", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				this.setVisible(false);
				this.dispose();
			}
//			else{
//				EditStudent frame = new EditStudent();
//				frame.setVisible(true);
//			}
			
	}
	
	
	public void doUpdateStudent(){
		
		String name = userField.getText();
		//System.out.println(name);
		String email = emailField.getText();
		String courseType = comboBox.getSelectedItem().toString();
		//int fee = new Integer(feeField.getText());
		//int paid = new Integer(paidField.getText());
		//int due = new Integer(dueField.getText());
		String  cityType =  cityComboBox.getSelectedItem().toString(); 
		String stateType = stateComboBox.getSelectedItem().toString();
		String phone = contactField.getText();		
		String country = countryField.getText();
		String address = addressArea.getText();
		//int rollno = new Integer( rollField.getText());
		feeField.setEditable(false);
		dueField.setEditable(false);
		paidField.setEditable(false);
		StudentDTO studentdto = new StudentDTO();
		studentdto.setName(name);
		studentdto.setEmail(email);
		studentdto.setCourse(courseType);
		//studentdto.setFee(fee);
		//studentdto.setPaid(paid);
		//studentdto.setDue(due);
		studentdto.setAddress(address);
		studentdto.setCity(cityType);
		studentdto.setState(stateType);
		studentdto.setCountry(country);
		studentdto.setPhone_number(phone);
		//studentdto.setRollno(rollno);
		EditStudentDAO editdao = new EditStudentDAO();
		
		try {
			 String msg = editdao.updateStudent(studentdto);
			 JOptionPane.showMessageDialog(this, msg);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "some error occur! please contact system admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "some error occur! please contact database admin");

			e.printStackTrace();
		}
		
		
	}
	
	public EditStudent() {
		
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				askToClose();
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 537, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
			
			JLabel lblAddStudent = new JLabel("Edit Student");
			lblAddStudent.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblAddStudent.setBounds(148, 11, 162, 20);
			contentPane.add(lblAddStudent);
			
			JLabel lblName = new JLabel("name");
			lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(24, 96, 57, 20);
			contentPane.add(lblName);
			
			userField = new JTextField();
			userField.setBounds(186, 98, 219, 20);
			contentPane.add(userField);
			userField.setColumns(10);
			
			JLabel lblEmail = new JLabel("email");
			lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEmail.setBounds(24, 151, 57, 14);
			contentPane.add(lblEmail);
			
			emailField = new JTextField();
			emailField.setBounds(186, 150, 219, 20);
			contentPane.add(emailField);
			emailField.setColumns(10);
			
			JLabel lblCourse = new JLabel("Course");
			lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCourse.setBounds(24, 188, 57, 20);
			contentPane.add(lblCourse);
			
			
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"CSE ", "ECE", "EE", "CE", "ME", "IT"}));
			comboBox.setBounds(186, 190, 158, 20);
			contentPane.add(comboBox);
			
			JLabel lblFee = new JLabel("fee");
			lblFee.setHorizontalAlignment(SwingConstants.CENTER);
			lblFee.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblFee.setBounds(35, 219, 46, 14);
			contentPane.add(lblFee);
			
			feeField = new JTextField();
			feeField.setBounds(186, 218, 106, 20);
			contentPane.add(feeField);
			feeField.setColumns(10);
			
			JLabel lblPaid = new JLabel("paid");
			lblPaid.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPaid.setHorizontalAlignment(SwingConstants.CENTER);
			lblPaid.setBounds(35, 244, 46, 19);
			contentPane.add(lblPaid);
			
			paidField = new JTextField();
			paidField.setBounds(186, 245, 106, 20);
			contentPane.add(paidField);
			paidField.setColumns(10);
			
			JLabel lblDue = new JLabel("Due");
			lblDue.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDue.setHorizontalAlignment(SwingConstants.CENTER);
			lblDue.setBounds(35, 274, 46, 14);
			contentPane.add(lblDue);
			
			dueField = new JTextField();
			dueField.setBounds(189, 273, 103, 20);
			contentPane.add(dueField);
			dueField.setColumns(10);
			
			JLabel lblCity = new JLabel("City");
			lblCity.setHorizontalAlignment(SwingConstants.CENTER);
			lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCity.setBounds(35, 311, 46, 14);
			contentPane.add(lblCity);
			
			
			cityComboBox.setModel(new DefaultComboBoxModel(new String[] {"Delhi", "Sonipat", "Noida", "Gurgaon", "Faridabad"}));
			cityComboBox.setBounds(185, 310, 162, 20);
			contentPane.add(cityComboBox);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddress.setBounds(35, 370, 70, 20);
			contentPane.add(lblAddress);
			
			
			addressArea.setBounds(178, 351, 207, 62);
			contentPane.add(addressArea);
			
			JLabel lblCountry = new JLabel("country");
			lblCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCountry.setHorizontalAlignment(SwingConstants.CENTER);
			lblCountry.setBounds(35, 422, 70, 20);
			contentPane.add(lblCountry);
			
			countryField = new JTextField();
			countryField.setBounds(176, 424, 209, 20);
			contentPane.add(countryField);
			countryField.setColumns(10);
			
			JLabel lblState = new JLabel("state");
			lblState.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblState.setBounds(47, 453, 46, 20);
			contentPane.add(lblState);
			
			
			stateComboBox.setModel(new DefaultComboBoxModel(new String[] {"Delhi", "Haryana", "UP"}));
			stateComboBox.setBounds(176, 453, 209, 20);
			contentPane.add(stateComboBox);
			
			JLabel lblContactNumber = new JLabel("contact number");
			lblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblContactNumber.setBounds(24, 498, 110, 19);
			contentPane.add(lblContactNumber);
			
			JButton btnSubmit = new JButton("Update");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					doUpdateStudent();
					
				}
			});
			btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			btnSubmit.setBounds(204, 530, 89, 27);
			contentPane.add(btnSubmit);
			
			contactField = new JTextField();
			contactField.setBounds(178, 499, 227, 20);
			contentPane.add(contactField);
			contactField.setColumns(10);
			
			JLabel label = new JLabel("RollNo");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Tahoma", Font.BOLD, 15));
			label.setBounds(10, 50, 81, 14);
			contentPane.add(label);
			
			rollField = new JTextField();
			rollField.setColumns(10);
			rollField.setBounds(178, 49, 219, 20);
			contentPane.add(rollField);
			
			JButton btnLoad = new JButton("Load");
			btnLoad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					getStudent();
				}
			});
			btnLoad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
			btnLoad.setBounds(422, 45, 89, 23);
			contentPane.add(btnLoad);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(35, 75, 449, 10);
			contentPane.add(separator);

	}
}
