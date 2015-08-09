RUNCAT:=$(RUN.class) $(PACKAGE)Cat

# verify output of the fakeOS programs, use the original shell commands as reference.
assertCat=cat$(1) > expectedOutputOf_$@; $(RUNCAT)$(1) | diff - expectedOutputOf_$@ > /dev/null

.SECONDEXPANSION:

paramsFor_catOneFileWithSingleLine:=data/file1

expectedOutputOf_catOneFileWithSingleLine:
	cat $(paramsFor_catOneFileWithSingleLine) > $@

.PHONY test_cat: catOneFileWithSingleLine
catOneFileWithSingleLine: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, data/file1)

paramsFor_catAnotherSingleFileWithSingleLine:=data/file2

expectedOutputOf_catAnotherSingleFileWithSingleLine:
	cat $(paramsFor_catAnotherSingleFileWithSingleLine) > $@

.PHONY test_cat: catAnotherSingleFileWithSingleLine
catAnotherSingleFileWithSingleLine: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, data/file2)

paramsFor_catSingleLineWithUnixEnding:=data/singleLineUnix

expectedOutputOf_catSingleLineWithUnixEnding:
	cat $(paramsFor_catSingleLineWithUnixEnding) > $@

.PHONY test_cat: catSingleLineWithUnixEnding
catSingleLineWithUnixEnding: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineUnix)

paramsFor_catSingleLineWithWindowsEnding:=data/singleLineWindows

expectedOutputOf_catSingleLineWithWindowsEnding:
	cat $(paramsFor_catSingleLineWithWindowsEnding) > $@

.PHONY test_cat: catSingleLineWithWindowsEnding
catSingleLineWithWindowsEnding: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineWindows)

paramsFor_catSingleLineWithMacEnding:=data/singleLineMac

expectedOutputOf_catSingleLineWithMacEnding:
	cat $(paramsFor_catSingleLineWithMacEnding) > $@

.PHONY test_cat: catSingleLineWithMacEnding
catSingleLineWithMacEnding: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineMac)

paramsFor_catSingleLineWithoutEnding:=data/singleLineNoEnd

expectedOutputOf_catSingleLineWithoutEnding:
	cat $(paramsFor_catSingleLineWithoutEnding) > $@

.PHONY test_cat: catSingleLineWithoutEnding
catSingleLineWithoutEnding: expectedOutputOf_$$@ $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineNoEnd)


