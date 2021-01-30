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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Insert_doctor extends JFrame {

	private JPanel contentPane;
	private JTextField isim;
	private JTextField soyisim;
	private JTextField essn;
	private JTextField sex;
	private JTextField brans;
	private JTable table;
	Connection conn=null;
	private JTextField salary;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_doctor frame = new Insert_doctor();
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
	public Insert_doctor() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Insert_doctor.class.getResource("/vt/medical-127-129383.png")));
		setTitle("Doktor \u0130\u015Flemleri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 646);
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
		
		JLabel lblNewLabel = new JLabel("Doktor \u0130\u015Flemleri");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 47));
		lblNewLabel.setBounds(26, 11, 685, 55);
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(32, 178, 170)));
		panel_1_1.setBackground(new Color(176, 224, 230));
		panel_1_1.setBounds(31, 114, 323, 334);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u0130sim");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(34, 70, 110, 30);
		panel_1_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Soyisim\r\n");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(34, 111, 110, 30);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Cinsiyet\r\n");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(34, 152, 110, 30);
		panel_1_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Bran\u015F");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(34, 193, 110, 30);
		panel_1_1.add(lblNewLabel_1_4);
		
		isim = new JTextField();
		isim.setBounds(152, 70, 133, 30);
		panel_1_1.add(isim);
		isim.setColumns(10);
		
		soyisim = new JTextField();
		soyisim.setColumns(10);
		soyisim.setBounds(152, 111, 133, 30);
		panel_1_1.add(soyisim);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(152, 152, 133, 30);
		panel_1_1.add(sex);
		
		brans = new JTextField();
		brans.setColumns(10);
		brans.setBounds(152, 193, 133, 30);
		panel_1_1.add(brans);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Maa\u015F");
		lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_4_1.setBounds(34, 234, 110, 30);
		panel_1_1.add(lblNewLabel_1_4_1);
		
		salary = new JTextField();
		salary.setColumns(10);
		salary.setBounds(152, 234, 133, 30);
		panel_1_1.add(salary);
		
		JButton btnNewButton = new JButton("Girilenleri Temizle");
		btnNewButton.setBounds(73, 275, 174, 36);
		panel_1_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isim.setText("");
				soyisim.setText("");
				essn.setText("");
				sex.setText("");
				brans.setText("");
				salary.setText("");
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		essn = new JTextField();
		essn.setBounds(152, 29, 133, 30);
		panel_1_1.add(essn);
		essn.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("TC\r\n");
		lblNewLabel_1_2.setBounds(34, 29, 110, 30);
		panel_1_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(32, 178, 170)));
		panel_1_2.setBackground(new Color(176, 224, 230));
		panel_1_2.setBounds(364, 114, 538, 334);
		panel.add(panel_1_2);
		JComboBox comboBox = new JComboBox();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 27, 477, 285);
		panel_1_2.add(scrollPane);
		conn=SqlConnect.dbConnector();
		JTable table = new JTable();
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u0130sim", "Soy\u0130sim", "TC", "Cinsiyet", "Brans"
			}
		));
		try {
			String query="select * from saglik_calisani order by maas ";
			PreparedStatement pst = conn.prepareStatement (query);
			ResultSet rs =pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			}
	   catch(Exception e)
			{
		   	e.printStackTrace();
			}
		table.getColumnModel().getColumn(3).setPreferredWidth(72);
		table.getColumnModel().getColumn(4).setPreferredWidth(79);
		scrollPane.setViewportView(table);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(32, 178, 170)));
		panel_1_3.setBackground(new Color(176, 224, 230));
		panel_1_3.setBounds(31, 484, 871, 90);
		panel.add(panel_1_3);
		
		JButton Ekle = new JButton("Doktoru Ekle");
		Ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	
				String query = "INSERT INTO employee(fname, lname, ssn, bdate, address, sex, salary, dno) " +
			12321z                       "VALUES( '" + ad + "', '" + soyad + "', '" + ssn + "' ,'" + dtarih + "', '" + address + 
			                       "', '" + sex + "', " + maas + ", " + dno + " )";*/
				String query = "INSERT INTO saglik_calisani(tc_no, ad, soyad, cinsiyet, brans,maas) " +
			            "VALUES( '" + essn.getText() + "', '" + isim.getText() + "', '" + soyisim.getText() + "' ,'" + sex.getText() + "', '" + brans.getText() +  "'," + salary.getText() +")";
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
				query="select * from saglik_calisani";
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
		Ekle.setBounds(241, 22, 192, 46);
		panel_1_3.add(Ekle);
		Ekle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JButton Sil = new JButton("Doktoru Sil");
		Sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				String query =	"DELETE FROM saglik_calisani WHERE tc_no= '"+(String)model.getValueAt(table.getSelectedRow(), 0)+"'";
				String x=(String) model.getValueAt(table.getSelectedRow(), 0);
				System.out.println(x);
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
		Sil.setBounds(645, 22, 192, 46);
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
		btnGeri.setBounds(39, 22, 192, 46);
		panel_1_3.add(btnGeri);
		
		JButton Duzenle = new JButton("Doktoru D\u00FCzenle");
		Duzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				String tc = (String)model.getValueAt(table.getSelectedRow(), 0);
				String column = (String)model.getColumnName(table.getSelectedColumn());
				if(column.equals("tc_no")) {
					JOptionPane.showMessageDialog(null, "TC numaarasý deðiþtiremezsin.");
					try {
						String query="select * from saglik_calisani";
						PreparedStatement pst = conn.prepareStatement (query);
						ResultSet rs =pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						pst.close();
						}
				   catch(Exception e)
						{
					   	e.printStackTrace();
						}
				}else if(column.equals("maas")){
					String query;
					String tmp = (String) model.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
					int tmp1=Integer.parseInt(tmp); 
					
					if(tmp1>30000) {
						JOptionPane.showMessageDialog(null,"Maaþ 30000'den fazla olamaz .Trigger tetiklendi.");
						 query =	"Update saglik_calisani SET "+ column+"='"+ "30000" +"' WHERE tc_no= '"+(String)model.getValueAt(table.getSelectedRow(), 0)+"'";
						
							String x=(String) model.getValueAt(table.getSelectedRow(), 0);
						
							Statement s = null;
							try {
								s = conn.createStatement();
								s.executeUpdate(query);
								s.close();
								JOptionPane.showMessageDialog(null,tc + " TC numaralý doktorun yeni bilgileri baþarýyla güncellendi.");
								try {
									String query1="select * from saglik_calisani";
									PreparedStatement pst = conn.prepareStatement (query1);
									ResultSet rs =pst.executeQuery();
									table.setModel(DbUtils.resultSetToTableModel(rs));
									pst.close();
									}
							   catch(Exception e)
									{
								   	e.printStackTrace();
									}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
					else {
						
						
						query =	"Update saglik_calisani SET "+ column+"='"+ tmp +"' WHERE tc_no= '"+(String)model.getValueAt(table.getSelectedRow(), 0)+"'";
						String x=(String) model.getValueAt(table.getSelectedRow(), 0);
						System.out.println(x);
						Statement s = null;
						try {
							s = conn.createStatement();
							s.executeUpdate(query);
							s.close();
							JOptionPane.showMessageDialog(null,tc + " TC numaralý doktorun yeni bilgileri baþarýyla güncellendi.");
							try {
								String query1="select * from saglik_calisani";
								PreparedStatement pst = conn.prepareStatement (query1);
								ResultSet rs =pst.executeQuery();
								table.setModel(DbUtils.resultSetToTableModel(rs));
								pst.close();
								}
						   catch(Exception e)
								{
							   	e.printStackTrace();
								}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					
				}else {
					String tmp = (String) model.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
					String query =	"Update saglik_calisani SET "+ column+"='"+ tmp +"' WHERE tc_no= '"+(String)model.getValueAt(table.getSelectedRow(), 0)+"'";
					String x=(String) model.getValueAt(table.getSelectedRow(), 0);
					System.out.println(x);
					Statement s = null;
					try {
						s = conn.createStatement();
						s.executeUpdate(query);
						s.close();
						JOptionPane.showMessageDialog(null,tc + " TC numaralý doktorun yeni bilgileri baþarýyla güncellendi.");
						try {
							String query1="select * from saglik_calisani";
							PreparedStatement pst = conn.prepareStatement (query1);
							ResultSet rs =pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							pst.close();
							}
					   catch(Exception e)
							{
						   	e.printStackTrace();
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		Duzenle.setBounds(443, 22, 192, 46);
		panel_1_3.add(Duzenle);
		Duzenle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		comboBox.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				switch (comboBox.getSelectedIndex()) {
				case 0:
					try {
						String query="select * from saglik_calisani order by maas ";
						PreparedStatement pst = conn.prepareStatement (query);
						ResultSet rs =pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						pst.close();
						}
				   catch(Exception e1)
						{
					   	e1.printStackTrace();
						}
					break;
				case 1:
					try {
						String query="select * from saglik_calisani order by maas Desc";
						PreparedStatement pst = conn.prepareStatement (query);
						ResultSet rs =pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						pst.close();
						}
				   catch(Exception e1)
						{
					   	e1.printStackTrace();
						}
					break;
				case 2:
					try {
						String query="select * from saglik_calisani where maas<(select avg(maas) from saglik_calisani) order by maas";
						PreparedStatement pst = conn.prepareStatement (query);
						ResultSet rs =pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						pst.close();
						}
				   catch(Exception e1)
						{
					   	e1.printStackTrace();
						}
					break;
				case 3:
					try {
						String query="select * from saglik_calisani where maas>(select avg(maas) from saglik_calisani) order by maas";
						PreparedStatement pst = conn.prepareStatement (query);
						ResultSet rs =pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						pst.close();
						}
				   catch(Exception e1)
						{
					   	e1.printStackTrace();
						}
					break;
				default:
					break;
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Maa\u015F Azdan \u00C7o\u011Fa", "Maa\u015F \u00C7oktan Aza", "Ortalama Maa\u015F Alt\u0131 Alanlar", "Ortalama Maa\u015F \u00DCst\u00FC Alanlar"}));
		comboBox.setBounds(688, 92, 167, 22);
		panel.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Bo\u015Ftaki Doktorlar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BostakiDoktorlar doktr = new BostakiDoktorlar();
				doktr.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(396, 92, 123, 23);
		panel.add(btnNewButton_1);
		
		
		
		
	}
}
