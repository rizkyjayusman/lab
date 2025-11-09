package main

import (
	"fmt"
	"math/rand"
)

type TinyURL struct{}

type Codec struct {
	mcode map[string]string
	murl  map[string]string
}

const (
	base62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
)

func Constructor() Codec {
	return Codec{make(map[string]string), make(map[string]string)}
}

func (this *Codec) encode(longUrl string) string {
	if _, ok := this.murl[longUrl]; ok {
		return this.murl[longUrl]
	}

	var code string
	for {
		code = this.generateShortUrl()
		if _, ok := this.mcode[code]; !ok {
			break
		}
	}

	this.mcode[code] = longUrl
	this.murl[longUrl] = code

	return code
}

func (this *Codec) generateShortUrl() string {
	var str []byte
	for i := 0; i < 6; i++ {
		str = append(str, base62[rand.Intn(62)])
	}
	return fmt.Sprintf("http://tinyurl.com/%s", string(str))
}

func (this *Codec) decode(shortUrl string) string {
	if _, ok := this.mcode[shortUrl]; ok {
		return this.mcode[shortUrl]
	}

	return ""
}
