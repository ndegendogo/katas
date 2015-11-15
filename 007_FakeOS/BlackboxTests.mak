TEMPPATH:=tmp/

.PHONY: blackboxtest
blackboxtest: test_echo test_cat test_head test_tail

# increase the loop limit from 100 to any number you like - only you have to wait then for a while ...
VERY_LARGE_INPUT:=for ((i=0;i<100;i++)) do cat data/8lines.txt; done

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

