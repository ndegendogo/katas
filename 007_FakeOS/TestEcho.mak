# verify output of the fakeOS programs, use the original shell commands as reference.
assertEcho=test "`echo$(1)`" = "`$(RUNECHO)$(1)`"

# the test cases for the blackbox tests
.PHONY test_echo: echoWithOneWordPrintsThisWord
echoWithOneWordPrintsThisWord: $(CLASSFILE_ECHO)
	$(call assertEcho, hello)

.PHONY test_echo: echoWithAnotherWordPrintsThisOtherWord
echoWithAnotherWordPrintsThisOtherWord: $(CLASSFILE_ECHO)
	$(call assertEcho, world)

.PHONY test_echo: echoWithoutParametersPrintsNothing
echoWithoutParametersPrintsNothing: $(CLASSFILE_ECHO)
	$(call assertEcho,)

.PHONY test_echo: echoWithFullSentencePrintsFullSentence
echoWithFullSentencePrintsFullSentence: $(CLASSFILE_ECHO)
	$(call assertEcho, Hello world!)

.PHONY test_echo: echoWithTrailingSpacesPreservesTheSpaces
echoWithTrailingSpacesPreservesTheSpaces: $(CLASSFILE_ECHO)
	$(call assertEcho, 'hello ')

.PHONY test_echo: echoWithEmptyArgumentPrintsNothing
echoWithEmptyArgumentPrintsNothing: $(CLASSFILE_ECHO)
	$(call assertEcho, '')


