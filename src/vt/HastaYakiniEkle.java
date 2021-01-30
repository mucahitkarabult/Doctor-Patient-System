package vt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class HastaYakiniEkle extends JFrame {

	private JPanel contentPane;
	private JTextField tel;
	private JTextField soyad;
	private JTextField ad;
	private JTextField tc;
	private JTextField yakinlik;
	private JTextField hastaTC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaYakiniEkle frame = new HastaYakiniEkle();
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
	public HastaYakiniEkle() {
		setResizable(false);
		setTitle("Hasta Yak\u0131n\u0131 Ekle");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HastaEkle.class.getResource("/vt/medical-127-129383.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 264);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(54,33,89));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Connection conn = SqlConnect.dbConnector();
		JLabel lblIsim = new JLabel("\u0130sim: ");
		lblIsim.setForeground(new Color(255, 255, 255));
		lblIsim.setHorizontalAlignment(SwingConstants.LEFT);
		lblIsim.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblIsim.setBounds(10, 11, 81, 23);
		contentPane.add(lblIsim);
		
		JLabel lblSoyisim = new JLabel("Soyisim:");
		lblSoyisim.setForeground(new Color(255, 255, 255));
		lblSoyisim.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblSoyisim.setBounds(10, 45, 81, 28);
		contentPane.add(lblSoyisim);
		
		JLabel lblTelefonNo = new JLabel("Telefon No: ");
		lblTelefonNo.setForeground(new Color(255, 255, 255));
		lblTelefonNo.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblTelefonNo.setBounds(10, 84, 116, 28);
		contentPane.add(lblTelefonNo);
		
		tel = new JTextField();
		tel.setText((String) null);
		tel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tel.setColumns(10);
		tel.setBounds(106, 87, 134, 23);
		contentPane.add(tel);
		
		JLabel lblTcNo = new JLabel("TC No: ");
		lblTcNo.setForeground(new Color(255, 255, 255));
		lblTcNo.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblTcNo.setBounds(10, 118, 66, 28);
		contentPane.add(lblTcNo);
		
		soyad = new JTextField();
		soyad.setText((String) null);
		soyad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		soyad.setColumns(10);
		soyad.setBounds(106, 48, 134, 23);
		contentPane.add(soyad);
		
		ad = new JTextField();
		ad.setText((String) null);
		ad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ad.setColumns(10);
		ad.setBounds(106, 11, 134, 23);
		contentPane.add(ad);
		
		tc = new JTextField();
		tc.setText((String) null);
		tc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tc.setColumns(10);
		tc.setBounds(106, 121, 134, 23);
		contentPane.add(tc);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HastaYakiniDuzenle newF=new HastaYakiniDuzenle();
				newF.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(10, 185, 116, 28);
		contentPane.add(btnGeri);
		
		JButton btnGncelle = new JButton("Ekle");
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "INSERT INTO hasta_yakini " +
			    "VALUES( '" + tc.getText() + "', '" + hastaTC.getText() + "', '" + ad.getText() + "' ,'" + soyad.getText() + "', '" + tel.getText() +  "', '" + yakinlik.getText() + "')";
				System.out.println(query);
				PreparedStatement s = null;
				try {
					 s= conn.prepareStatement(query);
					 s.execute();
			         s.close();
			         JOptionPane.showMessageDialog(null, "Hasta baþarýyla eklendi!!");
				}
			catch(Exception e1)
				{
				   JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnGncelle.setBounds(460, 185, 116, 28);
		contentPane.add(btnGncelle);
		
		JLabel lblCinsiyet = new JLabel("Yak\u0131nl\u0131k Derecesi: ");
		lblCinsiyet.setForeground(new Color(255, 255, 255));
		lblCinsiyet.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblCinsiyet.setBounds(311, 45, 159, 28);
		contentPane.add(lblCinsiyet);
		
		yakinlik = new JTextField();
		yakinlik.setText((String) null);
		yakinlik.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		yakinlik.setColumns(10);
		yakinlik.setBounds(454, 48, 105, 23);
		contentPane.add(yakinlik);
		
		JLabel lblHastaTcNo = new JLabel("Hasta TC No: ");
		lblHastaTcNo.setForeground(new Color(255, 255, 255));
		lblHastaTcNo.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblHastaTcNo.setBounds(311, 6, 134, 28);
		contentPane.add(lblHastaTcNo);
		
		hastaTC = new JTextField();
		hastaTC.setText((String) null);
		hastaTC.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		hastaTC.setColumns(10);
		hastaTC.setBounds(425, 9, 134, 23);
		contentPane.add(hastaTC);
	}
}
