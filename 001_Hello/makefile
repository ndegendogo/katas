.PHONY: all
all: hello

.PHONY: hello
hello:
	echo "Hello, world!"

.PHONY: cleanJava
cleanJava:
	rm -f *.class

.PHONY: buildJava
buildJava: Hello.class

.PHONY: runJava
runJava: Hello.class
	java Hello

.PHONY: testJava
testJava: Hello.class
	test "$$(java Hello)" = 'Hello, world!'

Hello.class: Hello.java
	javac Hello.java

