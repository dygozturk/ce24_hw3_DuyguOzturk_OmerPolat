package ce204_hw3_library.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ce204_hw3_library.controller.*;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.undo.*;
import javax.swing.JScrollPane;

public class EditorGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorGUI frame = new EditorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	CommandCopy cp = new CommandCopy();
	CommandCut cc = new CommandCut();
	CommandPaste cpa = new CommandPaste();
	CommandRedo cr = new CommandRedo(this);
	CommandUndo cu = new CommandUndo(this);
	
	public UndoManager um = new UndoManager();
	
	private JTextField textField;
	
	public EditorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 347, 247);
		contentPane.add(textArea);
		
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedText = textArea.getSelectedText();
                cp.comCopy(selectedText);
			}
		});
		btnCopy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCopy.setBounds(10, 264, 134, 59);
		contentPane.add(btnCopy);
		
		JButton btnPaste = new JButton("Paste");
		btnPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		     
		     int caretPosition = textArea.getCaretPosition();
		    
			} 
			    } );
           
		btnPaste.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPaste.setBounds(299, 264, 134, 59);
		contentPane.add(btnPaste);
		
		JButton btnCut = new JButton("Cut");
		btnCut.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
                String selectedText = textArea.getSelectedText();
		        if (selectedText != null) {
		        textArea.replaceSelection("");
		        }
		         cc.comCut(selectedText);
		        }
		        });
		
		btnCut.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCut.setBounds(154, 264, 134, 59);
		contentPane.add(btnCut);
		
		JButton btnUndo = new JButton("Undo");
		
		btnUndo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUndo.setBounds(443, 264, 134, 59);
		contentPane.add(btnUndo);
		
		JButton btnRedo = new JButton("Redo");
		
		btnRedo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRedo.setBounds(587, 264, 134, 59);
		contentPane.add(btnRedo);
		
		String Array[]= {"C++","Java","CSharp"};
		JComboBox comboBox = new JComboBox(Array);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox.setBounds(530, 346, 191, 38);
		contentPane.add(comboBox);
		
		JButton btnCompile = new JButton("Compile ");
		btnCompile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnCompile.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCompile.setBounds(10, 345, 134, 40);
		contentPane.add(btnCompile);
		
		JButton btnRun = new JButton("Run");
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRun.setBounds(154, 345, 134, 40);
		contentPane.add(btnRun);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnApply.setBounds(299, 344, 134, 40);
		contentPane.add(btnApply);
		
		textField = new JTextField();
		textField.setBounds(367, 10, 355, 247);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(748, 138, 2, 2);
		contentPane.add(scrollPane);
		
		
		textArea.getDocument().addUndoableEditListener((UndoableEditListener) new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });
		
		
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cu.undo();
			}
		});
		
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cr.redo();
			}
		});
		
		}
	}
