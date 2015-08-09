RUNCAT:=$(RUN.class) $(PACKAGE)Cat

# verify output of the fakeOS programs, use the original shell commands as reference.
assertCat=cat$(1) > expectedOutputOf_$@; $(RUNCAT)$(1) | diff - expectedOutputOf_$@ > /dev/null

.PHONY test_cat: catOneFileWithSingleLine
catOneFileWithSingleLine: $(CLASSFILE_CAT)
	$(call assertCat, data/file1)

.PHONY test_cat: catAnotherSingleFileWithSingleLine
catAnotherSingleFileWithSingleLine: $(CLASSFILE_CAT)
	$(call assertCat, data/file2)

.PHONY test_cat: catSingleLineWithUnixEnding
catSingleLineWithUnixEnding: $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineUnix)

.PHONY test_cat: catSingleLineWithWindowsEnding
catSingleLineWithWindowsEnding: $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineWindows)

.PHONY test_cat: catSingleLineWithMacEnding
catSingleLineWithMacEnding: $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineMac)

.PHONY test_cat: catSingleLineWithoutEnding
catSingleLineWithoutEnding: $(CLASSFILE_CAT)
	$(call assertCat, data/singleLineNoEnd)


