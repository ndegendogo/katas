.PHONY: all
all:

.PHONY: test
test: test_echo

.PHONY: test_echo
test_echo: bin/de/kifaru/ndegendogo/kata/fakeOs/Echo.class
	java -cp bin de.kifaru.ndegendogo.kata.fakeOs.Echo
#	test `echo hello` = `java Echo hello`

.PHONY: clean
clean:
	rm -rf bin

bin/de/kifaru/ndegendogo/kata/fakeOs/Echo.class: src/main/java/de/kifaru/ndegendogo/kata/fakeOs/Echo.java bin
	javac -cp bin -d bin src/main/java/de/kifaru/ndegendogo/kata/fakeOs/Echo.java

bin:
	mkdir bin
