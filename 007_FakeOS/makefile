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
RUN_UNITTEST:=$(JAVA) $(JAVAFLAGS_UNITTEST) org.junit.runner.JUnitCore

CLASSFILES:=$(CLASSPATH)$(PACKAGEPATH)Echo.class
UNITTEST_CLASSFILES:=$(CLASSPATH)$(PACKAGEPATH)TestEcho.class \
                     $(CLASSPATH)$(PACKAGEPATH)TestStreams.class \

ALL_CLASSFILES:=$(CLASSFILES) $(UNITTEST_CLASSFILES)
UNITTEST_CLASSES:=$(PACKAGE)TestEcho \
                  $(PACKAGE)TestStreams \


.PHONY: all
all: build_all test run_unittests

.PHONY: build_all
build_all: build build_unittests

.PHONY: build
build: $(CLASSFILES)

.PHONY: build_unittests
build_unittests: $(ALL_CLASSFILES) 

.PHONY: run_unittests
run_unittests: build_unittests
	$(RUN_UNITTEST) $(UNITTEST_CLASSES)

.PHONY: test
test: test_echo

# verify output of my Echo, use the original echo command as reference.
assertEcho=test "`echo$(1)`" = "`$(RUNECHO)$(1)`"

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

.PHONY: clean
clean:
	$(RM) -r $(CLASSPATH)

$(CLASSPATH)%.class: $(SOURCEPATH)%.java | $(CLASSPATH)
	javac $(JAVACFLAGS) $<

$(CLASSPATH)%.class: $(UNITTESTPATH)%.java | $(CLASSPATH)
	javac $(JAVACFLAGS_UNITTEST) $<

$(CLASSPATH):
	mkdir $@
