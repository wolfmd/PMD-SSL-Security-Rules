/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.lang.java.rule.sunsecure;

import java.util.regex.Pattern;
import net.sourceforge.pmd.*;
import net.sourceforge.pmd.lang.java.ast.ASTLiteral;
import net.sourceforge.pmd.lang.java.rule.regex.RegexHelper;
import net.sourceforge.pmd.lang.rule.properties.StringProperty;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;
import java.net.*;
import java.io.*;
import java.net.MalformedURLException;
import java.security.cert.Certificate;
import javax.net.ssl.HttpsURLConnection;

/**
 * This class is meant to match literals that contain 'http://' calls and then checks if a valid
 * https version exists. If so, the class throws a violation to show that there is an easy-to-fix 
 * securtity violation
 *
 * @author Michael Wolf wolfmd@mail.uc.edu, based off Literal Rule by Romain PELISSE, belaran@gmail.com
 */

public class UseHTTPSWhenPossibleRule extends AbstractJavaRule {
	
	/**
	 * This method checks if the URL starts with http://, if so it tries to ping the
	 * https version, throwing a violation if it succeeds.
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
   					HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
					urlConnection.setConnectTimeout(5000);
		     			response = urlConnection.getResponseCode();

	      			} catch (IOException e) {
		     			e.printStackTrace();
	      	
				} catch  (IllegalArgumentException e) {
            				e.printStackTrace();}

	     			} catch (URISyntaxException e) {
            				e.printStackTrace();
        			
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}

       			if (response == 200) {
  		 		addViolation(data, node);
  			 }

  			}
  		
	return data;
	
	}
}

