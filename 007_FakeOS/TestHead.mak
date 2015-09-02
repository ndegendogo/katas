HEAD_TESTCASES:= \
    head0linesFrom0files \
    head1linesFrom0files \

.PHONY: test_head
test_head: $(HEAD_TESTCASES)

head0linesFrom0files: params:= < data/empty
head1linesFrom0files: params:= < data/1line.txt

.PHONY: $(HEAD_TESTCASES)
# verify exit status and output of the fakeOs Head program, use the original shell command as reference.
$(HEAD_TESTCASES): head%: $(CLASSFILES)
	head $(params) > expectedOutputOf_$@; \
	expectedStatus=$$?; \
	$(RUNHEAD) $(params) > actualOutputOf_$@; \
	actualStatus=$$?; \
	test $$expectedStatus = $$actualStatus && (diff expectedOutputOf_$@ actualOutputOf_$@ > /dev/null)

RUNHEAD:=$(RUN.class) $(PACKAGE)Head

