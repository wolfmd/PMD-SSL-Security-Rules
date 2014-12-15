PMD-SSL-Security-Rules
======================

An extension for the Eclipse plugin PMD which highlights insecure Internet
connections on Android developed by Michael Wolf for the University of
Cincinnati. Included in this repository are rulesets for PMD in any environment.
The SSL_Security_Rules_Eclipse.xml removes the Java-based rule which is not
currently supported in the Eclipse PMD plugin.

Currently, ten rules exist

To install in non-Eclipse environments:

1. Place the jar file within PMD/IDE plugin jar directory.
	or, if you will be using a different version of PMD
	-Download PMD's sourcecode and extract it on your local filesysten
	-Place the "UseHTTPSWhenPossibleRule.java' into the sunsecure rule folder in PMD's src
		ex(../pmd/pmd-java/src/main/java/net/sourceforge/pmd/lang/java/rule/sunsecure)
	-Compile PMD and point your system to it. 
		(See http://pmd.sourceforge.net/pmd-5.1.1/compiling.html)

To install in Eclipse:
1: Open Eclipse
2: Go to Help>'Install New Software' 
3: add to the Available Software Sites: 

'http://sourceforge.net/projects/pmd/files/pmd-eclipse/update-site/'

4: Select the pmd application and follow the steps to install the plugin.
5: Open Window/Preferences/PMD/'Rule Configuration'
6: Select 'import ruleset' and browse for the SSL_Security_Rules_Eclipse.xml XML file on your 
	local file system
7: Make sure all rules are selected and click 'Okay'

The rules should now show up when you right click on your project and run PMD's
 Check Code command.


Notes for Eclipse
-------------------
Unfortunately, the official PMD Eclipse plugin only supports XPath rules out of box. 
Therefore, "Use HTTPS If Possible" is not officially supported in Eclipse at this time.

//TODO
Extend rules to include other possible violations of SSL in Android and future HTTPS-
style protocols.

For any questions, comments, etc
email Michael Wolf
wolfmd@mail.uc.edu

