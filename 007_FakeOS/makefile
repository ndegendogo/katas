# setup environment. You may override this with your own UserConfig.mak file.
include $(or $(wildcard UserConfig.mak), DefaultUserConfig.mak)


SOURCEPATH:=src/main/java/
TESTPATH:=src/test/java/
PACKAGEPATH:=de/kifaru/ndegendogo/kata/fakeOs/
PACKAGE:=de.kifaru.ndegendogo.kata.fakeOs.
CLASSPATH:=bin/
JAVAFLAGS:=-cp $(CLASSPATH)
JAVAFLAGS_UNITTEST:=-cp $(CLASSPATH):$(JUNIT):$(HAMCREST)
JAVACFLAGS:=-cp $(CLASSPATH) -d $(CLASSPATH)
JAVACFLAGS_TEST:=-cp $(CLASSPATH):$(JUNIT) -d $(CLASSPATH)
RUN.class:=$(JAVA) $(JAVAFLAGS)
RUN_UNITTEST:=$(JAVA) $(JAVAFLAGS_UNITTEST) org.junit.runner.JUnitCore

MODULES:=$(basename $(notdir $(shell find $(SOURCEPATH)$(PACKAGEPATH) -name "*.java")))
UNITTEST_MODULES:=$(basename $(notdir $(shell find $(TESTPATH)$(PACKAGEPATH) -name "*.java")))
TESTCASE_MODULES:=$(basename $(notdir $(shell find $(TESTPATH)$(PACKAGEPATH) -name "Test*.java")))

CLASSFILES:=$(foreach module,$(MODULES),$(CLASSPATH)$(PACKAGEPATH)$(module).class)
UNITTEST_CLASSFILES:=$(foreach module,$(UNITTEST_MODULES),$(CLASSPATH)$(PACKAGEPATH)$(module).class)
TESTCASE_CLASSFILES:=$(foreach module,$(TESTCASE_MODULES),$(CLASSPATH)$(PACKAGEPATH)$(module).class)
ALL_CLASSFILES:=$(CLASSFILES) $(UNITTEST_CLASSFILES)

TESTCASE_CLASSES:=$(foreach module,$(TESTCASE_MODULES),$(PACKAGE)$(module))


.PHONY: all
all: build_all blackboxtest unittest

.PHONY: build_all
build_all: $(ALL_CLASSFILES)

.PHONY: build
build: $(CLASSFILES)

.PHONY: unittest
unittest: build_all
	$(RUN_UNITTEST) $(TESTCASE_CLASSES)

.PHONY: clean
clean: cleanTempOutputFiles
	$(RM) -r $(CLASSPATH)

# blackbox tests for FakeOS
include BlackboxTests.mak

$(CLASSPATH)%.class: $(SOURCEPATH)%.java | $(CLASSPATH)
	javac $(JAVACFLAGS) $<

$(CLASSPATH)%.class: $(TESTPATH)%.java | $(CLASSPATH)
	javac $(JAVACFLAGS_TEST) $<

$(CLASSPATH):
	mkdir $@
