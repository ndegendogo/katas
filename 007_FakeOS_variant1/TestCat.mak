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
                 catNonexistingExisting \
                 catExistingNonexistingExisting \

.PHONY: test_cat 
test_cat: $(CAT_TESTCASES) catReadProtected

RUNCAT:=$(RUN.class) $(PACKAGE)Cat

cat%: cmd:=cat
cat%: RUNCMD:=$(RUNCAT)

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
catEmptyFile: params:=data/empty
catNonExistingFile: params:=data/nonExistingFile
catDirectory: params:=data
catNonexistingExisting: params:=data/nonExistingFile data/file2
catExistingNonexistingExisting: params:=data/file1 data/nonExistingFile data/file2
catReadProtected: params:=data/readProtected

.PHONY: $(CAT_TESTCASES)
# verify exit status and output of the fakeOs Cat program, use the original shell command as reference.
$(CAT_TESTCASES): cat%: $(CLASSFILES) | $(TEMPPATH)
	$(performBlackboxTest)

.PHONY: catReadProtected
catReadProtected: $(CLASSFILES) | $(TEMPPATH)
	chmod a-r $(params)
	$(performBlackboxTest)
	chmod a+r $(params)


