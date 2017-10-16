package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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
			listArray = "";
			for (int i = 0; i < list.size(); i++) {
				listArray += list.get(i) +"\n";
			}
			fw.write(listArray);
			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	String fileName = "";
	public void removeTask() {
		String typedTaskNumber = JOptionPane.showInputDialog("Choose which task you would like to delete by \nentering the task number in the space below, where 0 is the first task entered.");
		int taskNum = Integer.parseInt(typedTaskNumber);
		System.out.println(taskNum);
		list.remove(taskNum);
	}
	
	public void loadTask() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/intro_to_file_io/listFile.txt"));
			String load = "";
			String line = br.readLine();
			while(line != null){
				System.out.println(line);
				load+=line + "\n";
				list.add(line);
				line = br.readLine();
				//System.out.println(line);
			}
			br.close();
			JOptionPane.showMessageDialog(null, load );

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (task.length()>0) {
				list.add(task);
			}
		
		}

		if (e.getSource().equals(removeTask)) {
			removeTask();
			
		}
		
		if (e.getSource().equals(save)) {
			dateToFile();
			System.out.println(fw);
		}
		if (e.getSource().equals(load)) {
			loadTask();
		}
		System.out.println(list);
	}

}
