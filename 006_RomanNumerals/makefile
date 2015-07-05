.PHONY: all
all: build

.PHONY: build
build: bin/de/kifaru/ndegendogo/kata/romanNumbers/ConvertToRoman.class

.PHONY: clean
clean:
	rm -rf bin

bin/de/kifaru/ndegendogo/kata/romanNumbers/ConvertToRoman.class: bin src/main/java/de/kifaru/ndegendogo/kata/romanNumbers/ConvertToRoman.java
	javac -d bin src/main/java/de/kifaru/ndegendogo/kata/romanNumbers/ConvertToRoman.java
	
bin:
	mkdir bin
