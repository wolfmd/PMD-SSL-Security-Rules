/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.lang.java.rule.sunsecure;

import java.util.regex.Pattern;

import net.sourceforge.pmd.lang.java.ast.ASTLiteral;
import net.sourceforge.pmd.lang.java.rule.regex.RegexHelper;
import net.sourceforge.pmd.lang.rule.properties.StringProperty;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.ASTAssignmentOperator;
import net.sourceforge.pmd.lang.java.ast.ASTBlockStatement;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTConstructorDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTEqualityExpression;
import net.sourceforge.pmd.lang.java.ast.ASTExpression;
import net.sourceforge.pmd.lang.java.ast.ASTFormalParameter;
import net.sourceforge.pmd.lang.java.ast.ASTFormalParameters;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTPrimaryExpression;
import net.sourceforge.pmd.lang.java.ast.ASTPrimaryPrefix;
import net.sourceforge.pmd.lang.java.ast.ASTPrimarySuffix;
import net.sourceforge.pmd.lang.java.ast.ASTStatementExpression;
import net.sourceforge.pmd.lang.java.ast.ASTVariableDeclaratorId;
import java.net.*;
import java.io.*;
import java.net.MalformedURLException;
import java.security.cert.Certificate;
import javax.net.ssl.HttpsURLConnection;

/**
 * This class allow to match a Literal (most likely a String) with a regex pattern.
 * Obviously, there are many applications of it (such as basic.xml/AvoidUsingHardCodedIP).
 *
 * @author Romain PELISSE, belaran@gmail.com
 */
//FUTURE This is not referenced by any RuleSet?
public class UseHTTPSWhenPossibleRule extends AbstractJavaRule {

	private Pattern pattern;
	
	private static final String PROPERTY_NAME = "*";
		
	private static final StringProperty REGEX_PROPERTY = new StringProperty(PROPERTY_NAME,"http://","", 1.0f);
	
	public UseHTTPSWhenPossibleRule() {
	    definePropertyDescriptor(REGEX_PROPERTY);
	}
	
	/**
	 * This method checks if the Literal matches the pattern. If it does, a violation is logged.
	 */
	@Override
	public Object visit(ASTLiteral node, Object data) {
		String image = node.getImage();
		int response = 0;
		if ( image != null && image.length() > 0 && image.contains("http://") ) {
			String new_image = image.replace("http","https");
			new_image = new_image.replace("\"","");

		 	 URL url = null;
		 	 URI uri = null;
	     	
	     	 try { 
	     	 	url = new URL(new_image.toString());
	     	 	uri = url.toURI();
	     	 	try {
	     	 url = uri.toURL();	     
		     
   HttpsURLConnection urlConnection = (HttpsURLConnection)
   			url.openConnection();
			urlConnection.setConnectTimeout(5000);
		     response = urlConnection.getResponseCode();

	      } catch (IOException e) {
		     e.printStackTrace();
	      }
	     	
	     	catch  (IllegalArgumentException e) {
            e.printStackTrace();}

	     	 }
	     	 catch (URISyntaxException e) 
	     	 {
            e.printStackTrace();
        	}
        	catch (MalformedURLException e) {e.printStackTrace();}

        	
    	
		 
	      
	 	if (response == 200){
  		 		addViolation(data, node);
		
  			 }
  			}
  		
	
	return data;
}
}

