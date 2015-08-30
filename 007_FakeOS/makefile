# setup environment. You may override this with your own UserConfig.mak file.
include $(or $(wildcard UserConfig.mak), DefaultUserConfig.mak)


SOURCEPATH:=src/main/java/
UNITTESTPATH:=src/test/java/
PACKAGEPATH:=de/kifaru/ndegendogo/kata/fakeOs/
PACKAGE:=de.kifaru.ndegendogo.kata.fakeOs.
CLASSPATH:=bin/
JAVAFLAGS:=-cp $(CLASSPATH)
JAVAFLAGS_UNITTEST:=-cp $(CLASSPATH):$(JUNIT):$(HAMCREST)
JAVACFLAGS:=-cp $(CLASSPATH) -d $(CLASSPATH)
JAVACFLAGS_UNITTEST:=-cp $(CLASSPATH):$(JUNIT) -d $(CLASSPATH)
RUN.class:=$(JAVA) $(JAVAFLAGS)
RUN_UNITTEST:=$(JAVA) $(JAVAFLAGS_UNITTEST) org.junit.runner.JUnitCore

MODULES:=$(basename $(notdir $(shell find $(SOURCEPATH)$(PACKAGEPATH) -name "*.java")))
UNITTEST_MODULES:=$(basename $(notdir $(shell find $(UNITTESTPATH)$(PACKAGEPATH) -name "*.java")))

CLASSFILES:=$(foreach module,$(MODULES),$(CLASSPATH)$(PACKAGEPATH)$(module).class)
UNITTEST_CLASSFILES:=$(foreach module,$(UNITTEST_MODULES),$(CLASSPATH)$(PACKAGEPATH)$(module).class)
ALL_CLASSFILES:=$(CLASSFILES) $(UNITTEST_CLASSFILES)

UNITTEST_CLASSES:=$(foreach module,$(UNITTEST_MODULES),$(PACKAGE)$(module))


.PHONY: all
all: build_all test unittest

.PHONY: build_all
build_all: $(ALL_CLASSFILES)

.PHONY: build
build: $(CLASSFILES)

.PHONY: test
test: test_echo test_cat test_head

.PHONY: unittest
unittest: build_all
	$(RUN_UNITTEST) $(UNITTEST_CLASSES)

.PHONY: clean
clean: cleanTempOutputFiles
	$(RM) -r $(CLASSPATH)

.PHONY: cleanTempOutputFiles
cleanTempOutputFiles:
	$(RM) expectedOutputOf_*
	$(RM) actualOutputOf_*

# blackbox tests for FakeOS
include TestEcho.mak
include TestCat.mak
include TestHead.mak

$(CLASSPATH)%.class: $(SOURCEPATH)%.java | $(CLASSPATH)
	javac $(JAVACFLAGS) $<

$(CLASSPATH)%.class: $(UNITTESTPATH)%.java | $(CLASSPATH)
	javac $(JAVACFLAGS_UNITTEST) $<

$(CLASSPATH):
	mkdir $@
