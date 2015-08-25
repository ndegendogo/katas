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

catOneFileWithSingleLine: params:=data/file1
catAnotherSingleFileWithSingleLine: params:=data/file2
catSingleLineWithUnixEnding: params:=data/singleLineUnix
catSingleLineWithWindowsEnding: params:=data/singleLineWindows
catSingleLineWithMacEnding: params:=data/singleLineMac
catSingleLineWithoutEnding: params:=data/singleLineNoEnd
catMultipleFiles: params:=data/file1 data/singleLineUnix data/singleLineWindows
# note: automatted test with console input redirects from a file; true console input must be tested manually.
catNoParameters: params:= < data/singleLineUnix
catDashParameter: params:= - < data/singleLineUnix
catNonExistingFile: params:=data/nonExistingFile
catDirectory: params:=data
catEmptyFile: params:=data/empty

.PHONY: catReadProtected
catReadProtected: params:=data/readProtected
catReadProtected: $(CLASSFILES) 
	chmod a-r $(params)
	$(call performTestcaseForCat, $(params), expectedOutputOf_$@, actualOutputOf_$@)
	chmod a+r $(params)

.PHONY: $(CAT_TESTCASES)
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

