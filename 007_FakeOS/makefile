SOURCEPATH:=src/main/java/
UNITTESTPATH:=src/test/java/
PLUGINSPATH:=/Applications/eclipse/plugins/
JUNIT:=$(PLUGINSPATH)org.junit_4.11.0.v201303080030/junit.jar
HAMCREST:=$(PLUGINSPATH)org.hamcrest.core_1.3.0.v201303031735.jar
PACKAGEPATH:=de/kifaru/ndegendogo/kata/fakeOs/
PACKAGE:=de.kifaru.ndegendogo.kata.fakeOs.
CLASSPATH:=bin/
CLASSPATH_UNITTEST:=bin/:$(JUNIT)
JAVA:=java
JAVAFLAGS:=-cp $(CLASSPATH)
JAVAFLAGS_UNITTEST:=-cp bin/:$(JUNIT):$(HAMCREST)
JAVACFLAGS:=-cp $(CLASSPATH) -d $(CLASSPATH)
JAVACFLAGS_UNITTEST:=-cp $(CLASSPATH_UNITTEST) -d $(CLASSPATH)
RUN.class:=$(JAVA) $(JAVAFLAGS)
RUNECHO:=$(RUN.class) $(PACKAGE)Echo
RUN_UNITTEST:=$(JAVA) $(JAVAFLAGS_UNITTEST) org.junit.runner.JUnitCore

CLASSFILES:=bin/$(PACKAGEPATH)Echo.class
UNITTEST_CLASSFILES:=bin/$(PACKAGEPATH)TestEcho.class \
                  bin/$(PACKAGEPATH)TestStreams.class \

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
echoWithOneWordPrintsThisWord: bin/$(PACKAGEPATH)Echo.class
	$(call assertEcho, hello)

.PHONY test_echo: echoWithAnotherWordPrintsThisOtherWord
echoWithAnotherWordPrintsThisOtherWord: bin/$(PACKAGEPATH)Echo.class
	$(call assertEcho, world)

.PHONY test_echo: echoWithoutParametersPrintsNothing
echoWithoutParametersPrintsNothing: bin/$(PACKAGEPATH)Echo.class
	$(call assertEcho,)

.PHONY test_echo: echoWithFullSentencePrintsFullSentence
echoWithFullSentencePrintsFullSentence: bin/$(PACKAGEPATH)Echo.class
	$(call assertEcho, Hello world!)

.PHONY test_echo: echoWithTrailingSpacesPreservesTheSpaces
echoWithTrailingSpacesPreservesTheSpaces: bin/$(PACKAGEPATH)Echo.class
	$(call assertEcho, 'hello ')

.PHONY test_echo: echoWithEmptyArgumentPrintsNothing
echoWithEmptyArgumentPrintsNothing: bin/$(PACKAGEPATH)Echo.class
	$(call assertEcho, '')

.PHONY: clean
clean:
	$(RM) -r bin/

bin/%.class: $(SOURCEPATH)%.java | bin/
	javac $(JAVACFLAGS) $<

bin/%.class: $(UNITTESTPATH)%.java | bin/
	javac $(JAVACFLAGS_UNITTEST) $<

bin/:
	mkdir $@
