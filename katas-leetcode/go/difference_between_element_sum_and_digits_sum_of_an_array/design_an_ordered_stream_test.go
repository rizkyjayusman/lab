package main

import (
	"fmt"
	"testing"
)

var (
	orderedStream *OrderedStream
)

func TestDesignAnOrderedStream(t *testing.T) {
	ops := []string{"OrderedStream", "insert", "insert", "insert", "insert", "insert"}
	var params = []struct {
		Key   int
		Value string
	}{
		{Key: 5},
		{Key: 3, Value: "ccccc"},
		{Key: 1, Value: "aaaaa"},
		{Key: 2, Value: "bbbbb"},
		{Key: 5, Value: "eeeee"},
		{Key: 4, Value: "ddddd"},
	}

	var res [][]string
	for k, v := range ops {
		if v == "OrderedStream" {
			orderedStream = Constructor(params[k].Key)
		} else if v == "insert" {
			res = append(res, orderedStream.Insert(params[k].Key-1, params[k].Value))
		}
	}

	for _, v := range res {
		fmt.Println(v)
	}

}
