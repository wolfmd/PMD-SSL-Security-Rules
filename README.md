PMD-SSL-Security-Rules
======================

An extension for the Eclipse plugin PMD which highlights insecure Internet
connections on Android developed by Michael Wolf for the University of
Cincinnati

To install:

1: Place the "UseHTTPSWhenPossibleRule.java' into the sunsecure rule folder in PMD's src

ex(../pmd/pmd-java/src/main/java/net/sourceforge/pmd/lang/java/rule/sunsecure)

2: Compile PMD and point your system to it. (See http://pmd.sourceforge.net/pmd-5.1.1/compiling.html)
3: Open Eclipse
4: Go to Help>'Install New Software' 
5: add to the Available Software Sites: 

'http://sourceforge.net/projects/pmd/files/pmd-eclipse/update-site/'

6: Select the pmd application and follow the steps to install the plugin.
7: Open Window/Preferences/PMD/'Rule Configuration'
8: Select 'import ruleset' and browse for the XML file on your local file system
9: Make sure all rules are selected and click 'Okay'

The rules should now show up when you right click on your project and run PMD's
 Check Code command.

//TODO
Extend rules

For any questions, comments, etc
email Michael Wolf
wolfmd@mail.uc.edu

