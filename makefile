JCC = javac
JFLAGS = -g
JVM = java
JCP = -cp .:gson-2.2.4.jar

default: Words.class

WxStation.class: Words.java
	$(JCC) $(JFLAGS) $(JCP) Words.java

clean:
	$(RM) *.class

run:
	$(JVM) $(JCP) Words
