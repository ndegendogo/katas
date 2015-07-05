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
	test "$$(java -cp bin $(CLASS) 2)" == "II"
	test "$$(java -cp bin $(CLASS) 3)" == "III"
	test "$$(java -cp bin $(CLASS) 7)" == "VII"
	test "$$(java -cp bin $(CLASS) 13)" == "XIII"
	test "$$(java -cp bin $(CLASS) 61)" == "LXI"
	test "$$(java -cp bin $(CLASS) 2777)" == "MMDCCLXXVII"
	test "$$(java -cp bin $(CLASS) 4)" == "IV"
	test "$$(java -cp bin $(CLASS) 1444)" == "MCDXLIV"
	test "$$(java -cp bin $(CLASS) 2999)" == "MMCMXCIX"

$(CLASSFILE): bin $(SOURCEFILE)
	javac -d bin $(SOURCEFILE)
	
bin:
	mkdir bin
