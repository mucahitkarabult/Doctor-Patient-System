
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

public class HizmetHastaEkle extends JFrame {

	private JPanel contentPane;
	private JTextField tcc;
	private JTextField hAdi;
	Connection conn;
	private JTextField textField;

	public HizmetHastaEkle(String tc) {
		
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
		setBounds(100, 100, 424, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground( new Color(248,148,6));
		panel.setBounds(0, 0, 450, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hastaya Hizmet Ekle");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 440, 57);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(44,62,80));
		panel_1.setBounds(0, 55, 450, 242);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Hasta Tc No: ");
		lblNewLabel_1_3.setForeground(new Color(236, 240, 241));
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(23, 30, 158, 34);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Hizmet Ad\u0131:");
		lblNewLabel_1_4.setForeground(new Color(236, 240, 241));
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(23, 75, 144, 34);
		panel_1.add(lblNewLabel_1_4);
		
		tcc = new JTextField();
		tcc.setBounds(168, 30, 186, 31);
		panel_1.add(tcc);
		tcc.setColumns(10);
		tcc.setText(telno);
		
		hAdi = new JTextField();
		hAdi.setBounds(168, 75, 186, 31);
		panel_1.add(hAdi);
		hAdi.setColumns(10);
		hAdi.setText(boy);
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaglikAna saglik = new SaglikAna(tc);
				saglik.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(23, 176, 115, 34);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ekle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query =	"Insert Into hastahizmet values( '"+tcc.getText()+"' , '"+tc+"' , '"+hAdi.getText()+"');";
				Statement s = null;
				try {
					s = conn.createStatement();
					s.executeUpdate(query);
					s.close();
					SaglikAna saglik = new SaglikAna(tc);
					saglik.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton_1.setBounds(257, 176, 128, 34);
		panel_1.add(btnNewButton_1);
		
		
		
		
	}
}
