TAIL_TESTCASES:= \
    tail0linesFrom0files \

.PHONY: test_tail
test_tail: $(TAIL_TESTCASES)

RUNTAIL:=$(RUN.class) $(PACKAGE)Tail

tail%: cmd:=tail
tail%: RUNCMD:=$(RUNTAIL)

tail0linesFrom0files: params:= < data/empty

.PHONY: $(TAIL_TESTCASES)
# verify exit status and output of the fakeOs Tail program, use the original shell command as reference.
$(TAIL_TESTCASES): tail%: $(CLASSFILES) | $(TEMPPATH)
	$(performBlackboxTest)
