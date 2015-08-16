CAT_TESTCASES:=catOneFileWithSingleLine \
                 catAnotherSingleFileWithSingleLine \
                 catSingleLineWithUnixEnding \
                 catSingleLineWithWindowsEnding \
                 catSingleLineWithMacEnding \
                 catSingleLineWithoutEnding \
                 catMultipleFiles \
                 catNoParameters \
                 catDashParameter \

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

.PHONY: test_cat 
test_cat: $(CAT_TESTCASES)

.PHONY: $(CAT_TESTCASES)
$(CAT_TESTCASES): cat%: expectedOutputOf_cat% $(CLASSFILES)
	$(call statusCat, $(paramsFor_$@))
	$(call assertCat, $(paramsFor_$@))


RUNCAT:=$(RUN.class) $(PACKAGE)Cat

# verify output of the fakeOS Cat program, use the original shell command as reference.
assertCat=$(RUNCAT)$(1) | diff - expectedOutputOf_$@ > /dev/null

# verify exit status of the fakeOs Cat program, use the original shell command as reference.
statusCat=test "`cat$(1) >/dev/null; echo $$?`" = "`$(RUNCAT)$(1)>/dev/null; echo $$?`" 



.PHONY: cleanExpectedOutputFiles
cleanExpectedOutputFiles:
	$(RM) expectedOutputOf_*


.SECONDEXPANSION:

expectedOutputOf_cat%: $$(paramsFor_cat%)
	cat $+  > $@

expectedOutputOf_catNoParameters: $(filesFor_catNoParameters)
	cat $(paramsFor_catNoParameters) > $@

expectedOutputOf_catDashParameter: $(filesFor_catDashParameter)
	cat $(filesFor_catDashParameter) > $@
