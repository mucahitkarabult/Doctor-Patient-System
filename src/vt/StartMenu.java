package vt;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class StartMenu {

	JFrame frame;
	private JTextField TC;
	Connection conn=null;
	String admin = "admin";	
	char[] parola = { 'r','o','o','t' };
	private JPasswordField PW;
	   public static void main(String[] args) {
		   EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						StartMenu frame = new StartMenu();
						frame.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	   }


	public StartMenu() {
		initialize();
	};
	   
	   
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(StartMenu.class.getResource("/vt/medical-127-129383.png")));
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.setBounds(100, 100, 679, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox.addItem("Patient");
		comboBox.addItem("Health Employee");
		comboBox.addItem("Admin");
		comboBox.setBounds(239, 200, 102, 29);
		frame.getContentPane().add(comboBox);
		
		TC = new JTextField();
		TC.setBounds(226, 255, 131, 18);
		frame.getContentPane().add(TC);
		TC.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usarname:\r\n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(97, 252, 119, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(127, 283, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		PW = new JPasswordField();
		PW.setBounds(226, 284, 131, 17);
		frame.getContentPane().add(PW);
		
		
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(249, 312, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblStartLogo = new JLabel();
		lblStartLogo.setBounds(0, 0, 676, 451);

		ImageIcon imgIc = new ImageIcon(StartMenu.class.getResource("/vt/StartLogo.jpg"));
		Image img = imgIc.getImage();
		Image imgscale = img.getScaledInstance(lblStartLogo.getWidth(),lblStartLogo.getHeight(),Image.SCALE_SMOOTH);
		imgIc = new ImageIcon(imgscale);
		lblStartLogo.setIcon(imgIc);
		frame.getContentPane().add(lblStartLogo);
	
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] U_PW =PW.getPassword();	
				String Username =TC.getText();
				
				String chose=comboBox.getSelectedItem().toString();
				conn =SqlConnect.dbConnector();
				if(conn==null) {
					JOptionPane.showMessageDialog(null, "Database'e baðlanýlamýyor!!!");
					return;
				}
				
				if(chose.contentEquals("Patient")) {
		
					String query ="select * from hasta where htc_no= '"+ Username+"'";
					
					
					try {
						PreparedStatement pst = conn.prepareStatement (query);
						ResultSet r2 =pst.executeQuery();
						
						if(r2.next()) {
							char[] str=r2.getString("had").toCharArray();
							if(Arrays.equals(str, U_PW)) {
							JOptionPane.showMessageDialog(null, "Giriþ baþarýlý");
							pst.close();
							frame.dispose();
							HastaAna hasta=new HastaAna(Username);
							hasta.setVisible(true);}
							else {
								JOptionPane.showMessageDialog(null, "sifre yalnýþ");
							}
								
						}
						else {
							JOptionPane.showMessageDialog(null, "Kullanici adi veya sifre yalnýþ");
						}
					}
					   catch(Exception e)
							{
							JOptionPane.showMessageDialog(null, e);}
				}
				
				else if(chose.contentEquals("Health Employee")) {
					
					
					String query ="select * from saglik_calisani where tc_no= '"+ Username+"'";
					
					
					try {
						PreparedStatement pst = conn.prepareStatement (query);
						ResultSet r2 =pst.executeQuery();
						
						if(r2.next()) {
							char[] str=r2.getString("ad").toCharArray();
							if(Arrays.equals(str, U_PW)) {
							JOptionPane.showMessageDialog(null, "Giriþ baþarýlý");
							pst.close();
							frame.dispose();
							SaglikAna doctor=new SaglikAna(Username);
							doctor.setVisible(true);}
							else {
								JOptionPane.showMessageDialog(null, "sifre yalnýþ");
							}
								
						}
						else {
							JOptionPane.showMessageDialog(null, "Kullanici adi veya sifre yalnýþ");
						}
					}
					   catch(Exception e)
							{
							JOptionPane.showMessageDialog(null, e);
							}
					}
				else{
					if(Arrays.equals(U_PW, parola)&&admin.equals(Username)) {
						AdminAna admin=new AdminAna();
						frame.dispose();
						admin.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Kullanici adi veya þifre yalniþ");
					}
					
				}
				
			/*	char[] U_PW =PW.getPassword();	
				String Username=TC.getText();
				boolean r=Arrays.equals(U_PW, parola);
				if(admin.equals(Username)&& r) {
					JOptionPane.showMessageDialog(null, "Giris Basarili");
				}
				else {
					JOptionPane.showMessageDialog(null, "Kullanici adi veya þifre yalnýþ" );}*/
			
					
	
				
			
			}}
			
	);
	}
}

