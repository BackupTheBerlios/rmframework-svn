tell application "PowerSwitch_Service"

		log j level 1 message "Starting execute fusion pro script"
		
		set jobDataset to dataset "slimpackMerge.ds" of j
		
		-- check dataset if null
		if (jobDataset = "") then
			set errorMessage to "Dataset doesn't exist. Contact Administrator"
			fail j message errorMessage
			return
		end if
		
		set acroApp to POSIX file "/Applications/Adobe Acrobat 8 Professional/Adobe Acrobat Professional.app"
		
		set proofId to "AP12345"
		set partId to "PC12345"
		set inputFolder to read private data j tag "file.input.fusionPro"
		log j level 1 message "Input Folder: " & inputFolder
		set templateFile to inputFolder & proofId & ".pdf"
		set proofFilename to read private data j tag "file.input.fusionPro.name"
		set isWebAccess to read private data j tag "template.webAccess"

		log j level 1 message "Proof Filename is: " & proofFilename
		
		
		set aTemplateFile to POSIX file inputFolder as Unicode text
		

		log j level 1 message "The template file to open: " & aTemplateFile
		
	end tell
	
	tell application "Finder"
		open aTemplateFile using acroApp
		delay 1
	end tell
	
	tell application "Adobe Acrobat Professional"
		activate
	end tell

	tell application "System Events"
		
		-- check if process is running and wait for it
		set processRunning to false
		set counter to 0
		set countMax to 20
		tell application "PowerSwitch_Service"
			log j level 1 message "Repeat until process Acrobat exists. Trying for 20 sec."
		end tell
		repeat until processRunning is equal to true or counter is equal to countMax
			set processList to name of every process
			repeat with processName in processList
				if contents of processName is equal to "Acrobat" then
					set processRunning to true
					exit repeat
				else
					set processRunning to false
					
				end if
			end repeat
			
			delay 1
			set counter to counter + 1
		end repeat
		
	end tell
	
	tell application "System Events"
		tell process "Acrobat"
			tell application "PowerSwitch_Service"
				log j level 1 message "trying to access file in acrobat -> accessing Window->file menu item"
			end tell
			set menuExist to false
			set countMax to 3
			set iterator to 0
			tell application "PowerSwitch_Service"
				log j level 1 message "Repeat until menu Window with proofFilename exist: " & proofFilename
			end tell
			repeat until menuExist is equal to true or iterator is equal to countMax
				try
					tell menu bar 1
						tell menu bar item "Window"
							tell menu "Window"
								click menu item proofFilename
							end tell
						end tell
					end tell
					set menuExist to true
				on error msg number n
					if n = -1728 then
						set menuExist to false
						tell application "Finder"
							open aTemplateFile using acroApp
							delay 1
						end tell
					end if
				end try
				
				set iterator to iterator + 1
				
				tell application "PowerSwitch_Service"
					log j level 1 message "Tried open file: " & proofFilename & " File has been opened (menuExist): " & menuExist
				end tell
			end repeat
		end tell
		
		tell application "PowerSwitch_Service"
			if menuExist is equal to false then
				job fail message "Can't start file " & aTemplateFile
			end if
		end tell
		
		tell application "PowerSwitch_Service"
			set outputPath to path of j
			send to single j path outputPath
		end tell
	end tell
	

--For Webaccess style, close file and repeat opening process
	if isWebAccess = "true"
		tell application "PowerSwitch_Service"
			log j level 1 message "WebAccess Style"
		end tell
		tell application "Finder"
			open aTemplateFile using acroApp
			delay 3
		end tell
		tell application "Adobe Acrobat Professional"
			delay 4
			activate
			delay 1
			close all docs saving yes
			quit
			delay 10
		end tell

	tell application "Finder"
		open aTemplateFile using acroApp
		delay 1
	end tell
	
	tell application "Adobe Acrobat Professional"
		activate
	end tell

	tell application "System Events"
		
		-- check if process is running and wait for it
		set processRunning to false
		set counter to 0
		set countMax to 20
		tell application "PowerSwitch_Service"
			log j level 1 message "Repeat until process Acrobat exists. Trying for 20 sec."
		end tell
		repeat until processRunning is equal to true or counter is equal to countMax
			set processList to name of every process
			repeat with processName in processList
				if contents of processName is equal to "Acrobat" then
					set processRunning to true
					exit repeat
				else
					set processRunning to false
					
				end if
			end repeat
			
			delay 1
			set counter to counter + 1
		end repeat
		
	end tell
	
	tell application "System Events"
		tell process "Acrobat"
			tell application "PowerSwitch_Service"
				log j level 1 message "trying to access file in acrobat -> accessing Window->file menu item"
			end tell
			set menuExist to false
			set countMax to 3
			set iterator to 0
			tell application "PowerSwitch_Service"
				log j level 1 message "Repeat until menu Window with proofFilename exist: " & proofFilename
			end tell
			repeat until menuExist is equal to true or iterator is equal to countMax
				try
					tell menu bar 1
						tell menu bar item "Window"
							tell menu "Window"
								click menu item proofFilename
							end tell
						end tell
					end tell
					set menuExist to true
				on error msg number n
					if n = -1728 then
						set menuExist to false
						tell application "Finder"
							open aTemplateFile using acroApp
							delay 1
						end tell
					end if
				end try
				
				set iterator to iterator + 1
				
				tell application "PowerSwitch_Service"
					log j level 1 message "Tried open file: " & proofFilename & " File has been opened (menuExist): " & menuExist
				end tell
			end repeat
		end tell
		
		tell application "PowerSwitch_Service"
			if menuExist is equal to false then
				job fail message "Can't start file " & aTemplateFile
			end if
		end tell
		
		tell application "PowerSwitch_Service"
			set outputPath to path of j
			send to single j path outputPath
		end tell
	end tell
	end if



	--tell application "Finder"
		--open aTemplateFile using acroApp
		--delay 3
	--end tell
	--tell application "Adobe Acrobat Professional"
		--delay 4
		--activate
	--end tell




	tell application "System Events"
		
		tell process "Acrobat"
			tell menu bar 1
				tell menu bar item "FusionPro"
					tell menu "FusionPro"
						click menu item "Re-compose"
						
						
						delay 2
						--if window "alert" exists then
						--end if
					end tell
				end tell
			end tell
		end tell
		
		
		
		-- wait until window exist
		tell application "FusionPro"
			repeat until window "FusionPro Composition System" exists
			end repeat
			repeat until window "FusionPro Composition System" is visible
			end repeat
			
		end tell
		
		
		--click button "Close" of window "FusionPro Composition System"
		tell application "System Events"
			tell process "FusionPro"
				tell application "PowerSwitch_Service"
					log j level 1 message "Waiting for button close"
				end tell
				repeat until button "Close" of window "FusionPro Composition System" exists
					delay 1
					tell application "PowerSwitch_Service"
						log j level 1 message "Waiting for button close"
					end tell
				end repeat
				tell application "PowerSwitch_Service"
					log j level 1 message "Press Close button ..."
				end tell
				tell application "PowerSwitch_Service"
					log j level 1 message "Button Close found"
				end tell
				
				tell application "FusionPro"
					close window "FusionPro Composition System"
					quit
				end tell
				
			end tell
		end tell
		
		
		tell application "Adobe Acrobat Professional" to close all docs saving "No"
		tell application "Adobe Acrobat Professional"
			quit
		end tell
		
		tell application "PowerSwitch_Service"
			set outputPath to path of j
			send to single j path outputPath
		end tell
	end tell
	
on error errText number eNumber from errObj
	tell application "PowerSwitch_Service"
		log j level 1 message "Error occured. Catched complete script:" & errText & ":" & eNumber & ":" & errObj
	end tell
end try