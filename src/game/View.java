package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class View extends JPanel implements ActionListener, KeyListener {
	private Model game;
	
	private JLabel score;
	private JPanel board;
	
	// Constructor sets up the view
	public View(Model game) {
		// Store the game
		this.game = game;
		
		// Specify the layout to use for view components
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		setBackground(new Color(250, 248, 239));
		
		// Add an icon to the title
		JLabel icon = new JLabel(new ImageIcon("img/2048-logo.png"));
		icon.setAlignmentX(Component.CENTER_ALIGNMENT);
		icon.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(icon);
		
		// Add a title
//		JLabel title = new JLabel("2048");
//		title.setFont(new Font("Dialog", Font.BOLD, 50));
//		title.setForeground(new Color(119, 110, 101));
//		title.setAlignmentX(Component.CENTER_ALIGNMENT);
//		add(title);
		
		// Create a JLabel to store the game score and add it to the view
		score = new JLabel("Score: " + String.valueOf(game.getScore()));
		score.setFont(new Font("Dialog", Font.BOLD, 28));
		score.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		score.setForeground(new Color(119, 110, 101));
		score.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(score);
		
		// Create a JPanel to store the board state and add it to the view
		board = new JPanel();
		board.setLayout(new GridLayout(game.getSize(), game.getSize()));
		board.setBorder(BorderFactory.createLineBorder(new Color(187, 173, 160), 6));
		board.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(board);
		syncGameState();
		
		// Create a JPanel to store the reset button and add it to the view
		JButton resetButton = new JButton("\u27f2 Reset Game");
		resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		resetButton.setFont(new Font("Dialog", Font.BOLD, 20));
		resetButton.setFocusPainted(false);
		resetButton.setBackground(new Color(142, 122, 102));
		resetButton.setForeground(new Color(249, 246, 242));
		resetButton.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(new Color(250, 248, 239), 10),
			BorderFactory.createLineBorder(new Color(142, 122, 102), 10)
		));
		add(resetButton);
		
		// Listen for key press events
		addKeyListener(this);
		setFocusable(true);
		
		// Listen for button press events
		resetButton.addActionListener(this);
	}


	/**
	 * This method updates the board and score to match the model's
	 *   current state
	 */
	private void syncGameState() {
		board.removeAll();
		for (int r = 0; r < game.getSize(); r++) {
			for (int c = 0; c < game.getSize(); c++) {
				int value = game.getTile(r, c);
				board.add(makeTile(value));
			}
		}
		score.setText("Score: " + String.valueOf(game.getScore()));
		board.revalidate();
		score.revalidate();
	}
	
	
	/**
	 * Factory method for creating a new JLabel tile object
	 */
	private static JLabel makeTile(int value) {
		// Make a new tile
		JLabel tile = new JLabel();
		
		// Display the value of the tile
		if (value > 0) {
			tile.setText(String.valueOf(value));
		}
		
		// Set the size of the tile
		tile.setMinimumSize(new Dimension(100, 100));
		tile.setPreferredSize(new Dimension(100, 100));
		tile.setMaximumSize(new Dimension(100, 100));
		
		// Make the text centered in the tile
		tile.setHorizontalAlignment(SwingConstants.CENTER);
		tile.setVerticalAlignment(SwingConstants.CENTER);
		
		// Set the background of the tile and make the background visible
		tile.setBackground(getTileColor(value));
		tile.setOpaque(true);
		
		// Set the font style and color
		tile.setFont(new Font("Dialog", Font.BOLD, 32));
		tile.setForeground(new Color(119, 110, 101));
		
		// Set the border to be empty
		tile.setBorder(BorderFactory.createLineBorder(new Color(187, 173, 160), 6));
		
		// All done! Return the newly created tile
		return tile;
	}
	
	
	/**
	 * Factory method for creating the appropriate Color object for a tile
	 */
	private static Color getTileColor(int value) {
		switch (value) {
		case 0:
			return new Color(204, 193, 180);
		case 2:
			return new Color(238, 228, 218);
		case 4:
			return new Color(237, 224, 200);
		case 8:
			return new Color(242, 177, 121);
		case 16:
			return new Color(245, 149, 99);
		case 32:
			return new Color(246, 124, 95);
		case 64:
			return new Color(246, 94, 59);
		case 128:
			return new Color(237, 207, 114);
		case 256:
			return new Color(237, 204, 97);
		case 512:
			return new Color(237, 200, 80);
		case 1024:
			return new Color(237, 197, 63);
		case 2048:
			return new Color(237, 194, 46);
		default:
			return new Color(238, 228, 218);
		}
	}


	/**
	 * This method is executed by Java when the reset
	 *   button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		game.reset();
		syncGameState();
		requestFocusInWindow();
	}


	/**
	 * This method is executed by Java when a
	 *   keyboard key is typed (down and up)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	/**
	 * This method is executed by Java when a
	 *   keyboard key is pressed down
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if (game.canMove(Model.Direction.EAST)) {
				game.move(Model.Direction.EAST);
				game.addRandomTile();
				syncGameState();
			}
			break;
		case KeyEvent.VK_LEFT:
			if (game.canMove(Model.Direction.WEST)) {
				game.move(Model.Direction.WEST);
				game.addRandomTile();
				syncGameState();
			}
			break;
		case KeyEvent.VK_DOWN:
			if (game.canMove(Model.Direction.SOUTH)) {
				game.move(Model.Direction.SOUTH);
				game.addRandomTile();
				syncGameState();
			}
			break;
		case KeyEvent.VK_UP:
			if (game.canMove(Model.Direction.NORTH)) {
				game.move(Model.Direction.NORTH);
				game.addRandomTile();
				syncGameState();
			}
			break;
		}
	}


	/**
	 * This method is executed by Java when a
	 *   keyboard key is released
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
