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

public class D_bilgileri extends JFrame {

	private JPanel contentPane;
	private JLabel lblmaas;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public D_bilgileri(String tc) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Connection conn=null;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(54,33,89));
		panel.setBounds(0, 0, 563, 349);
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
		 	String ad = null;
	        String soyad = null;
	        String telno = null;
	        String maas = null;
	        String brans = null;
	        
	        conn=SqlConnect.dbConnector();
	        String query ="select * from saglik_calisani where tc_no= '"+ tc+"'";
	        try {
	            PreparedStatement pst = conn.prepareStatement (query);
	            ResultSet r2 =pst.executeQuery();
	            if(r2.next()) {
	                ad = r2.getString("ad");
	                soyad = r2.getString("soyad");
	                maas = r2.getString("maas");
	                brans = r2.getString("brans");
	            }
	            pst.close();
	        } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	        Ýsim.setText("Ýsim: "+ad);
	        Soyisim.setText("Soyisim: "+soyad);
	        Tc.setText("Tc: "+tc);
	        
	        
	        
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaglikAna profil = new SaglikAna(tc);
				profil.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(26, 270, 117, 36);
		panel.add(btnNewButton);
		
		JPanel panel_1_4_1 = new JPanel();
		panel_1_4_1.setLayout(null);
		panel_1_4_1.setBackground(new Color(85,68,118));
		panel_1_4_1.setBounds(50, 165, 167, 36);
		panel.add(panel_1_4_1);
		
		JLabel lblbrans = new JLabel("Bran\u015F: " + brans);
		lblbrans.setForeground(new Color(236, 240, 241));
		lblbrans.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblbrans.setBounds(0, 0, 167, 36);
		panel_1_4_1.add(lblbrans);
		
		JPanel panel_1_4_2 = new JPanel();
		panel_1_4_2.setLayout(null);
		panel_1_4_2.setBackground(new Color(85,68,118));
		panel_1_4_2.setBounds(337, 165, 167, 36);
		panel.add(panel_1_4_2);
		
		JLabel lblmaas;
		lblmaas = new JLabel("Maas: "+ maas);
		lblmaas.setForeground(new Color(236, 240, 241));
		lblmaas.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblmaas.setBounds(0, 0, 167, 36);
		panel_1_4_2.add(lblmaas);
		
		
		
		
	}
}
