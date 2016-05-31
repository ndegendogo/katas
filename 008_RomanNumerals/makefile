# setup environment. You may override this with your own UserConfig.mak file.
include $(or $(wildcard UserConfig.mak),DefaultUserConfig.mak)

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

ClassnamesFromSourcefiles=$(call PathToPackage,$(patsubst $(2)%.java,%,$(1)))
CLASSES:=$(call ClassnamesFromSourcefiles,$(SOURCEFILES),$(BASEPATH_SOURCE))
CLASSES_TEST:=$(call ClassnamesFromSourcefiles,$(SOURCEFILES_TEST),$(BASEPATH_TEST))

ClassfilesFromClassnames=$(patsubst %,$(BASEPATH_CLASSES)%.class,$(call PackageToPath,$(1)))
CLASSFILES:=$(call ClassfilesFromClassnames,$(CLASSES))
CLASSFILES_TEST:=$(call ClassfilesFromClassnames,$(CLASSES_TEST))

.PHONY: all
all: build run unittest

.PHONY: run
run: build
	java -cp $(BASEPATH_CLASSES) $(PACKAGE)RomanConverterMain

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
	javac -sourcepath $(BASEPATH_TEST) -cp $(BASEPATH_CLASSES):$(LIB_JUNIT) -d $(BASEPATH_CLASSES) $(SOURCEFILES_TEST)

$(BASEPATH_CLASSES):
	mkdir $@

.PHONY: clean
clean:
	$(RM) -r bin
