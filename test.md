#Installing CUPS

Since cups was already installed in my system, I first removed it, so that no problem occurs because of that.

''' sudo apt-get remove cups '''


I also removed all remaining system CUPS files manually.
 
 
Forked the [https://github.com/apple/cups.git]: https://github.com/apple/cups.git
And then cloned using

''' Git clone '''
 
Once the project was cloned, I run the configure command in the /cups directory

''' /configure '''
 
After configuring, I run the make command, check for faults after make command and finally run make install command

'''
make 
make check
sudo make install
'''
 
Now, the cups was successfully installed.
 
#Starting CUPS

I Start the CUPS service using:
'''
sudo cupsd -f
'''
I left this terminal running while I proceed further.

 
#Create printer :

Created a new printer and called it 'newPrinter'
'''
lpadmin -p newPrinter -E -v ipp://newPrinter.local/ipp/print
'''

#Printing Files 

Created a successful print job using lpr -P command
'''
lpr -P newPrinter hello.txt
'''

 
#Adding Comment:

The directory /var/log/cups has all the log files.
Logs were added by the log.c file in cups/scheduler/ directory
In the log.c file, in the definition of the function cupsdLogRequest(), there was the function named cupsFilePrintf(), which was adding logs to the access_log file. I added a string saying “Gaurav Jawla made this comment” in the function call.

After making these changes, I run these commands again.
'''
Make
Sudo make install
'''
And then restarted the cups service
'''
sudo cupsd -f
'''
 
Now, when making printing requests again, the changes were reflected in the access_log file.
 
 
 
 
 
 
