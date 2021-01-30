package vt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

import net.proteanit.sql.DbUtils;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;

public class VerilenHizmet extends JFrame {

	private JPanel contentPane;
	Connection conn=null;
	private JTable table;
	private JTextField hastaAd;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VerilenHizmet(String tc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlinanHizmet.class.getResource("/vt/medical-127-129383.png")));
		setTitle("Al\u0131nan Hizmetler");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(54,33,89));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		conn =SqlConnect.dbConnector();
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaglikAna saglik=new SaglikAna(tc);
				saglik.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 81, 34);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 68, 452, 265);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			String query="	select verilenHizmet.* from verilenHizmet,hizmet where '"+ tc+"' = hizmet.saglikci_tc_no and hizmetad = hizmet.hizmet_ad";
			PreparedStatement pst = conn.prepareStatement (query);
			ResultSet rs =pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			hastaAd = new JTextField();
			hastaAd.setBounds(308, 25, 98, 20);
			contentPane.add(hastaAd);
			hastaAd.setColumns(10);
			
			JButton btnNewButton_1 = new JButton("Ara");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(hastaAd.getText().equals("")) {
						try {
							String query="	select verilenHizmet.* from verilenHizmet,hizmet where '"+ tc+"' = hizmet.saglikci_tc_no and hizmetad = hizmet.hizmet_ad";
							PreparedStatement pst = conn.prepareStatement (query);
							ResultSet rs =pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
						}catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}	
					}else{
						try {
								String query="select * from hast_bul('"+hastaAd.getText()+"','"+ tc+ "')";
								PreparedStatement pst = conn.prepareStatement (query);
								Object [][] model;
								ResultSet rs =pst.executeQuery();
								table.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	//					try {
	//						String query="select * from hasta_bul('"+hastaAd.getText()+"','"+ tc+ "')";
	//						PreparedStatement pst = conn.prepareStatement (query);
	//						ResultSet rs =pst.executeQuery();
	//						table.setModel(DbUtils.resultSetToTableModel(rs));
	//					} catch (Exception e) {
	//						// TODO Auto-generated catch block
	//						e.printStackTrace();
						
					}					
				}
				
					
					
					
			});
			btnNewButton_1.setBounds(413, 24, 49, 23);
			contentPane.add(btnNewButton_1);
			
			JLabel lblhad = new JLabel("Hasta Ad\u0131: ");
			lblhad.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblhad.setForeground(new Color(255, 255, 255));
			lblhad.setBounds(225, 25, 91, 21);
			contentPane.add(lblhad);
			
			JButton btnHastaEkle = new JButton("Hasta Ekle");
			btnHastaEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					HizmetHastaEkle ekle = new HizmetHastaEkle(tc);
					ekle.setVisible(true);
					dispose();
				}
			});
			btnHastaEkle.setBounds(111, 11, 104, 34);
			contentPane.add(btnHastaEkle);
			pst.close();
			}
	   catch(Exception e)
			{
		   	e.printStackTrace();
			}
	
		

		
	}
}
