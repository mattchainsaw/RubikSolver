## -g flag is for debug
JC= javac -g

all: Tests

Tests: FaceTest
	
FaceTest: FaceTester.class

FaceTester.class: FaceException.class Face.class FaceTester.java
	$(JC) FaceTester.java

FaceException.class: FaceException.java
	 $(JC) FaceException.java

Face.class: Face.java
	$(JC) Face.java


clean:
	rm -f *.class
