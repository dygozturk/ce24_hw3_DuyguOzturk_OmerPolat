package ce204_hw3_test;

import static org.junit.Assert.*;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.undo.UndoManager;

import java.awt.datatransfer.StringSelection;

import ce204_hw3_library.controller.*;
import ce204_hw3_library.view.*;

import org.junit.Before;
import org.junit.Test;

public class ce204_hw3_test {

	//Declares a method named testCopy Com. 
	//Creates an instance of the Copy Command class and assigns it to a variable named copy Command. This is used to perform the copy operation.
	//Calls the copy Com method of the copy Command instance, passing the expected String as an argument. 
	//Retrieve the system clipboard using getDefaultToolkit().getSystemClipboard() and assign it to a Clipboard variable named clipboard. 
	//Then, the getContents(null) method is called on the clipboard to retrieve the contents of the clipboard as a Transferable object, which is assigned to the contents variable.
	//Check if the clipboard contents support the stringFlavor data flavor. If it does, it retrieves the transfer data as a String using contents.getTransferData(DataFlavor.stringFlavor) and assigns it to actualString. 
	//Then, it uses an assertEquals statement to compare expected String and actual String to ensure they are equal.
	//Overall, the testCopyCom method tests the CopyCommand functionality by creating a string to be copied, performing the copy operation, retrieving the clipboard contents, and asserting that the copied string matches the expected string.
	
	@Test
	public void testCopyCom() throws IOException, UnsupportedFlavorException {
		// Create a string to be copied
		String expectedString = "Hello, world!";
		
		// Create a CopyCommand instance
		CopyCommand copyCommand = new CopyCommand();
		

		copyCommand.copyCom(expectedString);
		

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		

		if (contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			String actualString = (String) contents.getTransferData(DataFlavor.stringFlavor);
			assertEquals(expectedString, actualString);
		} else {
			fail("Clipboard does not support string data");
		}
	}
	
	
	//Declares a method named test Cut. 
	//Creates a String variable named test String and assigns it the value "Hello, World!". This string represents the test string to be cut.
	//Creates an instance of the Cut Command class and assigns it to a variable named cut. This instance will be used to perform the cut operation.
	//Calls the cutCom method of the cut instance, passing testString as an argument. It performs the cut operation on the specified string.
	//Retrieves the system clipboard using getDefaultToolkit().getSystemClipboard() and assigns it to a Clipboard variable named clipboard.
	//Attempt to retrieve the clipboard contents as a String using clipboard.getData(DataFlavor.stringFlavor) and assign it to a variable named clipboardContents. 
	//Then, it uses an assertEquals statement to compare test String and clipboard Contents to ensure they are equal.
    //If any exception occurs during the process, it will be caught by the catch block, and the exception's stack trace will be printed.
	//Overall, the testCut method tests the CutCommand functionality by setting up a test string, performing the cut operation, retrieving the clipboard contents, and asserting that the clipboard contents match the test string.
	
	
	@Test
    public void testCut() {
        String testString = "Hello, World!";
        CutCommand cut = new CutCommand();
        cut.cutCom(testString);


        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            String clipboardContents = (String) clipboard.getData(DataFlavor.stringFlavor);
            assertEquals(testString, clipboardContents);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
	
	//Declares a test method named paste String  . It indicates that this method should be executed as a test case. It may throw Exception if an error occurs during the test.
	//Creates an instance of the Paste Command class and assigns it to a variable named paste Command. This instance will be used to perform the paste operation.
	//Test the paste String method with a simple string, "Hello, World!". First, it calls the pasteString method of the paste Command instance, passing the test String as an argument. 
	//It performs the paste operation with the specified string.
	//Then, it retrieves the clipboard contents as a string using java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString() and assigns it to the clipboardString variable. 
	//Finally, it uses an assertEquals statement to compare test String and clipboard String to ensure they are equal.
	//Test the paste String method with a longer string. Similar to the previous test, it calls the passed String method with long Test String, performs the paste operation, retrieves the clipboard contents, and asserts that longTestString and clipboardString are equal using assertEquals.
	//Overall, the pasteString test method verifies the functionality of the PasteCommand class by testing it with two different string inputs: a simple string and a longer string. It ensures that after performing the paste operation, the clipboard contains the expected string.
    
    
    @Test
    public void pasteString() throws Exception {
        PasteCommand pasteCommand = new PasteCommand();

        // test with a simple stringHello, world!Hello, world!
        String testString = "Hello, World!";
        pasteCommand.pasteString(testString);
        String clipboardString = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
        assertEquals(testString, clipboardString);

        // test with a longer string
        String longTestString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed blandit urna sed metus faucibus viverra. Vestibulum auctor volutpat leo, eu gravida velit malesuada sit amet.";
        pasteCommand.pasteString(longTestString);
        clipboardString = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
        assertEquals(longTestString, clipboardString);
    }
    
    
    
	
}
