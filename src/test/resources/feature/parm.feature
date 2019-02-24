Feature: 360影视登录页面参数化登录功能

#怎样实现重复输入账号密码操作的步骤
  Background: 用户打开360影视首页
    Given 用户正停留在360影视登录页

#输入账号密码a1/a1
  Scenario:
    When 用户输入用户名 "a1"
    And 用户输入密码 "a1"
    Then 登录失败，提示手机号不合法
#输入账号密码a2/a2
  Scenario:
    When 用户输入用户名 "a2"

    And 用户输入密码 "a2"
    Then 登录失败，提示手机号不合法

#输入账号密码a3/a3
  Scenario:
    When 用户输入用户名 "a3"
    And 用户输入密码 "a3"
    Then 登录失败，提示手机号不合法