RUNCAT:=$(RUN.class) $(PACKAGE)Cat

# verify output of the fakeOS programs, use the original shell commands as reference.
assertCat=$(RUNCAT)$(1) | diff - expectedOutputOf_$@ > /dev/null

.SECONDEXPANSION:

paramsFor_catOneFileWithSingleLine:=data/file1

expectedOutputOf_%: $$(paramsFor_%)
	cat $<  > $@

.PHONY test_cat: catOneFileWithSingleLine
catOneFileWithSingleLine: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, $(paramsFor_$@))

paramsFor_catAnotherSingleFileWithSingleLine:=data/file2

.PHONY test_cat: catAnotherSingleFileWithSingleLine
catAnotherSingleFileWithSingleLine: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, $(paramsFor_$@))

paramsFor_catSingleLineWithUnixEnding:=data/singleLineUnix

.PHONY test_cat: catSingleLineWithUnixEnding
catSingleLineWithUnixEnding: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, $(paramsFor_$@))

paramsFor_catSingleLineWithWindowsEnding:=data/singleLineWindows

.PHONY test_cat: catSingleLineWithWindowsEnding
catSingleLineWithWindowsEnding: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, $(paramsFor_$@))

paramsFor_catSingleLineWithMacEnding:=data/singleLineMac

.PHONY test_cat: catSingleLineWithMacEnding
catSingleLineWithMacEnding: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, $(paramsFor_$@))

paramsFor_catSingleLineWithoutEnding:=data/singleLineNoEnd

.PHONY test_cat: catSingleLineWithoutEnding
catSingleLineWithoutEnding: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, $(paramsFor_$@))


