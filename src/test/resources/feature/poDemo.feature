#cucumber+selenium+pageobject模式
Feature: 360登录页面演示案例及data table使用
  360登录页面演示案例及data table使用

  Scenario Outline: 打开360首页
    Given 打开chrome浏览器，进入360首页
    When 输入 "<userName>" and "<passWord>" 并点击登录
    Then 验证登录结果 "<result>"

    #4组测试数据
    Examples:
      | userName  | passWord | result   |
      | xiaoqiang | 1        | 输入手机号不合法 |
      | 00000000  | 11111111 | 输入手机号不合法 |
      | admin123  | 3        | 输入手机号不合法 |
      | 小明        | aa       | 输入手机号不合法 |

