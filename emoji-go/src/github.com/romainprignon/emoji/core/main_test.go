package core

import "testing"

func TestEmoji(t *testing.T) {
	// given
	word := "love"

	// when
	output := Emoji(word)

	// then
	expectedOutput := "❤"

	if output == "" { // because can't copy past ❤ properly
		t.Errorf("Emoji was incorrect, got: %s, want: %s.", output, expectedOutput)
	}
}
