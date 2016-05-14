SOURCEPATH=src/main/java/
CLASSPATH=bin/
PACKAGE=de.kifaru.ndegendogo.kata.romanNumbers.
PACKAGEPATH=$(subst .,/,$(PACKAGE))
SOURCEFILES=$(wildcard $(SOURCEPATH)$(PACKAGEPATH)*.java)
CLASSFILES=$(patsubst $(SOURCEPATH)%.java,$(CLASSPATH)%.class,$(SOURCEFILES))

.PHONY: all
all: build run

.PHONY: run
run: build
	java -cp $(CLASSPATH) $(PACKAGE)ConvertRomanMain

.PHONY: build
build: $(CLASSFILES)

$(CLASSPATH)%.class: $(SOURCEPATH)%.java | $(CLASSPATH)
	javac -sourcepath $(SOURCEPATH) -d $(CLASSPATH) $(SOURCEFILES)

$(CLASSPATH):
	mkdir $@

.PHONY: clean
clean:
	rm -rf bin
