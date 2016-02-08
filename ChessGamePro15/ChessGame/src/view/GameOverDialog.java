package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverDialog extends JDialog {
	
	
	private static final long serialVersionUID = 1L;

	public GameOverDialog(Game owner){
		super(owner, "Checkmate", true);
		String winner = owner.getTilesPanel().getTurn().equals("white") ? "black" : "white";
		add(new JLabel("<html><h1> Checkmate, " + winner + " wins!</h1></html>"));
		JButton ok = new JButton("OK");
		ok.addActionListener(event -> {
			owner.resetBoard();;
			setVisible(false);
		});

		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		pack();

	}

}
