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

public class AlinanHizmet extends JFrame {

	private JPanel contentPane;
	Connection conn=null;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AlinanHizmet(String tc) {
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
				HastaAna admin=new HastaAna(tc);
				admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 104, 34);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 68, 452, 265);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			String query="select hizmetAd, dr.ad ,dr.soyad, ilaclar from hizmet, hastahizmet, saglik_calisani dr where '"+tc+"' = tcno_hasta and  dr.tc_no = hastahizmet.saglikci_tc_no and hastahizmet.saglikci_tc_no = hizmet.saglikci_tc_no and hizmet.hizmet_ad=hastahizmet.hizmetAd";
			PreparedStatement pst = conn.prepareStatement (query);
			ResultSet rs =pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();

		
			}
	   catch(Exception e)
			{
		   	e.printStackTrace();
			}
	
		

		
	}
}
