package vt;

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
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Color;

public class AdminAna extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAna frame = new AdminAna();
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
	public AdminAna() {
		setBounds(new Rectangle(0, 0, 219, 0));
		setResizable(false);
		setTitle("Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminAna.class.getResource("/vt/medical-127-129383.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 278, 342);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblStartLogo = new JLabel();
		lblStartLogo.setBounds(77, 11, 118, 101);

		ImageIcon imgIc = new ImageIcon(StartMenu.class.getResource("/vt/adminn.png"));
		Image img = imgIc.getImage();
		Image imgscale = img.getScaledInstance(lblStartLogo.getWidth(),lblStartLogo.getHeight(),Image.SCALE_SMOOTH);
		imgIc = new ImageIcon(imgscale);
		contentPane.setLayout(null);
		lblStartLogo.setIcon(imgIc);
		getContentPane().add(lblStartLogo);
		
		JButton btnDoktorEkle = new JButton("Sa\u011Fl\u0131k \u00C7al\u0131\u015Fanlar\u0131n\u0131 \u0130\u015Flemleri");
		btnDoktorEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert_doctor doctor=new Insert_doctor();
				doctor.setVisible(true);
				dispose();
			}
		});
		btnDoktorEkle.setBounds(52, 123, 167, 31);
		getContentPane().add(btnDoktorEkle);
		
		JButton btnHizmetEkle = new JButton("Hizmet \u0130\u015Flemleri");
		btnHizmetEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HizmetDuzenle hizmet=new HizmetDuzenle();
				hizmet.setVisible(true);
				dispose();
			}
		});
		btnHizmetEkle.setBounds(52, 165, 167, 31);
		contentPane.add(btnHizmetEkle);
		
		JButton btnHastaEkle = new JButton("Hasta \u0130\u015Flemleri");
		btnHastaEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HastaDuzenle hasta=new HastaDuzenle();
				hasta.setVisible(true);
				dispose();
			}
		});
		btnHastaEkle.setBounds(52, 209, 167, 31);
		contentPane.add(btnHastaEkle);
		
		JButton btnHastaYaknEkle = new JButton("Hasta Yak\u0131nlar\u0131 \u0130\u015Flemleri");
		btnHastaYaknEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HastaYakiniDuzenle hastaY=new HastaYakiniDuzenle();
				hastaY.setVisible(true);
				dispose();
			}
		});
		btnHastaYaknEkle.setBounds(52, 251, 167, 31);
		contentPane.add(btnHastaYaknEkle);
	}
}
