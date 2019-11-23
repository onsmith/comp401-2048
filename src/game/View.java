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


// TODO: To handle button click events, implement ActionListener
// TODO: To handle keyboard events, implement KeyListener
public class View extends JPanel {
	private Model game;
	
	// TODO: Encapsulate a UI component to display
	//          the score and one to display the board
	
	// Constructor sets up the view
	public View(Model game) {
		// Store the game
		this.game = game;
		
		// Specify the layout to use for view components
		// TODO: Set the layout (box layout)
		// TODO: Set an empty border to pad the UI components
		// TODO: Set the background color to (250, 248, 239)
		
		// Add a title
		// TODO: Create a JLabel to store the title text
		// TODO: Set the font to be "Dialog", bold, and 50 pts
		// TODO: Set the foreground color to be (119, 110, 101)
		// TODO: Set the alignment to be "center"
		// TODO: Add the title to the JPanel
		
		// Add an icon to the title
		// TODO: Create a JLabel to store the title icon
		// TODO: Set the alignment to be "center"
		// TODO: Add an empty border to pad the icon
		// TODO: Add the icon to the JPanel
		
		// Create a JLabel to store the game score and add it to the view
		// TODO: Get the current game score from the model
		// TODO: Create a new JLabel to present the score
		// TODO: Add an empty border to pad the text
		// TODO: Set the foreground color to be (119, 110, 101)
		// TODO: Set the alignment to be "center"
		// TODO: Add the score to the JPanel
		
		// Create a JPanel to store the board state and add it to the view
		// TODO: Create a JPanel to store the board
		// TODO: Set the layout (grid layout)
		// TODO: Add a line border with color (187, 173, 160)
		// TODO: Set the alignment to be "center"
		// TODO: Add the board to the JPanel
		// TODO: Call a view method to insert the tiles
		
		// Create a JButton to store the reset button and add it to the view
		// TODO: Create a JButton to reset the game
		// TODO: Add Unicode to the button (hex 27f2)
		// TODO: Set the alignment to be "center"
		// TODO: Set the font to be "Dialog", bold, and 20 pts
		// TODO: Disable focus accent with button.setFocusPainted(false)
		// TODO: Set the background color to be (142, 122, 102)
		// TODO: Set the foreground color to be (249, 246, 242)
		// TODO: Set a compound border consisting of two line borders,
		//            first with color (250, 248, 239)
		//            and second with color (142, 122, 102)
		// TODO: Add the reset button to the JPanel
		
		// Listen for key press events
		// TODO: Add "this" as a listener of key press events
		// TODO: Designate "this" as the focus of keyboard events
		//            by calling this.setFocusable(true)
		
		// Listen for button press events
		// TODO: Add "this" as an action listener of the reset button
	}


	/**
	 * This method updates the board and score to match the model's
	 *   current state
	 */
	private void syncGameState() {
		// TODO: Remove all tiles from the board
		// TODO: Loop through the rows and columns
		// TODO: Get the value for the tile
		// TODO: Call a local factory method to make the tile into a JLabel
		// TODO: Add the tile JLabel to the board
		// TODO: Update the score JLabel text
		// TODO: Revalidate the board component
		// TODO: Revalidate the score component
	}
	
	
	/**
	 * Factory method for creating a new JLabel tile object
	 */
	private static JLabel makeTile(int value) {
		// Make a new tile
		// TODO: Create a new JLabel for this tile
		
		// Display the value of the tile
		// TODO: If the tile is non-zero, set the label text
		
		// Set the size of the tile
		// TODO: Set the dimensions of the tile to be 100 x 100
		// HINT: use setMinimumSize, setPreferredSize, and setMaximumSize
		
		// Make the text centered in the tile
		// TODO: Use setHorizontalAlignment and setVerticalAlignment
		//            to center the text within the tile
		
		// Set the background of the tile and make the background visible
		// TODO: Calculate and set the background color of the tile
		//            using a local factory method
		// TODO: Set the JLabel to be opaque using setOpaque(true)
		
		// Set the font style and color
		// TODO: Set the font to be "Dialog", bold, and 32 pts
		// TODO: Set the font color to be (119, 110, 101)
		
		// Set the border
		// TODO: Add a line border with color (187, 173, 160)
		//            to represent the grid lines
		
		// All done! Return the newly created tile
		// TODO: return the tile
	}
	
	
	/**
	 * Factory method for creating the appropriate Color object for a tile
	 */
	private static Color getTileColor(int value) {
		// TODO: Based on the tile value, return the
		//           correct color for the background
		// empty -> (204, 193, 180)
		// 2 -> (238, 228, 218)
		// 4 -> (237, 224, 200)
		// 8 -> (242, 177, 121)
		// 16 -> (245, 149, 99)
		// 32 -> (246, 124, 95)
		// 64 -> (246, 94, 59)
		// 128 -> (237, 207, 114)
		// 256 -> (237, 204, 97)
		// 512 -> (237, 200, 80)
		// 1024 -> (237, 197, 63)
		// 2048 -> (237, 194, 46)
		// Otherwise -> (238, 228, 218) (this is the grid line color)
	}
	
	
	// Handle the reset button event
	// TODO: Reset the model
	// TODO: Refresh the UI component display
	// TODO: Call requestFocusInWindow() to make sure
    //           "this" will receive keyboard events

	
	// Handle the key press event
	// TODO: Use getKeyCode() to get the key code of the pressed event
	// TODO: Listen for VK_RIGHT, VK_LEFT, VK_DOWN, and VK_UP
	// TODO: If the game can move in the requested direction,
	//           then move the board and add a random tile
	// TODO: Then, refresh the UI component display
}
