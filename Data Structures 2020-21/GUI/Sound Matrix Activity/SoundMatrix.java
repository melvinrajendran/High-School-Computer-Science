import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.*;
import javax.sound.sampled.*;


public class SoundMatrix extends JFrame implements Runnable, ActionListener, ChangeListener {
	Thread timing;

	JFileChooser fileChooser;
	File loadFile;
	String[] instrumentNames = new String[]{"Bell", "Glockenspiel", "Marimba", "Oboe", "Oh_Ah", "Piano"};
	String currentInstrument;
	String[] clipNames = new String[]{"C0", "B1", "A#1", "A1", "G#1", "G1", "F#1", "F1", "E1", "D#1", "D1", "C#1", "C1", "B2", "A#2", "A2", "G#2", "G2", "F#2", "F2", "E2", "D#2", "D2", "C#2", "C2", "B3", "A#3", "A3", "G#3", "G3", "F#3", "F3", "E3", "D#3", "D3", "C#3", "C3"};
	Clip[] clip;
	Font buttonFont = new Font("Momcake", Font.PLAIN, 13), menuFont = new Font("Momcake", Font.PLAIN, 20);

	JFrame frame = new JFrame();
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu, instrumentMenu, songMenu, addMenu, removeMenu;
	JMenuItem saveOption, loadOption;
	JMenuItem[] instrumentOptions, songOptions, addOptions, removeOptions;
	String[] songNames, addNames, removeNames;
	JPanel buttonPanel = new JPanel(), stepPanel = new JPanel();
	JSpinner stepSpinner;
	JButton playButton, resetButton, clearButton, randomizeButton;
	JScrollPane buttonPane;
    JToggleButton[][] button = new JToggleButton[clipNames.length][40];

	boolean isPlaying = false;
	int col = 0, step = 250;

	public SoundMatrix() {
		clip = new Clip[clipNames.length];
		currentInstrument = instrumentNames[0] + "/" + instrumentNames[0];

        try {
            for (int x = 0; x < clipNames.length; x++) {
         	    URL url = this.getClass().getClassLoader().getResource("Music/" + currentInstrument + "-" + clipNames[x] + ".wav");
         	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         	    clip[x] = AudioSystem.getClip();
         	    clip[x].open(audioIn);
		    }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
	
        buttonPanel.setLayout(new GridLayout(button.length, button[0].length, 0, 0));
		for (int r = 0; r < button.length; r++) {
			for (int c = 0; c < button[0].length; c++) {
				button[r][c] = new JToggleButton();
				button[r][c].setFont(buttonFont);
				button[r][c].setText(clipNames[r]);
				button[r][c].setPreferredSize(new Dimension(30, 30));
				button[r][c].setMargin(new Insets(0, 0, 0, 0));
				buttonPanel.add(button[r][c]);
			}
		}

		fileMenu = new JMenu("File");
		fileMenu.setFont(menuFont);
        saveOption = new JMenuItem("Save");
		loadOption = new JMenuItem("Load");
        saveOption.setFont(menuFont);
		loadOption.setFont(menuFont);
        saveOption.addActionListener(this);
		loadOption.addActionListener(this);
		fileMenu.add(saveOption);
		fileMenu.add(loadOption);

		instrumentMenu = new JMenu("Instrument");
		instrumentMenu.setFont(menuFont);
		instrumentOptions = new JMenuItem[instrumentNames.length];
		for (int x = 0; x < instrumentNames.length; x++) {
            instrumentOptions[x] = new JMenuItem(instrumentNames[x]);
            instrumentOptions[x].setFont(menuFont);
            instrumentOptions[x].addActionListener(this);
            instrumentMenu.add(instrumentOptions[x]);
        }

		songMenu = new JMenu("Songs");
		songMenu.setFont(menuFont);
		songNames = new String[]{"Super Mario Bros. - Theme", "Shrek - Fairytale", "Undertale - Once Upon a Time"};
		songOptions = new JMenuItem[songNames.length];
		for (int x = 0; x < songOptions.length; x++) {
            songOptions[x] = new JMenuItem(songNames[x]);
            songOptions[x].setFont(menuFont);
            songOptions[x].addActionListener(this);
            songMenu.add(songOptions[x]);
        }

		addMenu = new JMenu("Add Columns");
		addMenu.setFont(menuFont);
		addNames = new String[]{"+1", "+4", "+8"};
		addOptions = new JMenuItem[addNames.length];
		for (int x = 0; x < addOptions.length; x++) {
            addOptions[x] = new JMenuItem(addNames[x]);
            addOptions[x].setFont(menuFont);
            addOptions[x].addActionListener(this);
            addMenu.add(addOptions[x]);
        }

		removeMenu = new JMenu("Remove Columns");
		removeMenu.setFont(menuFont);
		removeNames = new String[]{"-1", "-4", "-8"};
		removeOptions = new JMenuItem[removeNames.length];
		for (int x = 0; x < addOptions.length; x++) {
            removeOptions[x] = new JMenuItem(removeNames[x]);
            removeOptions[x].setFont(menuFont);
            removeOptions[x].addActionListener(this);
            removeMenu.add(removeOptions[x]);
        }

		JLabel stepLabel = new JLabel("Step (ms)");
		stepLabel.setFont(menuFont);
		stepSpinner = new JSpinner(new SpinnerNumberModel(step, 50, 1500, 1));
		stepSpinner.setFont(menuFont);
		stepSpinner.addChangeListener(this);
		stepPanel.setLayout(new GridLayout(1, 2));
		stepPanel.add(stepLabel);
		stepPanel.add(stepSpinner);

		fileChooser = new JFileChooser(System.getProperty("user.dir"));

		playButton = new JButton("Play");
		playButton.setFont(menuFont);
		playButton.addActionListener(this);

		resetButton = new JButton("Reset");
		resetButton.setFont(menuFont);
		resetButton.addActionListener(this);

		clearButton = new JButton("Clear");
		clearButton.setFont(menuFont);
		clearButton.addActionListener(this);

		randomizeButton = new JButton("Randomize");
		randomizeButton.setFont(menuFont);
		randomizeButton.addActionListener(this);

		menuBar.setLayout(new GridLayout(2, 5));
		menuBar.add(fileMenu);
		menuBar.add(instrumentMenu);
		menuBar.add(songMenu);
		menuBar.add(addMenu);
		menuBar.add(removeMenu);
		menuBar.add(playButton);
		menuBar.add(resetButton);
		menuBar.add(clearButton);
		menuBar.add(randomizeButton);
		menuBar.add(stepPanel);

		buttonPane = new JScrollPane(buttonPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.add(menuBar, BorderLayout.NORTH);
		this.add(buttonPane, BorderLayout.CENTER);
		setSize(1000, 800);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timing = new Thread(this);
		timing.start();
	}
	
	public void run() {
		while (true) {
			try {
				if (!isPlaying) {
					new Thread().sleep(0);
					for (int r = 0; r < button.length; r++) {
						for (int c = 0; c < button[0].length; c++) {
							if (c == col)
								button[r][c].setForeground(Color.LIGHT_GRAY);
							else
								button[r][c].setForeground(Color.BLACK);
						}
					}
				} else {
					for (int r = 0; r < button.length; r++) {
						if (button[r][col].isSelected()) {
							clip[r].start();
						}
						button[r][col].setForeground(Color.LIGHT_GRAY);
					}
					new Thread().sleep(step);
					for (int r = 0; r < button.length; r++) {
						if (button[r][col].isSelected()) {
							clip[r].stop();
							clip[r].setFramePosition(0);
						}
						button[r][col].setForeground(Color.BLACK);
					}
					if (isPlaying) {
						col++;
						if (col == button[0].length)
							col = 0;
					}
				}
			}
			catch (InterruptedException e) {}
			catch (NullPointerException ne) {}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveOption) {
			saveSong();
		}

		if (e.getSource() == loadOption) {
			loadSong();
		}

		if (e.getSource() == playButton) {
			isPlaying = !isPlaying;
			if (isPlaying) {
				playButton.setText("Pause");
			} else {
				playButton.setText("Play");
			}
		}

		if (e.getSource() == resetButton) {
			isPlaying = false;
			col = 0;
			playButton.setText("Play");
		}

		if (e.getSource() == clearButton) {
			for (int r = 0; r < button.length; r++) {
				for (int c = 0; c < button[0].length; c++) {
					button[r][c].setSelected(false);
				}
			}
		}
		if (e.getSource() == randomizeButton) {
			for (int r = 0; r < button.length; r++) {
				for (int c = 0; c < button[0].length; c++) {
					button[r][c].setSelected(false);
				}
			}

			for (int c = 0; c < button[0].length; c++) {
				int numNotes = (int)(Math.random() * 6);
				for (int i = 0; i < numNotes; i++) {
					int randomNote = (int)(Math.random() * 37);
					button[randomNote][c].setSelected(true);
				}
			}
		}

		for (int y = 0; y < instrumentOptions.length; y++) {
			if (e.getSource() == instrumentOptions[y]) {
				currentInstrument = instrumentNames[y] + "/" + instrumentNames[y];

				try {
					for (int x = 0; x < clipNames.length; x++) {
						URL url = this.getClass().getClassLoader().getResource("Music/" + currentInstrument + "-" + clipNames[x] + ".wav");
						AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
						clip[x] = AudioSystem.getClip();
						clip[x].open(audioIn);
					}
				} catch (UnsupportedAudioFileException uafe) {
					uafe.printStackTrace();
				} catch (IOException uafe) {
					uafe.printStackTrace();
				} catch (LineUnavailableException uafe) {
					uafe.printStackTrace();
				}
			}
		}

		for (int x = 0; x < songOptions.length; x++) {
			if (e.getSource() == songOptions[x]) {
				switch (x) {
					case 0:
						loadFile = new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Sound Matrix Activity/Music/Songs/SuperMarioBrosTheme.txt");
						break;
					case 1:
						loadFile = new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Sound Matrix Activity/Music/Songs/ShrekFairytale.txt");
						break;
					case 2:
						loadFile = new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Sound Matrix Activity/Music/Songs/UndertaleOnceUponATime.txt");
						break;
					default:
						break;
				}
				try {
					BufferedReader input = new BufferedReader(new FileReader(loadFile));
					String temp;
					temp = input.readLine();
					step = Integer.parseInt(temp.substring(0, 4).trim());
					stepSpinner.setValue(step);
					Character[][] song = new Character[button.length][temp.length() - 2];
	
					int r = 0;
					while ((temp = input.readLine()) != null) {
						for (int c = 2; c < song[0].length; c++) {
							song[r][c - 2] = temp.charAt(c);
						}
						r++;
					}
					setNotes(song);
	
					input.close();
				} catch (IOException ioee) {}
				isPlaying = false;
				col = 0;
				playButton.setText("Play");
			}
		}

		for (int x = 0; x < addOptions.length; x++) {
			if (e.getSource() == addOptions[x]) {
				buttonPane.remove(buttonPanel);

				buttonPanel = new JPanel();
				JToggleButton[][] temp = button.clone();
				button = new JToggleButton[clipNames.length][button[0].length + Integer.parseInt(addNames[x].substring(1))];
				buttonPanel.setLayout(new GridLayout(button.length, button[0].length, 0, 0));
				for (int r = 0; r < button.length; r++) {
					for (int c = 0; c < button[0].length; c++) {
						button[r][c] = new JToggleButton();
						button[r][c].setFont(buttonFont);
						button[r][c].setText(clipNames[r]);
						button[r][c].setPreferredSize(new Dimension(30, 30));
						button[r][c].setMargin(new Insets(0, 0, 0, 0));
						buttonPanel.add(button[r][c]);
					}
				}
				this.remove(buttonPane);
				buttonPane = new JScrollPane(buttonPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				this.add(buttonPane, BorderLayout.CENTER);

				for (int r = 0; r < button.length; r++) {
					for (int c = 0; c < button[0].length; c++) {
						try {
							if (temp[r][c].isSelected())
								button[r][c].setSelected(true);
							else
								button[r][c].setSelected(false);
								
						}
						catch (NullPointerException npe) {}
						catch (ArrayIndexOutOfBoundsException aioobe) {}
					}
				}

				this.revalidate();
			}
		}

		for (int x = 0; x < removeOptions.length; x++) {
			if (e.getSource() == removeOptions[x]) {
				buttonPane.remove(buttonPanel);

				buttonPanel = new JPanel();
				JToggleButton[][] temp = button.clone();
				button = new JToggleButton[clipNames.length][button[0].length + Integer.parseInt(removeNames[x])];
				buttonPanel.setLayout(new GridLayout(button.length, button[0].length, 0, 0));
				for (int r = 0; r < button.length; r++) {
					for (int c = 0; c < button[0].length; c++) {
						button[r][c] = new JToggleButton();
						button[r][c].setFont(buttonFont);
						button[r][c].setText(clipNames[r]);
						button[r][c].setPreferredSize(new Dimension(30, 30));
						button[r][c].setMargin(new Insets(0, 0, 0, 0));
						buttonPanel.add(button[r][c]);
					}
				}
				this.remove(buttonPane);
				buttonPane = new JScrollPane(buttonPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				this.add(buttonPane, BorderLayout.CENTER);

				if (col > button[0].length - 1)
					col = 0;

				for (int r = 0; r < button.length; r++) {
					for (int c = 0; c < button[0].length; c++) {
						try {
							if (temp[r][c].isSelected())
								button[r][c].setSelected(true);
							else
								button[r][c].setSelected(false);
								
						}
						catch (NullPointerException npe) {}
						catch (ArrayIndexOutOfBoundsException aioobe) {}
					}
				}

				this.revalidate();
			}
		}
	}

	public void stateChanged(ChangeEvent e) {
        if (e.getSource() == stepSpinner) {
			step = (int)stepSpinner.getValue();
		}
    }

	public void saveSong() {
		FileFilter filter = new FileNameExtensionFilter("*.txt", "txt");
		fileChooser.setFileFilter(filter);
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				String str = file.getAbsolutePath();
				if (str.indexOf(".txt") >= 0)
					str = str.substring(0, str.length() - 4);
				String output = "";
				String[] noteNames = {"C ", "B ", "A#", "A ", "G#", "G ", "F#", "F ", "E ", "D#", "D ", "C#", "C ", "B ", "A#", "A ", "G#", "G ", "F#", "F ", "E ", "D#", "D ", "C#", "C ", "B ", "A#", "A ", "G#", "G ", "F#", "F ", "E ", "D#", "D ", "C#", "C "};
				for (int r = 0; r < button.length + 1; r++) {
					if (r == 0) {
						output += step;
						for (int c = (step + "").length(); c < button[0].length + 2; c++)
							output += " ";
					} else {
						output += noteNames[r - 1];
						for (int c = 0; c < button[0].length; c++) {
							if (button[r - 1][c].isSelected())
								output += "X";
							else
								output += "-";
						}
					}
					output += "\n";
				}

				BufferedWriter outputStream = null;
				outputStream = new BufferedWriter(new FileWriter(str + ".txt"));
				outputStream.write(output);
				outputStream.close();
			} catch (IOException e) {}
		}
	}

	public void loadSong() {
		int returnVal = fileChooser.showOpenDialog(this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				loadFile = fileChooser.getSelectedFile();
				BufferedReader input = new BufferedReader(new FileReader(loadFile));
				String temp;
				temp = input.readLine();
				step = Integer.parseInt(temp.substring(0, 4).trim());
				stepSpinner.setValue(step);
				Character[][] song = new Character[button.length][temp.length() - 2];

				int r = 0;
				while ((temp = input.readLine()) != null) {
					for (int c = 2; c < song[0].length; c++) {
						song[r][c - 2] = temp.charAt(c);
					}
					r++;
				}
				setNotes(song);

				input.close();
			} catch (IOException e) {}
			isPlaying = false;
			col = 0;
			playButton.setText("Play");
		}
	}

	public void setNotes(Character[][] song) {
		buttonPane.remove(buttonPanel);

		buttonPanel = new JPanel();
		button = new JToggleButton[clipNames.length][song[0].length];
		buttonPanel.setLayout(new GridLayout(button.length, button[0].length, 0, 0));
		for (int r = 0; r < button.length; r++) {
			for (int c = 0; c < button[0].length; c++) {
				button[r][c] = new JToggleButton();
				button[r][c].setFont(buttonFont);
				button[r][c].setText(clipNames[r]);
				button[r][c].setPreferredSize(new Dimension(30, 30));
				button[r][c].setMargin(new Insets(0, 0, 0, 0));
				buttonPanel.add(button[r][c]);
			}
		}
		this.remove(buttonPane);
		buttonPane = new JScrollPane(buttonPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(buttonPane, BorderLayout.CENTER);

		for (int r = 0; r < button.length; r++) {
			for (int c = 0; c < button[0].length; c++) {
				try {
					if (song[r][c] == 'X')
						button[r][c].setSelected(true);
					else
						button[r][c].setSelected(false);
						
				}
				catch (NullPointerException e) {}
				catch (ArrayIndexOutOfBoundsException e) {}
			}
		}

		this.revalidate();
	}

	public static void main(String[] args) {
		new SoundMatrix();
	}
}