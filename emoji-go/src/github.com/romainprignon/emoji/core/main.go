// error handling => si tu peux traiter traite,  sinon, retourne

package core

import (
	"encoding/json"
	// "errors"
	"io/ioutil"
	// "log"
	"net/http"
	"net/url"
)

type EmojiType struct {
	Text  string // has to be in majuscule
	Score float64
}

type EmojiBodyType struct {
	Results []EmojiType
}

func ToEmojiBody(body []byte) (bodyString EmojiBodyType) {
	// var bodyString EmojiBodyType

	// fmt.Println(string(body[:])) // tmp

	err := json.Unmarshal(body, &bodyString)
	//err = errors.New("boom") // just or test
	if err != nil {
		panic(err)
		// return bodyString, err
	}

	return bodyString
}

func PrepareQuery(word string) *url.URL {
	u, err := url.Parse("http://emoji.getdango.com/api/emoji")
	if err != nil {
		panic(err)
	}

	q := u.Query()
	q.Set("q", word)
	u.RawQuery = q.Encode()

	return u
}

func DoQuery(u *url.URL) (res *http.Response) {
	resp, err := http.Get(u.String())
	if err != nil {
		// log.Fatal("Get", err.Error())
		panic(err)
	}

	return resp
}

func ParseQuery(resp *http.Response) []byte {
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		panic(err)
	}
	defer resp.Body.Close()

	return body
}

func Query(word string) EmojiBodyType {

	// format url
	// u := PrepareQuery(word)
	// resp, err := DoQuery(u)
	// if err != nil {
	// 	// log.Fatal("Get", err.Error())
	// 	panic(err)
	// }

	// body := ParseQuery(resp)

	// res := ToEmojiBody(body)

	// return res

	body := ToEmojiBody(ParseQuery(DoQuery(PrepareQuery(word))))

	return body
}

func FilterBestEmoji(emojiBody EmojiBodyType) string {
	res := emojiBody.Results // passer par reference

	var max float64 = 0
	maxIndex := 0
	for index, element := range res {
		if element.Score > max {
			max = element.Score
			maxIndex = index
		}
	}

	return res[maxIndex].Text
}

func Emoji(word string) string {
	body := Query(word)

	return FilterBestEmoji(body)
}
