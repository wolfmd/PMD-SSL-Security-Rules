PMD-SSL-Security-Rules
======================

An extension for the Eclipse plugin PMD which highlights insecure Internet
connections on Android developed by Michael Wolf for the University of
Cincinnati

Currently, ten rules exist

To install:

1. Place the jar file within the eclipse plugin's jar directory.
	or, if you will be using a different version of PMD
	-Download PMD's sourcecode and extract it on your local filesysten
	-Place the "UseHTTPSWhenPossibleRule.java' into the sunsecure rule folder in PMD's src
		ex(../pmd/pmd-java/src/main/java/net/sourceforge/pmd/lang/java/rule/sunsecure)
	-Compile PMD and point your system to it. (See http://pmd.sourceforge.net/pmd-5.1.1/compiling.html)
2: Open Eclipse
3: Go to Help>'Install New Software' 
4: add to the Available Software Sites: 

'http://sourceforge.net/projects/pmd/files/pmd-eclipse/update-site/'

5: Select the pmd application and follow the steps to install the plugin.
6: Open Window/Preferences/PMD/'Rule Configuration'
7: Make sure all rules are selected and click 'Okay'
	If the rules don't show up initially,
	-Select 'import ruleset' and browse for the XML file on your local file system

The rules should now show up when you right click on your project and run PMD's
 Check Code command.

//TODO
Extend rules to include other possible violations of SSL in Android.

For any questions, comments, etc
email Michael Wolf
wolfmd@mail.uc.edu

