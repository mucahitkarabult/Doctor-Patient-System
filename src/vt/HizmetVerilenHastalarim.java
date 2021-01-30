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
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class HizmetVerilenHastalarim extends JFrame {

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
	public HizmetVerilenHastalarim(String tc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlinanHizmet.class.getResource("/vt/medical-127-129383.png")));
		setTitle("Al\u0131nan Hizmetler");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 374);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(54,33,89));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		conn =SqlConnect.dbConnector();
		
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaglikAna saglik=new SaglikAna(tc);
				saglik.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 11, 104, 34);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 68, 818, 265);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			String query="select ha.* from hasta ha,hizmet hi,hastahizmet hh where hh.tcno_hasta = ha.htc_no "
					+ "and hh.hizmetAd = hi.hizmet_ad and hh.saglikci_tc_no = hi.saglikci_tc_no and hi.saglikci_tc_no ='"+tc+"'";
			PreparedStatement pst = conn.prepareStatement (query);
			ResultSet rs =pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			hastaAd = new JTextField();
			hastaAd.setBounds(645, 25, 98, 20);
			contentPane.add(hastaAd);
			hastaAd.setColumns(10);
			
			JButton btnNewButton_1 = new JButton("Ara");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(hastaAd.getText().equals("")) {
						try {
							String query="select hastalarým.* from hastalarým,hizmet where hizmet.saglikci_tc_no = '"+tc+"' and hastalarým.saglikci_tc_no = hizmet.saglikci_tc_no;";
							PreparedStatement pst = conn.prepareStatement (query);
							ResultSet rs =pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							pst.close();
							}
					   catch(Exception e)
							{
						   	e.printStackTrace();
							}
					}else {
						try {
							String query="select hastalarým.* from hastalarým,hizmet where hastalarým.had like '%"+hastaAd.getText() +"%' and "
									+ "hizmet.saglikci_tc_no = '"+tc+"' and hastalarým.saglikci_tc_no = hizmet.saglikci_tc_no;";
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
			});
			btnNewButton_1.setBounds(758, 22, 70, 23);
			contentPane.add(btnNewButton_1);
			
			JLabel lblhad = new JLabel("Hasta Ad\u0131: ");
			lblhad.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblhad.setForeground(new Color(255, 255, 255));
			lblhad.setBounds(567, 24, 91, 21);
			contentPane.add(lblhad);
			pst.close();
			}
	   catch(Exception e)
			{
		   	e.printStackTrace();
			}
	
		

		
	}
}
