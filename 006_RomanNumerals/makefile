SOURCEFILE = src/main/java/de/kifaru/ndegendogo/kata/romanNumbers/ConvertToRoman.java
CLASSFILE = bin/de/kifaru/ndegendogo/kata/romanNumbers/ConvertToRoman.class
CLASS = de.kifaru.ndegendogo.kata.romanNumbers.ConvertToRoman

.PHONY: all
all: build

.PHONY: build
build: $(CLASSFILE)

.PHONY: clean
clean:
	rm -rf bin

.PHONY: test
test: $(CLASSFILE) 
	test "$$(java -cp bin $(CLASS) 1)" == "I"

$(CLASSFILE): bin $(SOURCEFILE)
	javac -d bin $(SOURCEFILE)
	
bin:
	mkdir bin
