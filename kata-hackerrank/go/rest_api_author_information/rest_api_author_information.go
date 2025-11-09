package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
)

type ArticleUser struct {
	Page        int
	Per_Page    int
	Total       int
	Total_Pages int
	Data        []struct {
		About string
	}
}

type Article struct {
	Page        int
	Per_Page    int
	Total       int
	Total_Pages int
	Data        []struct {
		Title       string
		Story_Title string
	}
}

func main() {
	fmt.Println(getAuthorHistory("epaga"))
}

func getAuthorHistory(author string) []string {
	var arr []string
	arr = append(arr, getAuthorAboutList(author)...)
	arr = append(arr, getArticleTitleByAuthor(author)...)
	return arr
}

func getArticleTitleByAuthor(author string) []string {
	var arr []string
	page := 1
	for {
		resp := doRequest(fmt.Sprintf("https://jsonmock.hackerrank.com/api/articles?author=%s&page=%v", author, page))
		data := Article{}
		json.Unmarshal([]byte(resp), &data)
		for _, article := range data.Data {
			if len(article.Title) > 0 {
				arr = append(arr, article.Title)
			} else if len(article.Story_Title) > 0 {
				arr = append(arr, article.Story_Title)
			}
		}

		page = data.Page
		if page >= data.Total_Pages {
			break
		}

	}

	return arr
}

func getAuthorAboutList(author string) []string {
	var arr []string
	page := 1
	for {
		resp := doRequest(fmt.Sprintf("https://jsonmock.hackerrank.com/api/article_users?username=%s&page=%v", author, page))
		data := ArticleUser{}
		json.Unmarshal([]byte(resp), &data)
		for _, author := range data.Data {
			if len(author.About) > 0 {
				arr = append(arr, author.About)
			}
		}
		page := data.Page
		if page >= data.Total_Pages {
			break
		}
	}

	return arr
}

func doRequest(baseUrl string) string {
	resp, err := http.Get(baseUrl)
	if err != nil {
		log.Fatalln(err)
	}

	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		log.Fatalln(err)
	}

	return string(body)
}
