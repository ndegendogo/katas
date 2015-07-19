PACKAGE=de.kifaru.ndegendogo.kata.fakeOs.
PACKAGEPATH=de/kifaru/ndegendogo/kata/fakeOs/
SOURCEPATH=src/main/java/


.PHONY: all
all:

.PHONY: test
test: test_echo

.PHONY: test_echo
test_echo: bin/$(PACKAGEPATH)Echo.class
	java -cp bin $(PACKAGE)Echo
#	test `echo hello` = `java Echo hello`

.PHONY: clean
clean:
	rm -rf bin

bin/$(PACKAGEPATH)Echo.class: $(SOURCEPATH)$(PACKAGEPATH)Echo.java bin
	javac -cp bin -d bin $(SOURCEPATH)$(PACKAGEPATH)Echo.java

bin:
	mkdir bin
