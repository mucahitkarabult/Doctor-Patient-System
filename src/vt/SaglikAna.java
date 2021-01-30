package vt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
public class SaglikAna extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public SaglikAna(String Tc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SaglikAna.class.getResource("/vt/medical-127-129383.png")));
		setTitle("Sa\u011Fl\u0131k \u00C7al\u0131\u015Fan\u0131");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
				
		panel.setBounds(0, 0, 434, 415);
		panel.setBackground(new Color(54,33,89));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel bilgilerim = new JPanel();
		bilgilerim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bilgilerim.setBackground(new Color(135,135,135));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bilgilerim.setBackground(new Color(85, 65 ,118));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				D_bilgileri  doc=new D_bilgileri(Tc);
				doc.setVisible(true);
				dispose();
				
			}
		});
		bilgilerim.setBackground(new Color(85,68,118));
		bilgilerim.setBounds(10, 56, 410, 75);
		panel.add(bilgilerim);
		bilgilerim.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(10, 10, 62, 53);
		bilgilerim.add(lblNewLabel);
		
		ImageIcon imgIc = new ImageIcon(StartMenu.class.getResource("/vt/doctor.png"));
		Image img = imgIc.getImage();
		Image imgscale = img.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
		imgIc = new ImageIcon(imgscale);
		lblNewLabel.setIcon(imgIc);
		JLabel lblNewLabel_1 = new JLabel("Bilgilerim\r\n");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(204 ,204, 204 ));
		lblNewLabel_1.setBounds(76, -1, 324, 64);
		
		bilgilerim.add(lblNewLabel_1);
		
		JPanel hizmetlerim = new JPanel();
		hizmetlerim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VerilenHizmet hizmet = new VerilenHizmet(Tc);
				hizmet.setVisible(true);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				hizmetlerim.setBackground(new Color(135,135,135));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hizmetlerim.setBackground(new Color(85, 65 ,118));
			}
		});
		hizmetlerim.setBackground(new Color(85,68,118));
		hizmetlerim.setLayout(null);
		hizmetlerim.setBounds(10, 182, 410, 75);
		panel.add(hizmetlerim);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 10, 62, 53);
		hizmetlerim.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hizmetlerim\r\n");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(76, -1, 324, 64);
		lblNewLabel_1_1.setForeground(new Color(204 ,204, 204 ));
		hizmetlerim.add(lblNewLabel_1_1);
		
		imgIc = new ImageIcon(StartMenu.class.getResource("/vt/heart.png"));
		img = imgIc.getImage();
		imgscale = img.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_SMOOTH);
		imgIc = new ImageIcon(imgscale);
		lblNewLabel_2.setIcon(imgIc);
		
		
		JPanel hasta_islemler = new JPanel();
		hasta_islemler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HizmetVerilenHastalarim hasta = new HizmetVerilenHastalarim(Tc);
				hasta.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				hasta_islemler.setBackground(new Color(135,135,135));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hasta_islemler.setBackground(new Color(85, 65 ,118));
			}
		});
		hasta_islemler.setBackground(new Color(85,68,118));
		hasta_islemler.setLayout(null);
		hasta_islemler.setBounds(10, 297, 410, 75);
		panel.add(hasta_islemler);
		
		JLabel lblNewLabel_3 = new JLabel();
		
		
		lblNewLabel_3.setBounds(10, 10, 62, 53);
		hasta_islemler.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Hasta \u0130\u015Flemleri\r\n");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_1_2.setForeground(new Color(204 ,204, 204 ));
		lblNewLabel_1_2.setBounds(82, -1, 324, 64);
		hasta_islemler.add(lblNewLabel_1_2);
		
		imgIc = new ImageIcon(StartMenu.class.getResource("/vt/Patience.png"));
		img = imgIc.getImage();
		imgscale = img.getScaledInstance(lblNewLabel_3.getWidth(),lblNewLabel_3.getHeight(),Image.SCALE_SMOOTH);
		imgIc = new ImageIcon(imgscale);
		lblNewLabel_3.setIcon(imgIc);
		
		
	}	
	}


