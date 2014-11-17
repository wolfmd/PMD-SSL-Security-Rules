PMD-SSL-Security-Rules
======================

An extension for the Eclipse plugin PMD which highlights insecure Internet
connections on Android developed by Michael Wolf for the University of
Cincinnati

To install:
1: Clone this repo and open Eclipse
2: Go to Help>'Install New Software' 
3: add to the Available Software Sites: 

'http://sourceforge.net/projects/pmd/files/pmd-eclipse/update-site/'

4: Select the pmd application and follow the steps to install the plugin.
5: Open Window/Preferences/PMD/'Rule Configuration'
6: Select 'import ruleset' and browse for the file on your local file
7: Make sure all rules are selected and click 'Okay'

The rules should now show up when you right click on your project and run PMD's
 Check Code command.

//TODO
Extend rules.
Create a java class which verifies whether or not an HTTPS site exists before
thrwoing a PMD error

For any questions, comments, etc
email Michael Wolf
wolfmd@mail.uc.edu

