JCC = javac
JFLAGS = -g
JVM = java
JCP = -cp .:gson-2.2.4.jar

default: Words.class

Words.class: Words.java
	$(JCC) $(JFLAGS) $(JCP) Words.java

clean:
	$(RM) *.class
	$(RM) Words.jar

run:
	$(JVM) $(JCP) Words

jar:
	jar cvmf manifest.txt Words.jar *.java *.class makefile gson-2.2.4.jar
