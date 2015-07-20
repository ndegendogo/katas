PACKAGE=de.kifaru.ndegendogo.kata.fakeOs.
PACKAGEPATH=de/kifaru/ndegendogo/kata/fakeOs/
SOURCEPATH=src/main/java/
JAVACALL=java -cp bin $(PACKAGE)

.PHONY: all
all: build

.PHONY: build
build: bin/$(PACKAGEPATH)Echo.class bin/$(PACKAGEPATH)TestEcho.class

.PHONY: test
test: test_echo

.PHONY: test_echo
test_echo: bin/$(PACKAGEPATH)Echo.class
	test "`echo hello`" = "`$(JAVACALL)Echo hello`"
	test "`echo world`" = "`$(JAVACALL)Echo world`"
	test "`echo`" = "`$(JAVACALL)Echo`"
	test "`echo Hello world!`" = "`$(JAVACALL)Echo Hello world!`"

.PHONY: clean
clean:
	rm -rf bin/

bin/$(PACKAGEPATH)Echo.class: $(SOURCEPATH)$(PACKAGEPATH)Echo.java | bin/
	javac -cp bin -d bin $(SOURCEPATH)$(PACKAGEPATH)Echo.java

bin/:
	mkdir bin/
