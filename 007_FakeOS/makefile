.PHONY: all
all:

.PHONY: test
test: test_echo

.PHONY: test_echo
test_echo: Echo.class
#	java Echo
#	test `echo hello` = `java Echo hello`

.PHONY: clean
clean:
	rm -rf bin

Echo.class: src/main/java/de/kifaru/ndegendogo/kata/fakeOs/Echo.java bin
	javac -cp bin -d bin src/main/java/de/kifaru/ndegendogo/kata/fakeOs/Echo.java

bin:
	mkdir bin
