PWD=`pwd`
SRC=$(PWD)/src/
BIN=$(PWD)/bin/
DOC=$(PWD)/doc/
JC=javac
FLAG1= -d $(BIN)
FLAG2= -cp $(BIN)
.SUFFIXES:
.SUFFIXES: .java .class 
.java.class:
	$(JC) $(FLAG1) $(FLAG2) $*.java
.java.java:
.class.class:

SOURCES= \
	 $(SRC)Face.java \
	 $(SRC)Solvable.java \
	 $(SRC)Cube.java \
	 $(SRC)Algorithm.java \
	 $(SRC)Input.java \
	 $(SRC)RubikSolver.java

all: classes
	@echo "Build Successful!"
	@echo "Enter \"make doc\" to generate documentation"
	@echo "Enter \"java -cp bin Solver\" to run"

classes:
	@mkdir -p $(BIN)
	@$(JC) $(FLAG1) $(FLAG2) $(SOURCES)

doc: 
	@mkdir -p $(DOC)
	@javadoc -quiet -author -d $(DOC) $(SOURCES) $(EXE)
	@echo "Documentation has been generated and can be found in the directory:"
	@echo "     $(DOC)"

clean:
	@$(RM) -r $(BIN)
	@$(RM) -r $(DOC)
