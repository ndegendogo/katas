SOURCEPATH:=src/main/java/
PACKAGEPATH:=de/kifaru/ndegendogo/kata/fakeOs/
PACKAGE:=de.kifaru.ndegendogo.kata.fakeOs.
JAVA:=java
JAVAFLAGS:=-cp bin/
RUN.class:=$(JAVA) $(JAVAFLAGS)
RUNECHO:=$(RUN.class) $(PACKAGE)Echo

.PHONY: all
all: build

.PHONY: build
build: bin/$(PACKAGEPATH)Echo.class bin/$(PACKAGEPATH)TestEcho.class

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

.PHONY: clean
clean:
	$(RM) -r bin/

bin/%.class: $(SOURCEPATH)%.java | bin/
	javac -cp bin/ -d bin/ $<

bin/:
	mkdir $@
