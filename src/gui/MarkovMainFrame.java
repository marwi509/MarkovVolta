package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import lyricsGenerator.LyricsFacade;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MarkovMainFrame extends JFrame{
	LyricsFacade theFacade;
	Vector<String> theFiles = new Vector<String>();
	JList list;
	JRadioButton rdbtnCharacter;
	JRadioButton rdbtnWord;
	JLabel lblNewLabel = new JLabel();
	JSlider slider;
	
	public MarkovMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFacade = new LyricsFacade();
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		sourceTextField = new JTextField("/home/marcus2/Dokument/Mars Volta/");
		panel.add(sourceTextField);
		sourceTextField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				theFiles.add(sourceTextField.getText());
				list.setListData(theFiles);
			}
		});
		
		panel.add(btnAdd);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		outputTextField = new JTextField("/home/marcus2/Dokument/Mars Volta/output/guisong.txt");
		panel_1.add(outputTextField);
		outputTextField.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rdbtnCharacter.isSelected())
				{
					theFacade.setCharacterSequenceLength(slider.getValue());
					theFacade.setUseCharacter();
				}
				else
				{
					theFacade.setWordSequenceLength(slider.getValue());
					theFacade.setUseWord();
				}
				int[] selected = list.getSelectedIndices();
				for(int i = 0; i < selected.length; i ++)
				{
					theFacade.addSong(theFiles.get(selected[i]));
				}
				
				theFacade.generateSong();
				theFacade.toFile(outputTextField.getText());
			}
		});
		panel_1.add(btnGenerate);
		
		list = new JList();
		JScrollPane scrollPane = new JScrollPane(list);
		
		
		
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setRowHeaderView(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		rdbtnCharacter = new JRadioButton("Character");
		rdbtnCharacter.setSelected(true);
		
		
		rdbtnWord = new JRadioButton("Word");
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnWord);
		btnGroup.add(rdbtnCharacter);
		panel_3.add(rdbtnCharacter);
		panel_3.add(rdbtnWord);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				lblNewLabel.setText(""+slider.getValue());
			}
		});
		slider.setValue(4);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMaximum(10);
		panel_4.add(slider);
		
		lblNewLabel = new JLabel(""+slider.getValue());
		panel_4.add(lblNewLabel);
		
		this.setMinimumSize(new Dimension(600,300));
		this.setVisible(true);
		this.setEnabled(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4805740937012221389L;
	private JTextField sourceTextField;
	private JTextField outputTextField;

}
