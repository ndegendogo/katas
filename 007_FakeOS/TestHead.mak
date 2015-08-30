HEAD_TESTCASES:=

.PHONY: test_head
test_head: $(HEAD_TESTCASES)

.PHONY: $(HEAD_TESTCASES)
$(HEAD_TESTCASES): head%: $(CLASSFILES)
	$(call perfrmTestcaseForHead, $(params), expectedOutputOf_$@, actualOutputOf_$@)

RUNHEAD:=$(RUN.class) $(PACKAGE)Head

# verify exit status and output of the fakeOs Head program, use the original shell command as reference.
performTestcaseForHead= \
    head$(1) > $(2); \
    expectedStatus=$$?; \
    $(RUNHEAD)$(1) > $(3); \
    actualStatus=$$?; \
    test $$expectedStatus = $$actualStatus && (diff $(2) $(3) > /dev/null)
