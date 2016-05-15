SOURCEPATH=src/main/java/
CLASSPATH=bin/
PACKAGE=de.kifaru.ndegendogo.kata.romanNumbers.
PACKAGEPATH=$(subst .,/,$(PACKAGE))
SOURCEFILES=$(wildcard $(SOURCEPATH)$(PACKAGEPATH)*.java)
CLASSFILES=$(patsubst $(SOURCEPATH)%.java,$(CLASSPATH)%.class,$(SOURCEFILES))
SOURCEPATH_TEST=src/test/java/
SOURCEFILES_TEST=$(wildcard $(SOURCEPATH_TEST)$(PACKAGEPATH)*.java)
CLASSFILES_TEST=$(patsubst $(SOURCEPATH_TEST)%.java,$(CLASSPATH)%.class,$(SOURCEFILES_TEST))
CLASSES_TEST=$(subst /,.,$(patsubst $(CLASSPATH)%.class,%,$(CLASSFILES_TEST)))
LIBPATH_JUNIT=$(JUNIT_HOME)/
LIB_JUNIT=$(LIBPATH_JUNIT)junit.jar
LIBPATH_HAMCREST=/Applications/eclipse/plugins/
LIB_HAMCREST=$(LIBPATH_HAMCREST)org.hamcrest.core_1.3.0.v201303031735.jar

.PHONY: all
all: build run unittest

.PHONY: run
run: build
	java -cp $(CLASSPATH) $(PACKAGE)ConvertRomanMain

.PHONY: build
build: $(CLASSFILES)

.PHONY: unittest
unittest: build_test
	java -cp $(CLASSPATH):$(LIB_JUNIT):$(LIB_HAMCREST) org.junit.runner.JUnitCore $(CLASSES_TEST)

.PHONY: build_test
build_test: $(CLASSFILES) $(CLASSFILES_TEST)

$(CLASSPATH)%.class: $(SOURCEPATH)%.java | $(CLASSPATH)
	javac -sourcepath $(SOURCEPATH) -d $(CLASSPATH) $(SOURCEFILES)

$(CLASSPATH)%.class: $(SOURCEPATH_TEST)%.java | $(CLASSPATH)
	javac -sourcepath $(SOURCEPATH_TEST) -cp $(LIB_JUNIT) -d $(CLASSPATH) $(SOURCEFILES_TEST)

$(CLASSPATH):
	mkdir $@

.PHONY: clean
clean:
	rm -rf bin
