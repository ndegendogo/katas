RUNECHO:=$(RUN.class) $(PACKAGE)Echo

# verify output of the fakeOS programs, use the original shell commands as reference.
assertEcho=test "`echo$(1)`" = "`$(RUNECHO)$(1)`"

# the test cases for the blackbox tests
.PHONY test_echo: echoWithOneWordPrintsThisWord
echoWithOneWordPrintsThisWord: $(CLASSFILES)
	$(call assertEcho, hello)

.PHONY test_echo: echoWithAnotherWordPrintsThisOtherWord
echoWithAnotherWordPrintsThisOtherWord: $(CLASSFILES)
	$(call assertEcho, world)

.PHONY test_echo: echoWithoutParametersPrintsNothing
echoWithoutParametersPrintsNothing: $(CLASSFILES)
	$(call assertEcho,)

.PHONY test_echo: echoWithFullSentencePrintsFullSentence
echoWithFullSentencePrintsFullSentence: $(CLASSFILES)
	$(call assertEcho, Hello world!)

.PHONY test_echo: echoWithTrailingSpacesPreservesTheSpaces
echoWithTrailingSpacesPreservesTheSpaces: $(CLASSFILES)
	$(call assertEcho, 'hello ')

.PHONY test_echo: echoWithEmptyArgumentPrintsNothing
echoWithEmptyArgumentPrintsNothing: $(CLASSFILES)
	$(call assertEcho, '')


