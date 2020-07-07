# Installing CUPS

Since CUPS was already installed in my system, I first removed it, so that no problem occurs because of that.

`` sudo apt-get remove cups ``


Also removed all remaining system CUPS files manually.
 
 
Forked CUPS from https://github.com/apple/cups.git


And then cloned using

`` Git clone https://github.com/thegauravjawla/cups.git``
 
Once the project was cloned, I run the configure command in the `` /cups `` directory

`` /configure ``
 
After configuring, I run the following commands to install CUPS.

```
make 
make check
sudo make install 
```
 
Now, the CUPS was successfully installed.
 
# Starting CUPS

I Start the CUPS service using

`` sudo cupsd -f ``

I left this terminal running while I proceed further.

 
# Creating printer

Created a new printer and called it 'newPrinter'

`` lpadmin -p newPrinter -E -v ipp://newPrinter.local/ipp/print ``


# Printing Files 

Created a successful print job using ``lpr -P`` command

`` lpr -P newPrinter hello.txt ``

 
# Adding Comment

The directory ``/var/log/cups`` has all the log files.

Logs were added by the ``log.c`` file in ``cups/scheduler/`` directory.

In the ``log.c ``file, in the definition of the function ``cupsdLogRequest()``, there was the function named ``cupsFilePrintf()``, which was adding logs to the ``access_log`` file. 

I added a string saying “Gaurav Jawla made this comment” in the function call.

After making these changes, I run these commands again.
```
Make
Sudo make install
```
And then restarted the cups service

`` sudo cupsd -f ``
 
Now, when making printing requests again, the changes were reflected in the ``access_log`` file.


NOTE:
**The `` access_log `` file has been added to the ``/cums/00. myLogs`` directory.**
