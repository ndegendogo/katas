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

CLASSFILES:=$(CLASSPATH)$(PACKAGEPATH)Echo.class \
            $(CLASSPATH)$(PACKAGEPATH)Cat.class \

UNITTEST_CLASSFILES:=$(CLASSPATH)$(PACKAGEPATH)TestEcho.class \
                     $(CLASSPATH)$(PACKAGEPATH)TestStreams.class \

ALL_CLASSFILES:=$(CLASSFILES) $(UNITTEST_CLASSFILES)
UNITTEST_CLASSES:=$(PACKAGE)TestEcho \
                  $(PACKAGE)TestStreams \


.PHONY: all
all: build_all test unittest

.PHONY: build_all
build_all: $(ALL_CLASSFILES)

.PHONY: build
build: $(CLASSFILES)

.PHONY: test
test: test_echo testcat

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
echoWithOneWordPrintsThisWord: $(CLASSPATH)$(PACKAGEPATH)Echo.class
	$(call assertEcho, hello)

.PHONY test_echo: echoWithAnotherWordPrintsThisOtherWord
echoWithAnotherWordPrintsThisOtherWord: $(CLASSPATH)$(PACKAGEPATH)Echo.class
	$(call assertEcho, world)

.PHONY test_echo: echoWithoutParametersPrintsNothing
echoWithoutParametersPrintsNothing: $(CLASSPATH)$(PACKAGEPATH)Echo.class
	$(call assertEcho,)

.PHONY test_echo: echoWithFullSentencePrintsFullSentence
echoWithFullSentencePrintsFullSentence: $(CLASSPATH)$(PACKAGEPATH)Echo.class
	$(call assertEcho, Hello world!)

.PHONY test_echo: echoWithTrailingSpacesPreservesTheSpaces
echoWithTrailingSpacesPreservesTheSpaces: $(CLASSPATH)$(PACKAGEPATH)Echo.class
	$(call assertEcho, 'hello ')

.PHONY test_echo: echoWithEmptyArgumentPrintsNothing
echoWithEmptyArgumentPrintsNothing: $(CLASSPATH)$(PACKAGEPATH)Echo.class
	$(call assertEcho, '')

.PHONY test_cat:



$(CLASSPATH)%.class: $(SOURCEPATH)%.java | $(CLASSPATH)
	javac $(JAVACFLAGS) $<

$(CLASSPATH)%.class: $(UNITTESTPATH)%.java | $(CLASSPATH)
	javac $(JAVACFLAGS_UNITTEST) $<

$(CLASSPATH):
	mkdir $@
