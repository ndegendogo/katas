HEAD_TESTCASES:= \
    head0linesFrom0files \
    head1linesFrom0files \
    head10linesFrom0files \
    head11linesFrom0files \
    head8linesFrom1file \
    headFrom2files \
    headFrom2Emptyfiles \
    headFromVeryLargeInput \
    headFrom3files \
    headFrom1Emptyfile \
    headNonExistingFile \
    headExistingNonexistingExistingFile \
    headReadProtected \
    headReadProtectedThenNormalFile \
    headWriteProtectedOutput \

.PHONY: test_head
test_head: $(HEAD_TESTCASES)

RUNHEAD:=$(RUN.class) $(PACKAGE)Head

head%: cmd:=head
head%: RUNCMD:=$(RUNHEAD)

head0linesFrom0files: params:= < data/empty
head1linesFrom0files: params:= < data/1line.txt
head10linesFrom0files: params:= < data/10lines.txt
head11linesFrom0files: params:= < data/11lines.txt
head8linesFrom1file: params:= data/8lines.txt
headFrom2files: params:= data/1line.txt data/8lines.txt
headFrom2Emptyfiles: params:= data/empty data/empty 
headFrom3files: params:= data/8lines.txt data/11lines.txt data/1line.txt
headFrom1Emptyfile: params:= data/empty
headNonExistingFile: params:=data/nonExistingFile
headExistingNonexistingExistingFile: params:=data/file1 data/nonExistingFile data/file2
headReadProtected: params:=data/readProtected
headReadProtectedThenNormalFile: params:=data/readProtected data/11lines.txt
headWriteProtectedOutput: params:=data/11lines.txt

.PHONY: $(HEAD_TESTCASES)
# verify exit status and output of the fakeOs Head program, use the original shell command as reference.
$(HEAD_TESTCASES): head%: $(CLASSFILES) | $(TEMPPATH)
	$(performBlackboxTest)

.PHONY: headReadProtected
headReadProtected: $(CLASSFILES) | $(TEMPPATH)
	chmod a-r $(params)
	$(performBlackboxTest)
	chmod a+r $(params)

.PHONY: headReadProtectedThenNormalFile 
headReadProtectedThenNormalFile: $(CLASSFILES) | $(TEMPPATH)
	chmod a-r data/readProtected
	$(performBlackboxTest)
	chmod a+r data/readProtected

.PHONY: headWriteProtectedOutput
headWriteProtectedOutput: $(CLASSFILES) | $(TEMPPATH)
	touch $(TEMPPATH)expectedOutputOf_$@
	chmod a-w $(TEMPPATH)expectedOutputOf_$@
	touch $(TEMPPATH)actualOutputOf_$@
	chmod a-w $(TEMPPATH)actualOutputOf_$@
	$(performBlackboxTest)
	chmod a+w $(TEMPPATH)expectedOutputOf_$@
	chmod a+w $(TEMPPATH)actualOutputOf_$@

# increase the loop limit from 100 to any number you like - only you have to wait then for a while ...
VERY_LARGE_INPUT:=for ((i=0;i<100;i++)) do cat data/8lines.txt; done

.PHONY: headFromVeryLargeInput 
headFromVeryLargeInput: $(CLASSFILES) | $(TEMPPATH)
	$(VERY_LARGE_INPUT) | $(cmd) > $(TEMPPATH)expectedOutputOf_$@; \
	expectedStatus=$$?; \
	$(VERY_LARGE_INPUT) | $(RUNCMD) > $(TEMPPATH)actualOutputOf_$@; \
	actualStatus=$$?; \
	test $$expectedStatus = $$actualStatus && (diff $(TEMPPATH)expectedOutputOf_$@ $(TEMPPATH)actualOutputOf_$@ > /dev/null)


