package ce204_hw3_library.controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class CopyCommand {
	//Declares a method named copy Com that takes a parameter of type String named string. This method doesn't return anything (void).
	//Declares a String variable named myString and assigns it the value of the string parameter passed to the method. It is used to store the string that will be copied.
	//Creates a new instance of String Selection and assigns it to a variable named selection. 
	//The StringSelection class is a Transferable implementation used to hold the selected string content. It is initialized with the myString value.
	//Retrieves the system clipboard using Toolkit.getDefaultToolkit().getSystemClipboard() and assigns it to a Clipboard variable named clipboard. 
	//The Clipboard class represents the system clipboard that holds the data to be copied or pasted.
	//Sets the contents of the clipboard to the selection object. It effectively copies the string specified by myString to the clipboard. 
	//The second argument, null, is a ClipboardOwner object, which in this case is not provided (null), indicating that the clipboard owner is not needed.
	//Overall, the copyCom method takes a string as input, creates a StringSelection object with that string, retrieves the system clipboard, and sets the clipboard contents to the StringSelection, effectively copying the string to the clipboard.
	
	public void copyCom(String string) {
		String myString = string;
        StringSelection selection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
	}
	
	
}
