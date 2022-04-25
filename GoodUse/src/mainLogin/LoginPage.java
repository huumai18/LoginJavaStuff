package mainLogin;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginPage extends JFrame {

	private Image img_logo = new ImageIcon(LoginPage.class.getResource("../res/Logo.png")).getImage()
			.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_user = new ImageIcon(LoginPage.class.getResource("../res/lock-icon.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_passwword = new ImageIcon(LoginPage.class.getResource("../res/Key.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_open = new ImageIcon(LoginPage.class.getResource("../res/Open.png")).getImage().getScaledInstance(40,
			40, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField password;
	private JLabel lblLoginMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 475);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlUser = new JPanel();
		pnlUser.setBackground(new Color(255, 255, 255));
		pnlUser.setBounds(239, 175, 346, 56);
		contentPane.add(pnlUser);
		pnlUser.setLayout(null);

		userName = new JTextField();
		userName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(userName.getText().equals("Username")) {
					userName.setText("");
				} else {
					userName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (userName.getText().equals("")) userName.setText("Username");
			}
		});
		
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setBorder(null);
		userName.setBackground(new Color(255, 255, 255));
		userName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		userName.setText("Username");
		userName.setBounds(24, 10, 264, 36);
		pnlUser.add(userName);
		userName.setColumns(10);

		JLabel lblUser = new JLabel("");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(284, 10, 52, 36);
		lblUser.setIcon(new ImageIcon(img_user));
		pnlUser.add(lblUser);

		JPanel pnlPwr = new JPanel();
		pnlPwr.setBackground(new Color(255, 255, 255));
		pnlPwr.setBounds(239, 249, 346, 56);
		contentPane.add(pnlPwr);
		pnlPwr.setLayout(null);

		password = new JPasswordField();
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (password.getText().equals("Password")) {
				password.setEchoChar('●');
				password.setText(""); } else { password.selectAll(); }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (password.getText().equals("")) 	password.setText("Password");
													
			}
		});
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setBorder(null);
		password.setEchoChar((char)0);
		password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		password.setText("Password");
		password.setBounds(22, 10, 264, 36);
		pnlPwr.add(password);

		JLabel lblPwr = new JLabel("");
		lblPwr.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwr.setBounds(284, 10, 52, 36);
		lblPwr.setIcon(new ImageIcon(img_passwword));
		pnlPwr.add(lblPwr);

		JPanel pnlLogin = new JPanel();
		pnlLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(userName.getText().equals("huumai18") && password.getText().equals("password")) {
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null, "Login Successful!");
					
				} else if (userName.getText().equals("") || userName.getText().equals("Username") ||
							password.getText().equals("") || password.getText().equals("Password")) {
					lblLoginMessage.setText("Please input all requirement!");
				} else {
					lblLoginMessage.setText("Your username or password are incorrect!");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlLogin.setBackground(new Color(57, 129, 150));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlLogin.setBackground(new Color(37, 209, 204));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlLogin.setBackground(new Color(175, 175, 175));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlLogin.setBackground(new Color(72, 209, 204));
			}
		});
		pnlLogin.setBackground(new Color(72, 209, 204));
		pnlLogin.setBounds(286, 348, 244, 56);
		contentPane.add(pnlLogin);
		pnlLogin.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(89, 10, 86, 36);
		pnlLogin.add(lblNewLabel);

		JLabel lblLogin = new JLabel("");
		lblLogin.setBounds(44, 10, 52, 46);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setIcon(new ImageIcon(img_open));
		pnlLogin.add(lblLogin);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure want to close this application?", "Confirmation",
						JOptionPane.YES_NO_OPTION) == 0)
					;
				LoginPage.this.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.BLACK);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblX.setBounds(797, 10, 23, 31);
		contentPane.add(lblX);

		JLabel LblLogo = new JLabel("");
		LblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		LblLogo.setBounds(274, 37, 256, 128);
		contentPane.add(LblLogo);
		LblLogo.setIcon(new ImageIcon(img_logo));
		
		lblLoginMessage.setForeground(new Color(255, 0, 0));
		lblLoginMessage.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMessage.setBounds(249, 315, 336, 28);
		contentPane.add(lblLoginMessage);
		setLocationRelativeTo(null);
	}
}
