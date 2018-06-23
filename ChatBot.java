package builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

public class ChatBot {

	private JFrame frmChatbotV;
	private JTextField txtTalkingBotV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatBot window = new ChatBot();
					window.frmChatbotV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChatBot() {
		initialize();
	}
	String Name;
	String Bot;
	String input;
	String you;
	
	private JTabbedPane tabbedPane;
	private JPanel infoPanel;
	private JPanel chatPanel;
	private JLabel label;
	private JTextField txtName;
	private JLabel label_1;
	private JTextField txtBot;
	private JButton btnSubmit;
	private JTextField txtInput;
	private JTextArea txtRespond;
	private JButton btnSend;
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChatbotV = new JFrame();
		frmChatbotV.setTitle("ChatBot v1.0");
		frmChatbotV.setBounds(350, 150, 603, 400);
		frmChatbotV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChatbotV.getContentPane().setLayout(null);
		
		txtTalkingBotV = new JTextField();
		txtTalkingBotV.setEditable(false);
		txtTalkingBotV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTalkingBotV.setText("Talking Bot v1");
		txtTalkingBotV.setHorizontalAlignment(SwingConstants.CENTER);
		txtTalkingBotV.setBounds(0, 0, 587, 23);
		frmChatbotV.getContentPane().add(txtTalkingBotV);
		txtTalkingBotV.setColumns(10);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(10, 23, 567, 327);
		frmChatbotV.getContentPane().add(tabbedPane);
		
		infoPanel = new JPanel();
		tabbedPane.addTab("Information", null, infoPanel, null);
		infoPanel.setLayout(null);
		
		label = new JLabel("Name :");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label.setBounds(126, 59, 45, 23);
		infoPanel.add(label);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(181, 59, 147, 30);
		infoPanel.add(txtName);
		
		label_1 = new JLabel("Bot's Name :");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_1.setBounds(91, 108, 80, 27);
		infoPanel.add(label_1);
		
		txtBot = new JTextField();
		txtBot.setColumns(10);
		txtBot.setBounds(181, 105, 147, 30);
		infoPanel.add(txtBot);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Name = txtName.getText();
				Bot = txtBot.getText();
				if(!Name.equals("") && !Bot.equals(""))
				{
				btnSubmit.setText("Update");
				btnSend.setEnabled(true);
				txtInput.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Name and Bot's name are missing! \nPlease fill these information");
							
				}
				
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSubmit.setBounds(203, 146, 89, 23);
		infoPanel.add(btnSubmit);
		
		chatPanel = new JPanel();
		tabbedPane.addTab("ChatBox", null, chatPanel, null);
		chatPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Say Something Here");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 134, 14);
		chatPanel.add(lblNewLabel);
		
		txtInput = new JTextField();
		txtInput.setEnabled(false);
		txtInput.setBounds(10, 27, 377, 20);
		chatPanel.add(txtInput);
		txtInput.setColumns(10);
		
		txtRespond = new JTextArea();
		txtRespond.setWrapStyleWord(true);
		txtRespond.setLineWrap(true);
		txtRespond.setEditable(false);
		txtRespond.setBounds(10, 58, 470, 253);
		chatPanel.add(txtRespond);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				you = Name+": "+txtInput.getText()+"\n";
				input = txtInput.getText();
				txtRespond.append(you);
				txtInput.setText("");
				
				if(input.contains("hello") || input.contains("Hello"))
				{
					txtRespond.append(Bot+": Hello, "+Name+"!! \n");
				}
				else if(input.equals("hi") || input.equals("Hi"))
				{
					txtRespond.append(Bot+": Hi there, "+Name+"!! \n");
				}
				else if(input.contains("how are you") || input.contains("whatzup"))
				{
					txtRespond.append(Bot+": Cool, how about you? "+"\n");
				}
				else if(input.contains("fine") || input.contains("i am fine"))
				{
					txtRespond.append(Bot+": Glad to know that. "+"\n");
				}
				else if(input.contains("who was steve jobs") || input.contains("steve jobs"))
				{
					txtRespond.append(Bot+": he was an apple farmer. "+"\n");
				}
				else if(input.contains("who was newton") || input.contains("newton"))
				{
					txtRespond.append(Bot+": he was an illiterate man. "+"\n");
				}
				else if(input.contains("are you a robot") 
						|| input.contains("are you a human") 
						|| input.contains("are you a child")
						|| input.contains("are you a man") 			
						|| input.contains("are you a woman"))
				{
					txtRespond.append(Bot+": i think i am not. "+"\n");
				}
				else if(input.contains("you are so stupid") || input.contains("you are a stupid"))
				{
					txtRespond.append(Bot+": I can say the same -_- "+"\n");
				}
				else if(input.contains("totally rubbish") 
						|| input.contains("idiot") 
						|| input.contains("stupid")
						|| input.contains("nonsense"))
				{
					txtRespond.append(Bot+": hey,Why are you mad at me? "+"\n");
				}
				else if(input.contains("you are so wrong") || input.contains("you are wrong"))
				{
					txtRespond.append(Bot+": Looks who's talking :P "+"\n");
				}
				else if(input.contains("How can a man go eight days without sleep?"))
				{
					txtRespond.append(Bot+": he doesn't need to sleep during the day, he sleeps at night "+"\n");
				}
				else if(input.contains("who are you"))
				{
					txtRespond.append(Bot+": i am "+Bot+"also known as GadhaGaskar"+"\n");
				}
				else 
				{
					//txtRespond.append(Bot+": Wanna tell me something or not??? "+"\n");
				}
				
			}
		});
		btnSend.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSend.setEnabled(false);
		btnSend.setBounds(397, 26, 72, 23);
		chatPanel.add(btnSend);
	}
}
