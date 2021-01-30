package vt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class P_bilgi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public P_bilgi(String tc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(P_bilgi.class.getResource("/vt/medical-127-129383.png")));
		setTitle("Profilim");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Connection conn=null;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(54,33,89));
		panel.setBounds(0, 0, 633, 414);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(85,68,118));
		panel_1.setBounds(50, 31, 167, 36);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Ýsim = new JLabel("\u0130sim:");
		Ýsim.setBounds(0, 0, 167, 36);
		panel_1.add(Ýsim);
		Ýsim.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Ýsim.setForeground(new Color(236, 240, 241));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(85,68,118));
		panel_1_1.setBounds(50, 100, 167, 36);
		panel.add(panel_1_1);
		
		JLabel Soyisim = new JLabel("Soyisim: ");
		Soyisim.setForeground(new Color(236, 240, 241));
		Soyisim.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Soyisim.setBounds(0, 0, 167, 36);
		panel_1_1.add(Soyisim);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(85,68,118));
		panel_1_2.setBounds(50, 173, 167, 36);
		panel.add(panel_1_2);
		
		JLabel Boy = new JLabel("Boy: ");
		Boy.setForeground(new Color(236, 240, 241));
		Boy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Boy.setBounds(0, 0, 167, 36);
		panel_1_2.add(Boy);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(new Color(85,68,118));
		panel_1_3.setBounds(50, 255, 167, 36);
		panel.add(panel_1_3);
		
		JLabel Kilo = new JLabel("Kilo:");
		Kilo.setForeground(new Color(236, 240, 241));
		Kilo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Kilo.setBounds(0, 0, 167, 36);
		panel_1_3.add(Kilo);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBackground(new Color(85,68,118));
		panel_1_4.setBounds(337, 31, 167, 36);
		panel.add(panel_1_4);
		
		JLabel Tc = new JLabel("Tc:\r\n");
		Tc.setForeground(new Color(236, 240, 241));
		Tc.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Tc.setBounds(0, 0, 167, 36);
		panel_1_4.add(Tc);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setLayout(null);
		panel_1_5.setBackground(new Color(85,68,118));
		panel_1_5.setBounds(337, 100, 167, 36);
		panel.add(panel_1_5);
		
		JLabel SGK = new JLabel("SGK: ");
		SGK.setForeground(new Color(236, 240, 241));
		SGK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		SGK.setBounds(0, 0, 167, 36);
		panel_1_5.add(SGK);
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setLayout(null);
		panel_1_6.setBackground(new Color(85,68,118));
		panel_1_6.setBounds(337, 173, 167, 36);
		panel.add(panel_1_6);
		
		JLabel Tel = new JLabel("Telefon: ");
		Tel.setForeground(new Color(236, 240, 241));
		Tel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Tel.setBounds(0, 0, 167, 36);
		panel_1_6.add(Tel);
		
		JPanel panel_1_7 = new JPanel();
		panel_1_7.setLayout(null);
		panel_1_7.setBackground(new Color(85,68,118));
		panel_1_7.setBounds(337, 255, 167, 36);
		panel.add(panel_1_7);
		
		JLabel Dogum = new JLabel("Do\u011FumT:\r\n");
		Dogum.setForeground(new Color(236, 240, 241));
		Dogum.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Dogum.setBounds(0, 0, 167, 36);
		panel_1_7.add(Dogum);
		
		JTextArea Adres = new JTextArea();
		Adres.setWrapStyleWord(true);
		Adres.setLineWrap(true);
		Adres.setForeground(new Color(236, 240, 241));
		Adres.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Adres.setText("Adres:\r\n");
		Adres.setBackground(new Color(85,68,118));
		Adres.setBounds(202, 305, 202, 76);
		panel.add(Adres);
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
	        Ýsim.setText("Ýsim: "+ad);
	        Soyisim.setText("Soyisim: "+soyad);
	        Boy.setText("Boy: "+boy);
	        Kilo.setText("Kilo: "+kilo);
	        SGK.setText("SGK: "+sgkno);
	        Dogum.setText("DoðumT: "+dogum);
	        Adres.setText("Adres: "+ adres);
	        Tel.setText("TelefonNO:"+telno);
	        Tc.setText("Tc: "+tc);
	        
	        
	        
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HastaAna profil = new HastaAna(tc);
				profil.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(34, 367, 117, 36);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("G\u00FCncelle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_bilgi_guncl profil = new P_bilgi_guncl(tc);
				profil.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(470, 367, 133, 36);
		panel.add(btnNewButton_1);
		
		
		
		
	}
}
