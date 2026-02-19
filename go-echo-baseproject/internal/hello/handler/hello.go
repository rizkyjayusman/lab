package handler

import (
	"net/http"

	"github.com/labstack/echo/v4"
)

type HelloHandler struct{}

func (h *HelloHandler) Hello(c echo.Context) error {
	return c.String(http.StatusOK, "Hello, TDD!")
}

func NewHelloHandler() *HelloHandler {
	return &HelloHandler{}
}
