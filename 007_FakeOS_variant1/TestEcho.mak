ECHO_TESTCASES:= \
    echoWithOneWordPrintsThisWord \
    echoWithAnotherWordPrintsThisOtherWord \
    echoWithoutParametersPrintsNothing \
    echoWithFullSentencePrintsFullSentence \
    echoWithTrailingSpacesPreservesTheSpaces \
    echoWithEmptyArgumentPrintsNothing \

.PHONY: test_echo
test_echo: $(ECHO_TESTCASES)

RUNECHO:=$(RUN.class) $(PACKAGE)Echo

echo%: cmd:=echo
echo%: RUNCMD:=$(RUNECHO)

echoWithOneWordPrintsThisWord: params:=hello
echoWithAnotherWordPrintsThisOtherWord: params:=world
echoWithoutParametersPrintsNothing: params:=
echoWithFullSentencePrintsFullSentence: params:=Hello world!
echoWithTrailingSpacesPreservesTheSpaces: params:='hello '
echoWithEmptyArgumentPrintsNothing: params:=''

.PHONY: $(ECHO_TESTCASES)
$(ECHO_TESTCASES): echo%: $(CLASSFILES) | $(TEMPPATH)
	$(performBlackboxTest)

