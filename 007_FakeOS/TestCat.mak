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

paramsFor_catOneFileWithSingleLine:=data/file1
paramsFor_catAnotherSingleFileWithSingleLine:=data/file2
paramsFor_catSingleLineWithUnixEnding:=data/singleLineUnix
paramsFor_catSingleLineWithWindowsEnding:=data/singleLineWindows
paramsFor_catSingleLineWithMacEnding:=data/singleLineMac
paramsFor_catSingleLineWithoutEnding:=data/singleLineNoEnd
paramsFor_catMultipleFiles:=data/file1 data/singleLineUnix data/singleLineWindows 
# note: automatted test with console input redirects from a file; true console input must be tested manually.
paramsFor_catNoParameters:= < data/singleLineUnix
filesFor_catNoParameters:=data/singleLineUnix
paramsFor_catDashParameter:= - < data/singleLineUnix
filesFor_catDashParameter:=data/singleLineUnix
paramsFor_catNonExistingFile:=data/nonExistingFile 
paramsFor_catDirectory:=data
paramsFor_catReadProtected:=data/readProtected
paramsFor_catEmptyFile:=data/empty

.PHONY: test_cat 
test_cat: $(CAT_TESTCASES) catReadProtected

.PHONY: $(CAT_TESTCASES)
$(CAT_TESTCASES): cat%: $(CLASSFILES)
	$(call performTestcaseForCat, $(paramsFor_$@), expectedOutputOf_$@, actualOutputOf_$@)

.PHONY: catReadProtected
catReadProtected: $(CLASSFILES)
	chmod a-r $(paramsFor_$@)
	$(call statusCat, $(paramsFor_$@))
	chmod a+r $(paramsFor_$@)


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

