### Junit 单元测试知识点 
[https://junit.org/junit4/](https://junit.org/junit4/)


测试分类是在编写和测试 JUnit 的重要分类。几种重要的分类如下：

- 包含一套断言方法的测试断言
- 包含规定运行多重测试工具的测试用例
- 包含收集执行测试用例结果的方法的测试结果


<table>
    <tr>
        <td>序号</td>
        <td>类名称</td>
        <td>类的功能</td>
    </tr>
    <tr>
        <td>1</td>
        <td>Assert</td>
        <td>assert方法的集合</td>
    </tr>
    <tr>
        <td>2</td>
        <td>TestCase</td>
        <td>一个定义了运行多重测试的固定装置</td>
    </tr>
    <tr>
        <td>3</td>
        <td>TestResult</td>
        <td>TestResult 集合了执行测试样例的所有结果</td>
    </tr>
    <tr>
        <td>4</td>
        <td>TestSuite</td>
        <td>TestSuite 是测试的集合</td>
    </tr>
</table>

### Assert

<table>
    <thead>
        <tr>
        <th>序号</th>
        <th>方法和描述</th>
        </tr>
        </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td><strong>void assertEquals(boolean expected, boolean actual)</strong> <br>检查两个变量或者等式是否平衡</td>
        </tr>
        <tr>
            <td>2</td>
            <td><strong>void assertFalse(boolean condition)</strong> <br>检查条件是假的</td>
        </tr>
        <tr>
            <td>3</td>
            <td><strong>void assertNotNull(Object object)</strong> <br>检查对象不是空的</td>
        </tr>
        <tr>
            <td>4</td>
            <td><strong>void assertNull(Object object)</strong> <br>检查对象是空的</td>
        </tr>
        <tr>
            <td>5</td>
            <td><strong>void assertTrue(boolean condition)</strong> <br>检查条件为真</td>
        </tr>
        <tr>
            <td>6</td>
            <td><strong>void fail()</strong> <br>在没有报告的情况下使测试不通过</td>
        </tr>
    </tbody>
</table>


### TestCase 

<table>
    <thead>
        <tr>
            <th>序号</th>
            <th>方法和描述</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td><strong>int countTestCases()</strong><br>为被run(TestResultresult)执行的测试案例计数</td>
        </tr>
        <tr>
            <td>2</td>
            <td><strong>TestResult createResult()</strong><br>创建一个默认的TestResult对象</td>
        </tr>
        <tr>
            <td>3</td>
            <td><strong>String getName()</strong><br>获取TestCase的名称</td>
        </tr>
        <tr>
            <td>4</td>
            <td><strong>TestResult run()</strong><br>一个运行这个测试的方便的方法，收集由TestResult对象产生的结果</td>
        </tr>
        <tr>
            <td>5</td>
            <td><strong>void run(TestResultresult)</strong><br>在TestResult中运行测试案例并收集结果</td>
        </tr>
        <tr>
            <td>6</td>
            <td><strong>void setName(Stringname)</strong><br>设置TestCase的名称</td>
        </tr>
        <tr>
            <td>7</td>
            <td><strong>void setUp()</strong><br>创建固定装置，例如，打开一个网络连接</td>
        </tr>
        <tr>
            <td>8</td>
            <td><strong>void tearDown()</strong><br>拆除固定装置，例如，关闭一个网络连接</td>
        </tr>
        <tr>
            <td>9</td>
            <td><strong>String toString()</strong><br>返回测试案例的一个字符串表示</td>
        </tr>
    </tbody>
</table>
