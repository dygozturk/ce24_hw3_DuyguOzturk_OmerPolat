package ce204_hw3_library.controller;

import ce204_hw3_library.view.EditorGUI;

//Declares a variable editorGUI of type EditorGUI. This variable will hold a reference to an instance of the Editor GUI class.
//Repeat is a constructor that takes an argument of type EditorGUÝ named editorGUÝ for the command class. 
//The constructor assigns the editor GUI value received as a parameter to the editor GUI variable of the class.
//This method, redo(), is a public method that doesn't take any parameters and doesn't return anything (void). 
//Within this method, it calls the redo() method on the um object of the editor GUI instance. The redo() method is likely part of an UndoManager or similar class associated with the Editor GUI.
//Overall, theRe do Command class represents a command to redo an action in the editor. It holds a reference to an Editor GUI object and provides a redo() method to invoke the corresponding redo() method on the associated EditorGUI instance.

public class RedoCommand {

	EditorGUI editorGUI;
	
	public RedoCommand(EditorGUI editorGUI) {
		// TODO Auto-generated constructor stub
		this.editorGUI = editorGUI;
	}
	
	public void redo() {
		editorGUI.um.redo();
	}

}
