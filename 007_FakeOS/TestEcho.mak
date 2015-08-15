ECHO_TESTCASES:=echoWithOneWordPrintsThisWord \
                echoWithAnotherWordPrintsThisOtherWord \
                echoWithoutParametersPrintsNothing \
                echoWithFullSentencePrintsFullSentence \
                echoWithTrailingSpacesPreservesTheSpaces \
                echoWithEmptyArgumentPrintsNothing \

paramsFor_echoWithOneWordPrintsThisWord:=hello
paramsFor_echoWithAnotherWordPrintsThisOtherWord:=world
paramsFor_echoWithoutParametersPrintsNothing:=
paramsFor_echoWithFullSentencePrintsFullSentence:=Hello world!
paramsFor_echoWithTrailingSpacesPreservesTheSpaces:='hello '
paramsFor_echoWithEmptyArgumentPrintsNothing:=''

.PHONY: test_echo
test_echo: $(ECHO_TESTCASES)

.PHONY: $(ECHO_TESTCASES)
$(ECHO_TESTCASES): echo%: $(CLASSFILES)
	$(call assertEcho, $(paramsFor_$@))
	$(call statusEcho, $(paramsFor_$@))

RUNECHO:=$(RUN.class) $(PACKAGE)Echo

# verify output of the fakeOS Echo program, use the original shell command as reference.
assertEcho=test "`echo$(1)`" = "`$(RUNECHO)$(1)`"

# verify exit status of the fakeOs Echo program, use the original shell command as reference.
statusEcho=test "`echo$(1)`>/dev/null; `echo $$?`" = "`$(RUNECHO)$(1)`>/dev/null; `echo $$?`" 
