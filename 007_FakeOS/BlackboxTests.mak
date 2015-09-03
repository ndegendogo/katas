.PHONY: test
test: test_echo test_cat test_head

include TestEcho.mak
include TestCat.mak
include TestHead.mak

.PHONY: cleanTempOutputFiles
cleanTempOutputFiles:
	$(RM) expectedOutputOf_*
	$(RM) actualOutputOf_*


