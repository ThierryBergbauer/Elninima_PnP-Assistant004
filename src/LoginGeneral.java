

/*
 * This class handles the Login. Either redirects to a new Login or compares the given inputs with a config file.
 * If the data matches the config file can be read in. 
 * This provides the option to load a game or create a new game
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class LoginGeneral extends JFrame
{
	
	private final JPanel contentPane;
	final Properties prop = new Properties();
	InputStream input = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(final String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					final LoginGeneral frame = new LoginGeneral();
					frame.setVisible(true);
				} catch (final Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public LoginGeneral()
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		final String usernameAndPasswordText = "Enter Username and Password";
		this.contentPane.setLayout(new MigLayout("", "[74px][][][4px][176px][6px][58px][6px][55px][63px][]", "[25px][25px][][][][][]"));
		
		final JLabel lblLoginScreen = new JLabel("Login Screen");
		this.contentPane.add(lblLoginScreen, "cell 0 0,alignx left,aligny center");
		
		final JButton btnNewLogin = new JButton("New Login");
		btnNewLogin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				final NewLogin newLoginFrame = new NewLogin();
				newLoginFrame.setVisible(true);
			}
		});
		this.contentPane.add(btnNewLogin, "cell 0 1 6 1,alignx left,aligny top");
		
		final JLabel lblEnterUsernameAnd = new JLabel(usernameAndPasswordText);
		this.contentPane.add(lblEnterUsernameAnd, "cell 0 3,alignx left,aligny center");
		
		final JTextField UsernameTextField = new JTextField();
		this.contentPane.add(UsernameTextField, "cell 0 4,growx,aligny center");
		UsernameTextField.setColumns(10);
		
		final JLabel lblUsername = new JLabel("Username");
		this.contentPane.add(lblUsername, "cell 1 4,alignx left,aligny center");
		
		final JPasswordField LoginPassword = new JPasswordField();
		this.contentPane.add(LoginPassword, "cell 0 5,growx,aligny center");
		
		final JLabel lblPassword = new JLabel("Password");
		this.contentPane.add(lblPassword, "cell 1 5,alignx left,aligny center");
		
		final JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				try
				{
					LoginGeneral.this.input = new FileInputStream(UsernameTextField.getText() + "_config.properties");
					LoginGeneral.this.prop.load(LoginGeneral.this.input);
					if (LoginGeneral.this.prop.getProperty("Password").equals(new String(LoginPassword.getPassword())))
					{
						//TODO AfterLoginWelcom frame -> new Game/load Game -> In Game frame use MigLayout for Login
						JOptionPane.showMessageDialog(null, "Login succesfull");
						/*final InGameMain_Elninima inGameFrame = new InGameMain_Elninima();
						inGameFrame.setVisible(true);*/
						
						Main.isLoggedIn = true;
						LoginGeneral.this.contentPane.setVisible(false);
						LoginGeneral.this.contentPane.invalidate();
						LoginGeneral.this.dispose();
						
						/*SwingUtilities.updateComponentTreeUI(ElninimaMain.frame);
						ElninimaMain.frame.invalidate();
						ElninimaMain.frame.validate();
						ElninimaMain.frame.repaint();
						ElninimaMain.frame.setVisible(true);*/
					}
					else
						JOptionPane.showMessageDialog(null, "Wrong Password");
				} catch (final IOException error3)
				{
					error3.printStackTrace();
				} finally
				{
					if (LoginGeneral.this.input != null)
						try
						{
							LoginGeneral.this.input.close();
						} catch (final IOException error4)
						{
							error4.printStackTrace();
						}
				}
			}
		});
		
		this.contentPane.add(btnLogin, "cell 0 6,alignx left,aligny top");
	}
}
