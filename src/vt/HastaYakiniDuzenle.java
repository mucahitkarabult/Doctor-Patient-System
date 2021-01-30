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

public class HastaYakiniDuzenle extends JFrame {

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
					HastaYakiniDuzenle frame = new HastaYakiniDuzenle();
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
	public HastaYakiniDuzenle() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Insert_doctor.class.getResource("/vt/medical-127-129383.png")));
		setTitle("Hasta Yak\u0131n\u0131 \u0130\u015Flemleri");
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
		
		JLabel lblNewLabel = new JLabel("Hasta Yak\u0131n\u0131 \u0130\u015Flemleri");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 47));
		lblNewLabel.setBounds(34, 11, 685, 44);
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(32, 178, 170)));
		panel_1_2.setBackground(new Color(176, 224, 230));
		panel_1_2.setBounds(31, 114, 871, 334);
		panel.add(panel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 26, 815, 282);
		panel_1_2.add(scrollPane);
		conn=SqlConnect.dbConnector();
		JTable table = new JTable();
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"72345678952", "12345678912", "Gamze", "Ka\u015F", null, "k\u0131z\u0131"},
				{"48345678912", "12343567891", "Hatice", "Ta\u015F", null, "e\u015Fi"},
				{"67345678912", "32345678912", "\u00D6mer", "Kara", null, "e\u015Fi"},
				{"25345678912", "12345678921", "Miray", "G\u00FCm\u00FC\u015F", null, "e\u015Fi"},
				{"47345678912", "12345674212", "Murat", "Pala", null, "o\u011Flu"},
				{"56345678912", "32145678912", "Ay\u015Fe", "Demir", null, "k\u0131z\u0131"},
				{"89345678912", "86545678912", "Sevgi", "\u0130z", null, "k\u0131z\u0131"},
				{"12342178912", "12344568912", "Furkan", "Kurt", null, "o\u011Flu"},
				{"12349678912", "12345678732", "Ali", "Fener", null, "o\u011Flu"},
				{"12365678912", "12345670912", "Ecrin", "Hayrettin", null, "k\u0131z\u0131"},
			},
			new String[] {
				"tc_no", "hasta_tc_no", "ad", "soyad", "tel_no", "yakinlik_derecesi"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(72);
		table.getColumnModel().getColumn(4).setPreferredWidth(79);
		try {
			String query="select * from hasta_yakini";
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
		
		JButton Ekle = new JButton("Hasta Yak\u0131n\u0131 Ekle");
		Ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HastaYakiniEkle ekle = new HastaYakiniEkle();
				ekle.setVisible(true);
				dispose();
			}
		});
		Ekle.setBounds(236, 22, 192, 46);
		panel_1_3.add(Ekle);
		Ekle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JButton Sil = new JButton("Hasta Yak\u0131n\u0131 Sil");	
		Sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				String query =	"DELETE FROM hasta_yakini WHERE hasta_tc_no= '"+(String)model.getValueAt(table.getSelectedRow(), 2)+"'";
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
		Sil.setBounds(640, 22, 192, 46);
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
		btnGeri.setBounds(34, 22, 192, 46);
		panel_1_3.add(btnGeri);
		
		JButton Duzenle = new JButton("Hasta Yak\u0131n\u0131 D\u00FCzenle");
		Duzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				String tc = (String)model.getValueAt(table.getSelectedRow(), 1);
				String column = (String)model.getColumnName(table.getSelectedColumn());
				if(column.equals("htc_no") || column.equals("tc_no")) {
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
					String query =	"Update hasta_yakini SET "+ column+"='"+ tmp +"' WHERE hasta_tc_no = '"+(String)model.getValueAt(table.getSelectedRow(), 1)+"'";
					Statement s = null;
					try {
						s = conn.createStatement();
						s.executeUpdate(query);
						s.close();
						JOptionPane.showMessageDialog(null,tc + " TC numaralý hastanýn hasta yakýný bilgileri baþarýyla güncellendi.");
					} catch (SQLException e1) {
						try {
							String query1="select * from hasta_yakini";
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
		Duzenle.setBounds(438, 22, 192, 46);
		panel_1_3.add(Duzenle);
		Duzenle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		
		
		
	}
}
