package main

import (
	"rizkyjayusman.com/v1/go-tasktracker-cli/cmd"
)

func main() {
	cfg := cmd.Config{}
	_, err := cmd.New(cfg)
	if err != nil {
		panic(err)
	}
}
