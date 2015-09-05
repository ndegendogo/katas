.PHONY: blackboxtest
blackboxtest: test_echo test_cat test_head

include TestEcho.mak
include TestCat.mak
include TestHead.mak

.PHONY: cleanTempOutputFiles
cleanTempOutputFiles:
	$(RM) expectedOutputOf_*
	$(RM) actualOutputOf_*

performBlackboxTest=\
	$(cmd) $(params) > expectedOutputOf_$@; \
	expectedStatus=$$?; \
	$(RUNCMD) $(params) > actualOutputOf_$@; \
	actualStatus=$$?; \
	test $$expectedStatus = $$actualStatus && (diff expectedOutputOf_$@ actualOutputOf_$@ > /dev/null)


