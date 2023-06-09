package ce204_hw3_library.model;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

public class SyntaxColorize {
	
	
	public void javaSyntax(RSyntaxTextArea text) {
		text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);

	}

	public void csSyntax(RSyntaxTextArea text) {
		text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);

	}

	public void cppSyntax(RSyntaxTextArea text) {
		text.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);

	}

}
