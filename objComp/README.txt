CS542 Design Patterns
Spring 2015
PROJECT <5> README FILE

Due Date: <Monday, May 4, 2015>
Submission Date: <May 5, 2015>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Nagare Pravin> 
e-mail(s): <pnagare1@binghamton.edu> 

PURPOSE:
[
  Learn and implement reflection. Also, understand hashCode and equals method and override them.
]

PERCENT COMPLETE:
[
  100%
]

PARTS THAT ARE NOT COMPLETE:
[
	Everything is completed according to requirements. 
]

BUGS:

[
  None
]

FILES:

[

Included with this project are 6 class files:
Class files-
Driver.java: 	Contains main function to drive the program.
FileProcessor.java: 	The file to read from an input file and write to an output file
Logger.java: 	File to print message according to the debug value.
First.java:	 the file to set IntValue and StringValue.
Second.Java:	 the file to set IntVaue and Double Value
PopulateObjects.java:	 The file containing Data Struct Map and performing operations to count duplicate and uniq objects.

README.txt
]

SAMPLE OUTPUT:

[
Pravins-Mac:objComp pravin$ ant -buildfile src/build.xml run -Darg0=inputbig.txt -Darg1=1 -Darg2=0
Buildfile: /Users/pravin/Documents/workspace/objComp/src/build.xml

jar:
    [mkdir] Created dir: /Users/pravin/Documents/workspace/objComp/BUILD/jar
      [jar] Building jar: /Users/pravin/Documents/workspace/objComp/BUILD/jar/objComp.jar

run:
     [java] Number of non-duplidate First objects: 237
     [java] Total Number of First objects: 474
     [java] Number of non-duplidate Second objects: 263
     [java] Total Number of Second objects: 526
     [java] Total time: 0.126 seconds

BUILD SUCCESSFUL
Total time: 0 seconds
]

TO COMPILE:

[
  ant -buildfile src/build.xml all
]

TO RUN:

[
  ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=1 -Darg3=1


]
EXTRA CREDIT:

[
  HashMap Data Structure: I used 2 hasMap to store the objects of First and Second and 
  integer counter as value. This is appropriate data structure for this assignment as the insertion
  and deletion operation can be performed in big-o 1 operation. Also, total number of duplicates and 
  non-duplicates objects can be found in big-o of n where n, is the total number of unique arguments of
  of First and Second. 

  Project running successfully on eclipse as well as using ANT. 
  DEBUG_VALUE=0 [Print to stdout the number of non-duplicate and total instances of First and Second]			
  DEBUG_VALUE=1 [Print to stdout every time a constructor is called] 
  DEBUG_VALUE=2 [Print to stdout every time a method other than constructor is called] 

]

BIBLIOGRAPHY:

[

Class Notes.
http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html

]

ACKNOWLEDGEMENT:
[

Prof. Madhusudhan Govindaraju
cs542.cs.binghamton.edu mailing list

]
