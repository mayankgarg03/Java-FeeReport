package com.brainmentor.feereport.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentor.feereport.DTO.RegisterDTO;
import com.brainmentor.feereport.DTO.RightDTO;
import javax.swing.JButton;

public class DashBoardView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoardView frame = new DashBoardView();
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
//				DashBoardView frame = new DashBoardView();
//				frame.setExtendedState(MAXIMIZED_BOTH);
//				frame.setVisible(true);
//				//this.setVisible(true);
//			}
	}
	
	public void fillDashBoard(RegisterDTO registerdto){
		if(registerdto!=null){
			lblNewLabel.setText("Welcome" + " " + registerdto.getUsername() +" "+ registerdto.getRoleName());
			if(registerdto.getRights()!=null){
				for(RightDTO right : registerdto.getRights()){
					JMenuItem menuItem = new JMenuItem(right.getName());
					menuItem.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							System.out.println("Screen Name "+right.getScreenName());
							try{
								int lastIndex = right.getScreenName().lastIndexOf(".java");
								System.out.println("Last Index "+lastIndex);
							String className = right.getScreenName().substring(0,lastIndex);
							System.out.println("ClassNAme "+className);
							Object object = Class.forName(className).newInstance();
							Method method = object.getClass().getMethod("setVisible", boolean.class);
							
							method.invoke(object, true);
							}
							catch(Exception e1){
								System.out.println("Reflection Problem "+e1);
								e1.printStackTrace();
							}
							}
					});
					mnNewMenu .add(menuItem);
					
				}
			}
		}
				
			}

private void logout(){
	
	LoginView loginview = new LoginView();
	loginview.setVisible(true);
	this.setVisible(false);
	this.dispose();
	
}
	
	
	
	
	JMenu mnNewMenu = new JMenu("File");
	
	JLabel lblNewLabel = new JLabel("");
	public DashBoardView() {
		
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				askToClose();
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 467, 343);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(55, 87, 318, 64);
		
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogout.setBounds(1042, 11, 109, 29);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				logout();
			}
			
		});
	}
}
