SOURCEPATH=src/main/java/
CLASSPATH=bin/
PACKAGE=de.kifaru.ndegendogo.kata.romanNumbers.
PACKAGEPATH=$(subst .,/,$(PACKAGE))
SOURCEFILES=$(wildcard $(SOURCEPATH)$(PACKAGEPATH)*.java)

all: run

run: build
	java -cp $(CLASSPATH) $(PACKAGE)ConvertRomanMain

.PHONY: build
build: bin
	javac -sourcepath $(SOURCEPATH) -d $(CLASSPATH) $(SOURCEFILES)

bin:
	mkdir $(CLASSPATH)

.PHONY: clean
clean:
	rm -rf bin
