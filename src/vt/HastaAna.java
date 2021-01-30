package vt;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;

public class HastaAna extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public HastaAna(String TC) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HastaAna.class.getResource("/vt/medical-127-129383.png")));
		setTitle("Hasta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 372);
		getContentPane().setLayout(null);
		setResizable(false);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(54,33,89));
		panel.setBounds(0, 0, 335, 404);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				P_bilgi profil=new P_bilgi(TC);
				profil.setVisible(true);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(135,135,135));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(85, 65 ,118));
			}
			
		});
		panel_1.setBackground(new Color(85,68,118));
		panel_1.setBounds(25, 103, 282, 66);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(21, 11, 46, 44);
		panel_1.add(lblNewLabel);
		ImageIcon imgIc = new ImageIcon(StartMenu.class.getResource("/vt/patient.png"));
		Image img = imgIc.getImage();
		Image imgscale = img.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
		imgIc = new ImageIcon(imgscale);
		lblNewLabel.setIcon(imgIc);
		
		JLabel lblNewLabel_1 = new JLabel("Profil Bilgilerim");
		lblNewLabel_1.setForeground(new Color(204 ,204, 204 ));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(77, 0, 205, 55);
		panel_1.add(lblNewLabel_1);
		
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AlinanHizmet hizmet=new AlinanHizmet(TC);
				hizmet.setVisible(true);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1_1.setBackground(new Color(135,135,135));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1_1.setBackground(new Color(85, 65 ,118));
			}
		});
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(85, 68, 118));
		panel_1_1.setBounds(25, 206, 282, 66);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ald\u0131\u011F\u0131m Hizmetler\r\n");
		lblNewLabel_1_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(77, 0, 205, 55);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(21, 11, 51, 44);
		panel_1_1.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.WHITE);
		imgIc = new ImageIcon(StartMenu.class.getResource("/vt/1.png"));
		img = imgIc.getImage();
		imgscale = img.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_SMOOTH);
		imgIc = new ImageIcon(imgscale);
		lblNewLabel_2.setIcon(imgIc);
		imgIc = new ImageIcon(StartMenu.class.getResource("/vt/pills.png"));
		img = imgIc.getImage();
		imgIc = new ImageIcon(imgscale);
			
		
	}
}






