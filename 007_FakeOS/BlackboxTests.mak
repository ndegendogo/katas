TEMPPATH:=tmp/

.PHONY: blackboxtest
blackboxtest: test_echo test_cat test_head test_tail

include TestEcho.mak
include TestCat.mak
include TestHead.mak
include TestTail.mak

.PHONY: cleanTempOutputFiles
cleanTempOutputFiles:
	$(RM) -r $(TEMPPATH)

performBlackboxTest=\
	$(cmd) $(params) > $(TEMPPATH)expectedOutputOf_$@; \
	expectedStatus=$$?; \
	$(RUNCMD) $(params) > $(TEMPPATH)actualOutputOf_$@; \
	actualStatus=$$?; \
	test $$expectedStatus = $$actualStatus && (diff $(TEMPPATH)expectedOutputOf_$@ $(TEMPPATH)actualOutputOf_$@ > /dev/null)

$(TEMPPATH):
	mkdir $@

