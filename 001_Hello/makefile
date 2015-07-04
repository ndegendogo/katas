.PHONY: all
all: hello

.PHONY: hello
hello:
	echo "Hello, world!"

cleanJava:
	rm -f *.class

.PHONY: buildJava
buildJava: Hello.class

.PHONY: runJava
runJava: Hello.class
	java Hello


Hello.class: Hello.java
	javac Hello.java

