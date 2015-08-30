HEAD_TESTCASES:= \
    head0linesFrom0files \
    head1linesFrom0files \

.PHONY: test_head
test_head: $(HEAD_TESTCASES)

head0linesFrom0files: params:= < data/empty
head1linesFrom0files: params:= < data/1line.txt

.PHONY: $(HEAD_TESTCASES)
$(HEAD_TESTCASES): head%: $(CLASSFILES)
	$(call performTestcaseForHead, $(params), expectedOutputOf_$@, actualOutputOf_$@)

RUNHEAD:=$(RUN.class) $(PACKAGE)Head

# verify exit status and output of the fakeOs Head program, use the original shell command as reference.
performTestcaseForHead= \
    head$(1) > $(2); \
    expectedStatus=$$?; \
    $(RUNHEAD)$(1) > $(3); \
    actualStatus=$$?; \
    test $$expectedStatus = $$actualStatus && (diff $(2) $(3) > /dev/null)
