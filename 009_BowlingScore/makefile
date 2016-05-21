include $(or $(wildcard UserConfig.mak),DefaultUserConfig.mak)

BASEPATH_SOURCE:=src/main/java/
BASEPATH_TEST:=src/test/java/
BASEPATH_CLASS:=bin/
PATH_PACKAGE:=de/kifaru/ndegendogo/kata/bowling/
PathToClass=$(subst /,.,$(1))
FILES_SOURCE:=$(wildcard $(BASEPATH_SOURCE)$(PATH_PACKAGE)*.java)
FILES_TEST=$(wildcard $(BASEPATH_TEST)$(PATH_PACKAGE)*.java)
CLASSFILES:=$(patsubst $(BASEPATH_SOURCE)$(PATH_PACKAGE)%.java,$(BASEPATH_CLASS)$(PATH_PACKAGE)%.class,$(FILES_SOURCE))
CLASSFILES_TEST:=$(patsubst $(BASEPATH_TEST)$(PATH_PACKAGE)%.java,$(BASEPATH_CLASS)$(PATH_PACKAGE)%.class,$(FILES_TEST))
MAIN_CLASS:=$(call PathToClass,$(PATH_PACKAGE))BowlingScore
CLASSES_TEST:=$(call PathToClass,$(patsubst $(BASEPATH_CLASS)%.class,%,$(CLASSFILES_TEST)))

.PHONY: all
all: build run test

.PHONY: build
build: $(CLASSFILES) | $(BASEPATH_CLASS)

.PHONY: run
run: build
	java -cp $(BASEPATH_CLASS) $(MAIN_CLASS)

.PHONY: test
test: build_all
	java -cp $(BASEPATH_CLASS):$(LIB_JUNIT):$(LIB_HAMCREST) org.junit.runner.JUnitCore $(CLASSES_TEST)

.PHONY: build_all
build_all: $(CLASSFILES) $(CLASSFILES_TEST) | $(BASEPATH_CLASS)

$(BASEPATH_CLASS):
	mkdir $@ 

$(BASEPATH_CLASS)$(PATH_PACKAGE)%.class: $(BASEPATH_SOURCE)$(PATH_PACKAGE)%.java | $(BASEPATH_CLASS)
	javac -cp $(BASEPATH_CLASS) -d $(BASEPATH_CLASS) -sourcepath $(BASEPATH_SOURCE) $(FILES_SOURCE)

$(BASEPATH_CLASS)$(PATH_PACKAGE)%.class: $(BASEPATH_TEST)$(PATH_PACKAGE)%.java | $(BASEPATH_CLASS)
	javac -cp $(BASEPATH_CLASS):$(LIB_JUNIT) -d $(BASEPATH_CLASS) -sourcepath $(BASEPATH_TEST) $(FILES_TEST)

.PHONY: clean
clean:
	-rm -r bin
