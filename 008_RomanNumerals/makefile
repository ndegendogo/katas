SOURCEPATH=src/main/java/
CLASSPATH=bin/
PACKAGE=de.kifaru.ndegendogo.kata.romanNumbers.
PACKAGEPATH=$(subst .,/,$(PACKAGE))
SOURCEFILES=$(wildcard $(SOURCEPATH)$(PACKAGEPATH)*.java)
CLASSFILES=$(patsubst $(SOURCEPATH)%.java,$(CLASSPATH)%.class,$(SOURCEFILES))

all: build run

run: build
	java -cp $(CLASSPATH) $(PACKAGE)ConvertRomanMain

build: bin $(CLASSFILES)
	javac -sourcepath $(SOURCEPATH) -d $(CLASSPATH) $(SOURCEFILES)

bin:
	mkdir $(CLASSPATH)

.PHONY: clean
clean:
	rm -rf bin
