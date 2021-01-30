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

public class HastaEkle extends JFrame {

	private JPanel contentPane;
	private JTextField kilo;
	private JTextField boy;
	private JTextField tel;
	private JTextField soyad;
	private JTextField ad;
	private JTextField tc;
	private JTextField sgk;
	private JTextField dogum;
	private JTextField cinsiyet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaEkle frame = new HastaEkle();
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
	public HastaEkle() {
		setResizable(false);
		setTitle("Hasta Ekle");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HastaEkle.class.getResource("/vt/medical-127-129383.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(54,33,89));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Connection conn = SqlConnect.dbConnector();
		JLabel lblIsim = new JLabel("\u0130sim: ");
		lblIsim.setForeground(new Color(255, 255, 255));
		lblIsim.setHorizontalAlignment(SwingConstants.LEFT);
		lblIsim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblIsim.setBounds(10, 11, 81, 23);
		contentPane.add(lblIsim);
		
		JLabel lblSoyisim = new JLabel("Soyisim:");
		lblSoyisim.setForeground(new Color(255, 255, 255));
		lblSoyisim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoyisim.setBounds(10, 45, 81, 28);
		contentPane.add(lblSoyisim);
		
		JLabel lblTelefonNo = new JLabel("Telefon No: ");
		lblTelefonNo.setForeground(new Color(255, 255, 255));
		lblTelefonNo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTelefonNo.setBounds(10, 84, 81, 28);
		contentPane.add(lblTelefonNo);
		
		JLabel lblBoy = new JLabel("Boy: ");
		lblBoy.setForeground(new Color(255, 255, 255));
		lblBoy.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblBoy.setBounds(10, 123, 37, 28);
		contentPane.add(lblBoy);
		
		JLabel lblKilo = new JLabel("Kilo: ");
		lblKilo.setForeground(new Color(255, 255, 255));
		lblKilo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKilo.setBounds(10, 162, 37, 28);
		contentPane.add(lblKilo);
		
		kilo = new JTextField();
		kilo.setText((String) null);
		kilo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		kilo.setColumns(10);
		kilo.setBounds(96, 164, 134, 23);
		contentPane.add(kilo);
		
		boy = new JTextField();
		boy.setText((String) null);
		boy.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		boy.setColumns(10);
		boy.setBounds(96, 125, 134, 23);
		contentPane.add(boy);
		
		tel = new JTextField();
		tel.setText((String) null);
		tel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tel.setColumns(10);
		tel.setBounds(96, 84, 134, 23);
		contentPane.add(tel);
		
		JLabel lblTcNo = new JLabel("TC No: ");
		lblTcNo.setForeground(new Color(255, 255, 255));
		lblTcNo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTcNo.setBounds(301, 11, 66, 28);
		contentPane.add(lblTcNo);
		
		JLabel lblSgkNo = new JLabel("SGK No: ");
		lblSgkNo.setForeground(new Color(255, 255, 255));
		lblSgkNo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSgkNo.setBounds(301, 45, 89, 28);
		contentPane.add(lblSgkNo);
		
		JLabel lblDoumTarihi = new JLabel("Do\u011Fum Tarihi: ");
		lblDoumTarihi.setForeground(new Color(255, 255, 255));
		lblDoumTarihi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDoumTarihi.setBounds(301, 80, 89, 28);
		contentPane.add(lblDoumTarihi);
		
		JTextArea adre = new JTextArea();
		adre.setText((String) null);
		adre.setLineWrap(true);
		adre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		adre.setBounds(350, 119, 182, 133);
		contentPane.add(adre);
		
		JTextArea txtAdres = new JTextArea();
		txtAdres.setForeground(new Color(255, 255, 255));
		txtAdres.setWrapStyleWord(true);
		txtAdres.setText("Adres: ");
		txtAdres.setLineWrap(true);
		txtAdres.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtAdres.setEditable(false);
		txtAdres.setBackground(new Color(54,33,89));
		txtAdres.setBounds(301, 119, 231, 133);
		contentPane.add(txtAdres);
		
		soyad = new JTextField();
		soyad.setText((String) null);
		soyad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		soyad.setColumns(10);
		soyad.setBounds(96, 45, 134, 23);
		contentPane.add(soyad);
		
		ad = new JTextField();
		ad.setText((String) null);
		ad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ad.setColumns(10);
		ad.setBounds(96, 11, 134, 23);
		contentPane.add(ad);
		
		tc = new JTextField();
		tc.setText((String) null);
		tc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tc.setColumns(10);
		tc.setBounds(398, 11, 134, 23);
		contentPane.add(tc);
		
		sgk = new JTextField();
		sgk.setText((String) null);
		sgk.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sgk.setColumns(10);
		sgk.setBounds(398, 47, 134, 23);
		contentPane.add(sgk);
		
		dogum = new JTextField();
		dogum.setText((String) null);
		dogum.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		dogum.setColumns(10);
		dogum.setBounds(400, 84, 134, 23);
		contentPane.add(dogum);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HastaDuzenle doctor=new HastaDuzenle();
				doctor.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(10, 287, 116, 28);
		contentPane.add(btnGeri);
		
		JButton btnGncelle = new JButton("Ekle");
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "INSERT INTO hasta " +
			    "VALUES( '" + ad.getText() + "', '" + soyad.getText() + "', '" + tc.getText() + "' ,'" + tel.getText() + "',"
			    		+ " '" + sgk.getText() +  "', nextval('hastaNoSeq'), '" + dogum.getText() + "', '" + cinsiyet.getText() + "', "
			    				+ "'" + boy.getText() +"', '" + kilo.getText() + "', '" + adre.getText() + "')";
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
		btnGncelle.setBounds(454, 290, 116, 28);
		contentPane.add(btnGncelle);
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet: ");
		lblCinsiyet.setForeground(new Color(255, 255, 255));
		lblCinsiyet.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCinsiyet.setBounds(10, 201, 81, 28);
		contentPane.add(lblCinsiyet);
		
		cinsiyet = new JTextField();
		cinsiyet.setText((String) null);
		cinsiyet.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cinsiyet.setColumns(10);
		cinsiyet.setBounds(96, 206, 134, 23);
		contentPane.add(cinsiyet);
	}
}
