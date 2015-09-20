# Java-Reflection-and-Object-Comparison-in-Java
Project Description

Design a Java class, First, in the following way:

  2 private data members int IntValue;
  String StringValue; empty constructor
  define the public method void setIntValue(int iIn) {... }
  define the public method void setStringValue(String sIn) {... } Design a Java class, Second, in the following way:
  2 private data members double DoubleValue;
  int IntValue; empty constructor
  define the public method void setIntValue(int iIn) {... }
  define the public method void setDoubleValue(double dIn) {... }

Define a class PopulateObjects that has data structures (as data members) to store instances of First and Second. Choose the data structure(s) that are efficient to determine the total number of non-duplicate object instances, and the total number of object instances (includes duplicates).
PopulateObjects should have a method deserObjects(...) to read data member values from an inputFile and accordingly create instances of First and Second. Decide the appropriate return value and parameters for the method deserObjects

In PopulateObjects First and Second, override equals and hashCode, with annotation, appropriately. You can design additional methods in PopulateObjects as needed.
The class FileProcessor should be used to read one line at a time from the file.

The input file will have data in the following format:

fqn:objComp.util.First
type=int, var=IntValue, value=17 type=String, var=StringValue, value=abc fqn:objComp.util.Second
type=int, var=IntValue, value=19 type=double, var=DoubleValue, value=3.14 fqn:objComp.util.Second
type=double, var=DoubleValue, value=4.13 type=int, var=IntValue, value=21 fqn:objComp.util.Second
type=int, var=IntValue, value=21 type=double, var=DoubleValue, value=3.14 fqn:objComp.util.First
type=int, var=IntValue, value=17 type=String, var=StringValue, value=abc fqn:objComp.util.First
type=int, var=IntValue, value=19 type=String, var=StringValue, value=def ...

Use java reflection ( newInstance method) to create an object using the value given for fqn. Please note that fqn is an abbreviation for Fully Quallified Class Name.
Here is an example of Java reflection code to create an object from given fqn value. This code then shows how to invoke a method.

￼￼￼￼￼￼￼￼￼String clsName = "objComp.util.First"; Class cls = Class.forName(clsName); Class[] signature = new Class[1]; signature[0] = Integer.TYPE;

String methdName = "set" + "IntValue";

Method meth = cls.getMethod(methodName, signature); Object obj = cls.newInstance();

Object[] params = new Object[1];

params[0] = new Integer(17);

Object result = meth.invoke(obj, params);

Populate the data structures with instances of First and Second.
Read the following link about boxed primitives, Integer.TYPE, and Integer.class in the context of Java reflection.
Generalize the above code so it works for both First and Second objects. For example, you need to set signature[0] value by looking up a map that returns "Integer.TYPE" for the key "int".
Populate the data structure in PopulateObjects class withe instances of First and Second that are read from the file.
Design and implement methods in the PopulateObjects class to return the number of non-duplicate instances of First and Second.
Design and implement methods in the PopulateObjects class to return the total number of instances of First and Second.
The Driver code should call the PopulateObjects class to populate the data structures and print output on the number of objects.

Report the performance of your code:
long startTime = System.currentTimeMillis();
Start of loop NUM_ITERATIONS times
// All the code in Driver, except the final 3 lines shown below to print the performance End of loop
long finishTime = System.currentTimeMillis();
Calculate total_time as (finishTime-startTime)/NUM_ITERATIONS.

The following should be read from command line: input file name, the value of NUM_ITERATIONS, and DEBUG_V ALUE.

Use the Logger class from the previous assignment along with your own debug scheme.
