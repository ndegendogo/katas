TAIL_TESTCASES:= \
    tail0linesFrom0files \
    tail1lineFrom0files \
    tail10linesFrom0files \
    tail11linesFrom0files \
    tail8linesFrom1file \
    tailFrom2files \
    tailFrom2Emptyfiles \
    tailFromVeryLargeInput \
    tailFrom3files \
    tailFrom1Emptyfile \
    tailNonExistingFile \
    tailExistingNonexistingExistingFile \
    tailReadProtected \
    tailReadProtectedThenNormalFile \
    tailWriteProtectedOutput \


.PHONY: test_tail
test_tail: $(TAIL_TESTCASES)

RUNTAIL:=$(RUN.class) $(PACKAGE)Tail

tail%: cmd:=tail
tail%: RUNCMD:=$(RUNTAIL)

tail0linesFrom0files: params:= < data/empty
tail1lineFrom0files: params:= < data/1line.txt
tail10linesFrom0files: params:= < data/10lines.txt
tail11linesFrom0files: params:= < data/11lines.txt
tail8linesFrom1file: params:= data/8lines.txt
tailFrom2files: params:= data/1line.txt data/8lines.txt
tailFrom2Emptyfiles: params:= data/empty data/empty 
tailFrom3files: params:= data/8lines.txt data/11lines.txt data/1line.txt
tailFrom1Emptyfile: params:= data/empty
tailNonExistingFile: params:=data/nonExistingFile
tailExistingNonexistingExistingFile: params:=data/file1 data/nonExistingFile data/file2
tailReadProtected: params:=data/readProtected
tailReadProtectedThenNormalFile: params:=data/readProtected data/11lines.txt
tailWriteProtectedOutput: params:=data/11lines.txt


.PHONY: $(TAIL_TESTCASES)
# verify exit status and output of the fakeOs Tail program, use the original shell command as reference.
$(TAIL_TESTCASES): tail%: $(CLASSFILES) | $(TEMPPATH)
	$(performBlackboxTest)

.PHONY: tailReadProtected
tailReadProtected: $(CLASSFILES) | $(TEMPPATH)
	chmod a-r $(params)
	$(performBlackboxTest)
	chmod a+r $(params)

.PHONY: tailReadProtectedThenNormalFile 
tailReadProtectedThenNormalFile: $(CLASSFILES) | $(TEMPPATH)
	chmod a-r data/readProtected
	$(performBlackboxTest)
	chmod a+r data/readProtected

.PHONY: tailWriteProtectedOutput
tailWriteProtectedOutput: $(CLASSFILES) | $(TEMPPATH)
	touch $(TEMPPATH)expectedOutputOf_$@
	chmod a-w $(TEMPPATH)expectedOutputOf_$@
	touch $(TEMPPATH)actualOutputOf_$@
	chmod a-w $(TEMPPATH)actualOutputOf_$@
	$(performBlackboxTest)
	chmod a+w $(TEMPPATH)expectedOutputOf_$@
	chmod a+w $(TEMPPATH)actualOutputOf_$@

.PHONY: tailFromVeryLargeInput 
tailFromVeryLargeInput: $(CLASSFILES) | $(TEMPPATH)
	$(VERY_LARGE_INPUT) | $(cmd) > $(TEMPPATH)expectedOutputOf_$@; \
	expectedStatus=$$?; \
	$(VERY_LARGE_INPUT) | $(RUNCMD) > $(TEMPPATH)actualOutputOf_$@; \
	actualStatus=$$?; \
	test $$expectedStatus = $$actualStatus && (diff $(TEMPPATH)expectedOutputOf_$@ $(TEMPPATH)actualOutputOf_$@ > /dev/null)

