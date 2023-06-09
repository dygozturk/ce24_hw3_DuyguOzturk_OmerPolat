package ce204_hw3_library.controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * Cuts the specified string and stores it in the system clipboard.
 *
 * @param string the string to be cut
 */

//This comment provides a brief description of the cutCom method, mentioning that it cuts the specified string and stores it in the system clipboard. 
//The @param tag documents the parameter string indicating its purpose. 

public class CutCommand {
	
public void cutCom(String string) {
		
		String myString = string;
        StringSelection selection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
	}
	
}
