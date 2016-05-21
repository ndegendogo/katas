BASEPATH_SOURCE=src/main/java/
BASEPATH_TEST=src/test/java/
BASEPATH_CLASS=bin/
PATH_PACKAGE=de/kifaru/ndegendogo/kata/bowling/
PathToClass=$(subst /,.,$(1))
FILES_SOURCE=$(wildcard $(BASEPATH_SOURCE)$(PATH_PACKAGE)*.java)
#FILES_TEST=$(BASEPATH_TEST)$(PATH_PACKAGE)*.java
CLASSFILES=$(patsubst $(BASEPATH_SOURCE)$(PATH_PACKAGE)%.java,$(BASEPATH_CLASS)$(PATH_PACKAGE)%.class,$(FILES_SOURCE))

.PHONY: all
all: build #run test

.PHONY: build
build: $(CLASSFILES) | $(BASEPATH_CLASS)

$(BASEPATH_CLASS):
	mkdir $@ 

$(BASEPATH_CLASS)$(PATH_PACKAGE)%.class: $(BASEPATH_SOURCE)$(PATH_PACKAGE)%.java | $(BASEPATH_CLASS)
	javac -cp $(BASEPATH_CLASS) -d $(BASEPATH_CLASS) -sourcepath $(BASEPATH_SOURCE) $(FILES_SOURCE)

.PHONY: clean
clean:
	-rm -r bin
