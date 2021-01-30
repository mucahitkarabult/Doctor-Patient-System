
package vt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class P_bilgi_guncl extends JFrame {

	private JPanel contentPane;
	private JTextField Tel;
	private JTextField Boy;
	private JTextField Kilo;
	Connection conn;
	private JTextField textField;

	public P_bilgi_guncl(String tc) {
		
		setUndecorated(true);
		String ad = null;
		String soyad = null;
		String telno = null;
		String sgkno = null;
		String dogum = null;
		String boy = null;
		String kilo = null;
		String adres = null;
		conn=SqlConnect.dbConnector();
		String query ="select * from hasta where htc_no= '"+ tc+"'";
		try {
			PreparedStatement pst = conn.prepareStatement (query);
			ResultSet r2 =pst.executeQuery();
			if(r2.next()) {
				ad = r2.getString("had");
				soyad = r2.getString("hsoyad");
				telno = r2.getString("htel_no");
				sgkno = r2.getString("hsgk_no");
				dogum = r2.getString("hdogum_tarihi");
				boy = r2.getString("hboy");
				kilo = r2.getString("hkilo");
				adres = r2.getString("hadres");
			}
		    pst.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(85,68,118));
		panel.setBounds(0, 0, 450, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bilgi G\u00FCncelleme Sayfasi");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 450, 57);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(54,33,89));
		panel_1.setBounds(0, 55, 450, 655);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u0130sim: "+"\t"+ad);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(new Color(236,240,241));
		lblNewLabel_1.setBounds(23, 34, 291, 34);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Soyisim: "+"\t"+soyad);
		lblNewLabel_1_1.setForeground(new Color(236, 240, 241));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(23, 79, 291, 34);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tc: "+"\t"+tc);
		lblNewLabel_1_2.setForeground(new Color(236, 240, 241));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(23, 181, 291, 34);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefon:");
		lblNewLabel_1_3.setForeground(new Color(236, 240, 241));
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(23, 271, 104, 34);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Boy:\r\n");
		lblNewLabel_1_4.setForeground(new Color(236, 240, 241));
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(23, 316, 104, 34);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Kilo:");
		lblNewLabel_1_5.setForeground(new Color(236, 240, 241));
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(23, 361, 104, 34);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("SGK: "+sgkno);
		lblNewLabel_1_3_1.setForeground(new Color(236, 240, 241));
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1_3_1.setBounds(23, 226, 291, 34);
		panel_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Adres\r\n");
		lblNewLabel_1_3_2.setForeground(new Color(236, 240, 241));
		lblNewLabel_1_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1_3_2.setBounds(23, 406, 104, 34);
		panel_1.add(lblNewLabel_1_3_2);
		
		Tel = new JTextField();
		Tel.setBounds(128, 274, 186, 31);
		panel_1.add(Tel);
		Tel.setColumns(10);
		Tel.setText(telno);
		
		Boy = new JTextField();
		Boy.setBounds(128, 319, 186, 31);
		panel_1.add(Boy);
		Boy.setColumns(10);
		Boy.setText(boy);
		
		Kilo = new JTextField();
		Kilo.setBounds(128, 364, 186, 31);
		panel_1.add(Kilo);
		Kilo.setColumns(10);
		Kilo.setText(boy);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("D-T:  "+"\t"+dogum);
		lblNewLabel_1_2_1.setForeground(new Color(236, 240, 241));
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1_2_1.setBounds(23, 136, 291, 34);
		panel_1.add(lblNewLabel_1_2_1);
		
		JTextArea Adres = new JTextArea();
		Adres.setWrapStyleWord(true);
		Adres.setLineWrap(true);
		Adres.setBounds(128, 420, 181, 153);
		panel_1.add(Adres);
		Adres.setText(adres);
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				P_bilgi profil = new P_bilgi(tc);
				profil.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(23, 597, 115, 34);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("G\u00FCncelle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query =	"UPDATE hasta SET hkilo = '"+Kilo.getText()+"' , hboy ='"+Boy.getText()+"' , htel_no = '"+Tel.getText()+"' ,"+
						"hadres ='"+Adres.getText()+"' WHERE htc_no= '"+tc+"'";
				Statement s = null;
				try {
					s = conn.createStatement();
					s.executeUpdate(query);
					s.close();
					P_bilgi profil = new P_bilgi(tc);
					profil.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton_1.setBounds(299, 597, 128, 34);
		panel_1.add(btnNewButton_1);
		
		
		
		
	}
}
