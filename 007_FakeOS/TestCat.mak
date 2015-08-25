CAT_TESTCASES:=catOneFileWithSingleLine \
                 catAnotherSingleFileWithSingleLine \
                 catSingleLineWithUnixEnding \
                 catSingleLineWithWindowsEnding \
                 catSingleLineWithMacEnding \
                 catSingleLineWithoutEnding \
                 catMultipleFiles \
                 catNoParameters \
                 catDashParameter \
                 catEmptyFile \
                 catNonExistingFile \
                 catDirectory \

.PHONY: test_cat 
test_cat: $(CAT_TESTCASES) catReadProtected

.PHONY: catOneFileWithSingleLine
catOneFileWithSingleLine: params:=data/file1

.PHONY: catAnotherSingleFileWithSingleLine
catAnotherSingleFileWithSingleLine: params:=data/file2

.PHONY: catSingleLineWithUnixEnding
catSingleLineWithUnixEnding: params:=data/singleLineUnix

.PHONY: catSingleLineWithWindowsEnding
catSingleLineWithWindowsEnding: params:=data/singleLineWindows

.PHONY: catSingleLineWithMacEnding
catSingleLineWithMacEnding: params:=data/singleLineMac

.PHONY: catSingleLineWithoutEnding
catSingleLineWithoutEnding: params:=data/singleLineNoEnd

.PHONY: catMultipleFiles
catMultipleFiles: params:=data/file1 data/singleLineUnix data/singleLineWindows

# note: automatted test with console input redirects from a file; true console input must be tested manually.

.PHONY: catNoParameters
catNoParameters: params:= < data/singleLineUnix

.PHONY: catDashParameter
catDashParameter: params:= - < data/singleLineUnix

.PHONY: catNonExistingFile
catNonExistingFile: params:=data/nonExistingFile

.PHONY: catDirectory
catDirectory: params:=data

.PHONY: catEmptyFile
catEmptyFile: params:=data/empty

.PHONY: catReadProtected
catReadProtected: params:=data/readProtected
catReadProtected: $(CLASSFILES) 
	chmod a-r $(params)
	$(call performTestcaseForCat, $(params), expectedOutputOf_$@, actualOutputOf_$@)
	chmod a+r $(params)

$(CAT_TESTCASES): cat%: $(CLASSFILES)
	$(call performTestcaseForCat, $(params), expectedOutputOf_$@, actualOutputOf_$@)

RUNCAT:=$(RUN.class) $(PACKAGE)Cat

# verify exit status and output of the fakeOs Cat program, use the original shell command as reference.
performTestcaseForCat= \
    cat$(1) > $(2); \
    expectedStatus=$$?; \
    $(RUNCAT)$(1) > $(3); \
    actualStatus=$$?; \
    test $$expectedStatus = $$actualStatus && (test ! $$expectedStatus || diff $(2) $(3) > /dev/null)

.PHONY: cleanTempOutputFiles
cleanTempOutputFiles:
	$(RM) expectedOutputOf_*
	$(RM) actualOutputOf_*

