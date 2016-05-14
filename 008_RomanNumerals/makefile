all: run

run: compile
	java -cp bin/ de.kifaru.ndegendogo.kata.romanNumbers.ConvertRomanMain

.PHONY: compile
compile: bin
	javac -sourcepath src/main/java -d bin src/main/java/de/kifaru/ndegendogo/kata/romanNumbers/*.java

bin:
	mkdir bin

.PHONY: clean
clean:
	rm -rf bin
