<template>
  <div class="body-content">
    <!--<div style="position:fixed;right: 35px;" class="tips">
      <template v-for="index in 75">
          <span :key="index"><a href="#a{index}" :class="answers[a + index] ? 'active' : 'inactive'">({{index}})</a></span>
          <el-divider :key="index"></el-divider>
      </template>
    </div>-->
    <!--卡片分割-->
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>2019年上半年上午试题</span>
      </div>
      <div>
        <div class="questions">
          <p>
            ●计算机执行指令的过程中，需要由<strong id="a1"> ( 1 ) </strong>产生每条指令的操作信号并将信号送往相应的部件进行处理，以完成指定的操作。
          </p>
        </div>
        <div class="answers">
          <p>
            (1)
            <el-radio-group v-model="answers.a1">
              <el-radio label="A">A．CPU的控制器</el-radio>
              <el-radio label="B">B．CPU的运算器</el-radio>
              <el-radio label="C">C．DMA控制器</el-radio>
              <el-radio label="D">D．Cache控制器</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●DMA控制方式是在<strong> ( 2 ) </strong>之间直接建立数据通路进行数据的交换处理。
          </p>
        </div>
        <div class="answers">
          <p>
            (2)
            <el-radio-group v-model="answers.a2">
              <el-radio label="A">A．CPU与主存</el-radio>
              <el-radio label="B">B．CPU与外设</el-radio>
              <el-radio label="C">C．主存与外设</el-radio>
              <el-radio label="D">D．外设与外设</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●CPU访问存储器时，被访问数据一般聚集在一个较小的连续存储区域中。若一个存储单元已被访问，则其邻近的存储单元有可能还要被访问，该特性被称为<strong> ( 3 ) </strong>。
          </p>
        </div>
        <div class="answers">
          <p>
            (3)
            <el-radio-group v-model="answers.a3">
              <el-radio label="A">A．数据局部性</el-radio>
              <el-radio label="B">B．指令局部性</el-radio>
              <el-radio label="C">C．空间局部性</el-radio>
              <el-radio label="D">D．时间局部性</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●某系统由3个部件构成，每个部件的千小时可靠度都为R，该系统的千小时可靠度为（1-（1-R）²）R,则该系统的构成方式是<strong> ( 4 ) </strong>。
          </p>
        </div>
        <div class="answers">
          <p>
            (4)
            <el-radio-group v-model="answers.a4">
              <el-radio label="A">A．3个部件串联</el-radio>
              <el-radio label="B">B．3个部件并联</el-radio>
              <el-radio label="C">C．前两个部件并联后与第三个部件串联</el-radio>
              <el-radio label="D">D．第一个部件与后两个部件并联构成的子系统串联</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●在<strong> ( 5 ) </strong>校验方法中,采用模2运算来构造校验位。
          </p>
        </div>
        <div class="answers">
          <p>
            (5)
            <el-radio-group v-model="answers.a5">
              <el-radio label="A">A．水平奇偶</el-radio>
              <el-radio label="B">B．垂直奇偶</el-radio>
              <el-radio label="C">C．海明码</el-radio>
              <el-radio label="D">D．循环冗余</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●以下关于RISC （精简指令系统计算机）技术的叙述中，错误的是<strong> ( 6 ) </strong>。
          </p>
        </div>
        <div class="answers">
          <p>
            (6)
            <el-radio-group v-model="answers.a6">
              <el-radio label="A">A．指令长度固定、指令种类尽量少</el-radio>
              <el-radio label="B">B．指令功能强大、寻址方式复杂多样</el-radio>
              <el-radio label="C">C．增加寄存器数目以减少访存次数</el-radio>
              <el-radio label="D">D．用硬布线电路实现指令解码，快速完成指令译码</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●<strong> ( 7 ) </strong>防火墙是内部网和外部网的隔离点,它可对应用层的通信数据流进行监控和过滤。
          </p>
        </div>
        <div class="answers">
          <p>
            (7)
            <el-radio-group v-model="answers.a7">
              <el-radio label="A">A．包过滤</el-radio>
              <el-radio label="B">B．应用级网关</el-radio>
              <el-radio label="C">C．数据库</el-radio>
              <el-radio label="D">D．WEB</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●下述协议中与安全电子邮箱服务无关的是<strong> ( 8 ) </strong>。
          </p>
        </div>
        <div class="answers">
          <p>
            (8)
            <el-radio-group v-model="answers.a8">
              <el-radio label="A">A．SSL</el-radio>
              <el-radio label="B">B．HTTPS</el-radio>
              <el-radio label="C">C．MIME</el-radio>
              <el-radio label="D">D．MIME</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●用户A和B要进行安全通信，通信过程需确认双方身份和消息不可否认。A和B通信时可使用<strong> ( 9 ) </strong>来对用户的身份进行认证;使用<strong> ( 10 ) </strong>确保消息不可否认。
          </p>
        </div>
        <div class="answers">
          <p>
            (9)
            <el-radio-group v-model="answers.a9">
              <el-radio label="A">A．数字证书</el-radio>
              <el-radio label="B">B．消息加密</el-radio>
              <el-radio label="C">C．用户私钥</el-radio>
              <el-radio label="D">D．数字签名</el-radio>
            </el-radio-group>
          </p>
          <p>
            (10)
            <el-radio-group v-model="answers.a10">
              <el-radio label="A">A．数字证书</el-radio>
              <el-radio label="B">B．消息加密</el-radio>
              <el-radio label="C">C．用户私钥</el-radio>
              <el-radio label="D">D．数字签名</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●震网（Stuxnet）病毒是一种破坏工业基础设施的恶意代码，利用系统漏洞攻击工业控制系统，是一种危害性极大的<strong> ( 11 ) </strong>。
          </p>
        </div>
        <div class="answers">
          <p>
            (11)
            <el-radio-group v-model="answers.a11">
              <el-radio label="A">A．引导区病毒</el-radio>
              <el-radio label="B">B．宏病毒</el-radio>
              <el-radio label="C">C．木马病毒</el-radio>
              <el-radio label="D">D．蠕虫病毒</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●刘某完全利用任职单位的实验材料、实验室和不对外公开的技术资料完成了一项 发明。以下关于该发明的权利归属的叙述中，正确的是<strong> ( 12 ) </strong>。
          </p>
        </div>
        <div class="answers">
          <p>
            (12)
          </p>
            <el-radio-group v-model="answers.a12">
              <el-radio label="A">A．无论刘某与单位有无特别约定，该项成果都属于单位</el-radio>
              <br>
              <el-radio label="B">B．原则上应归单位所有，但若单位与刘某对成果的归属有特别约定时遵从约定</el-radio>
              <br>
              <el-radio label="C">C．取决于该发明是否是单位分派给刘某的</el-radio>
              <br>
              <el-radio label="D">D．无论刘某与单位有无特别约定，该项成果都属于刘某</el-radio>
              <br>
            </el-radio-group>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●甲公司购买了一工具软件，并使用该工具软件开发了新的名为“恒友”的软件。 甲公司在销售新软件的同时，向客户提供工具软件的复制品，则该行为<strong> ( 13 ) </strong>。甲公司 未对“恒友”软件注册商标就开始推向市场，并获得用户的好评。三个月后，乙公司也推 出名为“恒友”的类似软件，并对之进行了商标注册，则其行为<strong> ( 14 ) </strong>。
          </p>
        </div>
        <div class="answers">
          <p>
            (13)
            <el-radio-group v-model="answers.a13">
              <el-radio label="A">A．侵犯了著作权</el-radio>
              <el-radio label="B">B．不构成侵权行为</el-radio>
              <el-radio label="C">C．侵犯了专利权</el-radio>
              <el-radio label="D">D．属于不正当竞争</el-radio>
            </el-radio-group>
          </p>
          <p>
            (14)
            <el-radio-group v-model="answers.a14">
              <el-radio label="A">A．侵犯了著作权</el-radio>
              <el-radio label="B">B．不构成侵权行为</el-radio>
              <el-radio label="C">C．侵犯了商标权</el-radio>
              <el-radio label="D">D．属于不正当竞争</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●数据流图建模应遵循<strong> ( 15 ) </strong>的原则。
          </p>
        </div>
        <div class="answers">
          <p>
            (15)
            <el-radio-group v-model="answers.a15">
              <el-radio label="A">A.自顶向下、从具体到抽象</el-radio>
              <el-radio label="B">B.自顶向下、从抽象到具体</el-radio>
              <el-radio label="C">C.自底向上、从具体到抽象</el-radio>
              <el-radio label="D">D.自底向上、从抽象到具体</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●结构化设计方法中使用结构图来描述构成软件系统的模块以及这些模块之间的调 用关系。结构图的基本成分不包括<strong> ( 16 ) </strong>的原则。
          </p>
        </div>
        <div class="answers">
          <p>
            (16)
            <el-radio-group v-model="answers.a16">
              <el-radio label="A">A.模块</el-radio>
              <el-radio label="B">B.调用</el-radio>
              <el-radio label="C">C.数据</el-radio>
              <el-radio label="D">D.控制</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●10个成员组成的开发小组，若任意两人之间都有沟通路径，则一共有<strong> ( 17 ) </strong>条沟通路径。
          </p>
        </div>
        <div class="answers">
          <p>
            (17)
            <el-radio-group v-model="answers.a17">
              <el-radio label="A">A.100</el-radio>
              <el-radio label="B">B.90</el-radio>
              <el-radio label="C">C.50</el-radio>
              <el-radio label="D">D.45</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●某项目的活动持续时间及其依赖关系如下表所示，则完成该项目的最少时间为<strong> ( 18 ) </strong>天
          </p>
        </div>
        <div class="answers">
          <p>
            (18)
            <el-radio-group v-model="answers.a18">
              <el-radio label="A">A.43</el-radio>
              <el-radio label="B">B.45</el-radio>
              <el-radio label="C">C.50</el-radio>
              <el-radio label="D">D.55</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●以下不属于软件项目风险的是<strong> ( 19 ) </strong>。
          </p>
        </div>
        <div class="answers">
          <p>
            (19)
            <el-radio-group v-model="answers.a19">
              <el-radio label="A">A.团队成员可以进行良好沟通</el-radio>
              <el-radio label="B">B.团队成员离职</el-radio>
              <el-radio label="C">C.团队成员缺乏某方面培训</el-radio>
              <el-radio label="D">D.招不到符合项目技术要求的团队成员</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●通用的高级程序设计语言一般都会提供描述数据、运算、控制和数据传输的语言成分，其中，控制包括顺序、<strong> ( 20 ) </strong>和循环结构。
          </p>
        </div>
        <div class="answers">
          <p>
            (20)
            <el-radio-group v-model="answers.a20">
              <el-radio label="A">A.选择</el-radio>
              <el-radio label="B">B.递归</el-radio>
              <el-radio label="C">C.递推</el-radio>
              <el-radio label="D">D.函数</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●以编译方式翻译C/C++杆源程序的过程中，<strong> ( 21 ) </strong>阶段的主要任务是对各条语句 的结构进行合法性分析。
          </p>
        </div>
        <div class="answers">
          <p>
            (21)
            <el-radio-group v-model="answers.a21">
              <el-radio label="A">A.词法分析</el-radio>
              <el-radio label="B">B.语义分析</el-radio>
              <el-radio label="C">C.语法分析</el-radio>
              <el-radio label="D">D.目标代码生成</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●在对高级语言源程序进行编译或解释处理的过程中，需要不断收集、记录和使用 源程序中一些相关符号的类型和特征等信息，并将其存入<strong> ( 22 ) </strong>中。
          </p>
        </div>
        <div class="answers">
          <p>
            (22)
            <el-radio-group v-model="answers.a22">
              <el-radio label="A">A.哈希表</el-radio>
              <el-radio label="B">B.符号表</el-radio>
              <el-radio label="C">C.堆栈</el-radio>
              <el-radio label="D">D.队列</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●在单处理机系统中，采用先来先服务调度算法。系统中有4个进程Pl、P2、P3、 P4 (假设进程按此顺序到达)，其中P］为运行状态，P2为就绪状态，P3和P4为等待状态，且P3等待打印机，P4等待扫描仪。若P1<strong> ( 23 ) </strong>,则Pl、P2、P3和P4的状态应分别 为<strong> ( 24 ) </strong>。
          </p>
        </div>
        <div class="answers">
          <p>
            (23)
            <el-radio-group v-model="answers.a23">
              <el-radio label="A">A.时间片到</el-radio>
              <el-radio label="B">B.释放了扫描仪</el-radio>
              <el-radio label="C">C.释放了打印机</el-radio>
              <el-radio label="D">D.已完成</el-radio>
            </el-radio-group>
          </p>
          <p>
            (24)
            <el-radio-group v-model="answers.a24">
              <el-radio label="A">A.等待、就绪、等待和等待</el-radio>
              <el-radio label="B">B.运行、就绪、运行和等待</el-radio>
              <el-radio label="C">C.就绪、运行、等待和等待</el-radio>
              <el-radio label="D">D.就绪、就绪、等待和运行</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●某文件系统采用位示图(bitmap)记录磁盘的使用情况。若计算机系统的字长为64 位，磁盘的容量为1024GB,物理块的大小为4MB,那么位示图的大小需要<strong> ( 25 ) </strong>个字。
          </p>
        </div>
        <div class="answers">
          <p>
            (25)
            <el-radio-group v-model="answers.a25">
              <el-radio label="A">A.1200</el-radio>
              <el-radio label="B">B.2400</el-radio>
              <el-radio label="C">C.4096</el-radio>
              <el-radio label="D">D.9600</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●若某文件系统的目录结构如下图所示，假设用户要访问文件book2.doc，且当前工作目录为MyDrivers,则该文件的绝对路径和相对路径分别为<strong> ( 26 ) </strong>个字。
          </p>
        </div>
        <div class="answers">
          <p>
            (26)
            <el-radio-group v-model="answers.a26">
              <el-radio label="A">A.MyDrivers\user2\和\user2\</el-radio>
              <el-radio label="B">B.\MyDrivers\user2\和\user2\</el-radio>
              <el-radio label="C">C.\MyDrivers\user20和user2\</el-radio>
              <el-radio label="D">D.MyDrivers\user2\和user2\</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

      <div>
        <div class="questions">
          <p>
            ●PV操作是操作系统提供的具有特定功能的原语。利用PV操作可以<strong> ( 27 ) </strong>。
          </p>
        </div>
        <div class="answers">
          <p>
            (27)
            <el-radio-group v-model="answers.a27">
              <el-radio label="A">A.保证系统不发生死锁</el-radio>
              <el-radio label="B">B.实现资源的互斥使用</el-radio>
              <el-radio label="C">C.提高资源利用率</el-radio>
              <el-radio label="D">D.推迟进程使用共享资源的时间</el-radio>
            </el-radio-group>
          </p>
        </div>
      </div>

    </el-card>
  </div>
</template>

<script>
export default {
  name: 'Morning',
  data () {
    return {
      answers: {}
    }
  }
}
</script>

<style scoped>
.body-content {
  margin: 10px 20px;
  font-size: 20px;
}
strong {
  color: red;
}
.tips span a{
  text-decoration: none;
  padding: 10px;
  display: block;
  color: white;
}
.active {
  background-color: green;
}
.inactive {
  background-color: #8c939d;
}
.el-divider {
  margin: 0px;
}
</style>
