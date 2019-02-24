#cucumber使用初探
Feature: 验证计算器计算功能
  打开计算器进行计算

  @CalculatorTest
  Scenario: 打开计算器进行计算1+1
    Given 打开计算器面板
    When  已经输入1并按下+
    And   输入 "1"
    And   按下=号
    Then  等待计算结果
