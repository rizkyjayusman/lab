package handler

import (
	"go-echo-baseproject/internal/user/service"
	"net/http"

	"github.com/labstack/echo/v4"
)

type UserHandler struct {
	UserService service.UserService
}

func (h UserHandler) GetAll(c echo.Context) error {
	res, err := h.UserService.GetAll()
	if err != nil {
		return echo.NewHTTPError(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, res)
}

func (h UserHandler) GetUser(c echo.Context) error {
	id := c.Param("id")
	return c.JSON(http.StatusOK, id)
}

func NewUserHandler(userService service.UserService) *UserHandler {
	return &UserHandler{
		UserService: userService,
	}
}
