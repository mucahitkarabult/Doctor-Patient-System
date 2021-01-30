package vt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class HastaDuzenle extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection conn=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaDuzenle frame = new HastaDuzenle();
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
	public HastaDuzenle() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Insert_doctor.class.getResource("/vt/medical-127-129383.png")));
		setTitle("Hastalar\u0131 D\u00FCzenle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(32, 178, 170)));
		panel.setBounds(0, 0, 932, 617);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(32, 178, 170)));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(31, 26, 871, 66);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Hasta D\u00FCzenleme");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 47));
		lblNewLabel.setBounds(34, 11, 685, 44);
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(32, 178, 170)));
		panel_1_2.setBackground(new Color(176, 224, 230));
		panel_1_2.setBounds(31, 113, 871, 359);
		panel.add(panel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 27, 813, 303);
		panel_1_2.add(scrollPane);
		conn=SqlConnect.dbConnector();
		JTable table = new JTable();
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Veli", "Ta\u015F", "12343567891", "5323764532", "234567958123", null, null, "erkek", "181", "70", "Esenler mah. Menek\u015Fe sok. 3/2 Kad\u0131k\u00F6y/\u0130stanbul                                                                                                                                                                                                                                                                                                                                                                                                                                                                      "},
				{"Asl\u0131", "Kara", "32345678912", "5328264532", "234567096123", null, null, "kad\u0131n", "169", "65", "\u00C7iftehavuzlar mah. Ku\u015Fkonmaz sok. 3/73 Kartal/\u0130stanbul                                                                                                                                                                                                                                                                                                                                                                                                                                                              "},
				{"Rag\u0131p", "G\u00FCm\u00FC\u015F", "12345678921", "5321764532", "234593590123", null, null, "erkek", "163", "90", "\u00C7i\u00E7ek\u00E7i mah. Karanfil sok. 3/23 Zeytinburnu/\u0130stanbul                                                                                                                                                                                                                                                                                                                                                                                                                                                                "},
				{"Cenk", "Pala", "12345674212", "5328434532", "234567863123", null, null, "erkek", "184", "85", "Burhaniye mah. Leylak sok. 3/63 \u00DCmraniye/\u0130stanbul                                                                                                                                                                                                                                                                                                                                                                                                                                                                   "},
				{"Seyfi", "Demir", "32145678912", "5328654532", "234567901253", null, null, "erkek", "185", "70", "Y\u0131ld\u0131r\u0131m mah. Kat sok. 3/27 Kad\u0131k\u00F6y/\u0130stanbul                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "},
				{"Mahir", "\u0130z", "86545678912", "5328764542", "234567861123", null, null, "erkek", "186", "75", "Balkan mah. Tan sok. 3/22 Sar\u0131yer/\u0130stanbul                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "},
				{"Leman", "Kurt", "12344568912", "5328634532", "234567890993", null, null, "kad\u0131n", "157", "83", "Altunizade mah. Fener sok. 32/23 Be\u015Fikta\u015F/\u0130stanbul                                                                                                                                                                                                                                                                                                                                                                                                                                                                  "},
				{"Zeki", "Fener", "12345678732", "5328764952", "234567808123", null, null, "erkek", "188", "86", "Ac\u0131badem mah. B\u00FClb\u00FCl sok. 33/23 /\u0130stanbul                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "},
				{"Barbaros", "Hayrettin", "12345670912", "5325964532", "234577890123", null, null, "erkek", "189", "88", "\u0130stinye mah. Keten sok. 3/83 \u00DCsk\u00FCdar/\u0130stanbul                                                                                                                                                                                                                                                                                                                                                                                                                                                                       "},
				{"Ali", "Ka\u015F", "12345678912", "5320764599", "234564350123", null, null, "erkek", "180", "80", "Barbaros mah. Gonca sok. 3/53 \u00DCsk\u00FCdar/\u0130stanbul                                                                                                                                                                                                                                                                                                                                                                                                                                                                      "},
			},
			new String[] {
				"Ad", "Soyad", "TC", "tel_no", "sgk_no", "hasta_no", "dogum_tarihi", "cinsiyet", "boy", "kilo", "adres"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(79);
		table.getColumnModel().getColumn(2).setMinWidth(79);
		table.getColumnModel().getColumn(2).setMaxWidth(79);
		table.getColumnModel().getColumn(3).setPreferredWidth(72);
		table.getColumnModel().getColumn(3).setMinWidth(72);
		table.getColumnModel().getColumn(3).setMaxWidth(72);
		table.getColumnModel().getColumn(4).setPreferredWidth(81);
		table.getColumnModel().getColumn(4).setMinWidth(81);
		table.getColumnModel().getColumn(4).setMaxWidth(81);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setMinWidth(90);
		table.getColumnModel().getColumn(5).setMaxWidth(90);
		table.getColumnModel().getColumn(6).setMinWidth(75);
		table.getColumnModel().getColumn(6).setMaxWidth(75);
		table.getColumnModel().getColumn(7).setPreferredWidth(51);
		table.getColumnModel().getColumn(7).setMinWidth(51);
		table.getColumnModel().getColumn(7).setMaxWidth(51);
		table.getColumnModel().getColumn(8).setPreferredWidth(28);
		table.getColumnModel().getColumn(8).setMinWidth(28);
		table.getColumnModel().getColumn(8).setMaxWidth(28);
		table.getColumnModel().getColumn(9).setPreferredWidth(28);
		table.getColumnModel().getColumn(9).setMinWidth(28);
		table.getColumnModel().getColumn(9).setMaxWidth(28);
		table.getColumnModel().getColumn(10).setPreferredWidth(276);
		try {
			String query="select * from hasta";
			PreparedStatement pst = conn.prepareStatement (query);
			ResultSet rs =pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			}
	   catch(Exception e)
			{
		   	e.printStackTrace();
			}
		scrollPane.setViewportView(table);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(32, 178, 170)));
		panel_1_3.setBackground(new Color(176, 224, 230));
		panel_1_3.setBounds(31, 484, 871, 90);
		panel.add(panel_1_3);
		
		JButton Ekle = new JButton("Hasta Ekle");
		Ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaEkle doctor=new HastaEkle();
				doctor.setVisible(true);
				dispose();
			}
		});
		Ekle.setBounds(239, 22, 192, 46);
		panel_1_3.add(Ekle);
		Ekle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JButton Sil = new JButton("Hasta Sil");
		Sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				String query =	"DELETE FROM hasta WHERE htc_no= '"+(String)model.getValueAt(table.getSelectedRow(), 2)+"'";
				model.removeRow(table.getSelectedRow());
				Statement s = null;
				try {
					s = conn.createStatement();
					s.executeUpdate(query);
					s.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Sil.setBounds(643, 22, 192, 46);
		panel_1_3.add(Sil);
		Sil.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminAna admin=new AdminAna();
				dispose();
				admin.setVisible(true);
			}
		});
		btnGeri.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnGeri.setBounds(37, 22, 192, 46);
		panel_1_3.add(btnGeri);
		
		JButton Duzenle = new JButton("Hasta D\u00FCzenle");
		Duzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				String tc = (String)model.getValueAt(table.getSelectedRow(), 2);
				String column = (String)model.getColumnName(table.getSelectedColumn());
				if(column.equals("htc_no")) {
					JOptionPane.showMessageDialog(null, "TC numarasý deðiþtiremezsin.");
					try {
						String query="select * from hasta";
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
					String tmp = (String) model.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
					String query =	"Update hasta SET "+ column+"='"+ tmp +"' WHERE htc_no= '"+(String)model.getValueAt(table.getSelectedRow(), 2)+"'";
					Statement s = null;
					try {
						s = conn.createStatement();
						s.executeUpdate(query);
						s.close();
						JOptionPane.showMessageDialog(null,tc + " TC numaralý hastanýn bilgileri baþarýyla güncellendi.");
					} catch (SQLException e1) {
						try {
							String query1="select * from hasta";
							PreparedStatement pst = conn.prepareStatement (query1);
							ResultSet rs =pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							pst.close();
							}
					   catch(Exception e)
							{
						   	e.printStackTrace();
							}
						e1.printStackTrace();
					}
				}
			}
		});
		Duzenle.setBounds(441, 22, 192, 46);
		panel_1_3.add(Duzenle);
		Duzenle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		
		
		
	}
}
