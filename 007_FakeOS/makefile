PACKAGE=de.kifaru.ndegendogo.kata.fakeOs.
PACKAGEPATH=de/kifaru/ndegendogo/kata/fakeOs/
SOURCEPATH=src/main/java/
JAVACALL=java -cp bin/ $(PACKAGE)

.PHONY: all
all: build

.PHONY: build
build: bin/$(PACKAGEPATH)Echo.class bin/$(PACKAGEPATH)TestEcho.class

.PHONY: test
test: test_echo

# verify output of my Echo, use the original echo command as reference.
assertEcho:=test "`echo $(1)`" = "`$(JAVACALL)Echo $(1)`"

.PHONY test_echo: thisWorksNotAsExpected
thisWorksNotAsExpected: bin/$(PACKAGEPATH)Echo.class
	$(call assertEcho,hello)

.PHONY test_echo: echoWithOneWordPrintsThisWord
echoWithOneWordPrintsThisWord: bin/$(PACKAGEPATH)Echo.class
	test "`echo hello`" = "`$(JAVACALL)Echo hello`"

.PHONY test_echo: echoWithAnotherWordPrintsThisOtherWord
echoWithAnotherWordPrintsThisOtherWord: bin/$(PACKAGEPATH)Echo.class
	test "`echo world`" = "`$(JAVACALL)Echo world`"

.PHONY test_echo: echoWithoutParametersPrintsNothing
echoWithoutParametersPrintsNothing: bin/$(PACKAGEPATH)Echo.class
	test "`echo`" = "`$(JAVACALL)Echo`"

.PHONY test_echo: echoWithFullSentencePrintsFullSentence
echoWithFullSentencePrintsFullSentence: bin/$(PACKAGEPATH)Echo.class
	test "`echo Hello world!`" = "`$(JAVACALL)Echo Hello world!`"

.PHONY: clean
clean:
	rm -rf bin/

bin/%.class: $(SOURCEPATH)%.java | bin/
	javac -cp bin/ -d bin/ $<

bin/:
	mkdir $@
