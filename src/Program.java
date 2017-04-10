import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.FileChooserUI;

public class Program extends JFrame {

	private JButton btnSave, btnOpen;
	private JTextField txtPath;
	private JTextArea txtNotepad;
	private JFileChooser chooser;
	private JScrollPane scroll;

	public Program() {
		setTitle("Notepad");
		initComponent();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		enable(false);
	}

	public void enable(boolean status) {
		txtPath.setEnabled(status);
		btnSave.setEnabled(status);
	}

	public void initComponent() {
		txtPath = new JTextField(15);
		txtNotepad = new JTextArea(20, 35);
		txtNotepad.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				enable(!txtNotepad.getText().equals(""));
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FileHelper.saveFile(txtPath.getText(), txtNotepad.getText());

					txtPath.setText("");
					txtNotepad.setText("");

					JOptionPane.showMessageDialog(null, "Saved.");
				} catch (IOException ioe) {
					System.out.println(ioe.getMessage());
				}
			}
		});
		btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chooser = new JFileChooser();

				int result = chooser.showOpenDialog(btnOpen);

				if (result == JFileChooser.APPROVE_OPTION) {
					try{
					txtNotepad.setText(FileHelper.openFile(chooser.getSelectedFile().getPath()));
				}catch(IOException ioe){
					System.out.println(ioe.getMessage());
				}
			}
			}
		});
		scroll = new JScrollPane(txtNotepad);
		Container container = getContentPane();
		container.add(txtPath);
		container.add(btnSave);
		container.add(btnOpen);
		container.add(scroll);

	}

	public static void main(String[] args) {

		Program pro = new Program();

	}

}
