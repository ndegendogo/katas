BASEPATH_SOURCE:=src/main/java/
BASEPATH_TEST:=src/test/java/
BASEPATH_CLASSES:=bin/

PackageToPath=$(subst .,/,$(1))
PathToPackage=$(subst /,.,$(1))

PACKAGE:=de.kifaru.ndegendogo.kata.romanNumbers.
PACKAGEPATH:=$(call PackageToPath,$(PACKAGE))

FindSourcefiles=$(wildcard $(1)$(PACKAGEPATH)*.java)
SOURCEFILES:=$(call FindSourcefiles,$(BASEPATH_SOURCE))
SOURCEFILES_TEST:=$(call FindSourcefiles,$(BASEPATH_TEST))

CLASSFILES:=$(patsubst $(BASEPATH_SOURCE)%.java,$(BASEPATH_CLASSES)%.class,$(SOURCEFILES))
CLASSFILES_TEST:=$(patsubst $(BASEPATH_TEST)%.java,$(BASEPATH_CLASSES)%.class,$(SOURCEFILES_TEST))
CLASSES_TEST:=$(subst /,.,$(patsubst $(BASEPATH_CLASSES)%.class,%,$(CLASSFILES_TEST)))

LIBPATH_JUNIT:=$(JUNIT_HOME)/
LIB_JUNIT:=$(LIBPATH_JUNIT)junit.jar
LIBPATH_HAMCREST:=/Applications/eclipse/plugins/
LIB_HAMCREST:=$(LIBPATH_HAMCREST)org.hamcrest.core_1.3.0.v201303031735.jar

.PHONY: all
all: build run unittest

.PHONY: run
run: build
	java -cp $(BASEPATH_CLASSES) $(PACKAGE)ConvertRomanMain

.PHONY: build
build: $(CLASSFILES)

.PHONY: unittest
unittest: build_test
	java -cp $(BASEPATH_CLASSES):$(LIB_JUNIT):$(LIB_HAMCREST) org.junit.runner.JUnitCore $(CLASSES_TEST)

.PHONY: build_test
build_test: $(CLASSFILES) $(CLASSFILES_TEST)

$(BASEPATH_CLASSES)%.class: $(BASEPATH_SOURCE)%.java | $(BASEPATH_CLASSES)
	javac -sourcepath $(BASEPATH_SOURCE) -d $(BASEPATH_CLASSES) $(SOURCEFILES)

$(BASEPATH_CLASSES)%.class: $(BASEPATH_TEST)%.java | $(BASEPATH_CLASSES)
	javac -sourcepath $(BASEPATH_TEST) -cp $(LIB_JUNIT) -d $(BASEPATH_CLASSES) $(SOURCEFILES_TEST)

$(BASEPATH_CLASSES):
	mkdir $@

.PHONY: clean
clean:
	rm -rf bin
