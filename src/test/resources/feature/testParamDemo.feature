#cucumber参数化使用
Feature: 验证计算器多组数字计算功能
  打开计算器进行计算

  Scenario Outline: 打开计算器进行计算
    Given 打开计算器面板
    When 输入 "<a1>" and "<a2>" 并计算结果
    Then 等待计算结果 "<result>"

    #5组数字计算机结果
    Examples:
      | a1 | a2 | result |
      | 1  | 1  | 1      |
      | 2  | 2  | 4      |
      | 3  | 3  | 6      |
      | 4  | 4  | 8      |
      | 5  | 5  | 7     |

