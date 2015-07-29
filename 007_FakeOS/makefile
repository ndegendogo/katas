SOURCEPATH:=src/main/java/
UNITTESTPATH:=src/test/java/
PLUGINSPATH:=/Applications/eclipse/plugins/
JUNIT:=$(PLUGINSPATH)org.junit_4.11.0.v201303080030/junit.jar
HAMCREST:=$(PLUGINSPATH)org.hamcrest.core_1.3.0.v201303031735.jar
PACKAGEPATH:=de/kifaru/ndegendogo/kata/fakeOs/
PACKAGE:=de.kifaru.ndegendogo.kata.fakeOs.
CLASSPATH:=bin/
JAVA:=java
JAVAFLAGS:=-cp $(CLASSPATH)
JAVAFLAGS_UNITTEST:=-cp $(CLASSPATH):$(JUNIT):$(HAMCREST)
JAVACFLAGS:=-cp $(CLASSPATH) -d $(CLASSPATH)
JAVACFLAGS_UNITTEST:=-cp $(CLASSPATH):$(JUNIT) -d $(CLASSPATH)
RUN.class:=$(JAVA) $(JAVAFLAGS)
RUNECHO:=$(RUN.class) $(PACKAGE)Echo
RUNCAT:=$(RUN.class) $(PACKAGE)Cat
RUN_UNITTEST:=$(JAVA) $(JAVAFLAGS_UNITTEST) org.junit.runner.JUnitCore

CLASSFILE_ECHO:=$(CLASSPATH)$(PACKAGEPATH)Echo.class
CLASSFILE_CAT:=$(CLASSPATH)$(PACKAGEPATH)Cat.class

CLASSFILES:=$(CLASSFILE_ECHO) \
            $(CLASSFILE_CAT) \

UNITTEST_MODULES:=TestEcho \
                  TestStreams \
                  TestCat \

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
test: test_echo test_cat

.PHONY: unittest
unittest: build_all
	$(RUN_UNITTEST) $(UNITTEST_CLASSES)

.PHONY: clean
clean:
	$(RM) -r $(CLASSPATH)

# verify output of the fakeOS programs, use the original shell commands as reference.
assertEcho=test "`echo$(1)`" = "`$(RUNECHO)$(1)`"
assertCat=test "`cat$(1)`" = "`$(RUNCAT)$(1)`"

# the test cases for the blackbox tests
.PHONY test_echo: echoWithOneWordPrintsThisWord
echoWithOneWordPrintsThisWord: $(CLASSFILE_ECHO)
	$(call assertEcho, hello)

.PHONY test_echo: echoWithAnotherWordPrintsThisOtherWord
echoWithAnotherWordPrintsThisOtherWord: $(CLASSFILE_ECHO)
	$(call assertEcho, world)

.PHONY test_echo: echoWithoutParametersPrintsNothing
echoWithoutParametersPrintsNothing: $(CLASSFILE_ECHO)
	$(call assertEcho,)

.PHONY test_echo: echoWithFullSentencePrintsFullSentence
echoWithFullSentencePrintsFullSentence: $(CLASSFILE_ECHO)
	$(call assertEcho, Hello world!)

.PHONY test_echo: echoWithTrailingSpacesPreservesTheSpaces
echoWithTrailingSpacesPreservesTheSpaces: $(CLASSFILE_ECHO)
	$(call assertEcho, 'hello ')

.PHONY test_echo: echoWithEmptyArgumentPrintsNothing
echoWithEmptyArgumentPrintsNothing: $(CLASSFILE_ECHO)
	$(call assertEcho, '')


.PHONY test_cat: catOneFileWithSingleLine
catOneFileWithSingleLine: $(CLASSFILE_CAT)
	$(call assertCat, data/file1)

.PHONY test_cat: catAnotherSingleFileWithSingleLine
catAnotherSingleFileWithSingleLine: $(CLASSFILE_CAT)
	$(call assertCat, data/file2)

.PHONY test_cat: catSingleLineWithUnixEnding
catSingleLineWithUnixEnding: $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineUnix)

.PHONY test_cat: catSingleLineWithWindowsEnding
catSingleLineWithWindowsEnding: $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineWindows)

.PHONY test_cat: catSingleLineWithMacEnding
catSingleLineWithMacEnding: $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineMac)

.PHONY test_cat: catSingleLineWithoutEnding
catSingleLineWithoutEnding: $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineNoEnd)


$(CLASSPATH)%.class: $(SOURCEPATH)%.java | $(CLASSPATH)
	javac $(JAVACFLAGS) $<

$(CLASSPATH)%.class: $(UNITTESTPATH)%.java | $(CLASSPATH)
	javac $(JAVACFLAGS_UNITTEST) $<

$(CLASSPATH):
	mkdir $@
