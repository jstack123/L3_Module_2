package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoListTracker implements ActionListener {
	JFrame frame;
	JPanel panel = new JPanel();
	JButton addTask = new JButton();
	JButton removeTask;
	JButton save;
	JButton load;
	ArrayList<String> list = new ArrayList<String>();
	String task;
	FileWriter fw;
	String listArray;

	public ToDoListTracker() {
		frame = new JFrame();
		panel = new JPanel();
		addTask = new JButton("addTask");
		removeTask = new JButton("removeTask");
		save = new JButton("save");
		load = new JButton("load");

		frame.add(panel);
		panel.add(addTask);
		panel.add(removeTask);
		panel.add(save);
		panel.add(load);
		addTask.addActionListener(this);
		removeTask.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args) {
		ToDoListTracker tracker = new ToDoListTracker();
	}
	public void dateToFile() {
		try {
			fw = new FileWriter("src/intro_to_file_io/listFile.txt");
			for (int i = 0; i < list.size(); i++) {
				listArray += list.get(i) +"\n";
			}
			fw.write(listArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		if (e.getSource().equals(addTask)) {
			task = JOptionPane.showInputDialog("Type a task in the space below.");
			list.add(task);
		}

		if (e.getSource().equals(removeTask)) {
			list.remove(0);
		}
		
		if (e.getSource().equals(save)) {
		
		}
		System.out.println(list);
	}

}
