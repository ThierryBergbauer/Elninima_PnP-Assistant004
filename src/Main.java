import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main
{
	
	private JFrame frame;
	public JScrollPane panelPlayerData;
	public JScrollPane panelMap;
	public JScrollPane panelConsole;
	public JScrollPane panelQuest;
	
	public static String username = "";
	public static boolean isLoggedIn = false;
	
	/*
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
					final Main window = new Main();
					window.frame.setVisible(true);
				} catch (final Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Main()
	{
		this.initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 1227, 730);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JMenuBar menuBar = new JMenuBar();
		this.frame.setJMenuBar(menuBar);
		
		final JMenu mnGeneral = new JMenu("General");
		menuBar.add(mnGeneral);
		
		final JMenuItem mntmLogin = new JMenuItem("Login");
		mnGeneral.add(mntmLogin);
		mntmLogin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				if (!isLoggedIn)
				{
					final LoginGeneral LoginFrame = new LoginGeneral();
					LoginFrame.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "You are still logged in. Try Logging out");
			}
		});
		
		final JMenuItem mnuLogout = new JMenuItem("Logout");
		mnGeneral.add(mnuLogout);
		mnuLogout.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				if (isLoggedIn)
				{
					isLoggedIn = false;
					;
					final LoginGeneral LoginFrame = new LoginGeneral();
					LoginFrame.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Not logged in");
			}
		});
		
		final JMenuItem mntmNewGame = new JMenuItem("New Game");
		mnGeneral.add(mntmNewGame);
		mntmNewGame.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				if (isLoggedIn)
					JOptionPane.showMessageDialog(null, "Creating new game");
				else
					JOptionPane.showMessageDialog(null, "Not logged in");
			}
		});
		
		final JMenuItem mntmLoadGame = new JMenuItem("Load Game");
		mnGeneral.add(mntmLoadGame);
		mntmLoadGame.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				if (isLoggedIn)
					JOptionPane.showMessageDialog(null, "Data loading");
				else
					JOptionPane.showMessageDialog(null, "Not logged in");
			}
		});
		
		final JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		final JMenuItem mntmMapView = new JMenuItem("Map View");
		mnView.add(mntmMapView);
		
		final JMenuItem mntmPlayaerDataView = new JMenuItem("Playaer Data View");
		mnView.add(mntmPlayaerDataView);
		
		final JMenuItem mntmConsoleeView = new JMenuItem("Consolee View");
		mnView.add(mntmConsoleeView);
		
		final JMenuItem mntmNpcView = new JMenuItem("NPC View");
		mnView.add(mntmNpcView);
		
		final JMenuItem mntmDiceView = new JMenuItem("Dice View");
		mnView.add(mntmDiceView);
		
		final JMenu mnProperties = new JMenu("Properties");
		menuBar.add(mnProperties);
		
		final JMenuItem mntmGeneralProperties = new JMenuItem("General Properties");
		mnProperties.add(mntmGeneralProperties);
		
		final JMenuItem mntmViewProperties = new JMenuItem("View Properties");
		mnProperties.add(mntmViewProperties);
		
		final JDesktopPane desktopPane = new JDesktopPane();
		this.frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		final JScrollPane panelPlayerData = new JScrollPane();
		//panelPlayerData.setTitle("Player Data");
		panelPlayerData.setBounds(1032, 0, 177, 446);
		desktopPane.add(panelPlayerData);
		
		final JScrollPane panelMap = new JScrollPane();
		//panelMap.setTitle("Map");
		panelMap.setBounds(269, 0, 764, 446);
		desktopPane.add(panelMap);
		
		final JScrollPane panelConsole = new JScrollPane();
		//panelConsole.setTitle("Consolee");
		panelConsole.setBounds(269, 444, 764, 213);
		desktopPane.add(panelConsole);
		

		final TextArea textAreaDisplay = new TextArea();
		panelConsole.setColumnHeaderView(textAreaDisplay);
		
		final JTextArea textAreaEntry = new JTextArea();
		panelConsole.setViewportView(textAreaEntry);
		textAreaDisplay.append("asdf\nasdf\nasdf\nasdf\nasdf\nasdf\nasdf\nasdf\nasdf\nasdf\nasdf\nasdf\nasdf\nasdf\nasdf");
		textAreaDisplay.addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(final KeyEvent e)
			{
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					final Console Con1 = new Console(username);
					Con1.addCommand(textAreaDisplay.getText());
					try
					{
						textAreaDisplay.setText(FileReaderLog.readFile1(username + "Log") + "\n");
					} catch (final FileNotFoundException e1)
					{
						e1.printStackTrace();
					} catch (final IOException e1)
					{
						e1.printStackTrace();
					}
				}
			}
			
			@Override
			public void keyTyped(final KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(final KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
		
		//final TextArea textArea = new TextArea();
		//panelConsole.getContentPane().add(textArea, BorderLayout.CENTER);
		//textArea.append("asdf");
		
		final JScrollPane panelQuest = new JScrollPane();
		//panelQuest.setTitle("Info & Quest");
		panelQuest.setBounds(1032, 444, 177, 213);
		desktopPane.add(panelQuest);
		
		final JScrollPane panelInventory = new JScrollPane();
		//panelInventory.setTitle("Inventory");
		panelInventory.setBounds(0, 444, 269, 213);
		desktopPane.add(panelInventory);
		
		final JScrollPane panelStats = new JScrollPane();
		//panelStats.setTitle("Stats");
		panelStats.setBounds(0, 0, 269, 446);
		desktopPane.add(panelStats);
	}
}
