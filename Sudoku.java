/**
	The program is the completion of one solvable Sudoku puzzle.
	
	@author Heather Frantisak
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sudoku extends JFrame
{
	private final String WINDOW_TITLE = "A Sudoku Puzzle";
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 300;
	
	private final int PUZZLE_ROW = 9;
	private final int PUZZLE_COL = 9;
	
	// To display each text field.
	private JTextField grid[][] = new JTextField[PUZZLE_ROW][PUZZLE_COL];
	
	// Array of numbers that make up the puzzle.
	private int puzzleGrid[][] = {
								{8,1,6,9,5,2,4,7,3},
								{4,7,3,8,1,6,9,5,2},
								{9,5,2,4,7,3,8,1,6},
								{1,6,9,5,2,4,7,3,8},
								{5,2,4,7,3,8,1,6,9},
								{7,3,8,1,6,9,5,2,4},
								{6,9,5,2,4,7,3,8,1},
								{2,4,7,3,8,1,6,9,5},
								{3,8,1,6,9,5,2,4,7}};

	// Each panel holds one 3x3 grid.
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();
	private JPanel panel7 = new JPanel();
	private JPanel panel8 = new JPanel();
	private JPanel panel9 = new JPanel();
	
	// Contains all 9 3x3 panels.
	private JPanel completePanel = new JPanel();

	// Menu components.
	private JMenuBar menuBar = new JMenuBar();
	private JMenu aboutMenu = new JMenu("About");
	private JMenuItem howToPlayItem = new JMenuItem("How To Play");
	
	private String howToPlayTitle = "Rules and Logic";
	private JLabel howToPlayLabel = new JLabel("<html>The numbers 1-9 appear " +
		"only once in the following ways:" +
		"<ul>" +
			"<li>Per row" +
			"<li>Per column" +
			"<li>Per 3x3 grid" +
		"</ul>" +
		"To get started, try looking at where a number cannot go, <br>" +
		"using the process of elimination.  The remaining empty <br>" +
		"square will be the solution.  There is only one solution. </html>");

	/**
		The main method creates an instance of the Sudoku class,
		to be executed once the application is run.
	*/	
	public static void main(String[] args)
	{
		new Sudoku();
	}
	
	/**
		The constructor initializes the application.
	*/
	public Sudoku()
	{
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildMenuBar();
		buildPanel1();
		add(panel1);
		buildPanel2();
		add(panel2);
		buildPanel3();
		add(panel3);
		buildPanel4();
		add(panel4);
		buildPanel5();
		add(panel5);
		buildPanel6();
		add(panel6);
		buildPanel7();
		add(panel7);
		buildPanel8();
		add(panel8);
		buildPanel9();
		add(panel9);
		buildCompletePanel();
		add(completePanel);
		setVisible(true);
	}
	
	/**
		The buildMenuBar method builds the menu bar.
	*/
	private void buildMenuBar()
	{
		buildAboutMenu();
		menuBar.add(aboutMenu);
		setJMenuBar(menuBar);
	}
	
	/**
		The buildAboutMenu method builds the About menu and
		returns a reference to its JMenu object.
	*/
	private void buildAboutMenu()
	{
		howToPlayItem.addActionListener(new MenuListener());
		aboutMenu.add(howToPlayItem);
	}
	
	/**
		The private inner class that handles the event that is
		generated when the user makes a selection from
		the About menu.
	*/
	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(completePanel, howToPlayLabel, 
				howToPlayTitle, JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	/**
		The following 9 buildPanel methods create new panels
		that contain GUI components.
	*/	
	private void buildPanel1()
	{
		panel1.setLayout(new GridLayout(3,3));
		
		for (int counter1 = 0; counter1 < 3; counter1++)
		{
			for (int counter2 = 0; counter2 < 3; counter2++)
			{
				// Print blank spaces.
				if (((counter1 == 0) || (counter1 == 2)) && ((counter2 == 0) || (counter2 == 1)))
				{
					grid[counter1][counter2] = new JTextField(1);
					grid[counter1][counter2].setText(" ");
					panel1.add(grid[counter1][counter2]);
				}
				// Print numbers.
				else
				{
					grid[counter1][counter2] = new JTextField(1);				
					grid[counter1][counter2].setText(String.valueOf(puzzleGrid[counter1][counter2]));
					panel1.add(grid[counter1][counter2]);
					grid[counter1][counter2].setEditable(false);
				}
			}
        }
		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}

	private void buildPanel2()
	{
		panel2.setLayout(new GridLayout(3,3));
		
		for (int counter1 = 0; counter1 < 3; counter1++)
		{
			for (int counter2 = 3; counter2 < 6; counter2++)
			{
				// Print blank spaces.
				if (((counter1 == 1) || (counter1 == 2)) && ((counter2 == 4) || (counter2 == 5)))
				{
					grid[counter1][counter2] = new JTextField(1);
					grid[counter1][counter2].setText(" ");
					panel2.add(grid[counter1][counter2]);
				}
				// Print numbers.
				else
				{
					grid[counter1][counter2] = new JTextField(1);				
					grid[counter1][counter2].setText(String.valueOf(puzzleGrid[counter1][counter2]));
					panel2.add(grid[counter1][counter2]);
					grid[counter1][counter2].setEditable(false);
				}
        	}
        }
		panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }
    
	private void buildPanel3()
	{
		panel3.setLayout(new GridLayout(3,3));
		
		for (int counter1 = 0; counter1 < 3; counter1++)
		{
			for (int counter2 = 6; counter2 < 9; counter2++)
			{
				// Print blank spaces.
				if ((counter1 == 1) || (counter2 == 7))
				{
					grid[counter1][counter2] = new JTextField(1);
					grid[counter1][counter2].setText(" ");
					panel3.add(grid[counter1][counter2]);
				}
				// Print numbers.
				else
				{
					grid[counter1][counter2] = new JTextField(1);				
					grid[counter1][counter2].setText(String.valueOf(puzzleGrid[counter1][counter2]));
					panel3.add(grid[counter1][counter2]);
					grid[counter1][counter2].setEditable(false);
				}
        	}
        }
		panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

	private void buildPanel4()
	{
		panel4.setLayout(new GridLayout(3,3));
		
		for (int counter1 = 3; counter1 < 6; counter1++)
		{
			for (int counter2 = 0; counter2 < 3; counter2++)
			{
				// Print blank spaces.
				if (((counter1 == 3) || (counter1 == 4)) && ((counter2 == 0) || (counter2 == 1) || counter2 ==2))
				{
					grid[counter1][counter2] = new JTextField(1);
					grid[counter1][counter2].setText(" ");
					panel4.add(grid[counter1][counter2]);
				}
				// Print numbers.
				else
				{
					grid[counter1][counter2] = new JTextField(1);				
					grid[counter1][counter2].setText(String.valueOf(puzzleGrid[counter1][counter2]));
					panel4.add(grid[counter1][counter2]);
					grid[counter1][counter2].setEditable(false);
				}
        	}
        }
		panel4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    private void buildPanel5()
	{
		panel5.setLayout(new GridLayout(3,3));
		
		for (int counter1 = 3; counter1 < 6; counter1++)
		{
			for (int counter2 = 3; counter2 < 6; counter2++)
			{
				// Print blank spaces.
				if (((counter1 == 3) || (counter1 == 4) || (counter1 == 5)) && ((counter2 == 3) || (counter2 == 4)))
				{
					grid[counter1][counter2] = new JTextField(1);
					grid[counter1][counter2].setText(" ");
					panel5.add(grid[counter1][counter2]);
				}
				// Print numbers.
				else
				{
					grid[counter1][counter2] = new JTextField(1);				
					grid[counter1][counter2].setText(String.valueOf(puzzleGrid[counter1][counter2]));
					panel5.add(grid[counter1][counter2]);
					grid[counter1][counter2].setEditable(false);
				}
        	}
        }
		panel5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    private void buildPanel6()
	{
		panel6.setLayout(new GridLayout(3,3));
		
		for (int counter1 = 3; counter1 < 6; counter1++)
		{
			for (int counter2 = 6; counter2 < 9; counter2++)
			{
				// Print blank spaces.
				if (((counter1 == 3) || (counter1 == 5)) && ((counter2 == 6) || (counter2 ==7) || counter2 ==8))
				{
					grid[counter1][counter2] = new JTextField(1);
					grid[counter1][counter2].setText(" ");
					panel6.add(grid[counter1][counter2]);
				}
				// Print numbers.
				else
				{
					grid[counter1][counter2] = new JTextField(1);				
					grid[counter1][counter2].setText(String.valueOf(puzzleGrid[counter1][counter2]));
					panel6.add(grid[counter1][counter2]);
					grid[counter1][counter2].setEditable(false);
				}
        	}
        }
		panel6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }
    
	private void buildPanel7()
	{
		panel7.setLayout(new GridLayout(3,3));
		
		for (int counter1 = 6; counter1 < 9; counter1++)
		{
			for (int counter2 = 0; counter2 < 3; counter2++)
			{
				// Print blank spaces.
				if (((counter1 == 7) || (counter1 == 8)) && ((counter2 == 0) || (counter2 == 2)))
				{
					grid[counter1][counter2] = new JTextField(1);
					grid[counter1][counter2].setText(" ");
					panel7.add(grid[counter1][counter2]);
				}
				// Print numbers.
				else
				{
					grid[counter1][counter2] = new JTextField(1);				
					grid[counter1][counter2].setText(String.valueOf(puzzleGrid[counter1][counter2]));
					panel7.add(grid[counter1][counter2]);
					grid[counter1][counter2].setEditable(false);
				}
        	}
        }
		panel7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

	private void buildPanel8()
	{
		panel8.setLayout(new GridLayout(3,3));
		
		for (int counter1 = 6; counter1 < 9; counter1++)
		{
			for (int counter2 = 3; counter2 < 6; counter2++)
			{
				// Print blank spaces.
				if (counter2 == 4)
				{
					grid[counter1][counter2] = new JTextField(1);
					grid[counter1][counter2].setText(" ");
					panel8.add(grid[counter1][counter2]);
				}
				// Print numbers.
				else
				{
					grid[counter1][counter2] = new JTextField(1);				
					grid[counter1][counter2].setText(String.valueOf(puzzleGrid[counter1][counter2]));
					panel8.add(grid[counter1][counter2]);
					grid[counter1][counter2].setEditable(false);
				}
        	}
        }
		panel8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

	private void buildPanel9()
	{
		panel9.setLayout(new GridLayout(3,3));
		
		for (int counter1 = 6; counter1 < 9; counter1++)
		{
			for (int counter2 = 6; counter2 < 9; counter2++)
			{
				// Print blank spaces.
				if ((counter1 == 7) && ((counter2 == 7) || (counter2 == 8)))
				{
					grid[counter1][counter2] = new JTextField(1);
					grid[counter1][counter2].setText(" ");
					panel9.add(grid[counter1][counter2]);
				}
				// Print numbers.
				else
				{
					grid[counter1][counter2] = new JTextField(1);				
					grid[counter1][counter2].setText(String.valueOf(puzzleGrid[counter1][counter2]));
					panel9.add(grid[counter1][counter2]);
					grid[counter1][counter2].setEditable(false);
				}
        	}
        }
		panel9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }
    
    /**
		The buildCompletePanel method creates a panel containing GUI components
		for all 9 panels.
	*/	
	private void buildCompletePanel()
	{
		completePanel.setLayout(new GridLayout(3,3));
		completePanel.add(panel1);
		completePanel.add(panel2);
		completePanel.add(panel3);
		completePanel.add(panel4);
		completePanel.add(panel5);
		completePanel.add(panel6);
		completePanel.add(panel7);
		completePanel.add(panel8);
		completePanel.add(panel9);
	}
}