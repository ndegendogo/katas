TAIL_TESTCASES:= \
    tail0linesFrom0files \
    tail1lineFrom0files \
    tail10linesFrom0files \
    tail11linesFrom0files \

.PHONY: test_tail
test_tail: $(TAIL_TESTCASES)

RUNTAIL:=$(RUN.class) $(PACKAGE)Tail

tail%: cmd:=tail
tail%: RUNCMD:=$(RUNTAIL)

tail0linesFrom0files: params:= < data/empty
tail1lineFrom0files: params:= < data/1line.txt
tail10linesFrom0files: params:= < data/10lines.txt
tail11linesFrom0files: params:= < data/11lines.txt

.PHONY: $(TAIL_TESTCASES)
# verify exit status and output of the fakeOs Tail program, use the original shell command as reference.
$(TAIL_TESTCASES): tail%: $(CLASSFILES) | $(TEMPPATH)
	$(performBlackboxTest)

