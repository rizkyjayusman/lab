package main

import "fmt"

func main() {
	fmt.Println(reversePrefix("abcdefd", 'd'))
	fmt.Println(reversePrefix("xyxzxe", 'z'))
	fmt.Println(reversePrefix("abcd", 'z'))
}

func reversePrefix(word string, ch byte) string {
	var strArr []byte
	trgt := -1
	for i := 0; i < len(word); i++ {
		if trgt == -1 && word[i] == ch {
			trgt = i
		}
		strArr = append(strArr, word[i])
	}

	if trgt != -1 {
		for i := 0; i < trgt; i++ {
			tmp := strArr[i]
			strArr[i] = strArr[trgt]
			strArr[trgt] = tmp
			trgt--
		}
	}

	return string(strArr)

}
