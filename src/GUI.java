import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Game game = new Game();
	private JPanel contentPane;

	JPanel[] panels = new JPanel[6];
	ArrayList<Card>[] hands = new ArrayList[6];
	// ArrayList<JLabel>[] labels = new ArrayList[6];

	JComboBox<Integer> playerNum;
	JComboBox<String> suit;
	JComboBox<String> rank;
	JButton btnAskThisCard;

	JComboBox<String> isLowSuit;
	JComboBox<String> suit1;
	JButton declareCompletion;

	JLabel A_score;
	JLabel B_score;
	JPanel panel_2,panel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		game.dealCard();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 1300, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
		gbc_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_desktopPane.gridx = 0;
		gbc_desktopPane.gridy = 0;
		contentPane.add(desktopPane, gbc_desktopPane);

		for (int j = 0; j < 3; j++) {
			panels[j] = new JPanel();

			desktopPane.add(panels[j]);

			hands[j] = game.teamA[j].hands;
			// System.out.println(teamA_player1_hands.size());
			// labels[j] = new ArrayList<JLabel>();
			for (int i = 0; i < hands[j].size(); i++) {
				JLabel label = new JLabel();
				label.setIcon(new ImageIcon("cards/" + hands[j].get(i).getIconIndex() + ".png"));
				// labels[j].add(label);
				panels[j].add(label);

			}
		}
		panels[0].setBounds(41, 100, 398, 280);
		panels[1].setBounds(451, 100, 393, 282);
		panels[2].setBounds(856, 100, 378, 282);

		for (int j = 0; j < 3; j++) {
			panels[3 + j] = new JPanel();

			desktopPane.add(panels[3 + j]);

			hands[3 + j] = game.teamB[j].hands;
			// System.out.println(teamA_player1_hands.size());
			// labels[3+j] = new ArrayList<JLabel>();
			for (int i = 0; i < hands[3 + j].size(); i++) {
				JLabel label = new JLabel();
				label.setIcon(new ImageIcon("cards/" + hands[3 + j].get(i).getIconIndex() + ".png"));
				// labels[3+j].add(label);
				panels[3 + j].add(label);

			}
		}
		panels[3].setBounds(41, 440, 398, 293);
		panels[4].setBounds(451, 440, 393, 293);
		panels[5].setBounds(856, 440, 378, 301);

		for (int i = 0; i < 6; i++) {
			panels[i].setBackground(Color.WHITE);
		}

		JLabel lblteam = new JLabel("teamA");
		lblteam.setBounds(6, 65, 61, 16);
		desktopPane.add(lblteam);

		JLabel lblteam_1 = new JLabel("teamB");
		lblteam_1.setBounds(6, 406, 61, 16);
		desktopPane.add(lblteam_1);

		JLabel lblPlayer = new JLabel("player1");
		lblPlayer.setBounds(198, 70, 61, 21);
		desktopPane.add(lblPlayer);

		JLabel lblPlayer_1 = new JLabel("player2");
		lblPlayer_1.setBounds(612, 72, 61, 16);
		desktopPane.add(lblPlayer_1);

		JLabel lblPlayer_2 = new JLabel("player3");
		lblPlayer_2.setBounds(1009, 72, 61, 16);
		desktopPane.add(lblPlayer_2);

		JLabel lblPlayer_3 = new JLabel("player1");
		lblPlayer_3.setBounds(198, 412, 61, 16);
		desktopPane.add(lblPlayer_3);

		JLabel lblPlayer_4 = new JLabel("player2");
		lblPlayer_4.setBounds(612, 412, 61, 16);
		desktopPane.add(lblPlayer_4);

		JLabel lblPlayer_5 = new JLabel("player3");
		lblPlayer_5.setBounds(993, 412, 61, 16);
		desktopPane.add(lblPlayer_5);

		JPanel panel = new JPanel();
		panel.setBounds(89, 19, 627, 41);
		desktopPane.add(panel);

		JLabel lblPlayer_6 = new JLabel("player");
		panel.add(lblPlayer_6);

		playerNum = new JComboBox<Integer>();
		playerNum.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 1, 2, 3 }));
		panel.add(playerNum);

		JLabel lblRank = new JLabel("rank");
		panel.add(lblRank);

		rank = new JComboBox<String>();
		rank.setMaximumRowCount(13);
		rank.setModel(new DefaultComboBoxModel<String>(
				new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" }));
		panel.add(rank);

		JLabel lblSuit = new JLabel("suit");
		panel.add(lblSuit);

		suit = new JComboBox<String>();
		suit.setModel(new DefaultComboBoxModel<String>(new String[] { "Clubs", "Spades", "Hearts", "Diamonds" }));
		panel.add(suit);

		btnAskThisCard = new JButton("ask this card");
		panel.add(btnAskThisCard);
		btnAskThisCard.addActionListener(this);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(734, 19, 506, 41);
		desktopPane.add(panel_1);

		JLabel lblIslowsuit = new JLabel("isLowSuit");
		panel_1.add(lblIslowsuit);

		isLowSuit = new JComboBox<String>();
		isLowSuit.setModel(new DefaultComboBoxModel<String>(new String[] { "Yes", "No" }));
		panel_1.add(isLowSuit);

		JLabel lblSuit_1 = new JLabel("suit");
		panel_1.add(lblSuit_1);

		suit1 = new JComboBox<String>();
		suit1.setModel(new DefaultComboBoxModel<String>(new String[] { "Clubs", "Spades", "Hearts", "Diamonds" }));
		panel_1.add(suit1);

		declareCompletion = new JButton("declare completion");
		panel_1.add(declareCompletion);
		declareCompletion.addActionListener(this);

		panel_2 = new JPanel();
		panel_2.setBounds(63, 65, 96, 30);
		desktopPane.add(panel_2);

		A_score = new JLabel("0");
		panel_2.add(A_score);
		A_score.setBackground(Color.CYAN);

		panel_3 = new JPanel();
		panel_3.setBounds(63, 406, 96, 21);
		desktopPane.add(panel_3);

		B_score = new JLabel("0");
		panel_3.add(B_score);

		String team = game.turn.getTeam();
		int number = game.turn.getPlayerNumber();
		if (team.equals("teamA")) {
			panels[number - 1].setBackground(Color.GREEN);
		} else {
			panels[2 + number].setBackground(Color.GREEN);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source instanceof JButton) {
			if (btnAskThisCard.equals(source)) {
				int playerID = (int) playerNum.getSelectedItem();
				String cardRank = (String) rank.getSelectedItem();
				String cardSuit = (String) suit.getSelectedItem();
				//System.out.println(game.turn.getTeam());
				if (game.turn.getTeam().equals("teamA")) {
					Card c = new Card(Card.getRankFromString(cardRank), Card.getSuitFromString(cardSuit));
					boolean b = game.teamA[game.turn.getPlayerNumber() - 1].askForACard(game.teamB[playerID - 1], c);
					// the person has that card
					if (b) {
						refresh(panels[2 + playerID], game.teamB[playerID - 1].hands);

						refresh(panels[game.turn.getPlayerNumber() - 1],
								game.teamA[game.turn.getPlayerNumber() - 1].hands);

					} else {
						// the person don't have that card, change the turn to
						// next one
						panels[2 + playerID].setBackground(Color.GREEN);
						panels[game.turn.getPlayerNumber() - 1].setBackground(Color.WHITE);
						game.turn = game.teamB[playerID - 1];
					}
				} else {
					Card c = new Card(Card.getRankFromString(cardRank), Card.getSuitFromString(cardSuit));
					boolean b = game.teamB[game.turn.getPlayerNumber() - 1].askForACard(game.teamA[playerID - 1], c);
					// the person has that card
					if (b) {

						refresh(panels[playerID - 1], game.teamA[playerID - 1].hands);
						refresh(panels[game.turn.getPlayerNumber() + 2],
								game.teamB[game.turn.getPlayerNumber() - 1].hands);

					} else {
						// the person don't have that card, change the turn to
						// next one
						panels[playerID - 1].setBackground(Color.GREEN);
						panels[game.turn.getPlayerNumber() + 2].setBackground(Color.WHITE);
						game.turn = game.teamA[playerID - 1];
					}
				}
			} else if (declareCompletion.equals(source)) {
				String isLow = (String) isLowSuit.getSelectedItem();
				String whichSuit = (String) suit1.getSelectedItem();
				boolean isLow1 = isLow.equals("Yes");
				boolean completion = game.turn.declareCompletionOfASuit(isLow1, Card.getSuitFromString(whichSuit));
				if (completion) {
					boolean isTeamA = game.turn.getTeam().equals("teamA");
					int score = game.getScore(isTeamA);
					//System.out.println(score);
					if (isTeamA) {
						JLabel newLabel = new JLabel("" + score);
						panel_2.removeAll();
						panel_2.add(newLabel);
						panel_2.revalidate();
						panel_2.repaint();
					} else {
						B_score.setText("" + score);
						JLabel newLabel = new JLabel("" + score);
						panel_3.removeAll();
						panel_3.add(newLabel);
						panel_3.revalidate();
						panel_3.repaint();
					}
					JOptionPane.showMessageDialog(this, "Congratulation! you complete a suit", "success",
							JOptionPane.PLAIN_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(this, "your hand's card can't complete a suit that you declared.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

	private void refresh(JPanel jPanel, ArrayList<Card> hands2) {
		jPanel.removeAll();
		for (Card c : hands2) {
			JLabel label = new JLabel();
			label.setIcon(new ImageIcon("cards/" + c.getIconIndex() + ".png"));
			jPanel.add(label);
		}
		jPanel.revalidate();
		jPanel.repaint();
	}
}
