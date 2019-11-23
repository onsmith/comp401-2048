package game;

import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		// Create the main window
		JFrame window = new JFrame();
		// TODO: Set the window title
		// TODO: Set the default close operation
		// TODO: Disable resizing

		// Create a model to handle the game logic
		Model game = new Model(4);

		// Create a view to handle the display code
		View ui = new View(game);
		window.setContentPane(ui);

		// Show the window on the screen
		window.pack();
		window.setVisible(true);
	}
}
