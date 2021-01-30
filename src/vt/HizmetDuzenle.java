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

public class HizmetDuzenle extends JFrame {

	private JPanel contentPane;
	private JTextField isim;
	private JTextField tc;
	private JTable table;
	Connection conn=null;
	private JTextField ilac;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HizmetDuzenle frame = new HizmetDuzenle();
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
	public HizmetDuzenle() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Insert_doctor.class.getResource("/vt/medical-127-129383.png")));
		setTitle("Hizmet \u0130\u015Flemleri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 657);
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
		
		JLabel lblNewLabel = new JLabel("Hizmet \u0130\u015Flemleri");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 47));
		lblNewLabel.setBounds(34, 11, 685, 44);
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(32, 178, 170)));
		panel_1_1.setBackground(new Color(176, 224, 230));
		panel_1_1.setBounds(31, 114, 323, 334);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("HizmetAd\u0131");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(34, 119, 110, 30);
		panel_1_1.add(lblNewLabel_1);
		
		isim = new JTextField();
		isim.setBounds(34, 146, 133, 30);
		panel_1_1.add(isim);
		isim.setColumns(10);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("\u0130la\u00E7lar");
		lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_4_1.setBounds(34, 197, 110, 30);
		panel_1_1.add(lblNewLabel_1_4_1);
		
		ilac = new JTextField();
		ilac.setColumns(10);
		ilac.setBounds(34, 223, 133, 30);
		panel_1_1.add(ilac);
		
		JButton btnNewButton = new JButton("Girilenleri Temizle");
		btnNewButton.setBounds(73, 275, 174, 36);
		panel_1_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isim.setText("");
				tc.setText("");
				ilac.setText("");
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		tc = new JTextField();
		tc.setBounds(34, 71, 133, 30);
		panel_1_1.add(tc);
		tc.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sa\u011Fl\u0131k \u00C7al\u0131\u015Fan\u0131 TC");
		lblNewLabel_1_2.setBounds(34, 44, 179, 30);
		panel_1_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(32, 178, 170)));
		panel_1_2.setBackground(new Color(176, 224, 230));
		panel_1_2.setBounds(364, 114, 538, 334);
		panel.add(panel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 27, 477, 285);
		panel_1_2.add(scrollPane);
		conn=SqlConnect.dbConnector();
		JTable table = new JTable();
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				 "SaglikCalisaniTC", "hizmet_Ad", "ilaclar",
			}
		));
		try {
			String query="select * from hizmet";
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
		panel_1_3.setBounds(31, 484, 891, 90);
		panel.add(panel_1_3);
		
		JButton Ekle = new JButton("Hizmet Ekle");
		Ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	
				String query = "INSERT INTO employee(fname, lname, ssn, bdate, address, sex, salary, dno) " +
			12321z                       "VALUES( '" + ad + "', '" + soyad + "', '" + ssn + "' ,'" + dtarih + "', '" + address + 
			                       "', '" + sex + "', " + maas + ", " + dno + " )";*/
				String query = "INSERT INTO hizmet " +
			            "VALUES( '" + tc.getText() + "', '" + isim.getText() + "', '" + ilac.getText() + "')";
				System.out.println(query);
				PreparedStatement s = null;
				try {
						
					 	s= conn.prepareStatement(query);
					 	s.execute();
			            s.close();
				
					}
			   catch(Exception e1)
					{
				   JOptionPane.showMessageDialog(null, e1);
					}
				query="select * from hizmet";
				try {
					
					PreparedStatement pst = conn.prepareStatement (query);
					ResultSet rs =pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();

				
					}
			   catch(Exception e1)
					{
				   	e1.printStackTrace();
					}
			}
		});
		Ekle.setBounds(247, 22, 192, 46);
		panel_1_3.add(Ekle);
		Ekle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JButton Sil = new JButton("Hizmet Sil");
		Sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				String query =	"DELETE FROM hizmet WHERE hizmet_ad= '"+(String)model.getValueAt(table.getSelectedRow(), 1)+"' and saglikci_tc_no = '"+(String)model.getValueAt(table.getSelectedRow(), 0)+"' ";
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
		Sil.setBounds(651, 22, 192, 46);
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
		btnGeri.setBounds(45, 22, 192, 46);
		panel_1_3.add(btnGeri);
		
		JButton Duzenle = new JButton("Hizmeti D\u00FCzenle");
		Duzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				String column = (String)model.getColumnName(table.getSelectedColumn());
				if(column.equals("saglikci_tc_no")|| column.equals("hizmet_ad")) {
					JOptionPane.showMessageDialog(null, "TC_NO veya Hizmet Adý deðiþtiremezsiniz!!");
					try {
						String query="select * from hizmet";
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
					String query =	"Update hizmet SET "+ column +"='"+ tmp +"' WHERE hizmet_ad= '"+(String)model.getValueAt(table.getSelectedRow(), 1)+"' and saglikci_tc_no = '"+(String)model.getValueAt(table.getSelectedRow(), 0)+"' ";
					Statement s = null;
					try {
						s = conn.createStatement();
						s.executeUpdate(query);
						s.close();
						JOptionPane.showMessageDialog(null,"Hizmet bilgileri baþarýyla güncellendi.");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		Duzenle.setBounds(449, 22, 192, 46);
		panel_1_3.add(Duzenle);
		Duzenle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		
		
		
	}
}
