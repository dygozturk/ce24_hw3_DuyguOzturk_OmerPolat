package ce204_hw3_library.controller;

import ce204_hw3_library.view.EditorGUI;

//Declares a variable editorGUI of type EditorGUI. This variable will hold a reference to an instance of the Editor GUI class.
//Undo is a constructor that takes an argument of type EditorGUÝ named editorGUÝ for the command class. 
//The constructor assigns the editor GUI value received as a parameter to the editor GUI variable of the class.
//This method, undo(), is a public method that doesn't take any parameters and doesn't return anything (void). Within this method, it calls the undo() method on the um object of the editorGUI instance. 
//The undo() method is likely part of an UndoManager or similar class associated with the EditorGUI.
//Overall, the UndoCommand class represents a command to undo an action in the editor. 
//It holds a reference to an EditorGUI object and provides an undo() method to invoke the corresponding undo() method on the associated EditorGUI instance.

public class UndoCommand {

	EditorGUI editorGUI;
	
	public UndoCommand(EditorGUI editorGUI) {
		// TODO Auto-generated constructor stub
		this.editorGUI = editorGUI;
	}

	public void undo() {
		editorGUI.um.undo();
	}
}
