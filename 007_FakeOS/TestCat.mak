CAT_TESTCASES:=catOneFileWithSingleLine \
                 catAnotherSingleFileWithSingleLine \
                 catSingleLineWithUnixEnding \
                 catSingleLineWithWindowsEnding \
                 catSingleLineWithMacEnding \
                 catSingleLineWithoutEnding \

paramsFor_catOneFileWithSingleLine:=data/file1
paramsFor_catAnotherSingleFileWithSingleLine:=data/file2
paramsFor_catSingleLineWithUnixEnding:=data/singleLineUnix
paramsFor_catSingleLineWithWindowsEnding:=data/singleLineWindows
paramsFor_catSingleLineWithMacEnding:=data/singleLineMac
paramsFor_catSingleLineWithoutEnding:=data/singleLineNoEnd

# note: automatted test with console input redirects from a file; true console input must be tested manually.
CAT_TESTCASES_:=catNoParameters \

paramsFor_catNoParameters:=data/singleLineUnix

.PHONY: test_cat 
test_cat: $(CAT_TESTCASES) $(CAT_TESTCASES_)

.PHONY: $(CAT_TESTCASES)
$(CAT_TESTCASES): cat%: expectedOutputOf_cat% $(CLASSFILES)
	$(call statusCat, $(paramsFor_$@))
	$(call assertCat, $(paramsFor_$@))

.PHONY: $(CAT_TESTCASES_)
$(CAT_TESTCASES_): cat%: expectedOutputOf_cat% $(CLASSFILES)
	$(call statusCat_, $(paramsFor_$@))
	$(call assertCat_, $(paramsFor_$@))

RUNCAT:=$(RUN.class) $(PACKAGE)Cat

# verify output of the fakeOS Cat program, use the original shell command as reference.
assertCat=$(RUNCAT)$(1) | diff - expectedOutputOf_$@ > /dev/null
assertCat_=$(RUNCAT) < $(1) | diff - expectedOutputOf_$@ > /dev/null

# verify exit status of the fakeOs Cat program, use the original shell command as reference.
statusCat=test "`cat$(1) >/dev/null; echo $$?`" = "`$(RUNCAT)$(1)>/dev/null; echo $$?`" 
statusCat_=test "`cat < $(1) >/dev/null; echo $$?`" = "`$(RUNCAT) < $(1) >/dev/null; echo $$?`" 







.PHONY: cleanExpectedOutputFiles
cleanExpectedOutputFiles:
	$(RM) expectedOutputOf_*


.SECONDEXPANSION:

expectedOutputOf_catNoParameters: $(paramsFor_catNoParameters)
	cat < $< > $@

expectedOutputOf_cat%: $$(paramsFor_cat%)
	cat $<  > $@

