package ce204_hw3_library.controller;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

//Defines a method named paste String that takes a parameter text of type String. It also indicates that the method may throw an Exception.
//Retrieves the system clipboard using the getDefaultToolkit() method from the Toolkit class and assigns it to a Clipboard object called clp.
//Creates a new StringSelection object, passing the text parameter to its constructor. This object represents the text to be copied to the clipboard.
//Sets the contents of the system clipboard using the setContents() method of the Clipboard object clp. It specifies the String Selection object self as the contents and null as the ClipboardOwner.
//Creates a new Robot object, which allows programmatic control of the mouse and keyboard.
//Simulate the keypresses needed to perform a paste operation. It uses the Robot object robot to press and release the Control key (KeyEvent.VK_CONTROL) and the V key (KeyEvent.VK_V). 
//This combination triggers the paste operation, simulating the user's action of pasting the contents from the clipboard.
//Overall, the pasteString method retrieves the system clipboard, creates a StringSelection object with the provided text, sets the StringSelection as the clipboard contents, and then uses the Robot class to simulate the keypresses for pasting the contents.

public class PasteCommand {
	public void pasteString(String text) throws Exception {
        Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection sel = new StringSelection(text);
        clp.setContents(sel, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
}
